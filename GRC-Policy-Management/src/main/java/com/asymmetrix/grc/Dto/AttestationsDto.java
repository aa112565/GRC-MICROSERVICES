package com.asymmetrix.grc.Dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttestationsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private long attestaionsId;
	private String agreement;
	private Date duedate;
	private Date expirydate;
	private String[] usergroups;
	private String[] user;
	private String PolicyId;
	private String activeFlag = "Y";
	private String deleteFlag = "N";
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String alertMessage;
	
	public long getAttestaionsId() {
		return attestaionsId;
	}
	public void setAttestaionsId(long attestaionsId) {
		this.attestaionsId = attestaionsId;
	}
	public String getAgreement() {
		return agreement;
	}
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	
	public String[] getUsergroups() {
		return usergroups;
	}
	public void setUsergroups(String[] usergroups) {
		this.usergroups = usergroups;
	}
	public String[] getUser() {
		return user;
	}
	public void setUser(String[] user) {
		this.user = user;
	}
	public String getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(String policyId) {
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
	public String getAlertMessage() {
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	
	
	
	

}
