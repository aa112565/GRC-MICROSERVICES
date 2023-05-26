package com.grc.itrisk.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.TemplateControlLog;

@Repository
public interface TemplateControlLogRepository extends JpaRepository<TemplateControlLog, Long> {
	
}
