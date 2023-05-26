package com.asymmetrix.grc.risk.dto;

import java.util.List;

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
public class RiskDetailsDTO {

	private List<Long> riskIdList;

	private List<Long> riskListId;

	private List<RiskScoringDTO> listRiskScoringDTO;

	private List<RiskLibraryExportDTO> riskLibraryExportDTO;

	private List<RiskRegisterActiveRiskListDTO> riskRegisterActiveRiskListDTO;

	private List<RiskRegisterDTO> activeRiskIdsList;

	private List<RiskLibraryDTO> riskLibraryList;
	
	private RiskIdPreferenceDTO idPreferenceDto;

	private List<RiskRegisterActiveRiskScoringListDTO> activeRiskRegisterScoringList;

	public List<RiskRegisterActiveRiskListDTO> getRiskRegisterActiveRiskListDTO() {
		return riskRegisterActiveRiskListDTO;
	}

	public void setRiskRegisterActiveRiskListDTO(List<RiskRegisterActiveRiskListDTO> riskRegisterActiveRiskListDTO) {
		this.riskRegisterActiveRiskListDTO = riskRegisterActiveRiskListDTO;
	}

	public List<RiskScoringDTO> getListRiskScoringDTO() {
		return listRiskScoringDTO;
	}

	public void setListRiskScoringDTO(List<RiskScoringDTO> listRiskScoringDTO) {
		this.listRiskScoringDTO = listRiskScoringDTO;
	}

	public List<Long> getRiskListId() {
		return riskListId;
	}

	public void setRiskListId(List<Long> riskListId) {
		this.riskListId = riskListId;
	}

	public List<Long> getRiskIdList() {
		return riskIdList;
	}

	public void setRiskIdList(List<Long> riskIdList) {
		this.riskIdList = riskIdList;
	}

	public List<RiskLibraryDTO> getRiskLibraryList() {
		return riskLibraryList;
	}

	public void setRiskLibraryList(List<RiskLibraryDTO> riskLibraryList) {
		this.riskLibraryList = riskLibraryList;
	}

	public List<RiskLibraryExportDTO> getRiskLibraryExportDTO() {
		return riskLibraryExportDTO;
	}

	public void setRiskLibraryExportDTO(List<RiskLibraryExportDTO> riskLibraryExportDTO) {
		this.riskLibraryExportDTO = riskLibraryExportDTO;
	}

	public List<RiskRegisterDTO> getActiveRiskIdsList() {
		return activeRiskIdsList;
	}

	public void setActiveRiskIdsList(List<RiskRegisterDTO> activeRiskIdsList) {
		this.activeRiskIdsList = activeRiskIdsList;
	}

	public List<RiskRegisterActiveRiskScoringListDTO> getActiveRiskRegisterScoringList() {
		return activeRiskRegisterScoringList;
	}

	public void setActiveRiskRegisterScoringList(
			List<RiskRegisterActiveRiskScoringListDTO> activeRiskRegisterScoringList) {
		this.activeRiskRegisterScoringList = activeRiskRegisterScoringList;
	}

	public RiskIdPreferenceDTO getIdPreferenceDto() {
		return idPreferenceDto;
	}

	public void setIdPreferenceDto(RiskIdPreferenceDTO idPreferenceDto) {
		this.idPreferenceDto = idPreferenceDto;
	}
	
	

}
