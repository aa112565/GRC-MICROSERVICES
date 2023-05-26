package com.asymmetrix.asset.dto;

import java.util.List;

import com.asymmetrix.asset.entity.AssetTypeDD;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.asymmetrix.asset.entity.GlNumberDD;
import com.asymmetrix.asset.entity.AssetIndustryDD;
import com.asymmetrix.asset.entity.AssetScoreAvailabilityDD;
import com.asymmetrix.asset.entity.AssetScoreConfidentialityDD;
import com.asymmetrix.asset.entity.AssetScoreIntegrityDD;
import com.asymmetrix.asset.entity.AssetCategoryDD;
import com.asymmetrix.asset.entity.AssetClassificationDD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropDownValues {

	private List<AssetTypeDD> assetType;

	private List<AssetCategoryDD> assetCategory;

	private List<AssetIndustryDD> assetIndustry;

	private List<AssetClassificationDD> assetClassification;

	private List<AssetScoreConfidentialityDD> confidentialityInfo;

	private List<AssetScoreAvailabilityDD> availabilityInfo;

	private List<AssetScoreIntegrityDD> integrityInfo;
	
	private List<GlNumberDD> glNumber;

	public List<AssetTypeDD> getAssetType() {
		return assetType;
	}

	public void setAssetType(List<AssetTypeDD> assetType) {
		this.assetType = assetType;
	}

	public List<AssetCategoryDD> getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(List<AssetCategoryDD> assetCategory) {
		this.assetCategory = assetCategory;
	}

	public List<AssetIndustryDD> getAssetIndustry() {
		return assetIndustry;
	}

	public void setAssetIndustry(List<AssetIndustryDD> assetIndustry) {
		this.assetIndustry = assetIndustry;
	}

	public List<AssetClassificationDD> getAssetClassification() {
		return assetClassification;
	}

	public void setAssetClassification(List<AssetClassificationDD> assetClassification) {
		this.assetClassification = assetClassification;
	}

	public List<AssetScoreConfidentialityDD> getConfidentialityInfo() {
		return confidentialityInfo;
	}

	public void setConfidentialityInfo(List<AssetScoreConfidentialityDD> confidentialityInfo) {
		this.confidentialityInfo = confidentialityInfo;
	}

	public List<AssetScoreAvailabilityDD> getAvailabilityInfo() {
		return availabilityInfo;
	}

	public void setAvailabilityInfo(List<AssetScoreAvailabilityDD> availabilityInfo) {
		this.availabilityInfo = availabilityInfo;
	}

	public List<AssetScoreIntegrityDD> getIntegrityInfo() {
		return integrityInfo;
	}

	public void setIntegrityInfo(List<AssetScoreIntegrityDD> integrityInfo) {
		this.integrityInfo = integrityInfo;
	}

	public List<GlNumberDD> getGlNumber() {
		return glNumber;
	}

	public void setGlNumber(List<GlNumberDD> glNumber) {
		this.glNumber = glNumber;
	}
	
	

}
