package com.asymmetrix.grc.service.impl;

import java.time.LocalDateTime;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCConstants;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.MailDetailsDTO;
import com.asymmetrix.grc.dto.PasswordDTO;
import com.asymmetrix.grc.entity.CnfgPasswordResetToken;
import com.asymmetrix.grc.entity.CnfgUser;
import com.asymmetrix.grc.repository.CnfgPasswordResetTokenRepository;
import com.asymmetrix.grc.service.CnfgPropertyDetailsService;
import com.asymmetrix.grc.service.PasswordService;
import com.asymmetrix.grc.service.UserService;

@Service
public class PasswordServiceImpl implements PasswordService {

	private static final String INVALID_FORGOT_TOKEN_OR_TOKEN_EXPIRED = "Invalid Forgot Password Key or Key Has Been Expired";

	private static final String FORGOT_PASSWORD_INVALID_FOR_LDAP_AUTH_ERROR = "Forgot password is invalid for LDAP based authentication";

	public static final String MAIL_FORGOT_PASSWORD_TOKEN_SUCCESS = "Forgot Password link has been sent to the Registered Mail id : ";

	public static final String FORGOT_PASSWORD_LINK_ALREADY_SENT = "Forgot Password link has been already sent to your Registered Mail id ";

	@Resource
	UserService userService;

	@Resource
	CnfgPropertyDetailsService cnfgExtAuthService;

	@Resource
	CnfgPasswordResetTokenRepository cnfgPasswordResetTokenRepo;

	@Resource
	ExternalRESTService externalRestService;

	@Value("${grc.mail.forgot.password.subject}")
	private String forgotPasswordMailSubject;

	@Value("${emailservice.endpoint}")
	private String emailServiceEndpoint;

	@Value("${emailservice.resource.url.instant_email}")
	private String emailResourceUrl;

	@Value("${grc.mail.forgot.password.url}")
	private String url;

	@Value("${grc.mail.forgot.password.link.expiry.time}")
	private int expirationTime;

	@Override
	public String mailForgotPasswordTokenUrl(CnfgUserDTO cnfgUserModel) {
//    final String token = getToken();
		if (!isValidUserId(cnfgUserModel.getUserId())) {
			return MAIL_FORGOT_PASSWORD_TOKEN_SUCCESS.concat("XXXXX.XXX");
		}
		final String token = getToken();
		CnfgPasswordResetToken resetToken = cnfgPasswordResetTokenRepo.findByUserId(cnfgUserModel.getUserId());
		if (!ObjectUtils.isEmpty(resetToken) && isTokenValid(resetToken)) {
			return FORGOT_PASSWORD_LINK_ALREADY_SENT;
		} else {
			deleteOldTokenByUserId(cnfgUserModel.getUserId());
			cnfgPasswordResetTokenRepo.save(new CnfgPasswordResetToken(token,
					MapperUtils.mapToTargetClass(cnfgUserModel, CnfgUser.class), expirationTime));
			externalRestService.sendMail(getUrlForEmailService(),
					getMailDetails(cnfgUserModel.getEmail(), getTokenUrl(token)));
			// return GRCUtils.maskUserEmailId(cnfgUserModel.getEmail());
			return MAIL_FORGOT_PASSWORD_TOKEN_SUCCESS.concat(cnfgUserModel.getEmail());
		}
	}

	private void deleteOldTokenByUserId(String userId) {
		cnfgPasswordResetTokenRepo.deleteByUserId(userId);
	}

	private boolean isValidUserId(String userId) {
		return ObjectUtils.isEmpty(userId) ? Boolean.FALSE : Boolean.TRUE;
	}

	private MailDetailsDTO getMailDetails(String userMailId, String url) {
		MailDetailsDTO mailDetails = new MailDetailsDTO();
		String[] toAddressArr = { userMailId };
		mailDetails.setToAddress(toAddressArr);
		mailDetails.setSubject(forgotPasswordMailSubject);
		mailDetails.setMailBodyContent(url);
		return mailDetails;
	}

	private String getUrlForEmailService() {
		return emailServiceEndpoint.concat(emailResourceUrl);
	}

	private String getTokenUrl(String token) {
		return url.concat(token);
	}

	private String getToken() {
		return UUID.randomUUID().toString();
	}

	@Override
	public boolean isForgotPasswordTokenValid(String token) {
		Optional<CnfgPasswordResetToken> cnfgPasswordResetToken = cnfgPasswordResetTokenRepo.findById(token);
		return (!cnfgPasswordResetToken.isPresent()) ? Boolean.FALSE
				// : isTokenExpired(cnfgPasswordResetToken.get());
				: isTokenValid(cnfgPasswordResetToken.get());

	}

	/*
	 * private boolean isTokenExpired(CnfgPasswordResetToken passToken) { final
	 * Calendar cal = Calendar.getInstance(); return
	 * passToken.getExpiryDate().after(cal.getTime()); }
	 */

	private boolean isTokenValid(CnfgPasswordResetToken passToken) {
		LocalDateTime timeFromDB = new java.sql.Timestamp(passToken.getExpiryDate().getTime()).toLocalDateTime();
		LocalDateTime currentTime = new java.sql.Timestamp(new Date().getTime()).toLocalDateTime();
		return timeFromDB.isAfter(currentTime);
	}

	@Override
	public void updatePassword(PasswordDTO passwordModel) {
		validate(passwordModel.getToken());
		Optional<CnfgPasswordResetToken> cnfgPasswordResetToken = cnfgPasswordResetTokenRepo
				.findById(passwordModel.getToken());
		if (cnfgPasswordResetToken.isPresent()) {
			userService.updatePassword(passwordModel.getNewEncryptedPassword(),
					cnfgPasswordResetToken.get().getCnfgUser().getUserId());
			deleteOldTokenByUserId(cnfgPasswordResetToken.get().getCnfgUser().getUserId());
		} else {
			throw new GRCException(GRCErrorConstants.ERROR_INVALID_FORGOT_PWD_RESET_TOKEN);
		}
	}

	private void validate(String token) {
		if (!cnfgExtAuthService.isAuthTypeByValue(GRCConstants.DB)) {
			throw new GRCException(FORGOT_PASSWORD_INVALID_FOR_LDAP_AUTH_ERROR);
		}
		if (!isForgotPasswordTokenValid(token)) {
			throw new GRCException(INVALID_FORGOT_TOKEN_OR_TOKEN_EXPIRED);
		}
	}

}
