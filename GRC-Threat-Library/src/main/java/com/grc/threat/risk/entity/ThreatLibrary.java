package com.grc.threat.risk.entity;

import java.util.Date;

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
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "THREAT_LIBRARY")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ThreatLibrary extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
//	@SequenceGenerator(name="SEQUENCE1", sequenceName="TAB_RISKLIBRARY_SEQ", allocationSize=1)
	@Column(name = "THREAT_ID")
	private long threatId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String threatUniqueId;
	
	@Column(name = "PREF_ORG", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "THREAT_NAME")
	private String threatName;

	@Column(name = "THREAT_DESC")
	private String threatDesc;

	@Column(name = "SOURCE_TYPE")
	private String threatSourceType;

	@Column(name = "THREAT_CATEGORY")
	private String threatCategory;

	@Column(name = "THREAT_REMARKS")
	private String threatRemarks;
	
	@Column(name = "REPORTED_DATE")
	private Date reportedDate;
	
	@Column(name = "THREAT_OWNER")
	private String threatOwner;
	
	@Column(name = "ORG_REF")
	private String orgRef;
	
	@Column(name = "SUBSIDAIRY_REF")
	private String subsidiaryRef;
	
	@Column(name = "DEPT_REF")
	private String departmentRef;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	public long getThreatId() {
		return threatId;
	}

	public void setThreatId(long threatId) {
		this.threatId = threatId;
	}

	public String getThreatUniqueId() {
		return threatUniqueId;
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

	public String getDepartmentRef() {
		return departmentRef;
	}

	public void setDepartmentRef(String departmentRef) {
		this.departmentRef = departmentRef;
	}

	public String getSubsidiaryRef() {
		return subsidiaryRef;
	}

	public void setSubsidiaryRef(String subsidiaryRef) {
		this.subsidiaryRef = subsidiaryRef;
	}


}
