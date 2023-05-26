package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskRegistWithScoringDTO {
	
	private String riskRegId;
	private String wsId;
	private String deptId;
	private long riskId;
	private String inherentRiskRating;
	private String inherentLikelihoodRating;
	private String inherentImpactRating;
	private String residualRiskRating;
	private String ownerName;
	private String approvalInitStatus;
	
	public String getRiskRegId() {
		return riskRegId;
	}
	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}
	public String getWsId() {
		return wsId;
	}
	public void setWsId(String wsId) {
		this.wsId = wsId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public long getRiskId() {
		return riskId;
	}
	public void setRiskId(long riskId) {
		this.riskId = riskId;
	}
	public String getInherentRiskRating() {
		return inherentRiskRating;
	}
	public void setInherentRiskRating(String inherentRiskRating) {
		this.inherentRiskRating = inherentRiskRating;
	}
	public String getInherentLikelihoodRating() {
		return inherentLikelihoodRating;
	}
	public void setInherentLikelihoodRating(String inherentLikelihoodRating) {
		this.inherentLikelihoodRating = inherentLikelihoodRating;
	}
	public String getInherentImpactRating() {
		return inherentImpactRating;
	}
	public void setInherentImpactRating(String inherentImpactRating) {
		this.inherentImpactRating = inherentImpactRating;
	}
	public String getResidualRiskRating() {
		return residualRiskRating;
	}
	public void setResidualRiskRating(String residualRiskRating) {
		this.residualRiskRating = residualRiskRating;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getApprovalInitStatus() {
		return approvalInitStatus;
	}
	public void setApprovalInitStatus(String approvalInitStatus) {
		this.approvalInitStatus = approvalInitStatus;
	}


}
