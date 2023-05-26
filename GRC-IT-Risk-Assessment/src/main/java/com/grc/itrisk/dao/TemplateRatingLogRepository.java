package com.grc.itrisk.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.TemplateRatingLog;

@Repository
public interface TemplateRatingLogRepository extends JpaRepository<TemplateRatingLog, Long> {
	
}
