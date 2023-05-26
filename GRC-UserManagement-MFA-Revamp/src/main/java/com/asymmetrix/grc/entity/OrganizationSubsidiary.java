package com.asymmetrix.grc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asymmetrix.grc.entity.Auditable;

@SuppressWarnings("unused")
@Entity
@Table(name = "ORGANIZATION_SUBSIDIARY")
public class OrganizationSubsidiary extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subsidiaryId;
	
	@Column(name = "V_SUBSIDIARY_NAME")
	private String subsidiaryName;
	
	@Column(name = "V_ORGANIZATION_ID")
	private String organizationId;

	@Column(name = "V_ORGANIZATION_NAME")
	private String organizationName;	

	@Column(name = "V_ADDRESS_ONE")
	private String addressOne;
	
	@Column(name = "V_ADDRESS_TWO")
	private String addressTwo;
	
	@Column(name = "V_ADDRESS_THREE")
	private String addressThree;
	
	@Column(name = "V_CITY")
	private String subsidiaryCity;
	
	@Column(name = "V_STATE")
	private String subsidiaryState;
	
	@Column(name = "V_COUNTRY")
	private String subsidiaryCountry;
	
	@Column(name = "V_ZIPCODE")
	private String subsidiaryZipCode;
	
	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name = "V_REMARKS")
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
