package com.grc.itrisk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ITRISK_INITIAL_ASSESSMENT")
public class PerformInitAssessment extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long initAssessmentId;
	
	@Column(name = "V_ASSESSMENT_ID")
	private long assessmentId;
	
	@Column(name = "V_TEMPLATE_ID")
	private long templateId;		

	@Column(name = "V_TEMPLATE_DOMAIN")
	private String templateDomain;
	
	@Column(name = "V_ANNEX_DETAILS")
	private String annexDetails;
	
	@Column(name = "V_CONTROL_OBJECTIVE")
	private String controlObjective;
	
	@Column(name = "V_CONTROL")
	private String control;
	
	@Column(name = "V_CONTROL_ID")
	private String controlId;
	
	@Column(name = "INIT_ASSESSMENT_RESPONSE")
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
	
	@Column(name = "V_REMARKS")
	private String remarks;

	@Column(name = "INIT_ASSESSMENT_FLAG")
	private String initialAssessmentFlag;
	
	@Column(name = "INIT_ASSESSMENT_STATUS")
	private String initialAssessmentStatus;




	
	public long getInitAssessmentId() {
		return initAssessmentId;
	}

	public void setInitAssessmentId(long initAssessmentId) {
		this.initAssessmentId = initAssessmentId;
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
