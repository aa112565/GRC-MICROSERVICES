package com.asymmetrix.grc.riskkri.service;

import java.util.List;



import com.asymmetrix.grc.riskkri.dto.KriIdPreferenceDTO;
import com.asymmetrix.grc.riskkri.entity.KriPreference;

public interface KriIdPreferenceService {


	List<KriPreference> getAllKriIdPreferenceByActiveflag();

	KriPreference getKriIdPreferenceById(long seriesId);

	KriIdPreferenceDTO createKriIdPreference(KriIdPreferenceDTO preferenceDto, String userName);

	List<KriPreference> saveAllKriIdPreference(List<KriPreference> preferenceList);

	KriIdPreferenceDTO updateKriIdPreference(KriIdPreferenceDTO preferenceDto, String userName);

	KriIdPreferenceDTO deleteKriIdPreference(KriIdPreferenceDTO preferenceDto, String userName);
	
	int getKriIdPreferenceCountByActiveflag(String preferenceModule);

	KriPreference getKriIdPreferenceByModule(String preferenceModule);

	int findNewIdPreferenceCountByStatusFlag(String preferenceModule);

	String findNewIdPreference(KriIdPreferenceDTO findingDto);

}
