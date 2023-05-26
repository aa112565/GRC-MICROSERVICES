package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.RiskAssessmentHistoryDTO;
import com.asymmetrix.grc.dto.RiskAssessmentTypesDTO;
import com.asymmetrix.grc.dto.RiskControlAssessmentDTO;
import com.asymmetrix.grc.entity.AssessmentAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskControlAssessmentAttachmentsDTO;


public interface RiskAssessmentService {
	
	public List<RiskControlAssessmentDTO> saveRiskControlAssessment(List<RiskControlAssessmentDTO> riskControlAssessmentList);
	public List<RiskControlAssessmentDTO> getAllRiskControlAssessments(String riskRegID, long riskID);
	public List<RiskAssessmentTypesDTO> getAllRiskAssessmentTypes();
	public List<RiskControlAssessmentDTO> getAllControlAssessments();
	
	//Attachments
	public List<RiskControlAssessmentAttachmentsDTO> getAttachmentsOfRiskControlAssessment(String riskRegID, long riskID, long controlID);
	public boolean createRiskControlAssessmentAttachment(AssessmentAttachmentsDTO attachments);
	public Integer deleteRiskControlAssessmentAttachment(Long attachmentIDList);
	public RiskControlAssessmentAttachmentsDTO downloadFile(Long attachmentID, String fileName);	
	
	//Assessment History
	public RiskAssessmentHistoryDTO getAssessmentHistory(String riskRegID, String riskID);
	
	//Delete Assessment
	public boolean deleteAssessment(String riskRegID, String riskID);
		
}
