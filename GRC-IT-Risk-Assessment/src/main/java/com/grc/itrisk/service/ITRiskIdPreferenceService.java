package com.grc.itrisk.service;

import java.util.List;

import com.grc.itrisk.dto.ITRiskPreferenceDTO;
import com.grc.itrisk.entity.ITRiskPreference;


public interface ITRiskIdPreferenceService {


	List<ITRiskPreference> getAllITRiskIdPreferenceByActiveflag();

	ITRiskPreference getITRiskIdPreferenceById(long seriesId);

	ITRiskPreference createITRiskIdPreference(ITRiskPreferenceDTO preferenceDto, String userName);

	List<ITRiskPreference> saveAllITRiskIdPreference(List<ITRiskPreference> preferenceList);

	ITRiskPreference updateITRiskIdPreference(ITRiskPreferenceDTO preferenceDto, String userName);

	ITRiskPreference deleteITRiskIdPreference(ITRiskPreferenceDTO preferenceDto, String userName);

	
	int getITRiskIdPreferenceCountByActiveflag(String preferenceModule);

	ITRiskPreference getITRiskIdPreferenceByModule(String preferenceModule);

	int findNewIdPreferenceCountByStatusFlag(String preferenceModule);

	String findNewIdPreference(ITRiskPreferenceDTO findingDto);

}
