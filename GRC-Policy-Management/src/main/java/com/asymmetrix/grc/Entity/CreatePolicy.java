package com.asymmetrix.grc.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonMerge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "PM_POLICY_CREATION" )
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePolicy  extends Auditable  {  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "PM_PolicyID")
	private long policyId;
	
	@Column(name = "PM_COLLABRATEID")
	private String collabrateId;
	
	@Column(name = "PM_TEMPLATEID")
	 private String docId;
	
	@Column(name = "PM_ATTESTATIONS_ID")
	private String attestaionsId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String policyUniqueId;
	
	@Column(name = "ORG_NAME")
	private String preferenceOganization;

	@Column(name = "PREF_YEAR")
	private String preferenceYear;
	
	@Column(name = "PM_Name")
	private String Name;
	
//	@Lob
	@Column(name = "PM_DESCRIPTION")
	private String Description;
	
	@Column(name = "PM_OBJECTIVE")
	private String Objective;
	
	@Column(name = "PM_APPROVE")
	private String approve;
	
	@Column(name = "PM_REJECT")
	private String reject;	
	
	@Column(name = "PM_CATEGORY")
	private String Category;
	
	
	@Column(name = "PM_ALERT_MESSAGE")
	private String alertMessage;

	
    @Column(name = "PM_ISSUINGDEPARTMENT")
	private String[] IssuingDepartment;
//	Set<String> IssuingDepartment = new HashSet<>();

	@Column(name = "PM_APPLICABLEDEPARTMENT")
	private String[] ApplicableDepartment ;
	
	@Column(name = "PM_ISSUANCEDATE")
	private Date IssuanceDate;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PM_PolicyID", referencedColumnName = "PM_PolicyID", unique = false)
	@JsonMerge
	private Set<PolicyReviewers> reviewers = new HashSet<>();
	
	@Column(name = "PM_REVIEWDATE")
	private Date ReviewDate;
	
	@Column(name = "PM_NEXTREVIEW")
	private Date NextReview;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PM_PolicyID", referencedColumnName = "PM_PolicyID", unique = false)
	@JsonMerge
	private Set<PolicyApprover> approvers = new HashSet<>();

	
	@Column(name = "PM_EFFECTFORM")
	private Date EffectFrom;
	
	@Column(name = "PM_VALIDTILL")
	private Date ValidTill;
	
	@Column(name = "PM_DEPCODE")
	private String departmentCode;
	
	@Column(name = "PM_POLICY_ORG")
	private String organizationName;
	
	@Column(name = "PM_POLICY_SUB")
	private String branchName;
	
	@Column(name = "PM_POLICY_LOCATION")
	private String Location;
	
	@Column(name = "PM_POLICY_BRANCHCODE")
	private String branchCode;
	
	@Column(name = "PM_POLICY_ORGCODE")
	private String organizationCode;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "PM_PolicyID", referencedColumnName = "PM_PolicyID", unique = false)
//	@JsonMerge
//	private Set<PolicyCollaborate> Collabrate = new HashSet<>();
	
	@Column(name = "PM_ATTESTATION")
	private String Attestations;
	
	@Column(name = "PM_TEMPLATE")
	private String Template;
	
	@Column(name = "STATUS")
	private String status;
	
     @Column(name = "PMM_REVIEW")
	private String review;
	
	@Column(name = "PUBLISHATTESTATION")
	private String publishAttestation;
	
	@Column(name = "COLLABRATE_FLAG")
	private String collabrateFlag;
	
	@Column(name = "D_CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "POLICY_APPROVE")
    private String policyApprove;
	
	@Column(name = "V_CREATED_BY")
	private String createdBy;
	
	@Column(name = "D_MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name = "V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag = "Y";
		 
	@Column(name = "DELETE_FLAG")
	private String deleteFlag = "N";
	
	@Column(name = "APPROVAL_LEVEL")
    private String approvalLevel;
	
    @Column(name = "APPROVAL_STATUS")
    private String approvalInitStatus;
    
    @Column(name = "APPROVAL_FLAG")
    private String approvalFlag;

	
	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
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

//	public String getDescription() {
//		return Description;
//	}
//
//	public void setDescription(String description) {
//		Description = description;
//	}
	
	

	public String getObjective() {
		return Objective;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setObjective(String objective) {
		Objective = objective;
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

	public Date getIssuanceDate() {
		return IssuanceDate;
	}

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


	public Set<PolicyApprover> getApprovers() {
		return approvers;
	}

	public void setApprovers(Set<PolicyApprover> approvers) {
		this.approvers = approvers;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}


	public String getCollabrateId() {
		return collabrateId;
	}

	public void setCollabrateId(String collabrateId) {
		this.collabrateId = collabrateId;
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

	public Set<PolicyReviewers> getReviewers() {
		return reviewers;
	}

	public void setReviewers(Set<PolicyReviewers> reviewers) {
		this.reviewers = reviewers;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}



//	public String getReviewPolicy() {
//		return reviewPolicy;
//	}
//
//	public void setReviewPolicy(String reviewPolicy) {
//		this.reviewPolicy = reviewPolicy;
//	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getPublishAttestation() {
		return publishAttestation;
	}

	public void setPublishAttestation(String publishAttestation) {
		this.publishAttestation = publishAttestation;
	}

	public String getPolicyApprove() {
		return policyApprove;
	}

	public void setPolicyApprove(String policyApprove) {
		this.policyApprove = policyApprove;
	}

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	public String getCollabrateFlag() {
		return collabrateFlag;
	}

	public void setCollabrateFlag(String collabrateFlag) {
		this.collabrateFlag = collabrateFlag;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

//	public Set<PolicyCollaborate> getCollabrate() {
//		return Collabrate;
//	}
//
//	public void setCollabrate(Set<PolicyCollaborate> collabrate) {
//		Collabrate = collabrate;
//	}




	
	

}
