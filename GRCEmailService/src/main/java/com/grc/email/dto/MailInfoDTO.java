package com.grc.email.dto;

public class MailInfoDTO {
	private String branchId;
	private String userId;	
	private String toAddress[];
	private String fileName;
	private String mailBodyContent;
	private String fullFilePath;
	private String ccAddress[];
	private String bccAddress[];
	private String subject;
	private String status;
	private String errorMessage;
	
	public MailInfoDTO() {
		
	}	
		
	public MailInfoDTO(String[] toAddress, String mailBodyContent, String ccAddress[]) {
		super();		
		this.toAddress = toAddress;		
		this.mailBodyContent = mailBodyContent;		
		this.ccAddress = ccAddress;
	}
		
	public MailInfoDTO(String branchId, String toAddress[], String fileName, String mailBodyContent, String fullFilePath) {
		super();
		this.branchId = branchId;
		this.toAddress = toAddress;
		this.fullFilePath = fullFilePath;
	}	
	
	public MailInfoDTO(String branchId, String userId, String[] toAddress, String[] ccAddress, String[] bccAddress, String fileName, String mailBodyContent, String fullFilePath) {
		super();
		this.branchId = branchId;
		this.userId = userId;
		this.toAddress = toAddress;
		this.ccAddress = ccAddress;
		this.fileName = fileName;
		this.mailBodyContent = mailBodyContent;
		this.fullFilePath = fullFilePath;
		this.bccAddress = bccAddress;
	}
	
	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String[] getToAddress() {
		return toAddress;
	}

	public void setToAddress(String[] toAddress) {
		this.toAddress = toAddress;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMailBodyContent() {
		return mailBodyContent;
	}

	public void setMailBodyContent(String mailBodyContent) {
		this.mailBodyContent = mailBodyContent;
	}
	
	public String getFullFilePath() {
		return fullFilePath;
	}
	
	public void setFullFilePath(String fullFilePath) {
		this.fullFilePath = fullFilePath;
	}

	public String[] getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress[]) {
		this.ccAddress = ccAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String[] getBccAddress() {
		return bccAddress;
	}

	public void setBccAddress(String[] bccAddress) {
		this.bccAddress = bccAddress;
	}
			
	
}
