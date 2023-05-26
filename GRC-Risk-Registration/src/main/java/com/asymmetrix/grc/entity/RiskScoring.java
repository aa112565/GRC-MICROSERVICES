package com.asymmetrix.grc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RR_RISK_SCORING", schema = "GRC_TEST_ENV_DB")
public class RiskScoring {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "N_SRNO")
	private long srno;

	@Column(name = "V_INHERENT_RISK_RATING")
	private String inherentRiskRating;

	@Column(name = "V_RESIDUAL_RISK_RATING")
	private String residualRiskRating;

	@Column(name = "V_INHERENT_LIKELIHOOD_RATING")
	private String inherentLikelihoodRating;

	@Column(name = "V_RESIDUAL_LIKELIHOOD_RATING")
	private String residualLikelihoodRating;

	@Column(name = "V_INHERENT_SPEED_ONSET")
	private String inherentSpeedOnset;

	@Column(name = "V_RESIDUAL_SPEED_ONSET")
	private String residualSpeedOnset;

	@Column(name = "V_INHERENT_IMPACT_RATING")
	private String inherentImpactRating;

	@Column(name = "V_RESIDUAL_IMPACT_RATING")
	private String residualImpactRating;

	@Column(name = "V_INHERENT_RISK_QNT_IMPACT")
	private String inherentRiskQntImpact;

	@Column(name = "V_RESIDUAL_RISK_QNT_IMPACT")
	private String residualRiskQntImpact;

	@Column(name = "V_INHERENT_RISK_QNT_IMPACT_CURRENCY")
	private String inherentRiskQntImpactCurrency;

	@Column(name = "V_RESIDUAL_RISK_QNT_IMPACT_CURRENCY")
	private String residualRiskQntImpactCurrency;

	@Column(name = "V_RISK_REG_ID")
	private String riskRegId;

	@Column(name = "V_RISK_ID")
	private long riskId;
	
	@Column(name = "V_JUSTIFICATION")
	private String justification;
	
	@Column(name = "V_ACTIVE")
	private String active;
	
	@Column(name = "D_ASSESSMENT_DATE")
	private Date assessmentDate;
	
	@Column(name = "V_APPROVAL_INIT_STATUS")
	private String approvalInitStatus;
	
	@Column(name = "V_APPROVAL_Flag")
	private String approvalFlag;

	public long getSrno() {
		return srno;
	}

	public void setSrno(long srno) {
		this.srno = srno;
	}

	public String getInherentRiskRating() {
		return inherentRiskRating;
	}

	public void setInherentRiskRating(String inherentRiskRating) {
		this.inherentRiskRating = inherentRiskRating;
	}

	public String getResidualRiskRating() {
		return residualRiskRating;
	}

	public void setResidualRiskRating(String residualRiskRating) {
		this.residualRiskRating = residualRiskRating;
	}

	public String getInherentLikelihoodRating() {
		return inherentLikelihoodRating;
	}

	public void setInherentLikelihoodRating(String inherentLikelihoodRating) {
		this.inherentLikelihoodRating = inherentLikelihoodRating;
	}

	public String getResidualLikelihoodRating() {
		return residualLikelihoodRating;
	}

	public void setResidualLikelihoodRating(String residualLikelihoodRating) {
		this.residualLikelihoodRating = residualLikelihoodRating;
	}

	public String getInherentSpeedOnset() {
		return inherentSpeedOnset;
	}

	public void setInherentSpeedOnset(String inherentSpeedOnset) {
		this.inherentSpeedOnset = inherentSpeedOnset;
	}

	public String getResidualSpeedOnset() {
		return residualSpeedOnset;
	}

	public void setResidualSpeedOnset(String residualSpeedOnset) {
		this.residualSpeedOnset = residualSpeedOnset;
	}

	public String getInherentImpactRating() {
		return inherentImpactRating;
	}

	public void setInherentImpactRating(String inherentImpactRating) {
		this.inherentImpactRating = inherentImpactRating;
	}

	public String getResidualImpactRating() {
		return residualImpactRating;
	}

	public void setResidualImpactRating(String residualImpactRating) {
		this.residualImpactRating = residualImpactRating;
	}

	public String getInherentRiskQntImpact() {
		return inherentRiskQntImpact;
	}

	public void setInherentRiskQntImpact(String inherentRiskQntImpact) {
		this.inherentRiskQntImpact = inherentRiskQntImpact;
	}

	public String getResidualRiskQntImpact() {
		return residualRiskQntImpact;
	}

	public void setResidualRiskQntImpact(String residualRiskQntImpact) {
		this.residualRiskQntImpact = residualRiskQntImpact;
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

	public String getInherentRiskQntImpactCurrency() {
		return inherentRiskQntImpactCurrency;
	}

	public void setInherentRiskQntImpactCurrency(String inherentRiskQntImpactCurrency) {
		this.inherentRiskQntImpactCurrency = inherentRiskQntImpactCurrency;
	}

	public String getResidualRiskQntImpactCurrency() {
		return residualRiskQntImpactCurrency;
	}

	public void setResidualRiskQntImpactCurrency(String residualRiskQntImpactCurrency) {
		this.residualRiskQntImpactCurrency = residualRiskQntImpactCurrency;
	}

	public RiskScoring() {
		super();
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
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

		
	
}
