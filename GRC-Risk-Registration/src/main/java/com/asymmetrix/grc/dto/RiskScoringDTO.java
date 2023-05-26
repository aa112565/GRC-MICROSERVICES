package com.asymmetrix.grc.dto;

import java.util.Date;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskScoringDTO {

	private long srno;
	private String inherentRiskRating;
	private String residualRiskRating;
	private String inherentLikelihoodRating;
	private String residualLikelihoodRating;
	private String inherentSpeedOnset;
	private String residualSpeedOnset;
	private String inherentImpactRating;
	private String residualImpactRating;
	private String inherentRiskQntImpact;
	private String residualRiskQntImpact;
	private String justification;
	private String active;
	private Date assessmentDate;
	private String approvalInitStatus;	
	private String approvalFlag;
	
	
	public RiskScoringDTO(String inherentImpactRating, String inherentRiskRating) {
		super();
		this.inherentRiskRating = inherentRiskRating;
		this.inherentImpactRating = inherentImpactRating;
	}

	private String inherentRiskQntImpactCurrency;
	private String residualRiskQntImpactCurrency;

	private String riskRegId;
	private long riskId;

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

	public RiskScoringDTO() {
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
