package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.OrganizationChartDTO;
import com.asymmetrix.grc.dto.OrganizationHierarchyDTO;
import com.asymmetrix.grc.entity.OrgWeightageDTO;
import com.asymmetrix.grc.entity.OrganizationDTO;

public interface OrganizationService {

	public List<OrganizationDTO> getAllOrganizationVersions();
	public OrganizationDTO createOrganizationVersion(OrganizationDTO organizationDTO);
	
	public List<OrganizationHierarchyDTO> getOrganizatinHierarchy(String version, int level);
	public List<OrganizationHierarchyDTO> createOrganizationHierarchyLevel(List<OrganizationHierarchyDTO> organizationHierarchyDTOList, String modifiedBy);
	
	public List<String> getParentMappingOfVersionAndLevel(String version, int level);
	
	public List<OrganizationChartDTO> getOrganizationChart(String version);
	
	public OrganizationHierarchyDTO getOrganizationParentInformation(String version, String parentID);
	
	public List<OrgWeightageDTO> getAllWeightages();
	
	public Integer getMaxLevelCompleted(String version);

}
