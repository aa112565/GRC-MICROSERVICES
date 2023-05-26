package com.grc.threat.risk.dto;

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
public class ThreatDetailsDTO {

	private List<Long> threatIdList;
	private List<ThreatLibraryDTO> threatLibraryList;
	private ThreatIdPreferenceDTO idPreferenceDto;

	public List<Long> getThreatIdList() {
		return threatIdList;
	}

	public void setThreatIdList(List<Long> threatIdList) {
		this.threatIdList = threatIdList;
	}

	public List<ThreatLibraryDTO> getThreatLibraryList() {
		return threatLibraryList;
	}

	public void setThreatLibraryList(List<ThreatLibraryDTO> threatLibraryList) {
		this.threatLibraryList = threatLibraryList;
	}

	public ThreatIdPreferenceDTO getIdPreferenceDto() {
		return idPreferenceDto;
	}

	public void setIdPreferenceDto(ThreatIdPreferenceDTO idPreferenceDto) {
		this.idPreferenceDto = idPreferenceDto;
	}

	
}
