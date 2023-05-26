package com.asymmetrix.grc.riskkri.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KriThresholdDefinitionDTO {

	private long thresholdDefId;
	private String currency;
	private String threshold;
	private String measuringScale;
	private String safeZone;
	private String warningLevel;
	private String escalationLevel;
	private Date createdDate;
	private String CreatedBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String kriId;
	private String kriUniqueId;
	private String deleteFlag;
	private String activeFlag;

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public long getThresholdDefId() {
		return thresholdDefId;
	}

	public void setThresholdDefId(long thresholdDefId) {
		this.thresholdDefId = thresholdDefId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	public String getMeasuringScale() {
		return measuringScale;
	}

	public void setMeasuringScale(String measuringScale) {
		this.measuringScale = measuringScale;
	}

	public String getSafeZone() {
		return safeZone;
	}

	public void setSafeZone(String safeZone) {
		this.safeZone = safeZone;
	}

	public String getWarningLevel() {
		return warningLevel;
	}

	public void setWarningLevel(String warningLevel) {
		this.warningLevel = warningLevel;
	}

	public String getEscalationLevel() {
		return escalationLevel;
	}

	public void setEscalationLevel(String escalationLevel) {
		this.escalationLevel = escalationLevel;
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

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}

}
