package com.asymmetrix.grc.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.dto.MailDetailsDTO;
import com.asymmetrix.grc.entity.CnfgOTP;
import com.asymmetrix.grc.entity.CnfgUser;
import com.asymmetrix.grc.repository.CnfgOTPRepository;
import com.asymmetrix.grc.repository.UserRepository;
import com.asymmetrix.grc.service.OTPService;

@Service
public class OTPServiceImpl implements OTPService {
	@Resource
	ExternalRESTService externalRestService;
	@Resource
	CnfgOTPRepository cnfgOTPRepository;
	@Resource
	UserRepository userReporsitory;
	@Value("${emailservice.endpoint}")
	private String emailServiceEndpoint;
	@Value("${emailservice.resource.url.instant_email}")
	private String emailResourceUrl;
	@Value("${ews.mail.otp.expiry.time}")
	private int otpExpirationTime;
	@Value("${ews.user.allowed.otp.failedAttempts}")
	private int otpMaxFaliedAttempts;
	@Value("${ews.otp.max.range}")
	private int otpMaxRange;
	@Value("${ews.otp.min.range}")
	private int otpMinRange;
	public static final String OTP_MAIL_SUCCESS_MSG = "OTP has been sent to the Registered Mail id : ";
	public static final String OTP_INVALID_OR_EXPIRED_ERROR_MSG = "OTP is Invalid / Expired ";
	public static final String PREVIOUS_OTP_STILL_VALID_MSG = "Previous OTP is still valid, Kindly wait for some time to resend OTP ! : ";
	public OTPServiceImpl() {
	}

	@Override
	public String mailOTP(final String userId) {
		CnfgUser cnfgUser = userReporsitory.findById(userId)
				.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + userId));
		
	//	CnfgOTP cnfgOTP = cnfgOTPRepository.findByUserId(userId)
	//			.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + userId));
	//			CnfgUser cnfgUser = cnfgOTP.getCnfgUser();
	//			if(isOTPValid(cnfgOTP)) {
	//			return PREVIOUS_OTP_STILL_VALID_MSG;
	//			}
		
		Optional<CnfgOTP> cnfgOTP = cnfgOTPRepository.findByUserId(userId);
		if(cnfgOTP.isPresent() && isOTPValid(cnfgOTP.get())) {
			return PREVIOUS_OTP_STILL_VALID_MSG;
		}
		
	
		int otp = GRCUtils.getRandomOTP(otpMinRange, otpMaxRange);
		cnfgOTPRepository.deleteByUserId(userId);
		externalRestService.sendMail(getUrlForEmailService(),
				getMailDetails(cnfgUser.getEmail(), otp, cnfgUser.getUserName()));
		CnfgOTP cnfgOTPEntity = new CnfgOTP(otp, cnfgUser, otpExpirationTime);
		cnfgOTPRepository.save(cnfgOTPEntity);
		return OTP_MAIL_SUCCESS_MSG.concat(cnfgUser.getEmail());
	}

	@SuppressWarnings("unused")
	private MailDetailsDTO getMailDetails(final String userMailId, final int otp, final String userName) {
		final MailDetailsDTO mailDetails = new MailDetailsDTO();
		final String[] toAddressArr = { userMailId };
		mailDetails.setToAddress(toAddressArr);
		mailDetails.setSubject("OTP for login");
		mailDetails.setMailBodyContent("Hi " + userName + ", your OTP = " + otp);
		return mailDetails;
	}

	private String getUrlForEmailService() {
		return emailServiceEndpoint.concat(emailResourceUrl);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean validateOTP(final String userId, final int otp) {
		Optional<CnfgOTP> cnfgOTP = cnfgOTPRepository.findByOtpAndUserId(otp, userId);
		if (!cnfgOTP.isPresent()) {
			CnfgOTP cnfgOTPObj = cnfgOTPRepository.findByUserId(userId)
					.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + userId));
			validateAndsetUserAsInActive(cnfgOTPObj.getFailedAttempt(), userId, otp);
			throw new GRCException(OTP_INVALID_OR_EXPIRED_ERROR_MSG);
		}
		if (!isOTPValid(cnfgOTP.get())) {
			validateAndsetUserAsInActive(cnfgOTP.get().getFailedAttempt(), userId, otp);
			throw new GRCException(OTP_INVALID_OR_EXPIRED_ERROR_MSG);
		}
		cnfgOTPRepository.deleteByOtpAndUserId(otp, userId);
		return Boolean.TRUE;
	}

	public void validateAndsetUserAsInActive(int failedAttempt, final String userId, final int otp) {
		cnfgOTPRepository.incrementFailedAttemptByUserIdAndOtp(userId);
		++failedAttempt;
		if (otpMaxFaliedAttempts < failedAttempt) {
			userReporsitory.setUserAsInActive(userId);
			cnfgOTPRepository.deleteByOtpAndUserId(otp, userId);
		}
	}

	private boolean isOTPValid(final CnfgOTP cnfgOTP) {
		final LocalDateTime timeFromDB = new Timestamp(cnfgOTP.getExpiryDate().getTime()).toLocalDateTime();
		final LocalDateTime currentTime = new Timestamp(new Date().getTime()).toLocalDateTime();
		return timeFromDB.isAfter(currentTime);
	}
}