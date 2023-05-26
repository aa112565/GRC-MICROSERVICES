package com.asymmetrix.grc.risk.entity;

import java.util.Date;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "RISK_LIBRARY_LOG")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RiskLibraryLog {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String id;

	@Column(name = "RISK_ID", updatable = false)
	private long riskId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String riskUniqueId;
	
	@Column(name = "ORG_NAME", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "RISK_NAME", updatable = false)
	private String riskName;

	@Column(name = "RISK_DESC", updatable = false)
	private String riskDesc;

	@Column(name = "RISK_TYPE", updatable = false)
	private String riskType;

	@Column(name = "RISK_EVENT_TYPE", updatable = false)
	private String riskEventType;

	@Column(name = "RISK_CATEGORY", updatable = false)
	private String riskCategory;

	@Column(name = "RISK_PRIM_SOURCE", updatable = false)
	private String riskPrimSource;

	@Column(name = "RISK_SECOND_SOURCE", updatable = false)
	private String riskSecondSource;

	@Column(name = "RISK_APPR_STATUS", updatable = false)
	private String riskApprStatus;
	
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE", updatable = false)
	private Date modifiedDate;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private String modifiedBy;

	@Column(name = "DELETE_FLAG", updatable = false)
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG", updatable = false)
	private String activeFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getRiskId() {
		return riskId;
	}

	public void setRiskId(long riskId) {
		this.riskId = riskId;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getRiskDesc() {
		return riskDesc;
	}

	public void setRiskDesc(String riskDesc) {
		this.riskDesc = riskDesc;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getRiskEventType() {
		return riskEventType;
	}

	public void setRiskEventType(String riskEventType) {
		this.riskEventType = riskEventType;
	}

	public String getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}

	public String getRiskPrimSource() {
		return riskPrimSource;
	}

	public void setRiskPrimSource(String riskPrimSource) {
		this.riskPrimSource = riskPrimSource;
	}

	public String getRiskSecondSource() {
		return riskSecondSource;
	}

	public void setRiskSecondSource(String riskSecondSource) {
		this.riskSecondSource = riskSecondSource;
	}

	public String getRiskApprStatus() {
		return riskApprStatus;
	}

	public void setRiskApprStatus(String riskApprStatus) {
		this.riskApprStatus = riskApprStatus;
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

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRiskUniqueId() {
		return riskUniqueId;
	}

	public void setRiskUniqueId(String riskUniqueId) {
		this.riskUniqueId = riskUniqueId;
	}

	public String getPreferenceOganization() {
		return preferenceOganization;
	}

	public void setPreferenceOganization(String preferenceOganization) {
		this.preferenceOganization = preferenceOganization;
	}

	public String getPreferenceYear() {
		return preferenceYear;
	}

	public void setPreferenceYear(String preferenceYear) {
		this.preferenceYear = preferenceYear;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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
	
	

}
