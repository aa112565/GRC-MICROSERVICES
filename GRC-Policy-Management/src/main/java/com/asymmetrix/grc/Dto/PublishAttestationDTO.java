package com.asymmetrix.grc.Dto;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublishAttestationDTO {
	
	private long publishAttestationID;
	private long PolicyId;
	private String activeFlag = "Y";
	private String deleteFlag = "N";
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
//	private MultipartFile[] files;
	private String email;
    private String approve;
    private String app;
	private String publishAttestation;
	private String alertMessage;
	
	
	public long getPublishAttestationID() {
		return publishAttestationID;
	}
	public void setPublishAttestationID(long publishAttestationID) {
		this.publishAttestationID = publishAttestationID;
	}
	
	public long getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(long policyId) {
		PolicyId = policyId;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
//	public MultipartFile[] getFiles() {
//		return files;
//	}
//	public void setFiles(MultipartFile[] files) {
//		this.files = files;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getPublishAttestation() {
		return publishAttestation;
	}
	public void setPublishAttestation(String publishAttestation) {
		this.publishAttestation = publishAttestation;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getAlertMessage() {
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	
	

}
