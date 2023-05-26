package com.asymmetrix.grc.riskcontrol.entity;

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
@Table(name = "CONTROL_LIBRARY_ARABIC")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ControlLibraryArabic extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
//	@SequenceGenerator(name="SEQUENCE1", sequenceName="TAB_RISKLIBRARY_SEQ", allocationSize=1)

	@Column(name = "CONTROL_ID")
	private long controlId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String controlUniqueId;
	
	@Column(name = "ORG_NAME", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "CONTROL_NAME")
	private String controlName;

	@Column(name = "CONTROL_DESC")
	private String controlDesc;

	@Column(name = "CONTROL_TYPE")
	private String controlType;

	@Column(name = "CONTROL_CATEGORY")
	private String controlCategory;

	@Column(name = "CONTROL_APPR_STATUS")
	private String controlApprStatus;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

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

	
}
