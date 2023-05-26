package com.asymmetrix.grc.riskkri.dto;

import java.util.List;


import com.asymmetrix.grc.riskkri.entity.EnterpriseKiDD;
import com.asymmetrix.grc.riskkri.entity.KriIdPreferenceDD;
import com.asymmetrix.grc.riskkri.entity.NatureOfKriDD;
import com.asymmetrix.grc.riskkri.entity.RiskIndicatorTypeDD;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropDownValues {

	private List<NatureOfKriDD> kriNature;

	private List<RiskIndicatorTypeDD> riskIndicatorType;

	private List<EnterpriseKiDD> enterpriseKi;
	
	private List<KriIdPreferenceDD>  idPreferenceModule;

	public List<NatureOfKriDD> getKriNature() {
		return kriNature;
	}

	public List<RiskIndicatorTypeDD> getRiskIndicatorType() {
		return riskIndicatorType;
	}

	public List<EnterpriseKiDD> getEnterpriseKi() {
		return enterpriseKi;
	}

	public void setKriNature(List<NatureOfKriDD> kriNature) {
		this.kriNature = kriNature;
	}

	public void setRiskIndicatorType(List<RiskIndicatorTypeDD> riskIndicatorType) {
		this.riskIndicatorType = riskIndicatorType;
	}

	public void setEnterpriseKi(List<EnterpriseKiDD> enterpriseKi) {
		this.enterpriseKi = enterpriseKi;
	}

	public List<KriIdPreferenceDD> getIdPreferenceModule() {
		return idPreferenceModule;
	}

	public void setIdPreferenceModule(List<KriIdPreferenceDD> idPreferenceModule) {
		this.idPreferenceModule = idPreferenceModule;
	}

	
}
