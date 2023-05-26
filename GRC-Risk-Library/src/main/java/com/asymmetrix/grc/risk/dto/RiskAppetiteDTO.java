package com.asymmetrix.grc.risk.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskAppetiteDTO {

	private long appetiteId;
	private String appetiteUniqueId;
	private String preferenceOganization;
	private String preferenceYear;
	private String appetiteStatement;
	private String appetiteCalculation;
	private String riskType;
	private String appetiteType;
	private String reportingYear;
	private Date reportingDate;
	private String status;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String deleteFlag;
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
	//	return appetiteUniqueId;
		String tempRes = null;
		if (getPreferenceOganization() != null) {
			tempRes = getPreferenceOganization()+"/";
		}
		if (getPreferenceYear() != null) {
			tempRes = tempRes + getPreferenceYear()+"/";
		}
		if (tempRes != null) {
			tempRes = tempRes + appetiteUniqueId;
			return tempRes;
		}else {
			return appetiteUniqueId;
			}
		
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
