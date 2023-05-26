package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.ImpactRiskRating;

@Repository
public interface ImpactRiskRatingRepository extends JpaRepository<ImpactRiskRating, Long> {

	List<ImpactRiskRating> findByImpactRatingScoreValLessThanEqual(String scoreVal);

	ImpactRiskRating findByImpactRating(String impactRating);
	
	@Query("SELECT i.impactRating from ImpactRiskRating i ")
	List<String> findAllImpatingRating();
	
	
	@Query("FROM ImpactRiskRating as i ORDER BY i.impactRatingScoreVal DESC")
	List<ImpactRiskRating> findImpatingRatingDesc();
	
}
