package com.asymmetrix.grc.Dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.asymmetrix.grc.Entity.PolicyApprover;
import com.asymmetrix.grc.Entity.PolicyCollaborate;
import com.asymmetrix.grc.Entity.PolicyReviewers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeriodicReviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private long periodicreviewId;
	private String policyId;
	private String collabrateId;
	private String attestaionsId;
	private String policyUniqueId;
	private String preferenceOganization;
	private String preferenceYear;
	private String Name;
	private String Description;
	private String Objective;
	private String approve;
	private String Category;
	private String IssuingDepartment;
	private Date IssuanceDate;
	private String reviewers;
	private Date ReviewDate;
	private Date NextReview;
	private String approvers;
	private Date EffectFrom;
	private Date ValidTill;
	private String departmentCode;
	private String organizationName;
	private String branchName;
	private String Location;
	private String branchCode;
	private String organizationCode;
	private String Collabrate;
	private String Attestations;
	private String Template;
	private String status;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String activeFlag = "Y";
	private String deleteFlag = "N";
    private String approvalLevel;
    private String approvalInitStatus;
    private String approvalFlag;
    
	public long getPeriodicreviewId() {
		return periodicreviewId;
	}
	public void setPeriodicreviewId(long periodicreviewId) {
		this.periodicreviewId = periodicreviewId;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getCollabrateId() {
		return collabrateId;
	}
	public void setCollabrateId(String collabrateId) {
		this.collabrateId = collabrateId;
	}
	public String getAttestaionsId() {
		return attestaionsId;
	}
	public void setAttestaionsId(String attestaionsId) {
		this.attestaionsId = attestaionsId;
	}
	public String getPolicyUniqueId() {
		return policyUniqueId;
	}
	public void setPolicyUniqueId(String policyUniqueId) {
		this.policyUniqueId = policyUniqueId;
	}
	public String getPreferenceOganization() {
		return preferenceOganization;
	}
	public void setPreferenceOganization(String preferenceOganization) {
		this.preferenceOganization = preferenceOganization;
	}
	public String getPreferenceYear() {
		return preferenceYear;
	}
	public void setPreferenceYear(String preferenceYear) {
		this.preferenceYear = preferenceYear;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getObjective() {
		return Objective;
	}
	public void setObjective(String objective) {
		Objective = objective;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getIssuingDepartment() {
		return IssuingDepartment;
	}
	public void setIssuingDepartment(String issuingDepartment) {
		IssuingDepartment = issuingDepartment;
	}
	public Date getIssuanceDate() {
		return IssuanceDate;
	}
	public void setIssuanceDate(Date issuanceDate) {
		IssuanceDate = issuanceDate;
	}
	
	public Date getReviewDate() {
		return ReviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		ReviewDate = reviewDate;
	}
	public Date getNextReview() {
		return NextReview;
	}
	public void setNextReview(Date nextReview) {
		NextReview = nextReview;
	}
	
	public Date getEffectFrom() {
		return EffectFrom;
	}
	public void setEffectFrom(Date effectFrom) {
		EffectFrom = effectFrom;
	}
	public Date getValidTill() {
		return ValidTill;
	}
	public void setValidTill(Date validTill) {
		ValidTill = validTill;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	
	public String getAttestations() {
		return Attestations;
	}
	public void setAttestations(String attestations) {
		Attestations = attestations;
	}
	public String getTemplate() {
		return Template;
	}
	public void setTemplate(String template) {
		Template = template;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getApprovalLevel() {
		return approvalLevel;
	}
	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}
	public String getApprovalInitStatus() {
		return approvalInitStatus;
	}
	public void setApprovalInitStatus(String approvalInitStatus) {
		this.approvalInitStatus = approvalInitStatus;
	}
	public String getApprovalFlag() {
		return approvalFlag;
	}
	public void setApprovalFlag(String approvalFlag) {
		this.approvalFlag = approvalFlag;
	}
	public String getReviewers() {
		return reviewers;
	}
	public void setReviewers(String reviewers) {
		this.reviewers = reviewers;
	}
	public String getApprovers() {
		return approvers;
	}
	public void setApprovers(String approvers) {
		this.approvers = approvers;
	}
	public String getCollabrate() {
		return Collabrate;
	}
	public void setCollabrate(String collabrate) {
		Collabrate = collabrate;
	}
    

    
    
}
