package com.asymmetrix.grc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.OrganizationSubsidiaryDDDTO;
import com.asymmetrix.grc.entity.OrganizationSubsidiary;


@Repository
public interface OrganizationSubsidiaryRepository extends JpaRepository<OrganizationSubsidiary, Long> {
	
	@Query("FROM  OrganizationSubsidiary WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<OrganizationSubsidiary> findAllOrgSubsidiary();
	
	@Query("Select new com.asymmetrix.grc.dto.OrganizationSubsidiaryDDDTO(subs.subsidiaryId, subs.subsidiaryName) FROM OrganizationSubsidiary subs WHERE subs.organizationId = :orgId AND subs.activeFlag = 'Y' AND subs.deleteFlag = 'N'")
	List<OrganizationSubsidiaryDDDTO> findAllOrgSubsidiaryDDByOrgId(String orgId);

	@Query("FROM  OrganizationSubsidiary WHERE organizationId = :orgId AND deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<OrganizationSubsidiary> findAllOrgSubsidiaryByOrgId(String orgId);

}
