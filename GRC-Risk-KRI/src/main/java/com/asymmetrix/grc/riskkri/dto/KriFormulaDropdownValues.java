package com.asymmetrix.grc.riskkri.dto;

import java.util.List;

import com.asymmetrix.grc.riskkri.entity.KriFormulaTypeDD;
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
public class KriFormulaDropdownValues {

	private List<KriFormulaTypeDD> formulaDropdownValuesdto;

	public List<KriFormulaTypeDD> getFormulaDropdownValuesdto() {
		return formulaDropdownValuesdto;
	}

	public void setFormulaDropdownValuesdto(List<KriFormulaTypeDD> formulaDropdownValuesdto) {
		this.formulaDropdownValuesdto = formulaDropdownValuesdto;
	}

}
