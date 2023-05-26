package com.asymmetrix.grc.risk.dto;

import java.util.List;

import com.asymmetrix.grc.risk.entity.PrimaryReasonSourceDD;
import com.asymmetrix.grc.risk.entity.RiskCategoryDD;
import com.asymmetrix.grc.risk.entity.RiskEventTypeDD;
import com.asymmetrix.grc.risk.entity.RiskIdPreferenceDD;
import com.asymmetrix.grc.risk.entity.RiskTypeDD;
import com.asymmetrix.grc.risk.entity.SecondaryReasonSource;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropDownValues {

	private List<SecondaryReasonSource> secondaryReasonSource;

	private List<PrimaryReasonSourceDD> primaryReasonSource;

	private List<RiskCategoryDD> riskCategory;

	private List<RiskEventTypeDD> riskEventType;

	private List<RiskTypeDD> risktype;
	
	private List<RiskIdPreferenceDD>  idPreferenceModule;

	public List<SecondaryReasonSource> getSecondaryReasonSource() {
		return secondaryReasonSource;
	}

	public void setSecondaryReasonSource(List<SecondaryReasonSource> secondaryReasonSource) {
		this.secondaryReasonSource = secondaryReasonSource;
	}

	public List<PrimaryReasonSourceDD> getPrimaryReasonSource() {
		return primaryReasonSource;
	}

	public void setPrimaryReasonSource(List<PrimaryReasonSourceDD> primaryReasonSource) {
		this.primaryReasonSource = primaryReasonSource;
	}

	public List<RiskCategoryDD> getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(List<RiskCategoryDD> riskCategory) {
		this.riskCategory = riskCategory;
	}

	public List<RiskEventTypeDD> getRiskEventType() {
		return riskEventType;
	}

	public void setRiskEventType(List<RiskEventTypeDD> riskEventType) {
		this.riskEventType = riskEventType;
	}

	public List<RiskTypeDD> getRisktype() {
		return risktype;
	}

	public void setRisktype(List<RiskTypeDD> risktype) {
		this.risktype = risktype;
	}

	public List<RiskIdPreferenceDD> getIdPreferenceModule() {
		return idPreferenceModule;
	}

	public void setIdPreferenceModule(List<RiskIdPreferenceDD> idPreferenceModule) {
		this.idPreferenceModule = idPreferenceModule;
	}

	
}
