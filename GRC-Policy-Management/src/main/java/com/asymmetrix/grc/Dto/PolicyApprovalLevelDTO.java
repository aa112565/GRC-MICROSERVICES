package com.asymmetrix.grc.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyApprovalLevelDTO {
	
	private String approvalId;
    private String policyUniqueId;
    private String policyId;
    private String policyDeptId;
    private String policyOrgName;
    private String policyBusinessUnit;
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
	public String getPolicyUniqueId() {
		return policyUniqueId;
	}
	public void setPolicyUniqueId(String policyUniqueId) {
		this.policyUniqueId = policyUniqueId;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getPolicyDeptId() {
		return policyDeptId;
	}
	public void setPolicyDeptId(String policyDeptId) {
		this.policyDeptId = policyDeptId;
	}
	public String getPolicyOrgName() {
		return policyOrgName;
	}
	public void setPolicyOrgName(String policyOrgName) {
		this.policyOrgName = policyOrgName;
	}
	public String getPolicyBusinessUnit() {
		return policyBusinessUnit;
	}
	public void setPolicyBusinessUnit(String policyBusinessUnit) {
		this.policyBusinessUnit = policyBusinessUnit;
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

    
    
    
}
