package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.ResponseCategoryDTO;
import com.asymmetrix.grc.dto.RiskTreatmentDTO;


public interface RiskTreatmentService {

	public List<ResponseCategoryDTO> getAllResponseCategoryList(); 
	public List<CnfgUserDTO> getAllUsers(); 
	public List<RiskTreatmentDTO> updateRiskTreatment(List<RiskTreatmentDTO> riskTreatmentDTO);
	public List<RiskTreatmentDTO> getRiskTreatmentsForRiskID(String riskRegID, String riskID);
}
