package com.asymmetrix.grc.riskkri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "KRI_THRESHOLD_DEFINITION")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class KriThresholdDefinition extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "THRESHOLD_ID")
	private long thresholdDefId;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "THRESHOLD")
	private String threshold;

	@Column(name = "MEASURING_SCALE")
	private String measuringScale;

	@Column(name = "SAFE_ZONE")
	private String safeZone;

	@Column(name = "WARNING_LEVEL")
	private String warningLevel;

	@Column(name = "ESCALATION_LEVEL")
	private String escalationLevel;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "KRI_ID", updatable = false)
	private String kriId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String kriUniqueId;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}

	
}
