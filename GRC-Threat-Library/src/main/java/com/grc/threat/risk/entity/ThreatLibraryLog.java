package com.grc.threat.risk.entity;

import java.util.Date;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "THREAT_LIBRARY_LOG")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ThreatLibraryLog {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String id;

	@Column(name = "THREAT_ID", updatable = false)
	private long threatId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String threatUniqueId;
	
	@Column(name = "PREF_ORG", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "THREAT_NAME", updatable = false)
	private String threatName;

	@Column(name = "THREAT_DESC", updatable = false)
	private String threatDesc;

	@Column(name = "THREAT_REMARKS")
	private String threatRemarks;

	@Column(name = "THREAT_CATEGORY", updatable = false)
	private String threatCategory;

	@Column(name = "SOURCE_TYPE")
	private String threatSourceType;
	
	@Column(name = "REPORTED_DATE")
	private Date reportedDate;
	
	@Column(name = "THREAT_OWNER")
	private String threatOwner;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private String modifiedBy;
	
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE", updatable = false)
	private Date modifiedDate;

	@Column(name = "DELETE_FLAG", updatable = false)
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG", updatable = false)
	private String activeFlag;
	
	@Column(name = "ORG_REF")
	private String orgRef;
	
	@Column(name = "SUBSIDAIRY_REF")
	private String subsidiaryRef;
	
	@Column(name = "DEPT_REF")
	private String departmentRef;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getThreatSourceType() {
		return threatSourceType;
	}

	public void setThreatSourceType(String threatSourceType) {
		this.threatSourceType = threatSourceType;
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

	public String getThreatRemarks() {
		return threatRemarks;
	}

	public void setThreatRemarks(String threatRemarks) {
		this.threatRemarks = threatRemarks;
	}

	
	
}
