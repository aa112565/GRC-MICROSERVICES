package com.asymmetrix.grc.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PM_POLICY_APPROVAL_LEVEL")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyApprovalLevel extends Auditable {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "APPROVAL_ID")
    private String approvalId;
	
    @Column(name = "POLICY_UNIQUE_ID")
    private String policyUniqueId;
    
    @Column(name = "POLICY_ID")
    private String policyId;
    
    @Column(name = "POLICY_DEPT_ID")
    private String policyDeptId;
    
    @Column(name = "POLICY_ORG_NAME")
    private String policyOrgName;
    
    @Column(name = "POLICY_BU")
    private String policyBusinessUnit;
    
    @Column(name = "REQ_APPROVAL_LEVEL")
    private String requiredApprovalLevel;
    
    @Column(name = "LEVEL_ONE_APPROVER")
    private String levelOneApprover;
    
    @Column(name = "LEVEL_TWO_APPROVER")
    private String levelTwoApprover;
    
    @Column(name = "LEVEL_THREE_APPROVER")
    private String levelThreeApprover;
    
    @Column(name = "LEVEL_ONE_STATUS")
    private String levelOneStatus;
    
    @Column(name = "LEVEL_TWO_STATUS")
    private String levelTwoStatus;
    
    @Column(name = "LEVEL_THREE_STATUS")
    private String levelThreeStatus;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;
    
    @Column(name = "LAST_UPDATED_BY")
    private String modifiedBy;
    
    @Column(name = "DELETE_FLAG")
    private String deleteFlag;
    
    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(final String approvalId) {
		this.approvalId = approvalId;
	}

	public String getPolicyUniqueId() {
		return policyUniqueId;
	}

	public void setPolicyUniqueId(final String policyUniqueId) {
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

	public void setRequiredApprovalLevel(final String requiredApprovalLevel) {
		this.requiredApprovalLevel = requiredApprovalLevel;
	}

	public String getLevelOneApprover() {
		return levelOneApprover;
	}

	public void setLevelOneApprover(final String levelOneApprover) {
		this.levelOneApprover = levelOneApprover;
	}

	public String getLevelTwoApprover() {
		return levelTwoApprover;
	}

	public void setLevelTwoApprover(final String levelTwoApprover) {
		this.levelTwoApprover = levelTwoApprover;
	}

	public String getLevelThreeApprover() {
		return levelThreeApprover;
	}

	public void setLevelThreeApprover(final String levelThreeApprover) {
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
