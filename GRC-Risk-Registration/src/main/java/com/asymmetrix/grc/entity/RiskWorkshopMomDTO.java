package com.asymmetrix.grc.entity;

import java.util.Date;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskWorkshopMomDTO {
	
	private long momID;	
	private String workshopID;	
	private String mom;	
	private String approverRemarks;	
	private String riskOwnerRemarks;	
	private String approverStatus;	
	private Date createdDate;	
	private String createdBy;	
	private Date modifiedDate;	
	private String modifiedBy;	
	private String active;

	public long getMomID() {
		return momID;
	}

	public void setMomID(long momID) {
		this.momID = momID;
	}

	public String getWorkshopID() {
		return workshopID;
	}

	public void setWorkshopID(String workshopID) {
		this.workshopID = workshopID;
	}

	public String getMom() {
		return mom;
	}

	public void setMom(String mom) {
		this.mom = mom;
	}

	public String getApproverRemarks() {
		return approverRemarks;
	}

	public void setApproverRemarks(String approverRemarks) {
		this.approverRemarks = approverRemarks;
	}

	public String getRiskOwnerRemarks() {
		return riskOwnerRemarks;
	}

	public void setRiskOwnerRemarks(String riskOwnerRemarks) {
		this.riskOwnerRemarks = riskOwnerRemarks;
	}

	public String getApproverStatus() {
		return approverStatus;
	}

	public void setApproverStatus(String approverStatus) {
		this.approverStatus = approverStatus;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
}
