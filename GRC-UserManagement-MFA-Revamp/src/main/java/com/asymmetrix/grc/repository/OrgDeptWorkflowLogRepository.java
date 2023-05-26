package com.asymmetrix.grc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.OrgDeptWorkflowLog;


@Repository
public interface OrgDeptWorkflowLogRepository extends JpaRepository<OrgDeptWorkflowLog, Long> {
	
	

}
