package com.asymmetrix.asset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.asset.common.aspect.Loggable;
import com.asymmetrix.asset.common.response.AssetResponse;
import com.asymmetrix.asset.common.response.AssetResponseEntity;
import com.asymmetrix.asset.dto.DropDownValues;

import com.asymmetrix.asset.entity.AssetIndustryDD;
import com.asymmetrix.asset.entity.AssetScoreAvailabilityDD;
import com.asymmetrix.asset.entity.AssetScoreConfidentialityDD;
import com.asymmetrix.asset.entity.AssetScoreIntegrityDD;
import com.asymmetrix.asset.entity.AssetTypeDD;
import com.asymmetrix.asset.entity.AssetCategoryDD;
import com.asymmetrix.asset.entity.AssetClassificationDD;

import com.asymmetrix.asset.service.DropDownValueService;
import com.asymmetrix.asset.entity.GlNumberDD;

@RestController
public class AssetDropDownValuesController {

	@Autowired
	private DropDownValueService dropDwonValueService;

	private static final String READ_ASSET_DD_ACTION = "READ-ASSET-LIBRARY-DROPDOWN-DETAILS";
	private static final String READ_ASSET_SCORE_DD_ACTION = "READ-ASSET-LIBRARY-SCORE-DROPDOWN-DETAILS";

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_ASSET_DD_ACTION)
	@GetMapping("/asset/dropdownvalues")
	public ResponseEntity<AssetResponse<DropDownValues>> getAssetDropDownValues() {

		DropDownValues dropDwonValuesDto = new DropDownValues();

		List<AssetTypeDD> assetType = getAssetType();
		dropDwonValuesDto.setAssetType(assetType);

		List<AssetCategoryDD> assetCategory = getAssetCategory();
		dropDwonValuesDto.setAssetCategory(assetCategory);

		List<AssetIndustryDD> assetIndustry = getAssetIndustry();
		dropDwonValuesDto.setAssetIndustry(assetIndustry);

		List<AssetClassificationDD> assetClassification = getAssetClassification();
		dropDwonValuesDto.setAssetClassification(assetClassification);
		
		List<GlNumberDD> glNumber = dropDwonValueService.getGlNumber();
		dropDwonValuesDto.setGlNumber(glNumber);

		return AssetResponseEntity.success(dropDwonValuesDto);
	}

	public List<AssetTypeDD> getAssetType() {
		return this.dropDwonValueService.getAssetType();
	}

	public List<AssetCategoryDD> getAssetCategory() {
		return this.dropDwonValueService.getAssetCategory();
	}

	public List<AssetIndustryDD> getAssetIndustry() {
		return this.dropDwonValueService.getAssetIndustry();
	}

	public List<AssetClassificationDD> getAssetClassification() {
		return this.dropDwonValueService.getAssetClassification();
	}

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_ASSET_SCORE_DD_ACTION)
	@GetMapping("/asset/score/optionalvalues")
	public ResponseEntity<AssetResponse<DropDownValues>> getAssetScoreDropDownValues() {

		DropDownValues dropDwonValuesDto = new DropDownValues();

		List<AssetScoreConfidentialityDD> confidentialityInfo = getAssetScoreConfidentialityInfo();
		dropDwonValuesDto.setConfidentialityInfo(confidentialityInfo);

		List<AssetScoreAvailabilityDD> availabilityInfo = getAssetScoreAvailabilityInfo();
		dropDwonValuesDto.setAvailabilityInfo(availabilityInfo);

		List<AssetScoreIntegrityDD> integrityInfo = getAssetScoreIntegrityInfo();
		dropDwonValuesDto.setIntegrityInfo(integrityInfo);

		return AssetResponseEntity.success(dropDwonValuesDto);
	}

	public List<AssetScoreConfidentialityDD> getAssetScoreConfidentialityInfo() {
		return this.dropDwonValueService.getConfidentialityInfo();
	}

	public List<AssetScoreAvailabilityDD> getAssetScoreAvailabilityInfo() {
		return this.dropDwonValueService.getAssetScoreAvailabilityInfo();
	}

	public List<AssetScoreIntegrityDD> getAssetScoreIntegrityInfo() {
		return this.dropDwonValueService.getAssetScoreIntegrityInfo();

	}
}
