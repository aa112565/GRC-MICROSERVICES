package com.grc.itrisk.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "ITRISK_ASSESSMEMT")
public class Assessment extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ASSESSMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long assessmentId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String assessmentUniqueId;
	
	@Column(name = "ORG_NAME")
	private String preferenceOganization;

	@Column(name = "PREF_YEAR")
	private String preferenceYear;

	
	@Column(name = "V_TEMPLATE_ID")
	private long templateId;

	@Column(name = "V_ASSESSMENT_NAME")
	private String assessmentName;	
	
	@Column(name = "V_ASSESSMENT_TYPE")
	private String assessmentType;
	
	@Column(name = "V_ASSESSMENT_PURPOSE")
	private String assessmentPurpose;
	
	@Column(name = "V_ASSESSMENT_FREQUENCY")
	private String assessmentFrequency;
	
	@Column(name = "V_REMARKS")
	private String remarks;	
	
	@Column(name = "V_organization")
	private String organization;
	
	@Column(name = "V_SUBSIDARY")
	private String subsidary;
	
	@Column(name = "V_DEPT")
	private String department;
	
	@Column(name = "V_START_DATE")
	private Date StartDate;	
	
	@Column(name = "V_END_DATE")
	private Date endDate;		
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSESSMENT_ID", referencedColumnName = "ASSESSMENT_ID", unique = false)
	@JsonMerge
	private  Set<AssessmentAssessors> assessors = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSESSMENT_ID", referencedColumnName = "ASSESSMENT_ID", unique = false)
	@JsonMerge
	private  Set<AssessmentAssessee> assessee = new HashSet<>();

	
	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name = "SAVE_FLAG")
	private String saveFlag;
	
	@Column(name = "V_STATUS")
	private String status;
	
	@Column(name = "APPROVAL_FLAG")
	private String approvalFlag;
	
	@Column(name = "APPROVAL_STATUS")
	private String approvalStatus;
	
	@Column(name = "APPROVAL_REMARKS")
	private String approvalRemarks;
	
	@Column(name = "INIT_ASSESSMENT_FLAG")
	private String initialAssessmentFlag;
	
	@Column(name = "INIT_ASSESSMENT_STATUS")
	private String initialAssessmentStatus;
	
	@Column(name = "POST_TREATMENT_FLAG")
	private String postTreatmentFlag;
	
	@Column(name = "POST_TREATMENT_STATUS")
	private String postTreatmentStatus;

	public long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public String getAssessmentPurpose() {
		return assessmentPurpose;
	}

	public void setAssessmentPurpose(String assessmentPurpose) {
		this.assessmentPurpose = assessmentPurpose;
	}

	public String getAssessmentFrequency() {
		return assessmentFrequency;
	}

	public void setAssessmentFrequency(String assessmentFrequency) {
		this.assessmentFrequency = assessmentFrequency;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getSubsidary() {
		return subsidary;
	}

	public void setSubsidary(String subsidary) {
		this.subsidary = subsidary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public String getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<AssessmentAssessors> getAssessors() {
		return assessors;
	}

	public void setAssessors(Set<AssessmentAssessors> assessors) {
		this.assessors = assessors;
	}

	public Set<AssessmentAssessee> getAssessee() {
		return assessee;
	}

	public void setAssessee(Set<AssessmentAssessee> assessee) {
		this.assessee = assessee;
	}

	public String getApprovalFlag() {
		return approvalFlag;
	}

	public void setApprovalFlag(String approvalFlag) {
		this.approvalFlag = approvalFlag;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalRemarks() {
		return approvalRemarks;
	}

	public void setApprovalRemarks(String approvalRemarks) {
		this.approvalRemarks = approvalRemarks;
	}

	public String getInitialAssessmentFlag() {
		return initialAssessmentFlag;
	}

	public void setInitialAssessmentFlag(String initialAssessmentFlag) {
		this.initialAssessmentFlag = initialAssessmentFlag;
	}

	public String getInitialAssessmentStatus() {
		return initialAssessmentStatus;
	}

	public void setInitialAssessmentStatus(String initialAssessmentStatus) {
		this.initialAssessmentStatus = initialAssessmentStatus;
	}

	public String getPostTreatmentFlag() {
		return postTreatmentFlag;
	}

	public void setPostTreatmentFlag(String postTreatmentFlag) {
		this.postTreatmentFlag = postTreatmentFlag;
	}

	public String getPostTreatmentStatus() {
		return postTreatmentStatus;
	}

	public void setPostTreatmentStatus(String postTreatmentStatus) {
		this.postTreatmentStatus = postTreatmentStatus;
	}

	public String getAssessmentUniqueId() {
		return assessmentUniqueId;
	}

	public void setAssessmentUniqueId(String assessmentUniqueId) {
		this.assessmentUniqueId = assessmentUniqueId;
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
	



}
