package com.grc.email.service.impl;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.grc.email.dto.MailInfoDTO;
import com.grc.email.entity.EmailNotification;
import com.grc.email.repository.EmailNotificationRepository;
import com.grc.email.service.EmailService;


@Service
public class EmailServiceImpl implements EmailService {

	@Resource
	EmailNotificationRepository emailNotificationRepository;
	
	@Autowired
    private JavaMailSender emailSender;
	
	@Value("${email.from.address}")
	private String emailFromAddress;
	
	private static final String INVALID_EMAIL_ADDRESS = "INVALID_EMAIL_ADDRESS";
	private static final String EMAIL_STATUS_NEW = "NEW";
	private static final String EMAIL_STATUS_SENT = "SENT";
	private static final String EMAIL_STATUS_FAILED = "FAILED";	
	private static final String EMAIL_SENT_MESSAGE = "Emails sent successfully!";
	private static final String NO_EMAILS_TO_BE_SENT_MESSAGE = "No email alerts to be sent!";
	private static final String EMAIL_ADDRESS_VALIDATION_ERROR_MESSAGE = "One of the given email address in invalid, kindly check";
	private static final String EMAIL_NOT_SENT_ERROR_MESSAGE = "Email was not sent and the error is ";
	//private static final String TEST_MAIL_SUBJECT = "TEST MAIL!!! No action required. Kindly Ignore!! ";

	public String sendEmail(MailInfoDTO mailInfo) {
		
		EmailNotification emailNotification = new EmailNotification(mailInfo.getUserId(), mailInfo.getBranchId(),
				mailInfo.getSubject(), mailInfo.getMailBodyContent(), EMAIL_STATUS_NEW,	new Date(), mailInfo.getErrorMessage());
		
		String validationResponse = validateMailInfoDTO(mailInfo, emailNotification);
		if("".equals(validationResponse)) {
			emailNotificationRepository.save(emailNotification);
		} else {
			return validationResponse;
		}		
		return EMAIL_SENT_MESSAGE;
	}
	
	public String sendInstantEmail(MailInfoDTO mailInfo) {	
		String response = "";
		EmailNotification emailNotification = new EmailNotification(mailInfo.getUserId(), mailInfo.getBranchId(),
				mailInfo.getSubject(), mailInfo.getMailBodyContent(), EMAIL_STATUS_SENT, new Date(), mailInfo.getErrorMessage());
		String validationResponse = validateMailInfoDTO(mailInfo, emailNotification);
		if("".equals(validationResponse)) {			
			response = sendEmail(emailNotification);				
			if(!response.equals(EMAIL_SENT_MESSAGE)) {
				emailNotification.setErrorMessage(response);
				emailNotification.setStatus(EMAIL_STATUS_FAILED);				
			}
			emailNotificationRepository.save(emailNotification);
		} else {
			return validationResponse;
		}				
		return response;
	}
	
	public String sendEmail(List<MailInfoDTO> mailInfoList) {
		String responseMessage = "";		
		List<EmailNotification> emailNotificationList = new ArrayList<EmailNotification>();
		for(MailInfoDTO mailInfo: mailInfoList) {			
			String toAddress[] = mailInfo.getToAddress();
			String toAddressStr = "";
			if(toAddress != null) {
				List<String> emailAddressList = Arrays.asList(toAddress);				
				toAddressStr = String.join(",", emailAddressList);
			}
			if(mailInfo.getMailBodyContent() != null && mailInfo.getMailBodyContent() != "" && toAddress.length > 0) {			
				EmailNotification emailNotification = new EmailNotification(mailInfo.getUserId(), mailInfo.getBranchId(),
						mailInfo.getSubject(), mailInfo.getMailBodyContent(), EMAIL_STATUS_NEW,	new Date(), mailInfo.getErrorMessage());	
				emailNotification.setToAddress(toAddressStr);				
				emailNotificationList.add(emailNotification);
			}
		}	
		if(emailNotificationList.size() > 0) {
			emailNotificationRepository.saveAll(emailNotificationList);
			responseMessage = EMAIL_SENT_MESSAGE;
		} else {
			responseMessage = NO_EMAILS_TO_BE_SENT_MESSAGE;
		}	
		return responseMessage;
	}
	
	@Async
	public String triggerScheduledEmails() {		
		String status;
		try {
			
			//Fetching scheduled Emails from database
			List<EmailNotification> scheduledEmailList = emailNotificationRepository.findByStatus(EMAIL_STATUS_NEW);
			
			for(EmailNotification emailInfo: scheduledEmailList) {
				sendEmail(emailInfo);
				emailInfo.setStatus(EMAIL_STATUS_SENT);
			}
			//Update the status of the mail in Email Notification table
			CompletableFuture.completedFuture(emailNotificationRepository.saveAll(scheduledEmailList));
			
			status = EMAIL_SENT_MESSAGE;
		} catch (Exception error) {						
			status = EMAIL_NOT_SENT_ERROR_MESSAGE + error.getMessage();
			error.printStackTrace();
		}		
		return status;
	}

	@Async
	private String sendEmail(EmailNotification emailInfo) {
		String response = "";
		try {
			MimeMessage message = emailSender.createMimeMessage();			
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.setSubject(emailInfo.getSubject());
			helper.setText(emailInfo.getBody(), true);
			helper.setFrom(emailFromAddress);
			if (emailInfo.getCcAddress() != null) {
				helper.setCc(emailInfo.getCcAddress());
			}
			helper.setTo(InternetAddress.parse(emailInfo.getToAddress()));
			emailSender.send(message);
			response = EMAIL_SENT_MESSAGE;
		} catch (Exception ex) {
			ex.printStackTrace();
			response = ex.getLocalizedMessage();
		}
		return response;
	}	
	
	
	private String validateMailInfoDTO(MailInfoDTO mailInfo, EmailNotification emailNotification) {
		String validationResponse = "";
		if(mailInfo.getToAddress() != null) {
			String toAddressStr = validateEmailAndConvertToStr(mailInfo.getToAddress());
			if(!toAddressStr.equals(INVALID_EMAIL_ADDRESS)) {
				emailNotification.setToAddress(toAddressStr);
			} else {
				return EMAIL_ADDRESS_VALIDATION_ERROR_MESSAGE;
			}
		}
		
		if(mailInfo.getCcAddress() != null) {
			String toCcAddressStr = validateEmailAndConvertToStr(mailInfo.getCcAddress());
			if(!toCcAddressStr.equals(INVALID_EMAIL_ADDRESS)) {
				emailNotification.setCcAddress(toCcAddressStr);
			} else {
				return EMAIL_ADDRESS_VALIDATION_ERROR_MESSAGE;
			}
		}
		
		if(mailInfo.getBccAddress() != null) {
			String toBccAddressStr = validateEmailAndConvertToStr(mailInfo.getBccAddress());
			if(!toBccAddressStr.equals(INVALID_EMAIL_ADDRESS)) {
				emailNotification.setBccAddress(toBccAddressStr);
			} else {
				return EMAIL_ADDRESS_VALIDATION_ERROR_MESSAGE;
			}
		}	
		return validationResponse;
	}
	
	private String validateEmailAndConvertToStr(String[] emailAddressArr) {		
		List<String> emailAddressList = Arrays.asList(emailAddressArr);		
		for(String emailAddress: emailAddressList) {
			if(!isValidEmailAddress(emailAddress)){
				return INVALID_EMAIL_ADDRESS;
			}
		}
		return String.join(",", emailAddressList);
	}
	
	private boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
}
