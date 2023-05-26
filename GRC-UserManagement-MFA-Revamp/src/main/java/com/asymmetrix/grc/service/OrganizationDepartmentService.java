package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.OrgDepartmentsDDDTO;
import com.asymmetrix.grc.dto.OrganizationDepartmentsDTO;
import com.asymmetrix.grc.entity.OrganizationDepartments;


public interface OrganizationDepartmentService {

	List<OrganizationDepartments> getAllOrgSubsidiaryDepartments(); 

	OrganizationDepartments getOrgSubsidiaryDepartmentsById(long orgSubsId);	

	OrganizationDepartments createOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto);

	OrganizationDepartments updateOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto);
	
	boolean activeOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto);

	boolean inActiveOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto);

	boolean deleteOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto);

	List<OrganizationDepartments> createOrgSubsidiaryDepartmentsList(List<OrganizationDepartmentsDTO> orgSubsDeptDtoList, String uname);

	List<OrgDepartmentsDDDTO> getOrgSubsidiaryDepartmentsDropdown(OrganizationDepartmentsDTO orgSubsDeptDto);

	List<OrganizationDepartments> getAllByOrganizationIdAndSubsidiaryId(OrganizationDepartmentsDTO orgSubsDeptDto);
	
}
