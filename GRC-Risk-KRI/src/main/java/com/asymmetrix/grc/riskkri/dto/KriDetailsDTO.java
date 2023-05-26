package com.asymmetrix.grc.riskkri.dto;

import java.util.List;

import com.asymmetrix.grc.riskkri.entity.RiskKri;
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
public class KriDetailsDTO {

	private List<Long> kriIdList;

	private List<RiskKri> kriRiskList;

	private List<RiskKriDTO> kriRiskListDto;

	private List<KRIWithBusinessLineDTO> kriwithbusinesslinelist;

	private List<KriDashboardDTO> kridashboard;

	public List<Long> getKriIdList() {
		return kriIdList;
	}

	public void setKriIdList(List<Long> kriIdList) {
		this.kriIdList = kriIdList;
	}

	public List<RiskKri> getKriRiskList() {
		return kriRiskList;
	}

	public void setKriRiskList(List<RiskKri> kriRiskList) {
		this.kriRiskList = kriRiskList;
	}

	public List<RiskKriDTO> getKriRiskListDto() {
		return kriRiskListDto;
	}

	public void setKriRiskListDto(List<RiskKriDTO> kriRiskListDto) {
		this.kriRiskListDto = kriRiskListDto;
	}

	public List<KRIWithBusinessLineDTO> getKriwithbusinesslinelist() {
		return kriwithbusinesslinelist;
	}

	public void setKriwithbusinesslinelist(List<KRIWithBusinessLineDTO> kriwithbusinesslinelist) {
		this.kriwithbusinesslinelist = kriwithbusinesslinelist;
	}

	public List<KriDashboardDTO> getKridashboard() {
		return kridashboard;
	}

	public void setKridashboard(List<KriDashboardDTO> kridashboard) {
		this.kridashboard = kridashboard;
	}

}
