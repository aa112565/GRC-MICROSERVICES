package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;

import javax.persistence.Column;

@SuppressWarnings("unused")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationSubsidiaryDTO {	
	
	private long subsidiaryId;
	private String subsidiaryName;
	private String organizationId;
	private String organizationName;
	private String addressOne;
	private String addressTwo;
	private String addressThree;
	private String subsidiaryCity;
	private String subsidiaryState;
	private String subsidiaryCountry;
	private String subsidiaryZipCode;
	private String createdBy;
	private String modifiedBy;	
	private Date createdDate;
	private Date modifiedDate;
	private String activeFlag;
	
	private String remarks;
	
	public long getSubsidiaryId() {
		return subsidiaryId;
	}
	public void setSubsidiaryId(long subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}
	public String getSubsidiaryName() {
		return subsidiaryName;
	}
	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
	}
	
	
	
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	public String getAddressThree() {
		return addressThree;
	}
	public void setAddressThree(String addressThree) {
		this.addressThree = addressThree;
	}
	public String getSubsidiaryCity() {
		return subsidiaryCity;
	}
	public void setSubsidiaryCity(String subsidiaryCity) {
		this.subsidiaryCity = subsidiaryCity;
	}
	public String getSubsidiaryState() {
		return subsidiaryState;
	}
	public void setSubsidiaryState(String subsidiaryState) {
		this.subsidiaryState = subsidiaryState;
	}
	public String getSubsidiaryCountry() {
		return subsidiaryCountry;
	}
	public void setSubsidiaryCountry(String subsidiaryCountry) {
		this.subsidiaryCountry = subsidiaryCountry;
	}
	public String getSubsidiaryZipCode() {
		return subsidiaryZipCode;
	}
	public void setSubsidiaryZipCode(String subsidiaryZipCode) {
		this.subsidiaryZipCode = subsidiaryZipCode;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
