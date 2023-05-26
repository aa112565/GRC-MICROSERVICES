package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "RISK_CONTROL_ASSESSMENT_ATTACHMENTS", schema = "GRC_TEST_ENV_DB")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskControlAssessmentAttachments {
	
	@Id
	@Column(name = "N_ATTACHMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attachmentID;
	
	@Column(name="V_RISK_REG_ID")
	private String riskRegID;
	
	@Column(name = "N_RISK_ID")
	private long riskID;
	
	@Column(name = "N_CONTROL_ID")
	private long controlID;
	
	@Lob
	@Column(name = "B_ATTACHMENT")
	private byte[] fileBytes;
	
	@Column(name = "V_FILENAME")
	private String fileName;
	
	@Column(name = "V_FILETYPE")
	private String filetype;
	
	@Column(name = "V_ACTIVE")
	private String active;
	
	public RiskControlAssessmentAttachments(String riskRegID, long riskID, long controlID, byte[] fileBytes, String fileName, String fileType) {
		this.riskRegID = riskRegID;
		this.riskID = riskID;
		this.controlID = controlID;
		this.fileBytes = fileBytes;
		this.fileName = fileName;
		this.filetype = fileType;
	}
	
	public RiskControlAssessmentAttachments() {
		
	}

	public long getAttachmentID() {
		return attachmentID;
	}

	public void setAttachmentID(long attachmentID) {
		this.attachmentID = attachmentID;
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

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
}
