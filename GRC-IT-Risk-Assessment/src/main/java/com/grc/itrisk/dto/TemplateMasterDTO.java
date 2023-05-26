package com.grc.itrisk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;

@SuppressWarnings("unused")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateMasterDTO {
	
	
	private long templateId;	
	private String templateUniqueId;
	private String preferenceOganization;
	private String preferenceYear;	
	private String templateName;
	private String remarks;
	private String createdBy;
	private String modifiedBy;	
	private Date createdDate;
	private Date modifiedDate;
	private String activeFlag;
	private String deleteFlag;
	private String saveFlag;	
	
	
	public long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public String getTemplateUniqueId() {
		String tempRes = null;
		if (getPreferenceOganization() != null) {
			tempRes = getPreferenceOganization()+"/";
		}
		if (getPreferenceYear() != null) {
			tempRes = tempRes + getPreferenceYear()+"/";
		}
		if (tempRes != null) {
			tempRes = tempRes + templateUniqueId;
			return tempRes;
		}else {
			return templateUniqueId;
		}		
	//	return templateUniqueId;
	}
	
	public void setTemplateUniqueId(String templateUniqueId) {
		this.templateUniqueId = templateUniqueId;
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
