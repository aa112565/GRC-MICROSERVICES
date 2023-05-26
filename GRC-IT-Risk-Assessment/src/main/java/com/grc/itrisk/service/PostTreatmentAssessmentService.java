package com.grc.itrisk.service;

import java.util.List;


import com.grc.itrisk.dto.PostAssessmentResponseDTO;
import com.grc.itrisk.dto.PostTreatmentAssessmentDTO;



public interface PostTreatmentAssessmentService {

	List<PostTreatmentAssessmentDTO> getAllPostTreatmentAssessment(); 

	PostTreatmentAssessmentDTO getPostTreatmentAssessmentById(long postAssessmentId);
	
	PostAssessmentResponseDTO getPostTreatmentAssessmentByAssessmentId(long assessmentId);
	
	PostAssessmentResponseDTO createPostTreatmentAssessment(List<PostTreatmentAssessmentDTO> postAssessmentDto, String userName);	

	PostAssessmentResponseDTO updatePostTreatmentAssessment(List<PostTreatmentAssessmentDTO> postAssessmentDto, String userName);
	
/*
	boolean deletePostTreatmentAssessment(PostTreatmentAssessmentDTO postAssessmentDto);

	boolean inActivePostTreatmentAssessment(PostTreatmentAssessmentDTO postAssessmentDto);

	boolean activePostTreatmentAssessment(PostTreatmentAssessmentDTO postAssessmentDto);

	
*/	
}
