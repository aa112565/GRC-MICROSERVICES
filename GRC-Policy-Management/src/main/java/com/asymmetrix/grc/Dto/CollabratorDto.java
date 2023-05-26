package com.asymmetrix.grc.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollabratorDto {
	
    private long collabratorId;
	private String policyId;
	private String collabrateId;
	private String attestaionsId;
	private String policyUniqueId;
	private String status;
	private String approve;
	private String reject;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String activeFlag;
	private String deleteFlag;
	
	public long getCollabratorId() {
		return collabratorId;
	}
	public void setCollabratorId(long collabratorId) {
		this.collabratorId = collabratorId;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getCollabrateId() {
		return collabrateId;
	}
	public void setCollabrateId(String collabrateId) {
		this.collabrateId = collabrateId;
	}
	public String getAttestaionsId() {
		return attestaionsId;
	}
	public void setAttestaionsId(String attestaionsId) {
		this.attestaionsId = attestaionsId;
	}
	public String getPolicyUniqueId() {
		return policyUniqueId;
	}
	public void setPolicyUniqueId(String policyUniqueId) {
		this.policyUniqueId = policyUniqueId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getReject() {
		return reject;
	}
	public void setReject(String reject) {
		this.reject = reject;
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

	
	
	
}
