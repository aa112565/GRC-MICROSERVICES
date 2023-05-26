package com.asymmetrix.grc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.OrganizationSubsidiaryLog;


@Repository
public interface OrganizationSubsidiaryLogRepository extends JpaRepository<OrganizationSubsidiaryLog, Long> {
	
	

}
