package com.grc.threat.risk.dto;

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
public class ThreatLibraryDTO {

	private long threatId;
	
	private String threatUniqueId;
	private String preferenceOganization;
	private String preferenceYear;

	private String threatName;

	private String threatDesc;

	private String threatCategory;

	private String threatSourceType;

	private String threatRemarks;
	
	private Date reportedDate;
	
	private String threatOwner;	

	private Date createdDate;

	private String createdBy;

	private Date modifiedDate;

	private String modifiedBy;

	private String deleteFlag;
	
	private String activeFlag;
	
	private String orgRef;
	
	private String subsidiaryRef;
	
	private String departmentRef;

	public long getThreatId() {
		return threatId;
	}

	public void setThreatId(long threatId) {
		this.threatId = threatId;
	}

	public String getThreatUniqueId() {
	//	return threatUniqueId;
		String tempRes = null;
		if (getPreferenceOganization() != null) {
			tempRes = getPreferenceOganization()+"/";
		}
		if (getPreferenceYear() != null) {
			tempRes = tempRes + getPreferenceYear()+"/";
		}
		if (tempRes != null) {
			tempRes = tempRes + threatUniqueId;
			return tempRes;
		}else {
			return threatUniqueId;
			}
	}

	public void setThreatUniqueId(String threatUniqueId) {
		this.threatUniqueId = threatUniqueId;
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

	public String getThreatName() {
		return threatName;
	}

	public void setThreatName(String threatName) {
		this.threatName = threatName;
	}

	public String getThreatDesc() {
		return threatDesc;
	}

	public void setThreatDesc(String threatDesc) {
		this.threatDesc = threatDesc;
	}

	public String getThreatCategory() {
		return threatCategory;
	}

	public void setThreatCategory(String threatCategory) {
		this.threatCategory = threatCategory;
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

	public String getThreatSourceType() {
		return threatSourceType;
	}

	public void setThreatSourceType(String threatSourceType) {
		this.threatSourceType = threatSourceType;
	}

	public String getThreatRemarks() {
		return threatRemarks;
	}

	public void setThreatRemarks(String threatRemarks) {
		this.threatRemarks = threatRemarks;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getThreatOwner() {
		return threatOwner;
	}

	public void setThreatOwner(String threatOwner) {
		this.threatOwner = threatOwner;
	}

	public String getOrgRef() {
		return orgRef;
	}

	public void setOrgRef(String orgRef) {
		this.orgRef = orgRef;
	}

	public String getSubsidiaryRef() {
		return subsidiaryRef;
	}

	public void setSubsidiaryRef(String subsidiaryRef) {
		this.subsidiaryRef = subsidiaryRef;
	}

	public String getDepartmentRef() {
		return departmentRef;
	}

	public void setDepartmentRef(String departmentRef) {
		this.departmentRef = departmentRef;
	}



}
