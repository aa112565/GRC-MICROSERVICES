package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.InherentRiskRatingMatrix;

@Repository
public interface InherentRiskRatingMatrixRepository extends JpaRepository<InherentRiskRatingMatrix, Long> {

	@Query("SELECT irm.riskRating FROM  InherentRiskRatingMatrix irm WHERE irm.impact = :impact AND irm.likelihood = :likelihood ")
	String getInherentRiskRating(@Param("impact") String impact, @Param("likelihood") String likelihood);

}
