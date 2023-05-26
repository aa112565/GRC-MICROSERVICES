package com.asymmetrix.grc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.OrganizationMasterLog;


@Repository
public interface OrganizationMasterLogRepository extends JpaRepository<OrganizationMasterLog, Long> {
	
	

}
