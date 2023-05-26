package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskTreatmentRespCategory;

@Repository
public interface RiskTreatmtRespCategoryRepository extends JpaRepository<RiskTreatmentRespCategory, Long>{

}
