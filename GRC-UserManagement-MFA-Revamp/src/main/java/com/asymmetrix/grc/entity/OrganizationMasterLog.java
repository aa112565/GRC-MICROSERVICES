package com.asymmetrix.grc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.asymmetrix.grc.entity.Auditable;

@SuppressWarnings("unused")
@Entity
@Table(name = "ORGANIZATION_MASTER_LOG")
public class OrganizationMasterLog {	

	@Id
	@Column(name = "LOG_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long logId;	
	
	@Column(name = "N_ID")	
	private long organizationId;

	@Column(name = "V_ORGANIZATION_NAME")
	private String organizationName;

	@Column(name = "V_ADDRESS_ONE")
	private String addressOne;
	
	@Column(name = "V_ADDRESS_TWO")
	private String addressTwo;
	
	@Column(name = "V_ADDRESS_THREE")
	private String addressThree;
	
	@Column(name = "V_CITY")
	private String orgCity;
	
	@Column(name = "V_STATE")
	private String orgState;
	
	@Column(name = "V_COUNTRY")
	private String orgCountry;
	
	@Column(name = "V_ZIPCODE")
	private String orgZipCode;
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
	
	 @Column(name = "D_CREATED")
	 private Date createdDate;
	 
	 @Column(name = "D_LAST_UPDATED")
	 private Date modifiedDate;

	 @Column(name = "V_REMARKS")
	 private String remarks;
	 
	 
	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
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

	public String getOrgCity() {
		return orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	public String getOrgState() {
		return orgState;
	}

	public void setOrgState(String orgState) {
		this.orgState = orgState;
	}

	public String getOrgCountry() {
		return orgCountry;
	}

	public void setOrgCountry(String orgCountry) {
		this.orgCountry = orgCountry;
	}

	public String getOrgZipCode() {
		return orgZipCode;
	}

	public void setOrgZipCode(String orgZipCode) {
		this.orgZipCode = orgZipCode;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
