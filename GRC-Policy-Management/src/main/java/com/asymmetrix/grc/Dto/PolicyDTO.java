package com.asymmetrix.grc.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.asymmetrix.grc.Entity.PolicyApprover;
import com.asymmetrix.grc.Entity.PolicyCollaborate;
import com.asymmetrix.grc.Entity.PolicyReviewers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyDTO {
	
	
	private long policyId;
	private String collabrateId;
	private String attestaionsId;
	private String policyUniqueId;
	private String preferenceOganization;
	private String preferenceYear;
	private String Name;
	private String Description;
	private String Objective;
	private String Category;
	private String IssuingDepartment[];
//	private List<IssuingDepartment> issuingDepartment = new ArrayList<>();
	private String ApplicableDepartment[];
//	private List<ApplicableDepartment> applicableDepartment = new ArrayList<>();
//	private String PolicyEntity;
	private String organizationName;
	private String branchName;
	private String branchCode;
	private String Location;
	private Date IssuanceDate;
	private String organizationCode;
//	private String Reviewers;
	private List<PolicyReviewers> reviewers = new ArrayList<>();
	private Date ReviewDate;
	private Date NextReview;
	//private String Approvers;
	private List<PolicyApprover> approvers = new ArrayList<>();
	private Date EffectFrom;
	private Date ValidTill;
	private String departmentCode;
//	private String Collabrate;
	private List<PolicyCollaborate> Collabrate = new ArrayList<>();
	private String Attestations;
	private String Template;
	private String status;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String activeFlag;
	private String deleteFlag;
	private String docId;
	private String collabrateFlag;
	
	
	public String[] getIssuingDepartment() {
		return IssuingDepartment;
	}
	public void setIssuingDepartment(String[] issuingDepartment) {
		IssuingDepartment = issuingDepartment;
	}
	public String[] getApplicableDepartment() {
		return ApplicableDepartment;
	}
	public void setApplicableDepartment(String[] applicableDepartment) {
		ApplicableDepartment = applicableDepartment;
	}
	public String getCategory() {
		return Category;
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
	public void setCategory(String category) {
		Category = category;
	}
	
	
	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
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
	
	public Date getIssuanceDate() {
		return IssuanceDate;
	}
	
	public void setIssuanceDate(Date issuanceDate) {
		IssuanceDate = issuanceDate;
	}
	
	
	public List<PolicyReviewers> getReviewers() {
		return reviewers;
	}
	public void setReviewers(List<PolicyReviewers> reviewers) {
		this.reviewers = reviewers;
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
	
	public List<PolicyApprover> getApprovers() {
		return approvers;
	}
	public void setApprovers(List<PolicyApprover> approvers) {
		this.approvers = approvers;
	}
	
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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
	
    public String getAttestaionsId() {
		return attestaionsId;
	}
	public void setAttestaionsId(String attestaionsId) {
		this.attestaionsId = attestaionsId;
	}
	//	public List<PolicyCollaborate> getCollabrate() {
//		return Collabrate;
//	}
//	public void setCollabrate(List<PolicyCollaborate> collabrate) {
//		Collabrate = collabrate;
//	}
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
	public String getCollabrateId() {
		return collabrateId;
	}
	public void setCollabrateId(String collabrateId) {
		this.collabrateId = collabrateId;
	}
	public List<PolicyCollaborate> getCollabrate() {
		return Collabrate;
	}
	public void setCollabrate(List<PolicyCollaborate> collabrate) {
		Collabrate = collabrate;
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
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getCollabrateFlag() {
		return collabrateFlag;
	}
	public void setCollabrateFlag(String collabrateFlag) {
		this.collabrateFlag = collabrateFlag;
	}
	
	

}
