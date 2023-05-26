package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.OrganizationSubsidiaryDDDTO;
import com.asymmetrix.grc.dto.OrganizationSubsidiaryDTO;
import com.asymmetrix.grc.entity.OrganizationSubsidiary;

public interface OrganizationSubsidiaryService {

	List<OrganizationSubsidiary> getAllOrgSubsidiary(); 

	OrganizationSubsidiary getOrgSubsidiaryById(long orgSubsId);	

	OrganizationSubsidiary createOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto);

	OrganizationSubsidiary updateOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto);

	boolean deleteOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto);

	List<OrganizationSubsidiary> createOrgSubsidiaryList(List<OrganizationSubsidiaryDTO> orgSubsList, String uname);
	
	List<OrganizationSubsidiary> getAllOrgSubsidiaryByOrgId(String orgId); 

	List<OrganizationSubsidiaryDDDTO> getAllOrgSubsidiaryDDByOrgId(String orgId);

	boolean activeOrgSubsidiary(OrganizationSubsidiaryDTO orgSubs);

	boolean inActiveOrgSubsidiary(OrganizationSubsidiaryDTO orgSubs);
	
}
