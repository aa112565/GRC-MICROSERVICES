package com.grc.itrisk.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.AssessmentLog;

@Repository
public interface AssessmentLogRepository extends JpaRepository<AssessmentLog, Long> {
	
}
