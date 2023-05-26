package com.grc.threat.risk.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.grc.threat.risk.entity.ThreatIdPreferenceDD;
import com.grc.threat.risk.entity.ThreatType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropDownValues {

//	private List<ThreatCategory> threatCategory;

	private List<ThreatType> threatType;	
	
	private List<ThreatIdPreferenceDD>  idPreferenceModule;

	

	public List<ThreatIdPreferenceDD> getIdPreferenceModule() {
		return idPreferenceModule;
	}

	public void setIdPreferenceModule(List<ThreatIdPreferenceDD> idPreferenceModule) {
		this.idPreferenceModule = idPreferenceModule;
	}

	public List<ThreatType> getThreatType() {
		return threatType;
	}

	public void setThreatType(List<ThreatType> threatType) {
		this.threatType = threatType;
	}

	
	
	

}
