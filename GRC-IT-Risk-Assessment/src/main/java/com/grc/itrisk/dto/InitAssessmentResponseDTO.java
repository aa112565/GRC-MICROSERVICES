package com.grc.itrisk.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitAssessmentResponseDTO {	
	
	private List<PerformInitAssessmentDTO> initAssessment;
	
	private AssessmentIntRatingDTO initAssessmentRating;

	public List<PerformInitAssessmentDTO> getInitAssessment() {
		return initAssessment;
	}

	public void setInitAssessment(List<PerformInitAssessmentDTO> initAssessment) {
		this.initAssessment = initAssessment;
	}

	public AssessmentIntRatingDTO getInitAssessmentRating() {
		return initAssessmentRating;
	}

	public void setInitAssessmentRating(AssessmentIntRatingDTO initAssessmentRating) {
		this.initAssessmentRating = initAssessmentRating;
	}
	
	
	
	
}
