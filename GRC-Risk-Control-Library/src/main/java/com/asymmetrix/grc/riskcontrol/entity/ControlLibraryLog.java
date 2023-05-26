package com.asymmetrix.grc.riskcontrol.entity;

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
@Table(name = "CONTROL_LIBRARY_LOG")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ControlLibraryLog {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String id;

	@Column(name = "CONTROL_ID", updatable = false)
	private long controlId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String controlUniqueId;
	
	@Column(name = "ORG_NAME", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "CONTROL_NAME", updatable = false)
	private String controlName;

	@Column(name = "CONTROL_DESC", updatable = false)
	private String controlDesc;

	@Column(name = "CONTROL_TYPE", updatable = false)
	private String controlType;

	@Column(name = "CONTROL_CATEGORY", updatable = false)
	private String controlCategory;

	@Column(name = "CONTROL_APPR_STATUS", updatable = false)
	private String controlApprStatus;

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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getControlId() {
		return controlId;
	}

	public String getControlName() {
		return controlName;
	}

	public String getControlDesc() {
		return controlDesc;
	}

	public String getControlType() {
		return controlType;
	}

	public String getControlCategory() {
		return controlCategory;
	}

	public void setControlId(long controlId) {
		this.controlId = controlId;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	public void setControlDesc(String controlDesc) {
		this.controlDesc = controlDesc;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public void setControlCategory(String controlCategory) {
		this.controlCategory = controlCategory;
	}

	public String getControlApprStatus() {
		return controlApprStatus;
	}

	public void setControlApprStatus(String controlApprStatus) {
		this.controlApprStatus = controlApprStatus;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public String getControlUniqueId() {
		return controlUniqueId;
	}

	public void setControlUniqueId(String controlUniqueId) {
		this.controlUniqueId = controlUniqueId;
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
