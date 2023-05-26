package com.asymmetrix.grc.dto;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateFileUploadDTO {
	
	public TemplateFileUploadDTO() {
		super();

	}
	
	public TemplateFileUploadDTO(String docId, String docName, String docType) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.docType = docType;		
	}

	public TemplateFileUploadDTO(String docName, String docType, byte[] supportDoc, String refId) {
		super();
		this.docName = docName;
		this.docType = docType;
		this.supportDoc = supportDoc;
		this.refId = refId;
	//	this.createdBy = createdBy;
	}
	
	public TemplateFileUploadDTO(String docName, String docType, byte[] supportDoc, String refId, String createdBy) {
		super();
		this.docName = docName;
		this.docType = docType;
		this.supportDoc = supportDoc;
		this.refId = refId;
		this.createdBy = createdBy;
	}

	public TemplateFileUploadDTO(String docId, String docName, String docType, byte[] supportDoc, String refId) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.docType = docType;
		this.supportDoc = supportDoc;
		this.refId = refId;
	}

	private String docId;
	private String docName;
	private String docType;
	private byte[] supportDoc;

	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;

	private String activeFlag;
	private String deleteFlag;
	private String refId;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getSupportDoc() {
		return supportDoc;
	}

	public void setSupportDoc(byte[] supportDoc) {
		this.supportDoc = supportDoc;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	@Override
	public String toString() {
		return "TemplateFileUploadDTO [docId=" + docId + ", docName=" + docName + ", docType=" + docType
				+ ", supportDoc=" + Arrays.toString(supportDoc) + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", activeFlag="
				+ activeFlag + ", deleteFlag=" + deleteFlag + ", refId=" + refId + "]";
	}

	
	
}
