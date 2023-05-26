package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.OrgDeptWorkflow;


@Repository
public interface OrgDeptWorkflowRepository extends JpaRepository<OrgDeptWorkflow, Long> {
	
	@Query("FROM  OrgDeptWorkflow WHERE deleteFlag = 'N' ORDER BY createdDate DESC ")
	List<OrgDeptWorkflow> findAllOrgDeptWorkflow();

	@Query("FROM  OrgDeptWorkflow WHERE organizationId = :orgId AND subsidiaryId = :subsId AND departmentId = :deptId AND deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<OrgDeptWorkflow> findAllByOrgIdAndSubsIdAndDeptId(String orgId, String subsId, String deptId);

}
