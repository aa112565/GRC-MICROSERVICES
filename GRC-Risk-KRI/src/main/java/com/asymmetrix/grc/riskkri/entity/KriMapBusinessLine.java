package com.asymmetrix.grc.riskkri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "KRI_BUSINESSLINE")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KriMapBusinessLine extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long buninessLineId;

	@Column(name = "BUSINESS_LINE_ONE")
	private String buninessLineOne;

	@Column(name = "BUSINESS_LINE_TWO")
	private String buninessLineTwo;

	@Column(name = "RISK_EVENT_TYPE_ONE")
	private String riskEventTypeOne;

	@Column(name = "RISK_EVENT_TYPE_TWO")
	private String riskEventTypeTwo;

	@Column(name = "RISK_CATEGORY")
	private String riskCategory;

	@Column(name = "CAUSE_CATETGORY")
	private String causeCategory;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "DATA_COLLECTION")
	private String dataCollection;

	@Column(name = "COUNT_DATA_COLLECT_FIELD")
	private String countDataCollectField;

	@Column(name = "OWNER")
	private String owner;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "KRI_ID", updatable = false)
	private String kriId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
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
