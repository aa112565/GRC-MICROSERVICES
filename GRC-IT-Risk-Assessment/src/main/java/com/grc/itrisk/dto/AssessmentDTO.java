package com.grc.itrisk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssessmentDTO {	
	
	private long assessmentId;
	
	private String assessmentUniqueId;
	private String preferenceOganization;
	private String preferenceYear;	
	
	private long templateId;
	private String assessmentName;
	private String assessmentType;
	private String assessmentPurpose;
	private String assessmentFrequency;
	private String remarks;
	private String organization;
	private String subsidary;
	private String department;
	private Date StartDate;
	private Date endDate;
	private String createdBy;
	private String modifiedBy;	
	private Date createdDate;
	private Date modifiedDate;
	private String activeFlag;
	private String deleteFlag;
	private String saveFlag;
	private String status;
	
	private String approvalFlag;
	private String approvalStatus;
	private String approvalRemarks;
	
	private String initialAssessmentFlag;
	private String initialAssessmentStatus;
	
	private String postTreatmentFlag;
	private String postTreatmentStatus;
	
	private List<AssessmentAssessorsDTO> assessors = new ArrayList<>();
	
	private List<AssessmentAssesseeDTO> assessee = new ArrayList<>();
	
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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
	public List<AssessmentAssessorsDTO> getAssessors() {
		return assessors;
	}
	public void setAssessors(List<AssessmentAssessorsDTO> assessors) {
		this.assessors = assessors;
	}
	public List<AssessmentAssesseeDTO> getAssessee() {
		return assessee;
	}
	public void setAssessee(List<AssessmentAssesseeDTO> assessee) {
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
	public String getAssessmentUniqueId() {
	//	return assessmentUniqueId;
		String tempRes = null;
		if (getPreferenceOganization() != null) {
			tempRes = getPreferenceOganization()+"/";
		}
		if (getPreferenceYear() != null) {
			tempRes = tempRes + getPreferenceYear()+"/";
		}
		if (tempRes != null) {
			tempRes = tempRes + assessmentUniqueId;
			return tempRes;
		}else {
			return assessmentUniqueId;
		}		
	}
	public void setAssessmentUniqueId(String assessmentUniqueId) {
		this.assessmentUniqueId = assessmentUniqueId;
	}
	
	
	
	
	
}
