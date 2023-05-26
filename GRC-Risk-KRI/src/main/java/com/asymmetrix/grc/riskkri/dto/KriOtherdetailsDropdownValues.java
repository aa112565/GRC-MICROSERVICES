package com.asymmetrix.grc.riskkri.dto;

import java.util.List;

import com.asymmetrix.grc.riskkri.entity.KriReviewFrequencyDD;
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
public class KriOtherdetailsDropdownValues {

	private List<KriReviewFrequencyDD> otherdetailsDropdownValues;

	public List<KriReviewFrequencyDD> getOtherdetailsDropdownValues() {
		return otherdetailsDropdownValues;
	}

	public void setOtherdetailsDropdownValues(List<KriReviewFrequencyDD> otherdetailsDropdownValues) {
		this.otherdetailsDropdownValues = otherdetailsDropdownValues;
	}

}
