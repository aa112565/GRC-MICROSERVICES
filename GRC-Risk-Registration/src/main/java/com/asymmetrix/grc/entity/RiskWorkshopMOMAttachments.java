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
@Table(name = "RISK_WORKSHOP_MOM_ATTACHMENTS", schema = "GRC_TEST_ENV_DB")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskWorkshopMOMAttachments {
	
	@Id
	@Column(name = "N_ATTACHMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attachmentID;
	
	@Column(name="N_MOM_ID")
	private long momID;
	
	@Column(name="V_WORKSHOP_ID")
	private String workshopID;
	
	@Lob
	@Column(name = "B_ATTACHMENT")
	private byte[] fileBytes;
	
	@Column(name = "V_FILENAME")
	private String fileName;
	
	@Column(name = "V_FILETYPE")
	private String filetype;
	
	@Column(name = "V_ACTIVE")
	private String active = "Y";
	
	public RiskWorkshopMOMAttachments(long momID, String workshopID, byte[] fileBytes, String fileName, String fileType) {
		this.momID = momID;
		this.workshopID = workshopID;
		this.fileBytes = fileBytes;
		this.fileName = fileName;
		this.filetype = fileType;
	}
	
	public RiskWorkshopMOMAttachments() {
		
	}	

	public long getMomID() {
		return momID;
	}

	public void setMomID(long momID) {
		this.momID = momID;
	}

	public long getAttachmentID() {
		return attachmentID;
	}

	public void setAttachmentID(long attachmentID) {
		this.attachmentID = attachmentID;
	}

	public String getWorkshopID() {
		return workshopID;
	}

	public void setWorkshopID(String workshopID) {
		this.workshopID = workshopID;
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
