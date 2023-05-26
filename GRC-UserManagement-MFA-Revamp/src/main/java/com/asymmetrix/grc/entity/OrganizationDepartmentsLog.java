package com.asymmetrix.grc.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORGANIZATION_DEPARTMENT_LOG")
public class OrganizationDepartmentsLog  {

	@Id
	@Column(name = "LOG_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long logId;	
	
	@Column(name = "N_ID")	
	private long orgDepartmentId;

	@Column(name = "V_DEPARTMENT_ID")
	private String departmentId;
	
	@Column(name = "V_DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name = "V_ORGANIZATION_ID")
	private String organizationId;
	
	@Column(name = "V_ORGANIZATION_NAME")
	private String organizationName;
	
	@Column(name = "V_SUBSIDIARY_ID")
	private String subsidiaryId;
	
	@Column(name = "V_SUBSIDIARY_NAME")
	private String subsidiaryName;	

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
	
	 @Column(name = "D_CREATED")
	 private Date createdDate;
	 
	 @Column(name = "D_LAST_UPDATED")
	 private Date modifiedDate;
	 
	 @Column(name = "V_REMARKS")
	 private String remarks;

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public long getOrgDepartmentId() {
		return orgDepartmentId;
	}

	public void setOrgDepartmentId(long orgDepartmentId) {
		this.orgDepartmentId = orgDepartmentId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getSubsidiaryId() {
		return subsidiaryId;
	}

	public void setSubsidiaryId(String subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

	public String getSubsidiaryName() {
		return subsidiaryName;
	}

	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	
}
