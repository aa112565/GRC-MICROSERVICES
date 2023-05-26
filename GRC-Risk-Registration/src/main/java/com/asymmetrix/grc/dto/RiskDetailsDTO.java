package com.asymmetrix.grc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskDetailsDTO {	

	private List<Long> riskListId;
	
	public RiskDetailsDTO() {
		super();
	}

	public RiskDetailsDTO(List<Long> riskListId) {
		super();
		this.riskListId = riskListId;
	}

	public List<Long> getRiskListId() {
		return riskListId;
	}

	public void setRiskListId(List<Long> riskListId) {
		this.riskListId = riskListId;
	}

	@Override
	public String toString() {
		return "RiskDetailsDTO [riskListId=" + riskListId + "]";
	}	
	
	




}
