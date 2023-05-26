package com.asymmetrix.grc.risk.entity;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
//import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "RISK_LIBRARY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RiskLibrary extends Auditable {

//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
//	@SequenceGenerator(name="SEQUENCE1", sequenceName="TAB_RISKLIBRARY_SEQ", allocationSize=1)

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RISK_ID")
	private long riskId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String riskUniqueId;
	
	@Column(name = "ORG_NAME", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "RISK_NAME")
	private String riskName;

	@Column(name = "RISK_DESC")
	private String riskDesc;

	@Column(name = "RISK_TYPE")
	private String riskType;

	@Column(name = "RISK_EVENT_TYPE")
	private String riskEventType;

	@Column(name = "RISK_CATEGORY")
	private String riskCategory;

	@Column(name = "RISK_PRIM_SOURCE")
	private String riskPrimSource;

	@Column(name = "RISK_SECOND_SOURCE")
	private String riskSecondSource;

	@Column(name = "RISK_APPR_STATUS")
	private String riskApprStatus;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

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
	
	

}
