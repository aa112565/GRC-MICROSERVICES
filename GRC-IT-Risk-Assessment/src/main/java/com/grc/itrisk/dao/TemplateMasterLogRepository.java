package com.grc.itrisk.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.TemplateMasterLog;

@Repository
public interface TemplateMasterLogRepository extends JpaRepository<TemplateMasterLog, Long> {
	
}
