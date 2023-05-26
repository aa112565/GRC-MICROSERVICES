package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskRating;

@Repository
public interface RiskRatingRepository extends JpaRepository<RiskRating, Long> {

	@Query("SELECT r.riskRatingVal from RiskRating r ")
	List<String> findAllRiskRating();

}
