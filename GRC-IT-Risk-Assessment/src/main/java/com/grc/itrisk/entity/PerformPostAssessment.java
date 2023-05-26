package com.grc.itrisk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ITRISK_POST_ASSESSMENT")
public class PerformPostAssessment extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postAssessmentId;
	
	@Column(name = "INIT_ASSESSMENT_ID", updatable = false)
	private long initAssessmentId;
	
	@Column(name = "V_ASSESSMENT_ID", updatable = false)
	private long assessmentId;
	
	@Column(name = "V_TEMPLATE_ID", updatable = false)
	private long templateId;		

	@Column(name = "V_TEMPLATE_DOMAIN", updatable = false)
	private String templateDomain;
	
	@Column(name = "V_ANNEX_DETAILS", updatable = false)
	private String annexDetails;
	
	@Column(name = "V_CONTROL_OBJECTIVE", updatable = false)
	private String controlObjective;
	
	@Column(name = "V_CONTROL", updatable = false)
	private String control;
	
	@Column(name = "V_CONTROL_ID", updatable = false)
	private String controlId;
	
	@Column(name = "INIT_ASSESSMENT_RESPONSE", updatable = false)
	private String initialAssessmentResponse;	

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
	
	@Column(name = "V_REMARKS", updatable = false)
	private String remarks;

	@Column(name = "POST_ASSESSMENT_FLAG")
	private String postAssessmentFlag;
	
	@Column(name = "POST_ASSESSMENT_STATUS")
	private String postAssessmentStatus;
	
	@Column(name = "V_CONTROL_IMPLEMETED")
	private String controlImplemented;
	
	@Column(name = "POST_ASSESSMENT_RESPONSE")
	private String postAssessmentResponse;
	
	@Column(name = "RISK_TREATMENT_REQUIRED")
	private String riskTreatmentRequired;
	
	@Column(name = "RISK_TREATMENT_METHOD")
	private String riskTreatmentMethod;

	public long getPostAssessmentId() {
		return postAssessmentId;
	}

	public void setPostAssessmentId(long postAssessmentId) {
		this.postAssessmentId = postAssessmentId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getControlId() {
		return controlId;
	}

	public void setControlId(String controlId) {
		this.controlId = controlId;
	}
	
	public String getInitialAssessmentResponse() {
		return initialAssessmentResponse;
	}

	public void setInitialAssessmentResponse(String initialAssessmentResponse) {
		this.initialAssessmentResponse = initialAssessmentResponse;
	}

	public long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(long assessmentId) {
		this.assessmentId = assessmentId;
	}


	public long getInitAssessmentId() {
		return initAssessmentId;
	}

	public void setInitAssessmentId(long initAssessmentId) {
		this.initAssessmentId = initAssessmentId;
	}

	public String getPostAssessmentResponse() {
		return postAssessmentResponse;
	}

	public void setPostAssessmentResponse(String postAssessmentResponse) {
		this.postAssessmentResponse = postAssessmentResponse;
	}

	public String getPostAssessmentFlag() {
		return postAssessmentFlag;
	}

	public void setPostAssessmentFlag(String postAssessmentFlag) {
		this.postAssessmentFlag = postAssessmentFlag;
	}

	public String getPostAssessmentStatus() {
		return postAssessmentStatus;
	}

	public void setPostAssessmentStatus(String postAssessmentStatus) {
		this.postAssessmentStatus = postAssessmentStatus;
	}

	public String getRiskTreatmentRequired() {
		return riskTreatmentRequired;
	}

	public void setRiskTreatmentRequired(String riskTreatmentRequired) {
		this.riskTreatmentRequired = riskTreatmentRequired;
	}

	public String getRiskTreatmentMethod() {
		return riskTreatmentMethod;
	}

	public void setRiskTreatmentMethod(String riskTreatmentMethod) {
		this.riskTreatmentMethod = riskTreatmentMethod;
	}

	public String getControlImplemented() {
		return controlImplemented;
	}

	public void setControlImplemented(String controlImplemented) {
		this.controlImplemented = controlImplemented;
	}

	
	
}
