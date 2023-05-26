package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "RR_RISK_APPROVAL_LEVEL", schema = "GRC_TEST_ENV_DB")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskApprovalLevel extends Auditable {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "APPROVAL_ID")
	private String approvalId;

	@Column(name = "RISK_REG_ID")
	private String riskRegId;

	@Column(name = "RISK_ID")
	private String riskId;

	@Column(name = "RISK_DEPT_ID")
	private String riskDeptId;

	@Column(name = "RISK_OWNER_NAME")
	private String riskOwnerName;

	@Column(name = "RISK_BU")
	private String riskBusinessUnit;

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

	public RiskApprovalLevel() {
		super();
	}

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
