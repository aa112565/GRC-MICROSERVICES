package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.OrganizationMasterDDDTO;
import com.asymmetrix.grc.dto.OrganizationMasterDTO;

import com.asymmetrix.grc.entity.OrganizationMaster;

public interface OrganizationNewService {

	List<OrganizationMaster> getAllOrganization(); 

	OrganizationMaster getOrganizationById(long orgMasterId);	

	OrganizationMaster createOrganization(OrganizationMasterDTO orgMasterDto);

	OrganizationMaster updateOrganization(OrganizationMasterDTO orgMasterDto);

	boolean deleteOrganization(OrganizationMasterDTO orgMasterDto);

	boolean inActiveOrganization(OrganizationMasterDTO orgMaster);

	boolean activeOrganization(OrganizationMasterDTO orgMaster);

	List<OrganizationMasterDDDTO> getAllOrganizationDD();

	
}
