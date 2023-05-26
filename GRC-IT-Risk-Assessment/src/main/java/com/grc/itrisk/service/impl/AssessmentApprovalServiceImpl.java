package com.grc.itrisk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.exception.ITRiskException;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.AssessmentApprovalRepository;
import com.grc.itrisk.dao.AssessmentRepository;
import com.grc.itrisk.dto.AssessmentApprovalDTO;
import com.grc.itrisk.dto.AssessmentDTO;
import com.grc.itrisk.entity.Assessment;
import com.grc.itrisk.service.AssessmentApprovalService;


@Service
public class AssessmentApprovalServiceImpl implements AssessmentApprovalService {

	@Autowired
	private AssessmentRepository assessmentRepo;
	
	@Autowired
	private AssessmentApprovalRepository assessmentApprovalRepo;
	

	@Override
	public List<AssessmentDTO> getAllAssessmentApproval() {
		List<Assessment> assessmentList = assessmentApprovalRepo.findAllAssessmentApproval();
		 if (assessmentList.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }		 
		 List<AssessmentDTO> assessList = MapperUtils.mapToTargetClass(assessmentList, AssessmentDTO.class);			
					
		return assessList;
	}


	@Override
	public AssessmentDTO getAssessmentApprovalByAssessmentId(long assessmentId) {
		Assessment assessment = assessmentApprovalRepo.getAssessmentApprovalByAssessmentId(assessmentId);				 
		AssessmentDTO assessList = MapperUtils.mapToTargetClass(assessment, AssessmentDTO.class);		
		return assessList;		
	}

/*	
	@Override
	public AssessmentDTO getAssessmentApprovalById(long approvalId) {		
		Assessment vAssessment = assessmentRepo.findById(approvalId).orElseThrow(
				() -> new ResourceNotFoundException("IT-Risk-Assessment not found with  Id----> " + approvalId));
		AssessmentDTO assessment = MapperUtils.mapToTargetClass( vAssessment, AssessmentDTO.class);			
		return assessment;
		
	}
*/
	
	public List<Assessment> saveAll(List<Assessment> assessmentList) {
		return this.assessmentRepo.saveAll(assessmentList);
	}

	@Override
	public AssessmentDTO createAssessmentApproval(AssessmentApprovalDTO assessmentApprovalDto) {		
		AssessmentDTO assessDto = getAssessmentApprovalByAssessmentId(assessmentApprovalDto.getAssessmentId());	
			assessDto.setCreatedBy(assessmentApprovalDto.getCreatedBy());
			assessDto.setApprovalFlag("Y");
			assessDto.setApprovalStatus(assessmentApprovalDto.getApprovalStatus());
			assessDto.setApprovalRemarks(assessmentApprovalDto.getApprovalRemarks());
			assessDto.setStatus("Assessment-Approval");
		Assessment assessmentApproval = MapperUtils.mapToTargetClass(assessDto, Assessment.class);
		AssessmentDTO assess = MapperUtils.mapToTargetClass(assessmentRepo.save(assessmentApproval), AssessmentDTO.class);
		return assess;
	}

	
	@Override
	@Transactional
	public AssessmentDTO updateAssessmentApproval(AssessmentApprovalDTO assessmentApprovalDto) {		
		AssessmentDTO assessDto = getAssessmentApprovalByAssessmentId(assessmentApprovalDto.getAssessmentId());		
		if( "Y".equals(assessDto.getApprovalFlag())) {		
			assessDto.setModifiedBy(assessmentApprovalDto.getCreatedBy());			
			assessDto.setApprovalStatus(assessmentApprovalDto.getApprovalStatus());
			assessDto.setApprovalRemarks(assessmentApprovalDto.getApprovalRemarks());
			assessDto.setStatus("Assessment-Approval");
		 } else {
			 return assessDto;
				}	
		Assessment assessmentApproval = MapperUtils.mapToTargetClass(assessDto, Assessment.class);
		AssessmentDTO assessApproval = MapperUtils.mapToTargetClass(assessmentRepo.save(assessmentApproval), AssessmentDTO.class);
		return assessApproval;
	}



}
