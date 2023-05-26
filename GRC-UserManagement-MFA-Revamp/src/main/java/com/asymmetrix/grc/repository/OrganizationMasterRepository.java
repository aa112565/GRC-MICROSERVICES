package com.asymmetrix.grc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.OrganizationMasterDDDTO;
import com.asymmetrix.grc.entity.OrganizationMaster;



@Repository
public interface OrganizationMasterRepository extends JpaRepository<OrganizationMaster, Long> {
	
	@Query("FROM  OrganizationMaster WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<OrganizationMaster> findAllOrg();
	
	@Query("Select new com.asymmetrix.grc.dto.OrganizationMasterDDDTO(org.organizationId, org.organizationName) FROM OrganizationMaster org WHERE org.activeFlag = 'Y' AND org.deleteFlag = 'N'")
	List<OrganizationMasterDDDTO> findAllOrgDD();
}
