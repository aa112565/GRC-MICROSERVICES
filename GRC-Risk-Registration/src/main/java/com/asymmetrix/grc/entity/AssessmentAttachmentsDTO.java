package com.asymmetrix.grc.entity;

import org.springframework.web.multipart.MultipartFile;

public class AssessmentAttachmentsDTO {	
	
	private String riskRegID;
	private long riskID;
	private long controlID;
	
	private MultipartFile[] files;
	
	public String getRiskRegID() {
		return riskRegID;
	}
	public void setRiskRegID(String riskRegID) {
		this.riskRegID = riskRegID;
	}
	public long getRiskID() {
		return riskID;
	}
	public void setRiskID(long riskID) {
		this.riskID = riskID;
	}
	public long getControlID() {
		return controlID;
	}
	public void setControlID(long controlID) {
		this.controlID = controlID;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}	
	
}
