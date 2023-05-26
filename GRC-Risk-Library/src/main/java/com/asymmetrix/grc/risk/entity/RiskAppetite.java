package com.asymmetrix.grc.risk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "RISK_APPETITE")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RiskAppetite extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APPETITE_ID")
	private long appetiteId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String appetiteUniqueId;
	
	@Column(name = "ORG_NAME", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "APPETITE_STATEMENT")
	private String appetiteStatement;

	@Column(name = "APPETITE_CALCULATION")
	private String appetiteCalculation;

	@Column(name = "RISK_TYPE")
	private String riskType;

	@Column(name = "APPETITE_TYPE")
	private String appetiteType;

	@Column(name = "REPORTING_YEAR")
	private String reportingYear;

	@Column(name = "REPORTING_DATE")
	private Date reportingDate;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	public long getAppetiteId() {
		return appetiteId;
	}

	public void setAppetiteId(long appetiteId) {
		this.appetiteId = appetiteId;
	}

	public String getAppetiteStatement() {
		return appetiteStatement;
	}

	public void setAppetiteStatement(String appetiteStatement) {
		this.appetiteStatement = appetiteStatement;
	}

	public String getAppetiteCalculation() {
		return appetiteCalculation;
	}

	public void setAppetiteCalculation(String appetiteCalculation) {
		this.appetiteCalculation = appetiteCalculation;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getAppetiteType() {
		return appetiteType;
	}

	public void setAppetiteType(String appetiteType) {
		this.appetiteType = appetiteType;
	}

	public String getReportingYear() {
		return reportingYear;
	}

	public void setReportingYear(String reportingYear) {
		this.reportingYear = reportingYear;
	}

	public Date getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(Date reportingDate) {
		this.reportingDate = reportingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getAppetiteUniqueId() {
		return appetiteUniqueId;
	}

	public void setAppetiteUniqueId(String appetiteUniqueId) {
		this.appetiteUniqueId = appetiteUniqueId;
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

	
}
