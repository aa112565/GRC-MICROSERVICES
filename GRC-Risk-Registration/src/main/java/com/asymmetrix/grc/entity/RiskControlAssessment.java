package com.asymmetrix.grc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "RISK_CONTROL_ASSESSMENT", schema = "GRC_TEST_ENV_DB")
public class RiskControlAssessment {

	@Id
	@Column(name = "N_CONTROL_ASSESSMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long controlAssessmentID;

	@Column(name = "V_RISK_REG_ID")
	private String riskRegId;

	@Column(name = "N_RISK_ID")
	private long riskId;

	@Column(name = "N_CONTROL_ID")
	private long controlId;


	@Column(name = "V_ACTIVE")
	private String active ="Y";
	
	@Column(name = "V_DOCUMENTS_EXAMINED")
	private String documentsExamined;
	
	@Column(name = "V_DESIGN_EFFECTIVENESS")
	private String designEffectiveness;
	
	@Column(name = "V_CONTROL_EFFECTIVENESS")
	private String controlEffectiveness;
	
	@Column(name = "V_REASON")
	private String reason;
	
	@Column(name = "V_RISK_NAME")
	private String riskName;
	
	@Column(name = "D_LAST_ASSESSMENT")
	private Date assessmentDate;
	
	@Column(name = "V_JUSTIFICATION")
	private String justification;
	
	@Column(name = "V_ASSESSED_BY")
	private String asssessedBy;
	
	@Column(name = "V_NEXT_ASSESSMENT")
	private String nextAssessment;
	

	public RiskControlAssessment() {
		super();
	}

	public RiskControlAssessment(String riskRegId, Long riskId, Long controlId) {
		this.riskRegId = riskRegId;
		this.riskId = riskId;
		this.controlId = controlId;
	//	this.active = active;
	}

	public long getControlAssessmentID() {
		return controlAssessmentID;
	}

	public void setControlAssessmentID(long controlAssessmentID) {
		this.controlAssessmentID = controlAssessmentID;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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
