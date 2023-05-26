package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.PolicyIdPreferenceDTO;
import com.asymmetrix.grc.Entity.PolicyIdPreference;



public interface PolicyIdPreferenceService {
	
	List<PolicyIdPreference> getAllPolicyIdPreferenceByActiveflag();

	PolicyIdPreference getPolicyIdPreferenceById(long seriesId);

	PolicyIdPreferenceDTO createPolicyIdPreference(PolicyIdPreferenceDTO preferenceDto, String userName);

	List<PolicyIdPreference> saveAllPolicyIdPreference(List<PolicyIdPreference> preferenceList);

	PolicyIdPreferenceDTO updatePolicyIdPreference(PolicyIdPreferenceDTO preferenceDto, String userName);

	PolicyIdPreferenceDTO deletePolicyIdPreference(PolicyIdPreferenceDTO preferenceDto, String userName);

	
	int getPolicyIdPreferenceCountByActiveflag(String preferenceModule);

	PolicyIdPreference getPolicyIdPreferenceByModule(String preferenceModule);

	int findNewIdPreferenceCountByStatusFlag(String preferenceModule);

	String findNewIdPreference(PolicyIdPreferenceDTO preferenceDto);



}
