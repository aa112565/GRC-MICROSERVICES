package com.asymmetrix.grc.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "PM_PUBLISH_ATTASTATION")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublishAttestation  implements Serializable {
	
	private static final long serialVersionUID = -8351864048852184625L;
	
	@Id
	@Column(name = "N_PUBLISH_ATTASTATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long publishAttestationID;
	
	@Column(name="V_POLICY_ID")
	private long PolicyId;
	
	@Column(name = "D_CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "V_CREATED_BY")
	private String createdBy;
	
	@Column(name = "PM_APPROVE")
	private String approve;
	
	@Column(name = "PM_APP")
     private String app;
	
	@Column(name = "PM_ALERT_MESSAGE")
	private String alertMessage;
	
	@Column(name = "PUBLISHATTESTATION")
	private String publishAttestation;
	
	@Column(name = "PM_EMAIL")
	private String email;
	
	@Column(name = "D_MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name = "V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag = "Y";
		 
	@Column(name = "DELETE_FLAG")
	private String deleteFlag = "N";

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

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
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

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	
	

}
