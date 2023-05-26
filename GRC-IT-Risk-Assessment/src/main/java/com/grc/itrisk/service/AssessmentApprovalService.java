package com.grc.itrisk.service;

import java.util.List;

import com.grc.itrisk.dto.AssessmentApprovalDTO;
import com.grc.itrisk.dto.AssessmentDTO;



public interface AssessmentApprovalService {

	List<AssessmentDTO> getAllAssessmentApproval(); 

//	AssessmentDTO getAssessmentApprovalById(long approvalId);	

	AssessmentDTO createAssessmentApproval(AssessmentApprovalDTO assessmentDto);

	AssessmentDTO updateAssessmentApproval(AssessmentApprovalDTO assessmentDto);

	AssessmentDTO getAssessmentApprovalByAssessmentId(long assessmentId);

	
	
}
