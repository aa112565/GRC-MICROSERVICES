package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.ImpactRiskRatingDTO;
import com.asymmetrix.grc.dto.LikelihoodRiskRatingDTO;
import com.asymmetrix.grc.dto.RiskControlMappingDTO;
import com.asymmetrix.grc.dto.RiskRegistWithScoringDTO;
import com.asymmetrix.grc.dto.RiskRegisterDTO;
import com.asymmetrix.grc.dto.RiskScoringDTO;
import com.asymmetrix.grc.entity.RiskRating;
import com.asymmetrix.grc.entity.RiskRegister;

public interface RiskRegisterService {
	
	List<RiskRegisterDTO> getAllActiveRiskIds();
//	List<RiskRegisterDTO> getAllActiveRiskIds(String branchname);
	
	List<RiskRegistWithScoringDTO> getAllActiveRiskIdswithScoring();
//	List<RiskRegistWithScoringDTO> getAllActiveRiskIdswithScoring(String branchname);
	
	RiskRegisterDTO getActiveRiskIds(String wsid, String deptId);
//	RiskRegisterDTO getActiveRiskIds(String wsid, String deptId, String branchname);
	
//	void saveRiskRegMapping(String riskRegisterId, List<Long> riskIds);	
	void saveRiskRegMapping(String riskRegisterId, List<Long> riskIds, String ownerName);

	String saveRiskRegister(RiskRegisterDTO model);

	RiskRegister saveToRiskRegAndRiskRegMapping(RiskRegisterDTO model);

	String saveRiskControlMapping(RiskControlMappingDTO model);

	RiskControlMappingDTO getActiveControlIds(String riskRegisterId, Long riskId);
	
	List<String> getCurrencyList();
	
	List<ImpactRiskRatingDTO> getImpactRatingList();
	
	List<ImpactRiskRatingDTO> getImpactRatingListDesc();
	
	
	List<LikelihoodRiskRatingDTO> getlikeLihoodRatingList();
	
	List<LikelihoodRiskRatingDTO> getlikeLihoodRatingListAsc();

	List<RiskRating> getRiskRatingList();
	
	RiskScoringDTO getRiskScoringById(String riskRegId, Long riskId); 

	RiskScoringDTO saveRiskScoring(RiskScoringDTO model);
	
	String getInherentRiskRating(String impact, String likelihood);
	
	String getResidualRiskRating(String impact, String likelihood);
	
	List<ImpactRiskRatingDTO> getImpactRatingListByScore(String score);
	
	List<LikelihoodRiskRatingDTO> getLikeLihoodRatingListByScore(String score);

	List<RiskRegistWithScoringDTO> getApprovalActionwithScoring();

	List<RiskRegistWithScoringDTO> getApprovalListwithScoring();

	
	
	
	
}
