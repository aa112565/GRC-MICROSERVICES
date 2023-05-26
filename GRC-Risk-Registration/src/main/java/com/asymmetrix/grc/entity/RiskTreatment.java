package com.asymmetrix.grc.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "RISK_TREATMENT", schema = "GRC_TEST_ENV_DB")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskTreatment {
	
	@Id
	@Column(name = "N_RISK_TREATMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long riskTreatmentID;
	
	@Column(name = "V_RISK_ID")
	private String riskID;
	
	@OneToOne(targetEntity = RiskTreatmentRespCategory.class)
	@JoinColumn(name = "N_RESPONSE_CATEGORY_ID")
	private RiskTreatmentRespCategory responseCategory;
	
	@Column(name = "V_ACTION_PLAN")
	private String actionPlan;
	
	@Column(name="V_JUSTIFICATION")
	private String justification;
	
	@Column(name="D_TIMELINE")
	private Date timeline;
	
	@Column(name="V_PARTIES_RESPONSIBLE")
	private String partyResponsibleUserName;
	
	@Column(name="V_PARTIES_RESPONSIBLE_ID")
	private String partyResponsibleUserID;
	
	@Column(name="V_INSURANCE_POLICY_NUMBER")
	private String insurancePolicyNumber;
	
	@Column(name="V_INSURANCE_TYPE")
	private String insuranceType;
	
	@Column(name="V_INSURANCE_COMPANY")
	private String insuranceCompany;
	
	@Column(name="D_RISK_START_DATE")
	private Date riskStartDate;
	
	@Column(name="D_RISK_CESSATION_DATE")
	private Date riskCessationDate;
	
	@Column(name="V_ACTIVE")
	private String active = "Y";
	
	@Column(name="D_PERIOD_OF_INSURANCE")
	private Date periodOfInsurance;
	
	@Column(name="N_SUM_INSURED")
	private BigDecimal sumInsured;
	
	@Column(name="V_RISK_REG_ID")
	private String riskRegID;
	
	@Column(name = "D_ASSESSMENT_DATE")
	private Date assessmentDate;
	
	public String getRiskRegID() {
		return riskRegID;
	}

	public void setRiskRegID(String riskRegID) {
		this.riskRegID = riskRegID;
	}

	public long getRiskTreatmentID() {
		return riskTreatmentID;
	}

	public void setRiskTreatmentID(long riskTreatmentID) {
		this.riskTreatmentID = riskTreatmentID;
	}

	public String getRiskID() {
		return riskID;
	}

	public void setRiskID(String riskID) {
		this.riskID = riskID;
	}

	public RiskTreatmentRespCategory getResponseCategory() {
		return responseCategory;
	}

	public void setResponseCategory(RiskTreatmentRespCategory responseCategory) {
		this.responseCategory = responseCategory;
	}

	public String getActionPlan() {
		return actionPlan;
	}

	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Date getTimeline() {
		return timeline;
	}

	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}

	public String getPartyResponsibleUserName() {
		return partyResponsibleUserName;
	}

	public void setPartyResponsibleUserName(String partyResponsibleUserName) {
		this.partyResponsibleUserName = partyResponsibleUserName;
	}
	
	public String getPartyResponsibleUserID() {
		return partyResponsibleUserID;
	}

	public void setPartyResponsibleUserID(String partyResponsibleUserID) {
		this.partyResponsibleUserID = partyResponsibleUserID;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public Date getRiskStartDate() {
		return riskStartDate;
	}

	public void setRiskStartDate(Date riskStartDate) {
		this.riskStartDate = riskStartDate;
	}

	public Date getRiskCessationDate() {
		return riskCessationDate;
	}

	public void setRiskCessationDate(Date riskCessationDate) {
		this.riskCessationDate = riskCessationDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getPeriodOfInsurance() {
		return periodOfInsurance;
	}

	public void setPeriodOfInsurance(Date periodOfInsurance) {
		this.periodOfInsurance = periodOfInsurance;
	}

	public BigDecimal getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}

	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

}
