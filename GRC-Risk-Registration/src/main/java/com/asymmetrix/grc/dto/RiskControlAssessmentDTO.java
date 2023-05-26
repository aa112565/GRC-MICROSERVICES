package com.asymmetrix.grc.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskControlAssessmentDTO {

	
	private String riskRegId;
	private long riskId;
	private long controlId;
	private String documentsExamined;
	private String designEffectiveness;
	private String controlEffectiveness;
	private String reason;	
	private String riskName;		
	private Date assessmentDate;		
	private String justification;
	private String asssessedBy;
	private String nextAssessment;	

	public RiskControlAssessmentDTO() {
		super();
	}

	public RiskControlAssessmentDTO(String riskRegId, Long riskId, Long controlId) {
		this.riskRegId = riskRegId;
		this.riskId = riskId;
		this.controlId = controlId;
	}

	public String getRiskRegId() {
		return riskRegId;
	}

	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}

	public long getRiskId() {
		return riskId;
	}

	public void setRiskId(long riskId) {
		this.riskId = riskId;
	}

	public long getControlId() {
		return controlId;
	}

	public void setControlId(long controlId) {
		this.controlId = controlId;
	}

	public String getDocumentsExamined() {
		return documentsExamined;
	}

	public void setDocumentsExamined(String documentsExamined) {
		this.documentsExamined = documentsExamined;
	}

	public String getDesignEffectiveness() {
		return designEffectiveness;
	}

	public void setDesignEffectiveness(String designEffectiveness) {
		this.designEffectiveness = designEffectiveness;
	}

	public String getControlEffectiveness() {
		return controlEffectiveness;
	}

	public void setControlEffectiveness(String controlEffectiveness) {
		this.controlEffectiveness = controlEffectiveness;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}	

	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getAsssessedBy() {
		return asssessedBy;
	}

	public void setAsssessedBy(String asssessedBy) {
		this.asssessedBy = asssessedBy;
	}

	public String getNextAssessment() {
		return nextAssessment;
	}

	public void setNextAssessment(String nextAssessment) {
		this.nextAssessment = nextAssessment;
	}
}
