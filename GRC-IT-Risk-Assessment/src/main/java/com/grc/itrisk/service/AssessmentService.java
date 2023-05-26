package com.grc.itrisk.service;

import java.util.List;

import com.grc.itrisk.dto.AssessmentAttachmentsDTO;
import com.grc.itrisk.dto.AssessmentDTO;
import com.grc.itrisk.dto.AssessmentFileUploadDTO;


public interface AssessmentService {

	List<AssessmentDTO> getAllAssessment(); 

	AssessmentDTO getAssessmentById(long assessmentId);	

	AssessmentDTO createAssessment(AssessmentDTO assessmentDto);

	AssessmentDTO updateAssessment(AssessmentDTO assessmentDto);

	boolean deleteAssessment(AssessmentDTO assessmentDto);

	boolean inActiveAssessment(AssessmentDTO assessment);

	boolean activeAssessment(AssessmentDTO assessment);

	List<AssessmentDTO> getAllAssessmentByTemplateId(long templateId);

	String createFiles(AssessmentAttachmentsDTO vendorDto, String userName);
	
	String fileDelete(String refId);
	
	String fileDeleteByDocId(String docId);
	
	List<AssessmentFileUploadDTO> findAllAttachment(String refId);
	
	AssessmentFileUploadDTO downloadFile(String docId);
	

//	List<AssessmentDDDTO> getAllTemplateDD();

	
}
