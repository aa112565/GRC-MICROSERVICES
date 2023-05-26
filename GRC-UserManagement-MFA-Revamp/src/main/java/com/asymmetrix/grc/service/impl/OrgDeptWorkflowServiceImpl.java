package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;

import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.OrgDeptWorkflowDTO;
import com.asymmetrix.grc.entity.OrgDeptWorkflow;
import com.asymmetrix.grc.entity.OrgDeptWorkflowLog;
import com.asymmetrix.grc.repository.OrgDeptWorkflowLogRepository;
import com.asymmetrix.grc.repository.OrgDeptWorkflowRepository;
import com.asymmetrix.grc.service.OrgDeptWorkflowService;


@Service
public class OrgDeptWorkflowServiceImpl implements OrgDeptWorkflowService {

	@Autowired
	OrgDeptWorkflowRepository orgDeptWorkflowRepo;

	@Autowired
	OrgDeptWorkflowLogRepository orgDeptWorkflowLogRepo;
	

	@Override
	public List<OrgDeptWorkflow> getAllOrgDeptWorkflow() {
		List<OrgDeptWorkflow> workflow = orgDeptWorkflowRepo.findAllOrgDeptWorkflow();
		if (workflow.size() <= 0) {
			throw new GRCException(GRCErrorConstants.WORKFLOW_ORG_SUBS_DEPT_NOT_FOUND);
		}
		return workflow;

	}
	
	@Override
	public List<OrgDeptWorkflow> getAllOrgDeptWorkflowByOrgIdAndSubsIdAndDeptId(OrgDeptWorkflowDTO orgDeptWorkflowDto) {
		// TODO Auto-generated method stub
		List<OrgDeptWorkflow> workflow = orgDeptWorkflowRepo.findAllByOrgIdAndSubsIdAndDeptId(orgDeptWorkflowDto.getOrganizationId(), orgDeptWorkflowDto.getSubsidiaryId(), orgDeptWorkflowDto.getDepartmentId());
		if (workflow.size() <= 0) {
			throw new GRCException(GRCErrorConstants.WORKFLOW_ORG_SUBS_DEPT_NOT_FOUND);
		}
		return workflow;

	}

	@Override
	public OrgDeptWorkflow getOrgDeptWorkflowById(long orgDeptWorkflowId) {
		return orgDeptWorkflowRepo.findById(orgDeptWorkflowId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Organization-Departments-Workflow not found with  Id----> " + orgDeptWorkflowId));
				.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + orgDeptWorkflowId));
	}

	
	public List<OrgDeptWorkflow> saveAll(List<OrgDeptWorkflow> orgDeptWorkflowList) {
		return this.orgDeptWorkflowRepo.saveAll(orgDeptWorkflowList);
	}

	@Override
	public OrgDeptWorkflow createOrgDeptWorkflow(OrgDeptWorkflowDTO orgDeptWorkflowDto) {		
		OrgDeptWorkflow orgDeptWorkflow = MapperUtils.mapToTargetClass(orgDeptWorkflowDto, OrgDeptWorkflow.class);
		orgDeptWorkflow.setActiveFlag("Y");
		orgDeptWorkflow.setDeleteFlag("N");	
		return this.orgDeptWorkflowRepo.save(orgDeptWorkflow);
	
	}
	
	@Override
	public List<OrgDeptWorkflow> createOrgDeptWorkflowList(List<OrgDeptWorkflowDTO> orgDeptWorkflowList, String uname) {
		List<OrgDeptWorkflow> savedOrgDeptWorkflowList = new ArrayList<>();
		for(OrgDeptWorkflowDTO orgDeptWorkflowDto : orgDeptWorkflowList) {
			OrgDeptWorkflow orgDeptWorkflow = MapperUtils.mapToTargetClass(orgDeptWorkflowDto, OrgDeptWorkflow.class);
			orgDeptWorkflow.setActiveFlag("Y");
			orgDeptWorkflow.setDeleteFlag("N");		
			orgDeptWorkflow.setCreatedBy(uname);
			OrgDeptWorkflow workflow = orgDeptWorkflowRepo.save(orgDeptWorkflow);
			savedOrgDeptWorkflowList.add(workflow);
		}
		return savedOrgDeptWorkflowList;
	}
	
	

	public OrgDeptWorkflowLog updateOrgDeptWorkflowLog(long orgDeptWorkflowId) {			
		OrgDeptWorkflow existingorgDeptWorkflow = getOrgDeptWorkflowById(orgDeptWorkflowId);		
		OrgDeptWorkflowLog orgDeptWorkflowLog = MapperUtils.mapToTargetClass(existingorgDeptWorkflow, OrgDeptWorkflowLog.class);
		return this.orgDeptWorkflowLogRepo.save(orgDeptWorkflowLog);
	}

	
	
	@Override
	@Transactional
	public OrgDeptWorkflow updateOrgDeptWorkflow(OrgDeptWorkflowDTO orgSubsDeptDto) {		
		@SuppressWarnings("unused")
		OrgDeptWorkflowLog log = updateOrgDeptWorkflowLog(orgSubsDeptDto.getOrgDeptWorkflowId());
		OrgDeptWorkflow orgDeptWorkflow = MapperUtils.mapToTargetClass(orgSubsDeptDto, OrgDeptWorkflow.class);
		orgDeptWorkflow.setActiveFlag("Y");
		orgDeptWorkflow.setDeleteFlag("N");
		return this.orgDeptWorkflowRepo.save(orgDeptWorkflow);
	}

	

	@Override
	public boolean deleteOrgDeptWorkflow(OrgDeptWorkflowDTO orgSubsDeptDto) {
		OrgDeptWorkflow orgDeptWorkflow = getOrgDeptWorkflowById(orgSubsDeptDto.getOrgDeptWorkflowId());
		orgDeptWorkflow.setActiveFlag("N");
		orgDeptWorkflow.setDeleteFlag("D");
		orgDeptWorkflow.setRemarks(orgSubsDeptDto.getRemarks());
	//	return this.orgDeptWorkflowRepo.save(orgDeptWorkflow);
		return (ObjectUtils.isEmpty(orgDeptWorkflowRepo.save(orgDeptWorkflow))) ? Boolean.FALSE : Boolean.TRUE;
	}

	

	

	
}
