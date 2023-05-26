package com.asymmetrix.grc.risk.service;

import java.util.List;

import com.asymmetrix.grc.risk.dto.RiskIdPreferenceDTO;
import com.asymmetrix.grc.risk.entity.RiskPreference;

public interface RiskIdPreferenceService {


	List<RiskPreference> getAllRiskIdPreferenceByActiveflag();

	RiskPreference getRiskIdPreferenceById(long seriesId);

	RiskIdPreferenceDTO createRiskIdPreference(RiskIdPreferenceDTO preferenceDto, String userName);

	List<RiskPreference> saveAllRiskIdPreference(List<RiskPreference> preferenceList);

	RiskIdPreferenceDTO updateRiskIdPreference(RiskIdPreferenceDTO preferenceDto, String userName);

	RiskIdPreferenceDTO deleteRiskIdPreference(RiskIdPreferenceDTO preferenceDto, String userName);

	
	int getRiskIdPreferenceCountByActiveflag(String preferenceModule);

	RiskPreference getRiskIdPreferenceByModule(String preferenceModule);

	int findNewIdPreferenceCountByStatusFlag(String preferenceModule);

	String findNewIdPreference(RiskIdPreferenceDTO preferenceDto);

}
