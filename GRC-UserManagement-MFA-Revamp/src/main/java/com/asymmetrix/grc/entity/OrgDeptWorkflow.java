package com.asymmetrix.grc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_SUBS_DEPT_WORKFLOW")
public class OrgDeptWorkflow  extends Auditable  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orgDeptWorkflowId;	
	
	@Column(name = "V_ORGANIZATION_ID")
	private String organizationId;
	
	@Column(name = "V_ORGANIZATION_NAME")
	private String organizationName;
	
	@Column(name = "V_SUBSIDIARY_ID")
	private String subsidiaryId;
	
	@Column(name = "V_SUBSIDIARY_NAME")
	private String subsidiaryName;
	
	@Column(name = "V_DEPARTMENT_ID")
	private String departmentId;
	
	@Column(name = "V_DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name = "V_CHECKER_ID")
	private String checkerId;
	
	@Column(name = "V_CHECKER_NAME")
	private String checkerName;
	
	@Column(name = "V_APPROVER_ID")
	private String approverId;
	
	@Column(name = "V_APPROVER_NAME")
	private String approverName;
	
	@Column(name = "V_REVIEWER_ID")
	private String reviewerId;
	
	@Column(name = "V_REVIEWER_NAME")
	private String reviewerName;	

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name = "V_REMARKS")
	private String remarks;



	public long getOrgDeptWorkflowId() {
		return orgDeptWorkflowId;
	}

	public void setOrgDeptWorkflowId(long orgDeptWorkflowId) {
		this.orgDeptWorkflowId = orgDeptWorkflowId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getSubsidiaryId() {
		return subsidiaryId;
	}

	public void setSubsidiaryId(String subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

	public String getSubsidiaryName() {
		return subsidiaryName;
	}

	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
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

	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	
}
