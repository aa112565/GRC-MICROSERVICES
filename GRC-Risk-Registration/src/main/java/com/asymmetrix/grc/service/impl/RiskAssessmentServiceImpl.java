package com.asymmetrix.grc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.RiskAssessmentHistoryDTO;
import com.asymmetrix.grc.dto.RiskAssessmentTypesDTO;
import com.asymmetrix.grc.dto.RiskControlAssessmentDTO;
import com.asymmetrix.grc.dto.RiskScoringDTO;
import com.asymmetrix.grc.dto.RiskTreatmentDTO;
import com.asymmetrix.grc.entity.AssessmentAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskControlAssessment;
import com.asymmetrix.grc.entity.RiskControlAssessmentAttachments;
import com.asymmetrix.grc.entity.RiskControlAssessmentAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskScoring;
import com.asymmetrix.grc.entity.RiskTreatment;
import com.asymmetrix.grc.repository.RiskAssessmentTypesRepository;
import com.asymmetrix.grc.repository.RiskControlAssessmentAttachementRepository;
import com.asymmetrix.grc.repository.RiskControlAssessmentRepository;
import com.asymmetrix.grc.repository.RiskScoringRepository;
import com.asymmetrix.grc.repository.RiskTreatmentRepository;
import com.asymmetrix.grc.service.RiskAssessmentService;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {
	
	private static final String ACTIVE_FLAG = "Y";

	@Resource
	RiskControlAssessmentRepository controlAssessmentRepo;
	
	@Resource
	RiskControlAssessmentAttachementRepository attachmentRepo;
	
	@Resource
	RiskAssessmentTypesRepository assessmentTypeRepo;
	
	@Resource
	RiskTreatmentRepository riskTreatementRepo;
	
	@Resource
	RiskScoringRepository riskScoringRepo;

	public List<RiskControlAssessmentDTO> saveRiskControlAssessment(List<RiskControlAssessmentDTO> riskControlAssessmentList) {	
		//Check whether the risk regid and its controls are present, if so deactivate them	
		if(riskControlAssessmentList.size() > 0) {
			for(RiskControlAssessmentDTO riskAssessmentDTO: riskControlAssessmentList) {				
				controlAssessmentRepo.setRiskControlAssessmentInActive(riskAssessmentDTO.getRiskRegId(), riskAssessmentDTO.getRiskId(), riskAssessmentDTO.getControlId());
			}
		}	
		
		/*	List<RiskControlAssessmentDTO> riskControlAssessList = new ArrayList<RiskControlAssessmentDTO>();
		if(riskControlAssessmentList.size() > 0) {
			for(RiskControlAssessmentDTO riskAssessmentDTO: riskControlAssessmentList) {				
				riskAssessmentDTO.set	
			}
		
		*/
		return MapperUtils.mapToTargetClass(
				controlAssessmentRepo
						.saveAll(MapperUtils.mapToTargetClass(riskControlAssessmentList, RiskControlAssessment.class)),
				RiskControlAssessmentDTO.class);
	}
	
	public List<RiskControlAssessmentDTO> getAllRiskControlAssessments(String riskRegID, long riskId) {
		//return MapperUtils.mapToTargetClass(controlAssessmentRepo.findByRiskRegIdAndRiskIdAndIsActive(riskRegID, riskId, ACTIVE_FLAG),
		return MapperUtils.mapToTargetClass(controlAssessmentRepo.findByRiskRegIdAndRiskId(riskRegID, riskId),
				RiskControlAssessmentDTO.class);
	}
	
	public List<RiskControlAssessmentDTO> getAllControlAssessments(){
		return MapperUtils.mapToTargetClass(controlAssessmentRepo.findByActive(ACTIVE_FLAG),
				RiskControlAssessmentDTO.class);
	}
	
	//Attachments
	
	public boolean createRiskControlAssessmentAttachment(AssessmentAttachmentsDTO attachmentsDTO) {
		boolean status = false;		
		List<RiskControlAssessmentAttachments> attachments = new ArrayList<RiskControlAssessmentAttachments>();
		try {
			for (MultipartFile attachment : attachmentsDTO.getFiles()) {
				attachments.add(new RiskControlAssessmentAttachments(attachmentsDTO.getRiskRegID(), attachmentsDTO.getRiskID(), attachmentsDTO.getControlID(),
						attachment.getBytes(), attachment.getOriginalFilename(),
						attachment.getContentType()));
			}
			attachmentRepo.saveAll(attachments);  
			status = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return status;
	}
	
	public List<RiskControlAssessmentAttachmentsDTO> getAttachmentsOfRiskControlAssessment(String riskRegID,
			long riskID, long controlID) {
		return MapperUtils.mapToTargetClass(
				attachmentRepo.findByRiskRegIDAndRiskIDAndControlIDAndActive(riskRegID, riskID, controlID, ACTIVE_FLAG),
				RiskControlAssessmentAttachmentsDTO.class);
	}
	
	public Integer deleteRiskControlAssessmentAttachment(Long attachmentID) {		
		return attachmentRepo.updateRiskControlAssessmentAttachmentToInactive(attachmentID);
	}	
	
	public RiskControlAssessmentAttachmentsDTO downloadFile(Long attachmentID, String fileName) {
		RiskControlAssessmentAttachments attachment = attachmentRepo.findByAttachmentIDAndFileNameAndActive(attachmentID, fileName, ACTIVE_FLAG);
		GRCUtils.isValid(attachment, "No Attachment found !");
		return MapperUtils.mapToTargetClass(attachment, RiskControlAssessmentAttachmentsDTO.class);
	}
	
	public List<RiskAssessmentTypesDTO> getAllRiskAssessmentTypes(){
		return MapperUtils.mapToTargetClass(assessmentTypeRepo.findAll(), RiskAssessmentTypesDTO.class);
	}
	
	//Assessment History
	public RiskAssessmentHistoryDTO getAssessmentHistory(String riskRegID, String riskID) {

		RiskAssessmentHistoryDTO riskAssessmentHistoryDTO = new RiskAssessmentHistoryDTO();
		riskAssessmentHistoryDTO.setRiskTreatementHistory(MapperUtils.mapToTargetClass(
				riskTreatementRepo.findTop2ByRiskRegIDAndRiskIDOrderByRiskTreatmentIDDesc(riskRegID, riskID), RiskTreatmentDTO.class));

		riskAssessmentHistoryDTO.setRiskScoringHistory(MapperUtils
				.mapToTargetClass(riskScoringRepo.findTop2ByRiskRegIdAndRiskIdOrderBySrnoDesc(riskRegID, Long.parseLong(riskID)), RiskScoringDTO.class));

		return riskAssessmentHistoryDTO;
	}
	
	//Delete Assessment
	public boolean deleteAssessment(String riskRegID, String riskID) {
		
		//Move to previous Risk Treatment - Toggled the active flag to the previous values
		List<RiskTreatment> riskTreatmentList = riskTreatementRepo.findTop2ByRiskRegIDAndRiskIDOrderByRiskTreatmentIDDesc(riskRegID, riskID);	
		for(RiskTreatment riskTreatement: riskTreatmentList) {
			if(!riskTreatement.getActive().equals(ACTIVE_FLAG))
				riskTreatementRepo.updateRiskTreatmentsToActive(riskTreatement.getRiskRegID(), riskTreatement.getRiskID());
			else
				riskTreatementRepo.updateRiskTreatmentsToInactive(riskTreatement.getRiskRegID(), riskTreatement.getRiskID());
		}
		
		//Move to previous Risk Scoring - Toggled the active flag to the previous values
		List<RiskScoring> riskScoringList = riskScoringRepo.findTop2ByRiskRegIdAndRiskIdOrderBySrnoDesc(riskRegID, Long.parseLong(riskID));	
		for(RiskScoring scoring: riskScoringList) {
			if(!scoring.getActive().equals(ACTIVE_FLAG))
				riskScoringRepo.updateRiskScoringToActive(scoring.getRiskRegId(), scoring.getRiskId());
			else
				riskScoringRepo.updateRiskScoringToInactive(scoring.getRiskRegId(), scoring.getRiskId());
		}
		
		//Move to previous control assessment - Toggled the active flag to the previous values
		
		
		
		return true;
	}

}
