package com.asymmetrix.grc.riskkri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "KRI_METRICS_UPDATE")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KriMetricsUpdate extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "METRICS_ID")
	private long metricsId;

	@Column(name = "FREQUENCY")
	private String frequency;

	@Column(name = "FINANCIAL_YEAR")
	private String financialYear;

	@Column(name = "FIELD_ONE_VALUE")
	private String fieldOneValue;

	@Column(name = "FIELD_TWO_VALUE")
	private String fieldTwoValue;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "UPLOAD_FILE_NAME")
	private String uploadFileName;

	@Lob
	@Column(name = "UPLOAD_FILE")
	private byte[] uploadFile;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "KRI_ID", updatable = false)
	private String kriId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String kriUniqueId;


	@Column(name = "BUSINESSLINE_ID")
	private String buninessLineId;

	@Column(name = "OTHERDETAIL_ID")
	private String otherDetailId;

	@Column(name = "THRESHOLD_ID")
	private String thresholdDefId;

	@Column(name = "FORMULA_ID")
	private String formulaId;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "CURRENT_LEVEL")
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getKriId() {
		return kriId;
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

	public void setKriId(String kriId) {
		this.kriId = kriId;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}

	
}
