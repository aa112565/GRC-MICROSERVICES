package com.grc.itrisk.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grc.itrisk.entity.AssessmentFrequencyDD;
import com.grc.itrisk.entity.AssessmentRatingResponseDD;
import com.grc.itrisk.entity.AssessmentTypeDD;
import com.grc.itrisk.entity.ITRiskIdPreferenceDD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropDownValues {

	
	private List<AssessmentRatingResponseDD> assessmentRatingResponse;
	
	private List<AssessmentFrequencyDD> assessmentFrequency;	
	
	private List<AssessmentTypeDD> assessmentType;
	
	private List<ITRiskIdPreferenceDD> idPreferenceModule;

	public List<AssessmentRatingResponseDD> getAssessmentRatingResponse() {
		return assessmentRatingResponse;
	}

	public void setAssessmentRatingResponse(List<AssessmentRatingResponseDD> assessmentRatingResponse) {
		this.assessmentRatingResponse = assessmentRatingResponse;
	}

	public List<AssessmentFrequencyDD> getAssessmentFrequency() {
		return assessmentFrequency;
	}

	public void setAssessmentFrequency(List<AssessmentFrequencyDD> assessmentFrequency) {
		this.assessmentFrequency = assessmentFrequency;
	}

	public List<AssessmentTypeDD> getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(List<AssessmentTypeDD> assessmentType) {
		this.assessmentType = assessmentType;
	}

	public List<ITRiskIdPreferenceDD> getIdPreferenceModule() {
		return idPreferenceModule;
	}

	public void setIdPreferenceModule(List<ITRiskIdPreferenceDD> idPreferenceModule) {
		this.idPreferenceModule = idPreferenceModule;
	}		
	
	

	

}
