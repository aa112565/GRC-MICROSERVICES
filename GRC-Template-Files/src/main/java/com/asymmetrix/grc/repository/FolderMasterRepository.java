package com.asymmetrix.grc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.entity.FolderMaster;

@Repository
public interface FolderMasterRepository extends JpaRepository<FolderMaster, Long> {
	
	@Query("FROM  FolderMaster WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<FolderMaster> findAllFolder();
	
	@Query("FROM FolderMaster WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<FolderMaster> getAllFolderByRefId(@Param("refId") String refId);
		
	
//	@Query("Select new com.asymmetrix.grc.dto.OrganizationMasterDDDTO(org.organizationId, org.organizationName) FROM OrganizationMaster org WHERE org.activeFlag = 'Y' AND org.deleteFlag = 'N'")
//	List<OrganizationMasterDDDTO> findAllOrgDD();
}
