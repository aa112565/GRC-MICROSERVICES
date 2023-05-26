package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.OrgDeptWorkflowDTO;
import com.asymmetrix.grc.entity.OrgDeptWorkflow;



public interface OrgDeptWorkflowService {

	List<OrgDeptWorkflow> getAllOrgDeptWorkflow(); 

	OrgDeptWorkflow getOrgDeptWorkflowById(long orgDeptWorkflowId);	

	OrgDeptWorkflow createOrgDeptWorkflow(OrgDeptWorkflowDTO orgDeptWorkflowDto);

	OrgDeptWorkflow updateOrgDeptWorkflow(OrgDeptWorkflowDTO orgDeptWorkflowDto);

	boolean deleteOrgDeptWorkflow(OrgDeptWorkflowDTO orgDeptWorkflowDto);

	List<OrgDeptWorkflow> createOrgDeptWorkflowList(List<OrgDeptWorkflowDTO> orgDeptWorkflowDtoList, String uname);

	List<OrgDeptWorkflow> getAllOrgDeptWorkflowByOrgIdAndSubsIdAndDeptId(OrgDeptWorkflowDTO orgDeptWorkflowDto);
	
}
