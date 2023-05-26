package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KRIWithBusinessLineDTO;
import com.asymmetrix.grc.riskkri.dto.RiskKriDTO;
import com.asymmetrix.grc.riskkri.entity.RiskKri;

public interface KRILibraryService {
	
	List<RiskKri> getAllKri();
	RiskKri getKriById(long kriId);
	List<RiskKriDTO> getKriByList(List<Long> kriIdList);
	List<KRIWithBusinessLineDTO> getAllKriwithBusinessline();
	List<RiskKri> saveAllKri(List<RiskKri> riskKriAll);
	RiskKri createKri(RiskKriDTO kriDTO);
	RiskKri updateKri(RiskKriDTO kriDTO);
	RiskKri deleteKri(RiskKriDTO kriDTO);
	String deleteKriList(List<RiskKriDTO> kriDtoList, String userDetail);
	
	

}
