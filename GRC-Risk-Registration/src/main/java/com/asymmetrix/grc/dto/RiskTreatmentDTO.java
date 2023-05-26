package com.asymmetrix.grc.dto;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskTreatmentDTO {
	
	private String riskID;	
	private String actionPlan;
	private String justification;
	private Date timeline;
	private String partyResponsibleUserName;
	private String partyResponsibleUserID;
	private String insurancePolicyNumber;
	private String insuranceType;
	private String insuranceCompany;
	private Date riskStartDate;
	private Date riskCessationDate;  
	private ResponseCategoryDTO responseCategory;	
	private Date periodOfInsurance;	
	private BigDecimal sumInsured;
	private String riskRegID;
	private Date assessmentDate;
	private String active;
	
	public RiskTreatmentDTO(String riskID, ResponseCategoryDTO responseCategory, String actionPlan, String justification, Date timeline, String partyResponsibleUserName,
			String partyResponsibleUserID, String insurancePolicyNumber, String insuranceType, String insuranceCompany, Date riskStartDate, Date riskCessationDate) {
		this.actionPlan = actionPlan;
		this.insuranceCompany = insuranceCompany;
		this.insurancePolicyNumber = insurancePolicyNumber;
		this.insuranceType= insuranceType;
		this.justification = justification;
		this.partyResponsibleUserID = partyResponsibleUserID;
		this.partyResponsibleUserName = partyResponsibleUserName;		
		this.riskCessationDate = riskCessationDate;
		this.riskStartDate = riskStartDate;
		this.responseCategory = responseCategory;
		this.timeline = timeline;
	}
	
	public String getRiskRegID() {
		return riskRegID;
	}
	public void setRiskRegID(String riskRegID) {
		this.riskRegID = riskRegID;
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
	public String getRiskID() {
		return riskID;
	}
	public void setRiskID(String riskID) {
		this.riskID = riskID;
	}

	public ResponseCategoryDTO getResponseCategory() {
		return responseCategory;
	}

	public void setResponseCategory(ResponseCategoryDTO responseCategory) {
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
	
	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public RiskTreatmentDTO() {
		
	}
	
}
