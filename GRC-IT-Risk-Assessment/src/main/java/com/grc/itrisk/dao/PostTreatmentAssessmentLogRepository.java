package com.grc.itrisk.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.PerformPostAssessmentLog;

@Repository
public interface PostTreatmentAssessmentLogRepository extends JpaRepository<PerformPostAssessmentLog, Long> {
	
}
