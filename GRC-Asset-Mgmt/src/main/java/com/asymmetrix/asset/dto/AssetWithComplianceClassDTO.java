package com.asymmetrix.asset.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetWithComplianceClassDTO {
	
	private long assetId;	
	private String assetType;
	private String assetName;
	private String assetDesc;
	private String assetCode;
	
	private String assetSerialNumber;
	private String assetCategory;
	private String LeasedDate;
	private String LeaseEndingDate;
	private String assetPurchaseDate;
	
	private String glCode;
	private String purchaseOrderNumber;
	private String assetSupplierDetails;
	private String manufacturerDetails;
	private String warrantyTill;
	
	private String assetIndustry;
	private String assetClassification;
	private String uploadImage;
	private String minimumComplianceClass;
	private Date lastUpdatedMinimumComplianceClassDate;
	private String assetPrimaryOwnerId;
	private String assetSecurityOwnerId;	
	private String assetSecondaryOwnerId;
	private String assetAllocatedToId;	
	
	private String assetPrimaryOwner;
	private String assetSecurityOwner;	
	private String assetSecondaryOwner;	
	private String assetAllocatedTo;	
	
	private String createdBy;	
	private String modifiedBy;
	
	private Date createdDate;	
	private Date modifiedDate;	
	private String activeFlag;
	private String deleteFlag;
	
	
	
	public long getAssetId() {
		return assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	
	public String getAssetCode() {
		return assetCode;
	}
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
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
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getMinimumComplianceClass() {
		return minimumComplianceClass;
	}
	public void setMinimumComplianceClass(String minimumComplianceClass) {
		this.minimumComplianceClass = minimumComplianceClass;
	}
	public Date getLastUpdatedMinimumComplianceClassDate() {
		return lastUpdatedMinimumComplianceClassDate;
	}
	public void setLastUpdatedMinimumComplianceClassDate(Date lastUpdatedMinimumComplianceClassDate) {
		this.lastUpdatedMinimumComplianceClassDate = lastUpdatedMinimumComplianceClassDate;
	}
	
	
}
