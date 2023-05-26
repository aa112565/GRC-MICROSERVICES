package com.asymmetrix.grc.entity;

//import java.util.Date;

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
@Table(name = "RISK_WORKSHOP_MOM", schema = "GRC_TEST_ENV_DB")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskWorkshopMOM extends Auditable{
	
	@Id
	@Column(name = "N_MOM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long momID;
	
	@Column(name="V_WORKSHOP_ID")
	private String workshopID;
	
	@Column(name="V_MOM")
	private String mom;
	
	@Column(name="V_APPROVER_REMARKS")
	private String approverRemarks;
	
	@Column(name="V_RISK_OWNER_REMARKS")
	private String riskOwnerRemarks;
	
	@Column(name="V_APPROVER_STATUS")
	private String approverStatus;
	
//	@Column(name="D_CREATED_DATE")
//	private Date createdDate;
	
	@Column(name="V_CREATED_BY")
	private String createdBy;
	
//	@Column(name="D_MODIFIED_DATE")
//	private Date modifiedDate;
	
	@Column(name="V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name="V_ACTIVE")
	private String active = "Y";

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
/*
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
*/
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

/*	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
*/
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
