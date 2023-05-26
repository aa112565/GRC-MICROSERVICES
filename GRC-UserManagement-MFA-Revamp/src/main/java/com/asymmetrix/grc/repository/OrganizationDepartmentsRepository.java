package com.asymmetrix.grc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.OrgDepartmentsDDDTO;
import com.asymmetrix.grc.entity.OrganizationDepartments;



@Repository
public interface OrganizationDepartmentsRepository extends JpaRepository<OrganizationDepartments, Long> {
	
	
	@Query("FROM  OrganizationDepartments WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<OrganizationDepartments> findAllOrgSubsidiaryDepartments();
	
	@Query("FROM  OrganizationDepartments WHERE organizationId = :orgId AND subsidiaryId = :subsId AND deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<OrganizationDepartments> findAllByOrganizationIdAndSubsidiaryId(String orgId, String subsId);
	
	@Query("Select new com.asymmetrix.grc.dto.OrgDepartmentsDDDTO(orgdept.departmentId, orgdept.departmentName) FROM OrganizationDepartments orgdept WHERE orgdept.organizationId = :orgId AND orgdept.subsidiaryId = :subsId AND orgdept.activeFlag = 'Y' AND orgdept.deleteFlag = 'N'")
	List<OrgDepartmentsDDDTO> findByOrganizationIdAndSubsidiaryId(String orgId, String subsId);

}
