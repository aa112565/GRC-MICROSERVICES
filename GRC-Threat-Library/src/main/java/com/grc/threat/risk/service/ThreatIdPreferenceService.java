package com.grc.threat.risk.service;

import java.util.List;

import com.grc.threat.risk.dto.ThreatIdPreferenceDTO;
import com.grc.threat.risk.entity.ThreatPreference;

public interface ThreatIdPreferenceService {


	List<ThreatPreference> getAllThreatIdPreferenceByActiveflag();

	ThreatPreference getThreatIdPreferenceById(long seriesId);

	ThreatIdPreferenceDTO createThreatIdPreference(ThreatIdPreferenceDTO preferenceDto, String userName);

	List<ThreatPreference> saveAllThreatIdPreference(List<ThreatPreference> preferenceList);

	ThreatIdPreferenceDTO updateThreatIdPreference(ThreatIdPreferenceDTO preferenceDto, String userName);

	ThreatIdPreferenceDTO deleteThreatIdPreference(ThreatIdPreferenceDTO preferenceDto, String userName);

	
	int getThreatIdPreferenceCountByActiveflag(String preferenceModule);

	ThreatPreference getThreatIdPreferenceByModule(String preferenceModule);

	int findNewIdPreferenceCountByStatusFlag(String preferenceModule);

	String findNewIdPreference(ThreatIdPreferenceDTO findingDto);

}
