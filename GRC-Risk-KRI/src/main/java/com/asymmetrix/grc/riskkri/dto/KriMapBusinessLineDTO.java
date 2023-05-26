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
public class KriMapBusinessLineDTO {

	private long buninessLineId;

	private String buninessLineOne;

	private String buninessLineTwo;

	private String riskEventTypeOne;

	private String riskEventTypeTwo;

	private String riskCategory;

	private String causeCategory;

	private String location;

	private String dataCollection;

	private String countDataCollectField;

	private String owner;

	private String deleteFlag;

	private String activeFlag;

	private Date createdDate;

	private String createdBy;

	private Date modifiedDate;

	private String modifiedBy;

	private String kriId;
	
	private String kriUniqueId;

	public long getBuninessLineId() {
		return buninessLineId;
	}

	public void setBuninessLineId(long buninessLineId) {
		this.buninessLineId = buninessLineId;
	}

	public String getBuninessLineOne() {
		return buninessLineOne;
	}

	public void setBuninessLineOne(String buninessLineOne) {
		this.buninessLineOne = buninessLineOne;
	}

	public String getBuninessLineTwo() {
		return buninessLineTwo;
	}

	public void setBuninessLineTwo(String buninessLineTwo) {
		this.buninessLineTwo = buninessLineTwo;
	}

	public String getRiskEventTypeOne() {
		return riskEventTypeOne;
	}

	public void setRiskEventTypeOne(String riskEventTypeOne) {
		this.riskEventTypeOne = riskEventTypeOne;
	}

	public String getRiskEventTypeTwo() {
		return riskEventTypeTwo;
	}

	public void setRiskEventTypeTwo(String riskEventTypeTwo) {
		this.riskEventTypeTwo = riskEventTypeTwo;
	}

	public String getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}

	public String getCauseCategory() {
		return causeCategory;
	}

	public void setCauseCategory(String causeCategory) {
		this.causeCategory = causeCategory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDataCollection() {
		return dataCollection;
	}

	public void setDataCollection(String dataCollection) {
		this.dataCollection = dataCollection;
	}

	public String getCountDataCollectField() {
		return countDataCollectField;
	}

	public void setCountDataCollectField(String countDataCollectField) {
		this.countDataCollectField = countDataCollectField;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getKriId() {
		return kriId;
	}

	public void setKriId(String kriId) {
		this.kriId = kriId;
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

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}
	
	

}
