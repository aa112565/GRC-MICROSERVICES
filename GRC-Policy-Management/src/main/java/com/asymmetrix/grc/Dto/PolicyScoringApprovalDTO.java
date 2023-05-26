package com.asymmetrix.grc.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyScoringApprovalDTO {
	
	 private String approvalId;
	    private String policyUniqueId;
	    private String policyId;
	    private String assessmentId;
	    private String businessUnit;
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
		public String getAssessmentId() {
			return assessmentId;
		}
		public void setAssessmentId(String assessmentId) {
			this.assessmentId = assessmentId;
		}
		public String getBusinessUnit() {
			return businessUnit;
		}
		public void setBusinessUnit(String businessUnit) {
			this.businessUnit = businessUnit;
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
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
	    
	    

}
