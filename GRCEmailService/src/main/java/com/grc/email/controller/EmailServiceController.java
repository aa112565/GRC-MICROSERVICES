package com.grc.email.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grc.email.common.constants.GRCErrorConstants;
import com.grc.email.common.response.GRCResponse;
import com.grc.email.common.response.GRCResponseEntity;
import com.grc.email.dto.MailInfoDTO;
import com.grc.email.service.EmailService;

@RestController
@RequestMapping("/emailservice")
public class EmailServiceController {
	
	@Resource EmailService emailService;
	private static final String EMAIL_SENT_MESSAGE = "Emails sent successfully!";
	
	@PutMapping("/sendEmail")
	public ResponseEntity<GRCResponse<?>> sendEmail(@Valid @NotNull @RequestBody MailInfoDTO mailInfo) throws MessagingException {				
		String responseMessage = emailService.sendEmail(mailInfo);	
		if(responseMessage.equals(EMAIL_SENT_MESSAGE)) {
			return GRCResponseEntity.success(responseMessage);
		} else {
			return GRCResponseEntity.failure(new GRCResponse<>(GRCErrorConstants.FAILED, responseMessage), HttpStatus.BAD_REQUEST);
		}		  
	}
	
	@PutMapping("/sendInstantEmail")
	public ResponseEntity<GRCResponse<?>> sendInstantEmail(@Valid @NotNull @RequestBody MailInfoDTO mailInfo) throws MessagingException {				
		String responseMessage = emailService.sendInstantEmail(mailInfo);
		if(responseMessage.equals(EMAIL_SENT_MESSAGE)) {
			return GRCResponseEntity.success(responseMessage);
		} else {
			return GRCResponseEntity.failure(new GRCResponse<>(GRCErrorConstants.FAILED, responseMessage), HttpStatus.BAD_REQUEST);
		}	 
	}
	
	@PutMapping("/sendListOfEmails")
	public ResponseEntity<GRCResponse<?>> sendListOfEmails(@Valid @NotNull @RequestBody List<MailInfoDTO> mailInfo) throws MessagingException {				
		String responseMessage = emailService.sendEmail(mailInfo);			
		if(responseMessage.equals(EMAIL_SENT_MESSAGE)) {
			return GRCResponseEntity.success(responseMessage);
		} else {
			return GRCResponseEntity.failure(new GRCResponse<>(GRCErrorConstants.FAILED, responseMessage), HttpStatus.BAD_REQUEST);
		}	 		
	}
	
	@GetMapping("/triggerScheduledEmails")
	public ResponseEntity<GRCResponse<?>> triggerScheduledEmails() throws MessagingException {				
		String responseMessage = emailService.triggerScheduledEmails();			
		if(responseMessage.equals(EMAIL_SENT_MESSAGE)) {
			return GRCResponseEntity.success(responseMessage);
		} else {
			return GRCResponseEntity.failure(new GRCResponse<>(GRCErrorConstants.FAILED, responseMessage), HttpStatus.BAD_REQUEST);
		}	  		
	}
	
}
