package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetScoring;
//import com.asymmetrix.bia.entity.BcmAssetScoring;

@Repository
public interface AssetScoringRepository extends JpaRepository<AssetScoring, Long> {

	@Query("FROM  AssetScoring WHERE assetId = :assetId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	AssetScoring findByAssetId(@Param("assetId") String assetId);

	@Query("FROM  AssetScoring WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY modifiedDate DESC  ")
	List<AssetScoring> findAllByActiveAssetScore();

	@Query("SELECT COUNT(*) FROM  AssetScoring WHERE assetId = :assetId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getAssetScoreCount(@Param("assetId") String assetId);

	@Query("SELECT choosenMinimumComplianceClass FROM  AssetScoring WHERE assetId = :assetId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	String getAssetComplianceClass(@Param("assetId") String assetId);

	@Query("FROM  AssetScoring WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY modifiedDate DESC  ")
	List<AssetScoring> findAllAssetScore();
}
