package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskApprovalLevelDTO {	
	
	private String approvalId;
	private String riskRegId;
	private String riskId;
	private String riskDeptId;
	private String riskOwnerName;
	private String riskBusinessUnit;
	private String requiredApprovalLevel;
	private String levelOneApprover;	
	private String levelTwoApprover;
	private String levelThreeApprover;
	private String levelOneStatus;
	private String levelTwoStatus;
	private String levelThreeStatus;
	private String status;
	private String createdBy;
	private String modifiedBy;
	private String deleteFlag;
	private String activeFlag;
	
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
	public String getRiskDeptId() {
		return riskDeptId;
	}
	public void setRiskDeptId(String riskDeptId) {
		this.riskDeptId = riskDeptId;
	}
	public String getRiskOwnerName() {
		return riskOwnerName;
	}
	public void setRiskOwnerName(String riskOwnerName) {
		this.riskOwnerName = riskOwnerName;
	}
	public String getRiskBusinessUnit() {
		return riskBusinessUnit;
	}
	public void setRiskBusinessUnit(String riskBusinessUnit) {
		this.riskBusinessUnit = riskBusinessUnit;
	}
	public String getRequiredApprovalLevel() {
		return requiredApprovalLevel;
	}
	public void setRequiredApprovalLevel(String requiredApprovalLevel) {
		this.requiredApprovalLevel = requiredApprovalLevel;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getLevelOneStatus() {
		return levelOneStatus;
	}
	public void setLevelOneStatus(String levelOneStatus) {
		this.levelOneStatus = levelOneStatus;
	}
	public String getLevelTwoStatus() {
		return levelTwoStatus;
	}
	public void setLevelTwoStatus(String levelTwoStatus) {
		this.levelTwoStatus = levelTwoStatus;
	}
	public String getLevelThreeStatus() {
		return levelThreeStatus;
	}
	public void setLevelThreeStatus(String levelThreeStatus) {
		this.levelThreeStatus = levelThreeStatus;
	}
		
	    
}


