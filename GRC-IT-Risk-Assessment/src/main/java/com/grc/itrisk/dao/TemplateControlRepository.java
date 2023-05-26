package com.grc.itrisk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.TemplateControl;

@Repository
public interface TemplateControlRepository extends JpaRepository<TemplateControl, Long> {
	
	@Query("FROM TemplateControl WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<TemplateControl> findAllTemplateControl();
	
	@Query("FROM TemplateControl WHERE templateId = :templateId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<TemplateControl> getAllTemplateControlByRefId(@Param("templateId") long templateId);
		
	
//	@Query("Select new com.asymmetrix.grc.dto.OrganizationMasterDDDTO(org.organizationId, org.organizationName) FROM OrganizationMaster org WHERE org.activeFlag = 'Y' AND org.deleteFlag = 'N'")
//	List<OrganizationMasterDDDTO> findAllOrgDD();
}
