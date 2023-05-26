package com.asymmetrix.grc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskAssessmentHistoryDTO {

			
	private List<RiskTreatmentDTO> riskTreatementHistory;
	private List<RiskScoringDTO> riskScoringHistory;
	
	public List<RiskTreatmentDTO> getRiskTreatementHistory() {
		return riskTreatementHistory;
	}
	public void setRiskTreatementHistory(List<RiskTreatmentDTO> riskTreatementHistory) {
		this.riskTreatementHistory = riskTreatementHistory;
	}
	public List<RiskScoringDTO> getRiskScoringHistory() {
		return riskScoringHistory;
	}
	public void setRiskScoringHistory(List<RiskScoringDTO> riskScoringHistory) {
		this.riskScoringHistory = riskScoringHistory;
	}	
	
}
