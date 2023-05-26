package com.grc.itrisk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.PerformPostAssessment;


@Repository
public interface PostTreatmentAssessmentRepository extends JpaRepository<PerformPostAssessment, Long> {
	
	@Query("FROM PerformPostAssessment WHERE deleteFlag = 'N' AND saveFlag = 'N' ORDER BY modifiedDate DESC ")
	List<PerformPostAssessment> findAllPerformPostAssessment();
	
	@Query("FROM PerformPostAssessment WHERE assessmentId = :assessmentId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<PerformPostAssessment> getPerformPostAssessmentByRefId(@Param("assessmentId") long assessmentId);
		
	
//	@Query("Select new com.asymmetrix.grc.dto.OrganizationMasterDDDTO(org.organizationId, org.organizationName) FROM OrganizationMaster org WHERE org.activeFlag = 'Y' AND org.deleteFlag = 'N'")
//	List<OrganizationMasterDDDTO> findAllOrgDD();
}
