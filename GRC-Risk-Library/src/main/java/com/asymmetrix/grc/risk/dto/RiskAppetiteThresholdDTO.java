package com.asymmetrix.grc.risk.dto;

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
public class RiskAppetiteThresholdDTO {

	private String thresholdId;
	private long appetiteId;
	private String appetiteUniqueId;
	private String veryHighValueOne;
	private String veryHighValueTwo;
	private String highValueOne;
	private String highValueTwo;
	private String mediumValueOne;
	private String mediumValueTwo;
	private String lowValueOne;
	private String lowValueTwo;
	private String veryLowValueOne;
	private String veryLowValueTwo;
	private String status;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String deleteFlag;
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
