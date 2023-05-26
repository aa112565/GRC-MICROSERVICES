package com.asymmetrix.grc.entity;


import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskControlAssessmentAttachmentsDTO {
		
	private long attachmentID;
	private String riskRegID;
	private long riskID;
	private long controlID;
	private MultipartFile file;	
	private byte[] fileBytes;
	private String fileName;	
	private String filetype;

	public long getAttachmentID() {
		return attachmentID;
	}

	public void setAttachmentID(long attachmentID) {
		this.attachmentID = attachmentID;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
}
