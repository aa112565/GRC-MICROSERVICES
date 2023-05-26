package com.grc.itrisk.service;

import java.util.List;

import com.grc.itrisk.dto.InitAssessmentResponseDTO;
import com.grc.itrisk.dto.PerformInitAssessmentDTO;



public interface PerformInitAssessmentService {

	List<PerformInitAssessmentDTO> getAllPerformInitAssessment(); 

	PerformInitAssessmentDTO getPerformInitAssessmentById(long initAssessmentId);
	
	InitAssessmentResponseDTO getPerformInitAssessmentByAssessmentId(long assessmentId);
	
	InitAssessmentResponseDTO createPerformInitAssessment(List<PerformInitAssessmentDTO> intAssessmentDto, String userName);	

	InitAssessmentResponseDTO updatePerformInitAssessment(List<PerformInitAssessmentDTO> intAssessmentDto, String userName);
	
/*
	boolean deletePerformInitAssessment(PerformInitAssessmentDTO initAssessmentDto);

	boolean inActivePerformInitAssessment(PerformInitAssessmentDTO initAssessmentDto);

	boolean activePerformInitAssessment(PerformInitAssessmentDTO initAssessmentDto);

	
*/	
}
