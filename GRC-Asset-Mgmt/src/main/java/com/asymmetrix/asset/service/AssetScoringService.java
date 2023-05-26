package com.asymmetrix.asset.service;

import java.util.List;

import com.asymmetrix.asset.dto.AssetScoreGenetatorDTO;
import com.asymmetrix.asset.dto.AssetScoringDTO;
import com.asymmetrix.asset.entity.AssetScoring;

public interface AssetScoringService {

//	List<AssetScoring> getAllAssetScore();

	List<AssetScoring> getAllActiveAssetScore();

	AssetScoring getAssetScoreById(long biaScoreId);

	AssetScoring getAssetScoreByAssetId(String biaId);

	AssetScoring createAssetScore(AssetScoringDTO assetScoreDto);

	List<AssetScoring> saveAllAssetScore(List<AssetScoring> assetScoreList);

	AssetScoring updateAssetScore(AssetScoringDTO assetScoreDto);

	AssetScoring deleteAssetScore(AssetScoringDTO assetScoreDto);

	List<AssetScoringDTO> getAssetScoreByList(List<Long> asserIdList);

	AssetScoreGenetatorDTO calculateScore(String desiredConfidentialityScore, String desiredIntegrityScore,
			String desiredAvailabilityScore);

	String deleteAssetScoreList(List<AssetScoringDTO> assetScoreDto, String username);

}
