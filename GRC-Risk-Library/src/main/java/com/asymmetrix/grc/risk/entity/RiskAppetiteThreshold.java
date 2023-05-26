package com.asymmetrix.grc.risk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "RISK_APPETITE_THRESHOLD")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RiskAppetiteThreshold extends Auditable {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "APPETITE_THRESHOLD_ID")
	private String thresholdId;

	@Column(name = "APPETITE_ID", updatable = false)
	private long appetiteId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String appetiteUniqueId;

	@Column(name = "VERY_HIGH_VALUE_ONE")
	private String veryHighValueOne;

	@Column(name = "VERY_HIGH_VALUE_TWO")
	private String veryHighValueTwo;

	@Column(name = "HIGH_VALUE_ONE")
	private String highValueOne;

	@Column(name = "HIGH_VALUE_TWO")
	private String highValueTwo;

	@Column(name = "MEDIUM_VALUE_ONE")
	private String mediumValueOne;

	@Column(name = "MEDIUM_VALUE_TWO")
	private String mediumValueTwo;

	@Column(name = "LOW_VALUE_ONE")
	private String lowValueOne;

	@Column(name = "LOW_VALUE_TWO")
	private String lowValueTwo;

	@Column(name = "VERY_LOW_VALUE_ONE")
	private String veryLowValueOne;

	@Column(name = "VERY_LOW_VALUE_TWO")
	private String veryLowValueTwo;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	public String getThresholdId() {
		return thresholdId;
	}

	public void setThresholdId(String thresholdId) {
		this.thresholdId = thresholdId;
	}

	public long getAppetiteId() {
		return appetiteId;
	}

	public void setAppetiteId(long appetiteId) {
		this.appetiteId = appetiteId;
	}

	public String getVeryHighValueOne() {
		return veryHighValueOne;
	}

	public void setVeryHighValueOne(String veryHighValueOne) {
		this.veryHighValueOne = veryHighValueOne;
	}

	public String getVeryHighValueTwo() {
		return veryHighValueTwo;
	}

	public void setVeryHighValueTwo(String veryHighValueTwo) {
		this.veryHighValueTwo = veryHighValueTwo;
	}

	public String getHighValueOne() {
		return highValueOne;
	}

	public void setHighValueOne(String highValueOne) {
		this.highValueOne = highValueOne;
	}

	public String getHighValueTwo() {
		return highValueTwo;
	}

	public void setHighValueTwo(String highValueTwo) {
		this.highValueTwo = highValueTwo;
	}

	public String getMediumValueOne() {
		return mediumValueOne;
	}

	public void setMediumValueOne(String mediumValueOne) {
		this.mediumValueOne = mediumValueOne;
	}

	public String getMediumValueTwo() {
		return mediumValueTwo;
	}

	public void setMediumValueTwo(String mediumValueTwo) {
		this.mediumValueTwo = mediumValueTwo;
	}

	public String getLowValueOne() {
		return lowValueOne;
	}

	public void setLowValueOne(String lowValueOne) {
		this.lowValueOne = lowValueOne;
	}

	public String getLowValueTwo() {
		return lowValueTwo;
	}

	public void setLowValueTwo(String lowValueTwo) {
		this.lowValueTwo = lowValueTwo;
	}

	public String getVeryLowValueOne() {
		return veryLowValueOne;
	}

	public void setVeryLowValueOne(String veryLowValueOne) {
		this.veryLowValueOne = veryLowValueOne;
	}

	public String getVeryLowValueTwo() {
		return veryLowValueTwo;
	}

	public void setVeryLowValueTwo(String veryLowValueTwo) {
		this.veryLowValueTwo = veryLowValueTwo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getAppetiteUniqueId() {
		return appetiteUniqueId;
	}

	public void setAppetiteUniqueId(String appetiteUniqueId) {
		this.appetiteUniqueId = appetiteUniqueId;
	}
	
	

}
