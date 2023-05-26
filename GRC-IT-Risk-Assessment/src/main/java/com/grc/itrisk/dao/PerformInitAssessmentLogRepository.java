package com.grc.itrisk.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.PerformInitAssessmentLog;

@Repository
public interface PerformInitAssessmentLogRepository extends JpaRepository<PerformInitAssessmentLog, Long> {
	
}
