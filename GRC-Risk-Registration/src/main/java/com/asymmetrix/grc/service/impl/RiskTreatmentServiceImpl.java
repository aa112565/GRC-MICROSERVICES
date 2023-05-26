package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.ResponseCategoryDTO;
import com.asymmetrix.grc.dto.RiskTreatmentDTO;
import com.asymmetrix.grc.entity.RiskTreatment;
import com.asymmetrix.grc.repository.RiskTreatmentRepository;
import com.asymmetrix.grc.repository.RiskTreatmtRespCategoryRepository;
import com.asymmetrix.grc.service.ExternalRESTService;
import com.asymmetrix.grc.service.RiskTreatmentService;

@Service
public class RiskTreatmentServiceImpl implements RiskTreatmentService{
	
	@Resource
	RiskTreatmtRespCategoryRepository respCategoryRepository;
	
	@Resource
	RiskTreatmentRepository riskTreatmentRepository;
	
	@Resource
	ExternalRESTService externalRestService;
	
	private static final String RISK_TREATEMENT_ACTIVE = "Y";
	
	public List<ResponseCategoryDTO> getAllResponseCategoryList(){
		return MapperUtils.mapToTargetClass(respCategoryRepository.findAll(), ResponseCategoryDTO.class);
	}
	
	public List<CnfgUserDTO> getAllUsers(){
		return MapperUtils.mapToTargetClass(externalRestService.getAllUserDetailsFromUserMgmt(), CnfgUserDTO.class);
	}
	
	public List<RiskTreatmentDTO> updateRiskTreatment(List<RiskTreatmentDTO> riskTreatmentDTO){		
		
		//Check whether the risk treatment is already persists and if exists make it inactive.
		if(riskTreatmentDTO.size() > 0)
			riskTreatmentRepository.updateRiskTreatmentsToInactive(riskTreatmentDTO.get(0).getRiskRegID(), riskTreatmentDTO.get(0).getRiskID());	
		
		List<RiskTreatment> riskTreatment = riskTreatmentRepository.saveAll(MapperUtils.mapToTargetClass(riskTreatmentDTO, RiskTreatment.class));
		return MapperUtils.mapToTargetClass(riskTreatment, RiskTreatmentDTO.class);
	}
	
	public List<RiskTreatmentDTO> getRiskTreatmentsForRiskID(String riskRegID, String riskID){	
		return MapperUtils.mapToTargetClass(riskTreatmentRepository.findByRiskRegIDAndRiskIDAndActive(riskRegID, riskID, RISK_TREATEMENT_ACTIVE), RiskTreatmentDTO.class);
	}

}
