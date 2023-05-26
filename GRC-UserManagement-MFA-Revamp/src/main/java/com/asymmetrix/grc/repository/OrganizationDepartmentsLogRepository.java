package com.asymmetrix.grc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.entity.OrganizationDepartmentsLog;


@Repository
public interface OrganizationDepartmentsLogRepository extends JpaRepository<OrganizationDepartmentsLog, Long> {
	
	

}
