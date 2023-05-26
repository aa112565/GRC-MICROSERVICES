package com.grc.itrisk.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAssessmentResponseDTO {	
	
	private List<PostTreatmentAssessmentDTO> postAssessment;
	
	private AssessmentPostRatingDTO postAssessmentRating;

	public List<PostTreatmentAssessmentDTO> getPostAssessment() {
		return postAssessment;
	}

	public void setPostAssessment(List<PostTreatmentAssessmentDTO> postAssessment) {
		this.postAssessment = postAssessment;
	}

	public AssessmentPostRatingDTO getPostAssessmentRating() {
		return postAssessmentRating;
	}

	public void setPostAssessmentRating(AssessmentPostRatingDTO postAssessmentRating) {
		this.postAssessmentRating = postAssessmentRating;
	}

	

	

	
}
