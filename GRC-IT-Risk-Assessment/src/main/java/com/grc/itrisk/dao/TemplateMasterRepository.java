package com.grc.itrisk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.grc.itrisk.entity.TemplateMaster;

@Repository
public interface TemplateMasterRepository extends JpaRepository<TemplateMaster, Long> {
	
	@Query("FROM TemplateMaster WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<TemplateMaster> findAllTemplate();
	
//	@Query("FROM TemplateMaster WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
//	List<TemplateMaster> getAllTemplateByRefId(@Param("refId") String refId);
		
	
//	@Query("Select new com.asymmetrix.grc.dto.OrganizationMasterDDDTO(org.organizationId, org.organizationName) FROM OrganizationMaster org WHERE org.activeFlag = 'Y' AND org.deleteFlag = 'N'")
//	List<OrganizationMasterDDDTO> findAllOrgDD();

	TemplateMaster findFirstByOrderByCreatedDateDescTemplateIdDesc();
}
