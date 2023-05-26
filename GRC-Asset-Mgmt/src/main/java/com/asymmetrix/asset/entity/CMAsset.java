package com.asymmetrix.asset.entity;

//import java.io.File;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "CM_ASSET_LIBRARY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CMAsset extends Auditable {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCEASSET")
	@SequenceGenerator(name = "SEQUENCEASSET", sequenceName = "ASSET_SEQUENCE", allocationSize = 1)
	@Column(name = "ASSET_ID")
	private long assetId;

	@Column(name = "ASSET_TYPE")
	private String assetType;

	@Column(name = "ASSET_NAME")
	private String assetName;

	@Column(name = "ASSET_DESC")
	private String assetDesc;

	@Column(name = "ASSET_CODE")
	private String assetCode;

	@Column(name = "ASSET_SERIAL_NUMBER")
	private String assetSerialNumber;

	@Column(name = "ASSET_CATEGORY")
	private String assetCategory;

	@Column(name = "LEASED_DATE")
	private String LeasedDate;

	@Column(name = "LEASE_ENDING_DATE")
	private String LeaseEndingDate;

	@Column(name = "ASSET_PURCHASE_DATE")
	private String assetPurchaseDate;

	@Column(name = "GL_CODE")
	private String glCode;

	@Column(name = "PURCHASE_ORDER_NUMBER")
	private String purchaseOrderNumber;

	@Column(name = "ASSET_SUPPLIER_DETAILS")
	private String assetSupplierDetails;

	@Column(name = "MANUFACTURER_DETAILS")
	private String manufacturerDetails;

	@Column(name = "WARRANTY_TILL")
	private String warrantyTill;

	@Column(name = "ASSET_INDUSTRY")
	private String assetIndustry;

	@Column(name = "ASSET_CLASSIFICATION")
	private String assetClassification;

	@Column(name = "UPLOAD_IMAGE")
	private String uploadImage;

	@Column(name = "ASSET_PRIMARY_OWNER_ID")
	private String assetPrimaryOwnerId;

	@Column(name = "ASSET_SECURITY_OWNER_ID")
	private String assetSecurityOwnerId;

	@Column(name = "ASSET_SECONDARY_OWNER_ID")
	private String assetSecondaryOwnerId;

	@Column(name = "ASSET_ALLOCATED_TO_ID")
	private String assetAllocatedToId;

	@Column(name = "ASSET_PRIMARY_OWNER")
	private String assetPrimaryOwner;

	@Column(name = "ASSET_SECURITY_OWNER")
	private String assetSecurityOwner;

	@Column(name = "ASSET_SECONDARY_OWNER")
	private String assetSecondaryOwner;

	@Column(name = "ASSET_ALLOCATED_TO")
	private String assetAllocatedTo;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetDesc() {
		return assetDesc;
	}

	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getAssetSerialNumber() {
		return assetSerialNumber;
	}

	public void setAssetSerialNumber(String assetSerialNumber) {
		this.assetSerialNumber = assetSerialNumber;
	}

	public String getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getLeasedDate() {
		return LeasedDate;
	}

	public void setLeasedDate(String leasedDate) {
		LeasedDate = leasedDate;
	}

	public String getLeaseEndingDate() {
		return LeaseEndingDate;
	}

	public void setLeaseEndingDate(String leaseEndingDate) {
		LeaseEndingDate = leaseEndingDate;
	}

	public String getAssetPurchaseDate() {
		return assetPurchaseDate;
	}

	public void setAssetPurchaseDate(String assetPurchaseDate) {
		this.assetPurchaseDate = assetPurchaseDate;
	}

	public String getGlCode() {
		return glCode;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public String getAssetSupplierDetails() {
		return assetSupplierDetails;
	}

	public void setAssetSupplierDetails(String assetSupplierDetails) {
		this.assetSupplierDetails = assetSupplierDetails;
	}

	public String getManufacturerDetails() {
		return manufacturerDetails;
	}

	public void setManufacturerDetails(String manufacturerDetails) {
		this.manufacturerDetails = manufacturerDetails;
	}

	public String getWarrantyTill() {
		return warrantyTill;
	}

	public void setWarrantyTill(String warrantyTill) {
		this.warrantyTill = warrantyTill;
	}

	public String getAssetIndustry() {
		return assetIndustry;
	}

	public void setAssetIndustry(String assetIndustry) {
		this.assetIndustry = assetIndustry;
	}

	public String getAssetClassification() {
		return assetClassification;
	}

	public void setAssetClassification(String assetClassification) {
		this.assetClassification = assetClassification;
	}

	public String getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(String uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getAssetPrimaryOwnerId() {
		return assetPrimaryOwnerId;
	}

	public void setAssetPrimaryOwnerId(String assetPrimaryOwnerId) {
		this.assetPrimaryOwnerId = assetPrimaryOwnerId;
	}

	public String getAssetSecurityOwnerId() {
		return assetSecurityOwnerId;
	}

	public void setAssetSecurityOwnerId(String assetSecurityOwnerId) {
		this.assetSecurityOwnerId = assetSecurityOwnerId;
	}

	public String getAssetSecondaryOwnerId() {
		return assetSecondaryOwnerId;
	}

	public void setAssetSecondaryOwnerId(String assetSecondaryOwnerId) {
		this.assetSecondaryOwnerId = assetSecondaryOwnerId;
	}

	public String getAssetAllocatedToId() {
		return assetAllocatedToId;
	}

	public void setAssetAllocatedToId(String assetAllocatedToId) {
		this.assetAllocatedToId = assetAllocatedToId;
	}

	public String getAssetPrimaryOwner() {
		return assetPrimaryOwner;
	}

	public void setAssetPrimaryOwner(String assetPrimaryOwner) {
		this.assetPrimaryOwner = assetPrimaryOwner;
	}

	public String getAssetSecurityOwner() {
		return assetSecurityOwner;
	}

	public void setAssetSecurityOwner(String assetSecurityOwner) {
		this.assetSecurityOwner = assetSecurityOwner;
	}

	public String getAssetSecondaryOwner() {
		return assetSecondaryOwner;
	}

	public void setAssetSecondaryOwner(String assetSecondaryOwner) {
		this.assetSecondaryOwner = assetSecondaryOwner;
	}

	public String getAssetAllocatedTo() {
		return assetAllocatedTo;
	}

	public void setAssetAllocatedTo(String assetAllocatedTo) {
		this.assetAllocatedTo = assetAllocatedTo;
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

}
