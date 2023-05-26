package com.grc.email.dto;

import java.util.Date;


public class AuditEmailLogDTO {
	
	private Long auditEmailId;
	
	private Long userId;
	
	private String branchId;
	
	private String toAddress;
	
	private String subject;
	
	private String body;
	
	private String status;
	
	private Date sentDate;
	
	private String errorMessage;

	AuditEmailLogDTO(){}

	public Long getAuditEmailId() {
		return auditEmailId;
	}

	public void setAuditEmailId(Long auditEmailId) {
		this.auditEmailId = auditEmailId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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
	
	
}
