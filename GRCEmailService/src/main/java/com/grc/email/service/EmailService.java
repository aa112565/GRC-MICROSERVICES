package com.grc.email.service;

import java.util.List;

import javax.mail.MessagingException;

import com.grc.email.dto.MailInfoDTO;

public interface EmailService {
	
	public String sendEmail(MailInfoDTO mailInfo)  throws MessagingException;
	public String sendEmail(List<MailInfoDTO> mailInfo)  throws MessagingException;
	public String triggerScheduledEmails();
	public String sendInstantEmail(MailInfoDTO mailInfo) throws MessagingException;	
}
