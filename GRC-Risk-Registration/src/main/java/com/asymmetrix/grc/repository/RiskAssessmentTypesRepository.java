package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskAssessmentTypes;

@Repository
public interface RiskAssessmentTypesRepository extends JpaRepository<RiskAssessmentTypes, Long> {
	
	
}
