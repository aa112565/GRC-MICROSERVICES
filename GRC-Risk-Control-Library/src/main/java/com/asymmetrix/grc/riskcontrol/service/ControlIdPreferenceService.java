package com.asymmetrix.grc.riskcontrol.service;

import java.util.List;


import com.asymmetrix.grc.riskcontrol.dto.ControlIdPreferenceDTO;
import com.asymmetrix.grc.riskcontrol.entity.ControlPreference;

public interface ControlIdPreferenceService {


	List<ControlPreference> getAllControlIdPreferenceByActiveflag();

	ControlPreference getControlIdPreferenceById(long seriesId);

	ControlIdPreferenceDTO createControlIdPreference(ControlIdPreferenceDTO preferenceDto, String userName);

	List<ControlPreference> saveAllControlIdPreference(List<ControlPreference> preferenceList);

	ControlIdPreferenceDTO updateControlIdPreference(ControlIdPreferenceDTO preferenceDto, String userName);

	ControlIdPreferenceDTO deleteControlIdPreference(ControlIdPreferenceDTO preferenceDto, String userName);

	
	int getControlIdPreferenceCountByActiveflag(String preferenceModule);

	ControlPreference getControlIdPreferenceByModule(String preferenceModule);

	int findNewIdPreferenceCountByStatusFlag(String preferenceModule);

	String findNewIdPreference(ControlIdPreferenceDTO findingDto);

}
