package com.grc.itrisk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PerformInitAssessmentDTO {	
	
	private long initAssessmentId;
	private long assessmentId;
	private long templateId;
	private String templateDomain;
	private String annexDetails;
	private String controlObjective;
	private String control;
	private String controlId;
	private String remarks;
	private String createdBy;
	private String modifiedBy;	
	private Date createdDate;
	private Date modifiedDate;
	private String activeFlag;
	private String deleteFlag;
	private String saveFlag;
	private String initialAssessmentResponse;
	private String initialAssessmentFlag;
	private String initialAssessmentStatus;
	
//	private AssessmentIntRatingDTO initAssessmentRating;
	
	
	public long getInitAssessmentId() {
		return initAssessmentId;
	}
	public void setInitAssessmentId(long initAssessmentId) {
		this.initAssessmentId = initAssessmentId;
	}
	public long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	public String getTemplateDomain() {
		return templateDomain;
	}
	public void setTemplateDomain(String templateDomain) {
		this.templateDomain = templateDomain;
	}
	public String getAnnexDetails() {
		return annexDetails;
	}
	public void setAnnexDetails(String annexDetails) {
		this.annexDetails = annexDetails;
	}
	public String getControlObjective() {
		return controlObjective;
	}
	public void setControlObjective(String controlObjective) {
		this.controlObjective = controlObjective;
	}
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getControlId() {
		return controlId;
	}
	public void setControlId(String controlId) {
		this.controlId = controlId;
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
	public long getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(long assessmentId) {
		this.assessmentId = assessmentId;
	}
	public String getInitialAssessmentResponse() {
		return initialAssessmentResponse;
	}
	public void setInitialAssessmentResponse(String initialAssessmentResponse) {
		this.initialAssessmentResponse = initialAssessmentResponse;
	}

	
	
	
}
