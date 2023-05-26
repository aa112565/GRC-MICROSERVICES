package com.asymmetrix.grc.Dto;

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
public class PolicyPreferenceDTO {
	
//	private long seriesId;
	private String preferenceOganization;
	private String preferenceYear;
	private String preferenceModule;
	private String runningSeries;
	private String status;
	private String activeFlag;
	private String deleteFlag;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;

	
//	public long getSeriesId() {
//		return seriesId;
//	}
//	public void setSeriesId(long seriesId) {
//		this.seriesId = seriesId;
//	}
//	
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
	public String getPreferenceModule() {
		return preferenceModule;
	}
	public void setPreferenceModule(String preferenceModule) {
		this.preferenceModule = preferenceModule;
	}
	public String getRunningSeries() {
		return runningSeries;
	}
	public void setRunningSeries(String runningSeries) {
		this.runningSeries = runningSeries;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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
