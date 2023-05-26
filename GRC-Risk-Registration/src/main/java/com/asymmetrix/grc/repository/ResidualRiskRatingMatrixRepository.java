package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.ResidualRiskRatingMatrix;

@Repository
public interface ResidualRiskRatingMatrixRepository extends JpaRepository<ResidualRiskRatingMatrix, Long> {

	@Query("SELECT rrm.riskRating FROM  ResidualRiskRatingMatrix rrm WHERE rrm.impact = :impact AND rrm.likelihood = :likelihood ")
	String getResidualRiskRating(@Param("impact") String impact, @Param("likelihood") String likelihood);

}
