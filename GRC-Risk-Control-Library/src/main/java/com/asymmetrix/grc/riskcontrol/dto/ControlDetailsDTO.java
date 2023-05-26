package com.asymmetrix.grc.riskcontrol.dto;

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
public class ControlDetailsDTO {

	private List<Long> controlIdList;
	private List<ControlLibraryDTO> controlLibraryList;
	private ControlIdPreferenceDTO idPreferenceDto;

	public List<Long> getControlIdList() {
		return controlIdList;
	}

	public void setControlIdList(List<Long> controlIdList) {
		this.controlIdList = controlIdList;
	}

	public List<ControlLibraryDTO> getControlLibraryList() {
		return controlLibraryList;
	}

	public void setControlLibraryList(List<ControlLibraryDTO> controlLibraryList) {
		this.controlLibraryList = controlLibraryList;
	}

	public ControlIdPreferenceDTO getIdPreferenceDto() {
		return idPreferenceDto;
	}

	public void setIdPreferenceDto(ControlIdPreferenceDTO idPreferenceDto) {
		this.idPreferenceDto = idPreferenceDto;
	}

	
}
