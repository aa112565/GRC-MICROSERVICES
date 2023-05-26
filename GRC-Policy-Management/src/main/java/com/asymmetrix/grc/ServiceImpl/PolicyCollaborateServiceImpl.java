package com.asymmetrix.grc.ServiceImpl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.PolicyCollaborateDTO;
import com.asymmetrix.grc.Entity.PolicyCollaborate;
import com.asymmetrix.grc.Repository.PolicyCollaborateRepo;
import com.asymmetrix.grc.Service.PolicyCollaborateService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;

@Service
public class PolicyCollaborateServiceImpl implements PolicyCollaborateService {
	
	@Resource
	PolicyCollaborateRepo policyCollaborateRepo;
	
	@Override
	public List<PolicyCollaborate> getAllPolicyCollaborate() {
		return this.policyCollaborateRepo.findAll();
	}


	@Override
	public PolicyCollaborate createPolicyCollaborate(PolicyCollaborateDTO policyCollaborateDTO, CreatePolicyDto createPolicyDto) {
		policyCollaborateRepo.updateCollabrateToactive(policyCollaborateDTO.getPolicyId() ,policyCollaborateDTO.getCollabrateId() );
//	policyCollaborateRepo.updateCollabrate(policyCollaborateDTO.getCollabrateId() ,policyCollaborateDTO.getPolicyId());
	//	createPolicyDto.setApprove("A");
		policyCollaborateDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		policyCollaborateDTO.setCollabrateFlag("Y");
		createPolicyDto.setCollabrateFlag("Y");
	//	createPolicyDto.setPolicyCreatedFlag("Y");
	
		
		PolicyCollaborate Collaborate = MapperUtils.mapToTargetClass(policyCollaborateDTO, PolicyCollaborate.class);
		return this.policyCollaborateRepo.save(Collaborate);
	}


	@Override
	public PolicyCollaborate updatePolicyCollaborate(PolicyCollaborateDTO policyCollaborateDTO) {
		PolicyCollaborate Collaborate = MapperUtils.mapToTargetClass(policyCollaborateDTO, PolicyCollaborate.class);
		policyCollaborateDTO.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return this.policyCollaborateRepo.save(Collaborate);
	}


	@Override
	public PolicyCollaborate getCollaborateById(long collabrateId) {
		return policyCollaborateRepo.findById(collabrateId)
				.orElseThrow(() -> new ResourceNotFoundException("CollabrateId not found with  Id----> " + collabrateId));
	}


//	@Override
//	public PolicyCollaborate deletePolicyCollaborate(PolicyCollaborateDTO policyCollaborateDTO) {
//		PolicyCollaborate existingPolicyCollaborate = getCollaborateById(policyCollaborateDTO.getCollabrateId());
//		return this.policyCollaborateRepo.save(existingPolicyCollaborate);
//	}


	@Override
	public List<PolicyCollaborate> getCollaborateByPolicyId(String PolicyId) {
		return policyCollaborateRepo.findByPolicyId(PolicyId);
	}


}
