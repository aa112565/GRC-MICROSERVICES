package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskScoringApprovalDTO {

	private String approvalId;
	private String riskRegId;
	private String riskId;
	private String riskBusinessUnit;
	private String requiredApprovalLevel;
	private String levelOneApprover;
	private String levelTwoApprover;
	private String levelThreeApprover;
	private String remarks;	
	
	
	public String getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}
	public String getRiskRegId() {
		return riskRegId;
	}
	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}
	public String getRiskId() {
		return riskId;
	}
	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}
	
	public String getRequiredApprovalLevel() {
		return requiredApprovalLevel;
	}
	public void setRequiredApprovalLevel(String requiredApprovalLevel) {
		this.requiredApprovalLevel = requiredApprovalLevel;
	}
	public String getRiskBusinessUnit() {
		return riskBusinessUnit;
	}
	public void setRiskBusinessUnit(String riskBusinessUnit) {
		this.riskBusinessUnit = riskBusinessUnit;
	}
	public String getLevelOneApprover() {
		return levelOneApprover;
	}
	public void setLevelOneApprover(String levelOneApprover) {
		this.levelOneApprover = levelOneApprover;
	}
	public String getLevelTwoApprover() {
		return levelTwoApprover;
	}
	public void setLevelTwoApprover(String levelTwoApprover) {
		this.levelTwoApprover = levelTwoApprover;
	}
	public String getLevelThreeApprover() {
		return levelThreeApprover;
	}
	public void setLevelThreeApprover(String levelThreeApprover) {
		this.levelThreeApprover = levelThreeApprover;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
