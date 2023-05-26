package com.asymmetrix.grc.riskcontrol.dto;

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
public class ControlLibraryDTO {

	private long controlId;
	
	private String controlUniqueId;
	private String preferenceOganization;
	private String preferenceYear;

	private String controlName;

	private String controlDesc;

	private String controlCategory;

	private String controlType;

	private String controlApprStatus;

	private Date createdDate;

	private String createdBy;

	private Date modifiedDate;

	private String modifiedBy;

	private String deleteFlag;
	
	private String activeFlag;

	public long getControlId() {
		return controlId;
	}

	public void setControlId(long controlId) {
		this.controlId = controlId;
	}

	public String getControlName() {
		return controlName;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	public String getControlDesc() {
		return controlDesc;
	}

	public void setControlDesc(String controlDesc) {
		this.controlDesc = controlDesc;
	}

	public String getControlCategory() {
		return controlCategory;
	}

	public void setControlCategory(String controlCategory) {
		this.controlCategory = controlCategory;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getControlApprStatus() {
		return controlApprStatus;
	}

	public void setControlApprStatus(String controlApprStatus) {
		this.controlApprStatus = controlApprStatus;
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

	public String getControlUniqueId() {
		//return controlUniqueId;
		String tempRes = null;
		if (getPreferenceOganization() != null) {
			tempRes = getPreferenceOganization()+"/";
		}
		if (getPreferenceYear() != null) {
			tempRes = tempRes + getPreferenceYear()+"/";
		}
		if (tempRes != null) {
			tempRes = tempRes + controlUniqueId;
			return tempRes;
		}else {
			return controlUniqueId;
			}
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
