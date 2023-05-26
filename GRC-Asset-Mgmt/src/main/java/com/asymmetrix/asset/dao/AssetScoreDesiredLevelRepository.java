package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetScoreDesiredLevel;

@Repository
public interface AssetScoreDesiredLevelRepository extends JpaRepository<AssetScoreDesiredLevel, String> {

	@Query("FROM  AssetScoreDesiredLevel WHERE desiredConfidentialityScore = :desiredConfidentialityScore AND desiredIntegrityScore = :desiredIntegrityScore AND desiredAvailabilityScore = :desiredAvailabilityScore ")
	AssetScoreDesiredLevel findByDesiredScoreLevels(
			@Param("desiredConfidentialityScore") String desiredConfidentialityScore,
			@Param("desiredIntegrityScore") String desiredIntegrityScore,
			@Param("desiredAvailabilityScore") String desiredAvailabilityScore);

}
