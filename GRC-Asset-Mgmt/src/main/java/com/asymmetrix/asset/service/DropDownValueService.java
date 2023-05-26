/**
 * 
 */
package com.asymmetrix.asset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.asset.dao.AssetCategoryRepo;
import com.asymmetrix.asset.dao.AssetClassificationRepo;
import com.asymmetrix.asset.dao.AssetIndustryRepo;
import com.asymmetrix.asset.dao.AssetScoreAvailabilityRepoDD;
import com.asymmetrix.asset.dao.AssetScoreConfidentialityRepoDD;
import com.asymmetrix.asset.dao.AssetScoreIntegrityRepoDD;
import com.asymmetrix.asset.dao.AssetTypeRepo;
import com.asymmetrix.asset.dao.GlNumberRepo;
import com.asymmetrix.asset.entity.AssetCategoryDD;
import com.asymmetrix.asset.entity.AssetClassificationDD;
import com.asymmetrix.asset.entity.AssetIndustryDD;
import com.asymmetrix.asset.entity.AssetScoreAvailabilityDD;
import com.asymmetrix.asset.entity.AssetScoreConfidentialityDD;
import com.asymmetrix.asset.entity.AssetScoreIntegrityDD;
import com.asymmetrix.asset.entity.AssetTypeDD;
import com.asymmetrix.asset.entity.GlNumberDD;

@Service
public class DropDownValueService {

	@Autowired
	private AssetTypeRepo assetTypeRepo;

	@Autowired
	private AssetIndustryRepo assetIndustryRepo;

	@Autowired
	private AssetCategoryRepo assetCategoryRepo;

	@Autowired
	private AssetClassificationRepo assetClassificationRepo;

	@Autowired
	private AssetScoreConfidentialityRepoDD confidentialityRepo;

	@Autowired
	private AssetScoreAvailabilityRepoDD availabilityRepo;

	@Autowired
	private AssetScoreIntegrityRepoDD integrityRepo;
	
	@Autowired
	private GlNumberRepo glNumberRepo;

	public List<AssetCategoryDD> getAssetCategory() {
		return this.assetCategoryRepo.findAll();
	}

	public List<AssetTypeDD> getAssetType() {
		return this.assetTypeRepo.findAll();
	}

	public List<AssetIndustryDD> getAssetIndustry() {
		return this.assetIndustryRepo.findAll();
	}

	public List<AssetClassificationDD> getAssetClassification() {
		return this.assetClassificationRepo.findAll();
	}

	public List<AssetScoreConfidentialityDD> getConfidentialityInfo() {
		return this.confidentialityRepo.findAll();
	}

	public List<AssetScoreAvailabilityDD> getAssetScoreAvailabilityInfo() {
		return this.availabilityRepo.findAll();
	}

	public List<AssetScoreIntegrityDD> getAssetScoreIntegrityInfo() {
		return this.integrityRepo.findAll();
	}
	
	public List<GlNumberDD> getGlNumber() {
		return this.glNumberRepo.findAllByOrder();
	}

}
