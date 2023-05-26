package com.asymmetrix.grc.riskkri.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KriMetricsUpdateDTO {

	private long metricsId;
	private String frequency;
	private String financialYear;
	private String fieldOneValue;
	private String fieldTwoValue;
	private String remarks;
	private String uploadFileName;
	private byte[] uploadFile;
	private Date createdDate;
	private String CreatedBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String kriId;
	private String kriUniqueId;
	private String buninessLineId;
	private String otherDetailId;
	private String thresholdDefId;
	private String formulaId;

	private String deleteFlag;
	private String activeFlag;
	private String currentLevel;

	public long getMetricsId() {
		return metricsId;
	}

	public void setMetricsId(long metricsId) {
		this.metricsId = metricsId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
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

	public String getKriId() {
		return kriId;
	}

	public void setKriId(String kriId) {
		this.kriId = kriId;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getFieldOneValue() {
		return fieldOneValue;
	}

	public void setFieldOneValue(String fieldOneValue) {
		this.fieldOneValue = fieldOneValue;
	}

	public String getFieldTwoValue() {
		return fieldTwoValue;
	}

	public void setFieldTwoValue(String fieldTwoValue) {
		this.fieldTwoValue = fieldTwoValue;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public byte[] getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(byte[] uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String getBuninessLineId() {
		return buninessLineId;
	}

	public void setBuninessLineId(String buninessLineId) {
		this.buninessLineId = buninessLineId;
	}

	public String getOtherDetailId() {
		return otherDetailId;
	}

	public void setOtherDetailId(String otherDetailId) {
		this.otherDetailId = otherDetailId;
	}

	public String getThresholdDefId() {
		return thresholdDefId;
	}

	public void setThresholdDefId(String thresholdDefId) {
		this.thresholdDefId = thresholdDefId;
	}

	public String getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}

}
