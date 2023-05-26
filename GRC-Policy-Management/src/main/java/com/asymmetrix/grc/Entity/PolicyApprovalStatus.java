package com.asymmetrix.grc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PM_POLICY_APPROVAL_STATUS")
@JsonIgnoreProperties(ignoreUnknown = true)

public class PolicyApprovalStatus extends  Auditable {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "STATUS_ID")
    private String statusId;
    @Column(name = "APPROVAL_ID")
    private String approvalId;
    @Column(name = "POLICY_UNIQUE_ID")
    private String policyUniqueId;
    @Column(name = "POLICY_ID")
    private String policyId;
    @Column(name = "APPROVAL_LEVEL")
    private String approvalLevel;
    @Column(name = "APPROVAL_STATUS")
    private String approvalStatus;
    @Column(name = "COMMENTS")
    private String comments;
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
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
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
	public String getApprovalLevel() {
		return approvalLevel;
	}
	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
