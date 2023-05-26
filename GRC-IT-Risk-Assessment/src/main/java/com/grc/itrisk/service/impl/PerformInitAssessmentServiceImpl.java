package com.grc.itrisk.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.exception.ITRiskException;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.AssessmentInitRatingRepository;
import com.grc.itrisk.dao.PerformInitAssessmentLogRepository;
import com.grc.itrisk.dao.PerformInitAssessmentRepository;
import com.grc.itrisk.dto.AssessmentDTO;
import com.grc.itrisk.dto.AssessmentIntRatingDTO;
import com.grc.itrisk.dto.InitAssessmentResponseDTO;
import com.grc.itrisk.dto.PerformInitAssessmentDTO;
import com.grc.itrisk.entity.AssessmentInitRating;
import com.grc.itrisk.entity.PerformInitAssessment;
import com.grc.itrisk.entity.PerformInitAssessmentLog;
import com.grc.itrisk.entity.TemplateRating;
import com.grc.itrisk.exception.ResourceNotFoundException;
import com.grc.itrisk.service.PerformInitAssessmentService;


@Service
public class PerformInitAssessmentServiceImpl implements PerformInitAssessmentService {

	@Autowired
	private PerformInitAssessmentRepository initAssessmentRepo;
	
	@Autowired
	private PerformInitAssessmentLogRepository initAssessmentLogRepo;
	
	@Autowired
	private AssessmentServiceImpl assessmentServiceImpl;

	@Autowired
	private TemplateRatingServiceImpl templateRatingServiceImpl;

	@Autowired
	AssessmentInitRatingRepository initAssessmentRatingRepo;

	@Override
	public List<PerformInitAssessmentDTO> getAllPerformInitAssessment() {
		List<PerformInitAssessment> initAssessmentList = initAssessmentRepo.findAllPerformInitAssessment();
		 if (initAssessmentList.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }		 
		 List<PerformInitAssessmentDTO> initAssessmentListDto = MapperUtils.mapToTargetClass(initAssessmentList, PerformInitAssessmentDTO.class);			
		return initAssessmentListDto;
	}


	@Override
	public InitAssessmentResponseDTO getPerformInitAssessmentByAssessmentId(long assessmentId) {
		InitAssessmentResponseDTO responseDto = new InitAssessmentResponseDTO();
		List<PerformInitAssessment> initAssessment = initAssessmentRepo.getPerformInitAssessmentByRefId(assessmentId);			 
		List<PerformInitAssessmentDTO> initAssessmentList = MapperUtils.mapToTargetClass(initAssessment, PerformInitAssessmentDTO.class);		
		responseDto.setInitAssessment(initAssessmentList);
		AssessmentIntRatingDTO responseInitRatingDto = MapperUtils.mapToTargetClass(initAssessmentRatingRepo.getAssessmentInitRatingByRefId(assessmentId), AssessmentIntRatingDTO.class);
		responseDto.setInitAssessmentRating(responseInitRatingDto);
		return responseDto;		
	}

	
	@Override
	public PerformInitAssessmentDTO getPerformInitAssessmentById(long initAssessmentId) {		
		PerformInitAssessment initAssessment = initAssessmentRepo.findById(initAssessmentId).orElseThrow(
				() -> new ResourceNotFoundException("IT-Risk-PerformInitAssessment not found with  Id----> " + initAssessmentId));
		PerformInitAssessmentDTO intiAssessmentDto = MapperUtils.mapToTargetClass( initAssessment, PerformInitAssessmentDTO.class) ;		
		return intiAssessmentDto;		
	}
	

	public List<PerformInitAssessment> saveAll(List<PerformInitAssessment> intiAssessmentList) {
		return this.initAssessmentRepo.saveAll(intiAssessmentList);
	}
	


	@Transactional
	@Override
	public InitAssessmentResponseDTO createPerformInitAssessment(List<PerformInitAssessmentDTO> intAssessmentDto, String userName) {
		InitAssessmentResponseDTO responseDto = new InitAssessmentResponseDTO();
		List<PerformInitAssessmentDTO> resList = new ArrayList<PerformInitAssessmentDTO>();
		
		String initAssessmentFlag = null, initAssessmentStatus = null;
		
		for(PerformInitAssessmentDTO initPerformList:intAssessmentDto) {		
		PerformInitAssessment initAssessment = MapperUtils.mapToTargetClass(initPerformList, PerformInitAssessment.class);	
		if( "Y".equals(initAssessment.getSaveFlag())) {	
			initAssessment.setActiveFlag("Y");
			initAssessment.setDeleteFlag("N");			
			initAssessment.setInitialAssessmentFlag("Y");
			initAssessment.setInitialAssessmentStatus("In-Progress");
			initAssessmentFlag = "Y";
			initAssessmentStatus = "In-Progress";
			initAssessment.setCreatedBy(userName);
			initAssessment.setSaveFlag("Y");
			} else {
			initAssessment.setActiveFlag("Y");
			initAssessment.setDeleteFlag("N");			
			initAssessment.setInitialAssessmentFlag("Y");
			initAssessment.setInitialAssessmentStatus("Completed");
			initAssessmentFlag = "Y";
			initAssessmentStatus = "Completed";			
			initAssessment.setCreatedBy(userName);
			initAssessment.setSaveFlag("N");
			}
	
		PerformInitAssessmentDTO initAssessmentDto = MapperUtils.mapToTargetClass(initAssessmentRepo.save(initAssessment), PerformInitAssessmentDTO.class);
		resList.add(initAssessmentDto);
		}		
		
		AssessmentIntRatingDTO assessmentInitRating = calculateRatingScore(resList, "N");		
		AssessmentDTO asssessment = assessmentServiceImpl.getAssessmentById(assessmentInitRating.getAssessmentId());
		asssessment.setInitialAssessmentFlag(initAssessmentFlag);
		asssessment.setInitialAssessmentStatus(initAssessmentStatus);
		asssessment.setStatus("Assessment-Init-Perform");
		@SuppressWarnings("unused")
		AssessmentDTO asssessmentUpdate = assessmentServiceImpl.updateAssessment(asssessment);	
		
		responseDto.setInitAssessment(resList);
		responseDto.setInitAssessmentRating(assessmentInitRating);
		
		return responseDto;
	}
	
	
	
	private AssessmentIntRatingDTO calculateRatingScore(List<PerformInitAssessmentDTO> resList, String opsFlag) {

		int tempCount = 0;
		String tempCaseOne = null, tempCaseTwo = null, tempCaseThree = null, tempCaseFour = null, tempCaseFive = null;
		int caseOneCount = 0, caseTwoCount = 0, caseThreeCount = 0, caseFourCount = 0, caseFiveCount = 0, totalCount = 0;
		long caseOneRating = 0, caseTwoRating = 0, caseThreeRating = 0, caseFourRating = 0, caseFiveRating = 0, totalRating = 0;
		long caseOneScore = 0, caseTwoScore = 0, caseThreeScore = 0, caseFourScore = 0, caseFiveScore = 0;
		AssessmentDTO asssessment = null;
		TemplateRating templateRating = null;
		
		AssessmentIntRatingDTO assessmentInitRatingDto = new AssessmentIntRatingDTO();
		
		for(PerformInitAssessmentDTO ratingList:resList) {			
			
			if(tempCount == 0) {
				asssessment = assessmentServiceImpl.getAssessmentById(ratingList.getAssessmentId());
				assessmentInitRatingDto.setAssessmentId(ratingList.getAssessmentId());				
				tempCount++;
			}
			
			if(tempCount == 1) {
				templateRating  = templateRatingServiceImpl.getTemplateRatingByRefId(asssessment.getTemplateId());
				assessmentInitRatingDto.setTemplateId(asssessment.getTemplateId());
				
				tempCaseOne = templateRating.getNotApplicableLable();
				caseOneRating = Long.parseLong(templateRating.getNotApplicable());				
				assessmentInitRatingDto.setNotApplicableLable(tempCaseOne);
				
				tempCaseTwo = templateRating.getNonCompliantLable();
				caseTwoRating = Long.parseLong(templateRating.getNonCompliant());				
				assessmentInitRatingDto.setNonCompliantLable(tempCaseTwo);
				
				tempCaseThree = templateRating.getPartiallyCompliantLable();
				caseThreeRating = Long.parseLong(templateRating.getPartiallyCompliant());				
				assessmentInitRatingDto.setPartiallyCompliantLable(tempCaseThree);
				
				tempCaseFour = templateRating.getCompliantWithDocumentsLable();
				caseFourRating = Long.parseLong(templateRating.getCompliantWithDocuments());				
				assessmentInitRatingDto.setCompliantWithDocumentsLable(tempCaseFour);
				
				tempCaseFive = templateRating.getCompliantWithoutDocumentsLable();
				caseFiveRating = Long.parseLong(templateRating.getCompliantWithDocuments());	
				assessmentInitRatingDto.setCompliantWithoutDocumentsLable(tempCaseFive); 
				tempCount++;
			}
			
				 
			 System.out.println("================getInitialAssessmentResponse============="+ratingList.getInitialAssessmentResponse());
			 
			 if (ratingList.getInitialAssessmentResponse().equals(tempCaseOne)) {
				  caseOneCount++;
			  } else if (ratingList.getInitialAssessmentResponse().equals(tempCaseTwo)) {
				  caseTwoCount++;
			  } else if (ratingList.getInitialAssessmentResponse().equals(tempCaseThree)) {
				  caseThreeCount++;
			  } else if (ratingList.getInitialAssessmentResponse().equals(tempCaseFour)) {
				  caseFourCount++;
			  } else if (ratingList.getInitialAssessmentResponse().equals(tempCaseFive)) {
				  caseFiveCount++;
			  }
			  
		}
		
		caseOneScore = calculateRating(caseOneCount, caseOneRating);
		caseTwoScore = calculateRating(caseTwoCount, caseTwoRating);
		caseThreeScore = calculateRating(caseThreeCount, caseThreeRating);
		caseFourScore = calculateRating(caseFourCount, caseFourRating);
		caseFiveScore = calculateRating(caseFiveCount, caseFiveRating);		
		totalRating = caseOneScore+caseTwoScore+caseThreeScore+caseFourScore+caseFiveScore;
		totalCount = caseOneCount+caseTwoCount+caseThreeCount+caseFourCount+caseFiveCount;
		
		assessmentInitRatingDto.setNotApplicable(String.valueOf(caseOneCount));
		assessmentInitRatingDto.setNonCompliant(String.valueOf(caseTwoCount));
		assessmentInitRatingDto.setPartiallyCompliant(String.valueOf(caseThreeCount));
		assessmentInitRatingDto.setCompliantWithDocuments(String.valueOf(caseFourCount));
		assessmentInitRatingDto.setCompliantWithoutDocuments(String.valueOf(caseFiveCount));
	/*	
		assessmentInitRatingDto.setNotApplicableScore(String.valueOf(caseOneScore));
		assessmentInitRatingDto.setNonCompliantScore(String.valueOf(caseTwoScore));
		assessmentInitRatingDto.setPartiallyCompliantScore(String.valueOf(caseThreeScore));
		assessmentInitRatingDto.setCompliantWithDocumentsScore(String.valueOf(caseFourScore));
		assessmentInitRatingDto.setCompliantWithoutDocumentsScore(String.valueOf(caseFiveScore));		
	*/	
		assessmentInitRatingDto.setTotalCount(String.valueOf(totalCount));
		assessmentInitRatingDto.setInitAssessmentRating(String.valueOf(totalRating));		
		assessmentInitRatingDto.setActiveFlag("Y");
		assessmentInitRatingDto.setDeleteFlag("N");
		if(opsFlag.equals("Y")) {
			initAssessmentRatingRepo.updateAssessmentInitRatingToInactive(assessmentInitRatingDto.getAssessmentId());		
				}
		AssessmentInitRating initRating = MapperUtils.mapToTargetClass(assessmentInitRatingDto, AssessmentInitRating.class);
		AssessmentIntRatingDTO responseInitRatingDto = MapperUtils.mapToTargetClass(initAssessmentRatingRepo.save(initRating), AssessmentIntRatingDTO.class);
		return responseInitRatingDto;
	}
	
	private long calculateRating(int count, long rating) {
		long toatlRating = count * (rating / 100);
		return toatlRating;		
	}
	
	public PerformInitAssessmentLog updatePerformInitAssessmentLog(long initAssessmentId) {			
		PerformInitAssessmentDTO existingInitAssessment = getPerformInitAssessmentById(initAssessmentId);		
		PerformInitAssessmentLog initAssessmentLog = MapperUtils.mapToTargetClass(existingInitAssessment, PerformInitAssessmentLog.class);
		return this.initAssessmentLogRepo.save(initAssessmentLog);
	}

	
	@Override
	@Transactional
	public InitAssessmentResponseDTO updatePerformInitAssessment(List<PerformInitAssessmentDTO> intAssessmentDto, String userName) {		
		List<PerformInitAssessmentDTO> resList = new ArrayList<PerformInitAssessmentDTO>();
		InitAssessmentResponseDTO responseDto = new InitAssessmentResponseDTO();
		String initAssessmentFlag = null, initAssessmentStatus = null;
		
		for(PerformInitAssessmentDTO initPerformList:intAssessmentDto) {
		@SuppressWarnings("unused")
		PerformInitAssessmentLog log = updatePerformInitAssessmentLog(initPerformList.getInitAssessmentId());
		PerformInitAssessment initAssessment = MapperUtils.mapToTargetClass(initPerformList, PerformInitAssessment.class);		
		if( "Y".equals(initAssessment.getSaveFlag())) {	
				initAssessment.setActiveFlag("Y");
				initAssessment.setDeleteFlag("N");			
				initAssessment.setInitialAssessmentFlag("Y");
				initAssessment.setInitialAssessmentStatus("In-Progress");
				initAssessmentFlag = "Y";
				initAssessmentStatus = "In-Progress";
				initAssessment.setModifiedBy(userName);
				initAssessment.setSaveFlag("Y");
			} else {			 	
					initAssessment.setActiveFlag("Y");
					initAssessment.setDeleteFlag("N");			
					initAssessment.setInitialAssessmentFlag("Y");
					initAssessment.setInitialAssessmentStatus("Completed");
					initAssessmentFlag = "Y";
					initAssessmentStatus = "Completed";
					initAssessment.setModifiedBy(userName);
					initAssessment.setSaveFlag("N");
					
			}
		PerformInitAssessmentDTO assessInitAssessment = MapperUtils.mapToTargetClass(initAssessmentRepo.save(initAssessment), PerformInitAssessmentDTO.class);
		resList.add(assessInitAssessment);
		}
				
		@SuppressWarnings("unused")
		AssessmentIntRatingDTO assessmentInitRating = calculateRatingScore(resList, "Y");		
		AssessmentDTO asssessment = assessmentServiceImpl.getAssessmentById(assessmentInitRating.getAssessmentId());
		asssessment.setInitialAssessmentFlag(initAssessmentFlag);
		asssessment.setInitialAssessmentStatus(initAssessmentStatus);
		asssessment.setStatus("Assessment-Init-Perform");
		@SuppressWarnings("unused")
		AssessmentDTO asssessmentUpdate = assessmentServiceImpl.updateAssessment(asssessment);		
		
		responseDto.setInitAssessment(resList);
		responseDto.setInitAssessmentRating(assessmentInitRating);
		return responseDto;
	}


}
