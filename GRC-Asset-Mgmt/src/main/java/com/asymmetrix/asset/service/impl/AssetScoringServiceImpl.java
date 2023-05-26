package com.asymmetrix.asset.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.asymmetrix.asset.dao.AssetScoreDesiredLevelRepository;
import com.asymmetrix.asset.dao.AssetScoreImliedLevelRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.entity.AssetScoreDesiredLevel;
import com.asymmetrix.asset.entity.AssetScoreImpliedLevel;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.common.constants.AssetConstants;
import com.asymmetrix.asset.common.utils.MapperUtils;

import com.asymmetrix.asset.dto.AssetScoreGenetatorDTO;
import com.asymmetrix.asset.dto.AssetScoringDTO;
import com.asymmetrix.asset.dto.ScoringDTO;
import com.asymmetrix.asset.exception.ResourceNotFoundException;
import com.asymmetrix.asset.service.AssetScoringService;

@Service
public class AssetScoringServiceImpl implements AssetScoringService {

	@Autowired
	private AssetScoringRepository ciaScoreRepo;

	@Autowired
	private AssetScoreDesiredLevelRepository desiredScoreLevelRepo;

	@Autowired
	private AssetScoreImliedLevelRepository impliedScoreLevelRepo;


	public List<AssetScoring> getAllAssetScore() {
		return this.ciaScoreRepo.findAllAssetScore();
	}

	@Override
	public List<AssetScoring> getAllActiveAssetScore() {
		return this.ciaScoreRepo.findAllByActiveAssetScore();
	}

	@Override
	public AssetScoring getAssetScoreById(long assetScoreId) {
		return ciaScoreRepo.findById(assetScoreId).orElseThrow(
				() -> new ResourceNotFoundException("ASSEET-CIA Score not found with  Id----> " + assetScoreId));
	}

	@Override
	public AssetScoring getAssetScoreByAssetId(String assetId) {
		// System.out.println("++++++++++++++++++assetId+++++++++++++"+assetId);
		return ciaScoreRepo.findByAssetId(assetId);
	}

	@Override
	public AssetScoring createAssetScore(AssetScoringDTO assetScoreDto) {
		AssetScoring assetScore = MapperUtils.mapToTargetClass(assetScoreDto, AssetScoring.class);		
		assetScore.setDeleteFlag("N");
		assetScore.setActiveFlag("Y");
		return this.ciaScoreRepo.save(assetScore);
	}

	@Override
	public List<AssetScoring> saveAllAssetScore(List<AssetScoring> assetScoreList) {
		return this.ciaScoreRepo.saveAll(assetScoreList);
	}

	@Override
	@Transactional
	@Modifying
	public AssetScoring updateAssetScore(AssetScoringDTO assetScoreDto) {		
		AssetScoring existingAsset = deleteUpdate(assetScoreDto);		
		assetScoreDto.setCreatedBy(existingAsset.getCreatedBy());		
		assetScoreDto.setDeleteFlag("N");
		assetScoreDto.setActiveFlag("Y");	
		ScoringDTO scoreDto = MapperUtils.mapToTargetClass(assetScoreDto, ScoringDTO.class);
		AssetScoring assetScore = MapperUtils.mapToTargetClass(scoreDto, AssetScoring.class);	
		return this.ciaScoreRepo.save(assetScore);
	}
	
	public AssetScoring deleteUpdate(AssetScoringDTO assetScoreDto) {
		AssetScoring existingScore = getAssetScoreById(assetScoreDto.getCiaScoreId());
		existingScore.setDeleteFlag("N");
		existingScore.setActiveFlag("N");
		return this.ciaScoreRepo.save(existingScore);
	}
	
	// Asset Score - Soft Delete
	@Override
	public AssetScoring deleteAssetScore(AssetScoringDTO assetScoreDto) {
		AssetScoring existingScore = getAssetScoreById(assetScoreDto.getCiaScoreId());
		existingScore.setDeleteFlag("D");
		existingScore.setActiveFlag("N");
		return this.ciaScoreRepo.save(existingScore);
	}
	
	@Override
	public String deleteAssetScoreList(List<AssetScoringDTO> assetScoreDto, String username) {
		
		List<AssetScoring> scoringList = null;
		scoringList = new ArrayList<>();
		for(AssetScoringDTO score : assetScoreDto) {
			AssetScoring existingScore = getAssetScoreById(score.getCiaScoreId());
			existingScore.setDeleteFlag("D");
			existingScore.setActiveFlag("N");
			existingScore.setModifiedBy(username);
			scoringList.add(ciaScoreRepo.save(existingScore));
		}
		
		return StringUtils.replace(AssetConstants.ASSET_SCORE_LIST_DELETE_SUCCESS, AssetConstants.CURLY_BRACKETS_SYMBOL,
				Integer.toString(scoringList.size()));
	}

	@Override
	public List<AssetScoringDTO> getAssetScoreByList(List<Long> assetIdList) {
		List<AssetScoringDTO> assetScoreList = new ArrayList<>();
		for (long mapId : assetIdList) {
			AssetScoringDTO detailAsset = MapperUtils.mapToTargetClass(getAssetScoreById(mapId), AssetScoringDTO.class);
			assetScoreList.add(detailAsset);
		}
		return assetScoreList;
	}

	@Override
	public AssetScoreGenetatorDTO calculateScore(String desiredConfidentialityScore, String desiredIntegrityScore,
			String desiredAvailabilityScore) {
		// System.out.println("Values+++++++++++"+desiredConfidentialityScore+"========="+
		// desiredIntegrityScore +"========="+desiredAvailabilityScore);
		AssetScoreGenetatorDTO resScoredto = new AssetScoreGenetatorDTO();
		AssetScoreDesiredLevel desiredScore = desiredScoreLevelRepo
				.findByDesiredScoreLevels(desiredConfidentialityScore, desiredIntegrityScore, desiredAvailabilityScore);
		// System.out.println("Value-Desired+++++++++++"+desiredScore.getDesiredScore());
		AssetScoreImpliedLevel impliedLevel = impliedScoreLevelRepo.findByImpliedScore(desiredScore.getDesiredScore());
		resScoredto.setDesiredConfidentialityScore(desiredConfidentialityScore);
		resScoredto.setDesiredIntegrityScore(desiredIntegrityScore);
		resScoredto.setDesiredAvailabilityScore(desiredAvailabilityScore);
		resScoredto.setImpliedConfidentialityScore(impliedLevel.getImpliedConfidentialityScore());
		resScoredto.setImpliedIntegrityScore(impliedLevel.getImpliedIntegrityScore());
		resScoredto.setImpliedAvailabilityScore(impliedLevel.getImpliedAvailabilityScore());
		resScoredto.setMinimumComplianceClassRecomanded(desiredScore.getDesiredScore());
		resScoredto.setChoosenMinimumComplianceClass(desiredScore.getDesiredScore());
		// resScoredto.setDesiredComplianceScore(desiredScore.getDesiredScore());
		// resScoredto.setImpliedComplianceScore(desiredScore.getDesiredScore());

		return resScoredto;
	}

	

}
