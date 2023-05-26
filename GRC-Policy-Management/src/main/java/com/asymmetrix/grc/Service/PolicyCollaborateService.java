package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.PolicyCollaborateDTO;
import com.asymmetrix.grc.Entity.PolicyCollaborate;



public interface PolicyCollaborateService {
	
	public List<PolicyCollaborate> getAllPolicyCollaborate();
	public PolicyCollaborate createPolicyCollaborate(PolicyCollaborateDTO policyCollaborateDTO , CreatePolicyDto createPolicyDto);
	public PolicyCollaborate updatePolicyCollaborate(PolicyCollaborateDTO policyCollaborateDTO);
	public PolicyCollaborate getCollaborateById(long collabrateId);
//	public PolicyCollaborate deletePolicyCollaborate(PolicyCollaborateDTO policyCollaborateDTO);
	public List<PolicyCollaborate> getCollaborateByPolicyId(String PolicyId);

}
