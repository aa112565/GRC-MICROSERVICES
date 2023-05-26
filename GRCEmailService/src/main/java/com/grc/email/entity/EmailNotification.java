package com.grc.email.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "EMAIL_NOTIFICATION")
public class EmailNotification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_NOTIFICATION_ID")
	private Long auditEmailId;
	@Column(name = "V_USER_ID")
	private String userId;
	@Column(name = "V_BRANCH_ID")
	private String branchId;	
	@Column(name = "V_TO_ADDRESS")
	@NotBlank(message = "The toAddress field should not be blank")
	private String toAddress;
	@Column(name = "V_SUBJECT")
	@NotBlank(message = "The subject field should not be blank")
	private String subject;
	@Column(name = "V_BODY")
	@NotBlank(message = "The body field should not be blank")
	private String body;
	@Column(name = "V_STATUS")
	private String status;
	@Column(name = "V_SENT_DATE")
	private Date sentDate;
	@Column(name = "V_ERROR_MESSAGE")
	private String errorMessage;
	@Column(name = "V_CC_ADDRESS")
	private String ccAddress;
	@Column(name = "V_BCC_ADDRESS")
	private String bccAddress;
	@Column(name="V_ATTACHMENT_FILE")
	private String attachmentFullFilePath;

	EmailNotification(){}

	public Long getAuditEmailId() {
		return auditEmailId;
	}

	public void setAuditEmailId(Long auditEmailId) {
		this.auditEmailId = auditEmailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getBccAddress() {
		return bccAddress;
	}

	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}

	public String getAttachmentFullFilePath() {
		return attachmentFullFilePath;
	}

	public void setAttachmentFullFilePath(String attachmentFullFilePath) {
		this.attachmentFullFilePath = attachmentFullFilePath;
	}
	
	public EmailNotification(String userId, String branchId, String subject, String body, String status,
			Date sentDate, String errorMessage) {
		this.userId = userId;
		this.branchId = branchId;		
		this.subject = subject;
		this.body = body;
		this.status = status;
		this.sentDate = sentDate;
		this.errorMessage = errorMessage;

	}

	public EmailNotification(String userId, String branchId, String toAddress, String subject, String body, String status,
			Date sentDate, String errorMessage) {

		this.userId = userId;
		this.branchId = branchId;
		this.toAddress = toAddress;
		this.subject = subject;
		this.body = body;
		this.status = status;
		this.sentDate = sentDate;
		this.errorMessage = errorMessage;

	}
	
	public EmailNotification(String userId, String branchId, String toAddress, String ccAddress, String bccAddress, String subject, String body, String status,
			Date sentDate, String errorMessage) {

		this.userId = userId;
		this.branchId = branchId;
		this.toAddress = toAddress;
		this.ccAddress = ccAddress;
		this.bccAddress = bccAddress;
		this.subject = subject;
		this.body = body;
		this.status = status;
		this.sentDate = sentDate;
		this.errorMessage = errorMessage;

	}
	
	public EmailNotification(String userId, String branchId, String toAddress, String ccAddress, String bccAddress, String subject, String body, String attachmentFileFullPath, String status,
			Date sentDate, String errorMessage) {

		this.userId = userId;
		this.branchId = branchId;
		this.toAddress = toAddress;
		this.ccAddress = ccAddress;
		this.bccAddress = bccAddress;
		this.attachmentFullFilePath = attachmentFileFullPath;
		this.subject = subject;
		this.body = body;
		this.status = status;
		this.sentDate = sentDate;
		this.errorMessage = errorMessage;

	}
	
	
}
