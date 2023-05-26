package com.grc.itrisk.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.exception.ITRiskException;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.AssessmentPostRatingRepository;
import com.grc.itrisk.dao.PostTreatmentAssessmentLogRepository;
import com.grc.itrisk.dao.PostTreatmentAssessmentRepository;
import com.grc.itrisk.dto.AssessmentDTO;
import com.grc.itrisk.dto.AssessmentPostRatingDTO;
import com.grc.itrisk.dto.PostAssessmentResponseDTO;
import com.grc.itrisk.dto.PostTreatmentAssessmentDTO;
import com.grc.itrisk.entity.AssessmentPostRating;
import com.grc.itrisk.entity.PerformPostAssessment;
import com.grc.itrisk.entity.PerformPostAssessmentLog;
import com.grc.itrisk.entity.TemplateRating;
import com.grc.itrisk.exception.ResourceNotFoundException;
import com.grc.itrisk.service.PostTreatmentAssessmentService;


@Service
public class PostTreatmentAssessmentServiceImpl implements PostTreatmentAssessmentService {

	@Autowired
	private PostTreatmentAssessmentRepository postAssessmentRepo;
	
	@Autowired
	private PostTreatmentAssessmentLogRepository postAssessmentLogRepo;
	
	@Autowired
	private AssessmentServiceImpl assessmentServiceImpl;

	@Autowired
	private TemplateRatingServiceImpl templateRatingServiceImpl;

	@Autowired
	AssessmentPostRatingRepository postAssessmentRatingRepo;

	@Override
	public List<PostTreatmentAssessmentDTO> getAllPostTreatmentAssessment() {
		List<PerformPostAssessment> postAssessmentList = postAssessmentRepo.findAllPerformPostAssessment();
		 if (postAssessmentList.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }		 
		 List<PostTreatmentAssessmentDTO> postAssessmentListDto = MapperUtils.mapToTargetClass(postAssessmentList, PostTreatmentAssessmentDTO.class);			
		return postAssessmentListDto;
	}


	@Override
	public PostAssessmentResponseDTO getPostTreatmentAssessmentByAssessmentId(long assessmentId) {
		PostAssessmentResponseDTO responseDto = new PostAssessmentResponseDTO();
		List<PerformPostAssessment> postAssessment = postAssessmentRepo.getPerformPostAssessmentByRefId(assessmentId);			 
		List<PostTreatmentAssessmentDTO> postAssessmentList = MapperUtils.mapToTargetClass(postAssessment, PostTreatmentAssessmentDTO.class);		
		responseDto.setPostAssessment(postAssessmentList);
		AssessmentPostRatingDTO responsePostRatingDto = MapperUtils.mapToTargetClass(postAssessmentRatingRepo.getAssessmentPostRatingByRefId(assessmentId), AssessmentPostRatingDTO.class);
		responseDto.setPostAssessmentRating(responsePostRatingDto);
		return responseDto;		
	}

	
	@Override
	public PostTreatmentAssessmentDTO getPostTreatmentAssessmentById(long postAssessmentId) {		
		PerformPostAssessment postAssessment = postAssessmentRepo.findById(postAssessmentId).orElseThrow(
				() -> new ResourceNotFoundException("IT-Risk-PostTreatmentAssessment not found with  Id----> " + postAssessmentId));
		PostTreatmentAssessmentDTO intiAssessmentDto = MapperUtils.mapToTargetClass( postAssessment, PostTreatmentAssessmentDTO.class) ;		
		return intiAssessmentDto;		
	}
	

	public List<PerformPostAssessment> saveAll(List<PerformPostAssessment> intiAssessmentList) {
		return this.postAssessmentRepo.saveAll(intiAssessmentList);
	}
	


	@Transactional
	@Override
	public PostAssessmentResponseDTO createPostTreatmentAssessment(List<PostTreatmentAssessmentDTO> intAssessmentDto, String userName) {
		PostAssessmentResponseDTO responseDto = new PostAssessmentResponseDTO();
		List<PostTreatmentAssessmentDTO> resList = new ArrayList<PostTreatmentAssessmentDTO>();
		
		String postTreatmentFlag = null, postTreatmentStatus = null;
		
		for(PostTreatmentAssessmentDTO postPerformList:intAssessmentDto) {		
		PerformPostAssessment postAssessment = MapperUtils.mapToTargetClass(postPerformList, PerformPostAssessment.class);	
		if( "Y".equals(postAssessment.getSaveFlag())) {	
			postAssessment.setActiveFlag("Y");
			postAssessment.setDeleteFlag("N");			
			postAssessment.setPostAssessmentFlag("Y");
			postAssessment.setPostAssessmentStatus("In-Progress");
			postTreatmentFlag = "Y";
			postTreatmentStatus = "In-Progress";
			postAssessment.setCreatedBy(userName);
			postAssessment.setSaveFlag("Y");
			} else {
			postAssessment.setActiveFlag("Y");
			postAssessment.setDeleteFlag("N");			
			postAssessment.setPostAssessmentFlag("Y");
			postAssessment.setPostAssessmentStatus("Completed");
			postTreatmentFlag = "Y";
			postTreatmentStatus = "Completed";			
			postAssessment.setCreatedBy(userName);
			postAssessment.setSaveFlag("N");
			}
	
		PostTreatmentAssessmentDTO postAssessmentDto = MapperUtils.mapToTargetClass(postAssessmentRepo.save(postAssessment), PostTreatmentAssessmentDTO.class);
		resList.add(postAssessmentDto);
		}		
		
		AssessmentPostRatingDTO assessmentPostRating = calculateRatingScore(resList, "N");		
		AssessmentDTO asssessment = assessmentServiceImpl.getAssessmentById(assessmentPostRating.getAssessmentId());
		asssessment.setPostTreatmentFlag(postTreatmentFlag);
		asssessment.setPostTreatmentStatus(postTreatmentStatus);
		asssessment.setStatus("Assessment-Post-Treatment");
		@SuppressWarnings("unused")
		AssessmentDTO asssessmentUpdate = assessmentServiceImpl.updateAssessment(asssessment);	
		
		responseDto.setPostAssessment(resList);
		responseDto.setPostAssessmentRating(assessmentPostRating);
		
		return responseDto;
	}
	
	
	
	private AssessmentPostRatingDTO calculateRatingScore(List<PostTreatmentAssessmentDTO> resList, String opsFlag) {

		int tempCount = 0;
		String tempCaseOne = null, tempCaseTwo = null, tempCaseThree = null, tempCaseFour = null, tempCaseFive = null;
		int caseOneCount = 0, caseTwoCount = 0, caseThreeCount = 0, caseFourCount = 0, caseFiveCount = 0, totalCount = 0;
		long caseOneRating = 0, caseTwoRating = 0, caseThreeRating = 0, caseFourRating = 0, caseFiveRating = 0, totalRating = 0;
		long caseOneScore = 0, caseTwoScore = 0, caseThreeScore = 0, caseFourScore = 0, caseFiveScore = 0;
		AssessmentDTO asssessment = null;
		TemplateRating templateRating = null;
		
		AssessmentPostRatingDTO assessmentPostRatingDto = new AssessmentPostRatingDTO();
		
		for(PostTreatmentAssessmentDTO ratingList:resList) {			
			
			if(tempCount == 0) {
				asssessment = assessmentServiceImpl.getAssessmentById(ratingList.getAssessmentId());
				assessmentPostRatingDto.setAssessmentId(ratingList.getAssessmentId());				
				tempCount++;
			}
			
			if(tempCount == 1) {
				templateRating  = templateRatingServiceImpl.getTemplateRatingByRefId(asssessment.getTemplateId());
				assessmentPostRatingDto.setTemplateId(asssessment.getTemplateId());
				
				tempCaseOne = templateRating.getNotApplicableLable();
				caseOneRating = Long.parseLong(templateRating.getNotApplicable());				
				assessmentPostRatingDto.setNotApplicableLable(tempCaseOne);
				
				tempCaseTwo = templateRating.getNonCompliantLable();
				caseTwoRating = Long.parseLong(templateRating.getNonCompliant());				
				assessmentPostRatingDto.setNonCompliantLable(tempCaseTwo);
				
				tempCaseThree = templateRating.getPartiallyCompliantLable();
				caseThreeRating = Long.parseLong(templateRating.getPartiallyCompliant());				
				assessmentPostRatingDto.setPartiallyCompliantLable(tempCaseThree);
				
				tempCaseFour = templateRating.getCompliantWithDocumentsLable();
				caseFourRating = Long.parseLong(templateRating.getCompliantWithDocuments());				
				assessmentPostRatingDto.setCompliantWithDocumentsLable(tempCaseFour);
				
				tempCaseFive = templateRating.getCompliantWithoutDocumentsLable();
				caseFiveRating = Long.parseLong(templateRating.getCompliantWithDocuments());	
				assessmentPostRatingDto.setCompliantWithoutDocumentsLable(tempCaseFive); 
				tempCount++;
			}
			
				 
			 System.out.println("================getPostialAssessmentResponse============="+ratingList.getPostAssessmentResponse());
			 
			 if (ratingList.getPostAssessmentResponse().equals(tempCaseOne)) {
				  caseOneCount++;
			  } else if (ratingList.getPostAssessmentResponse().equals(tempCaseTwo)) {
				  caseTwoCount++;
			  } else if (ratingList.getPostAssessmentResponse().equals(tempCaseThree)) {
				  caseThreeCount++;
			  } else if (ratingList.getPostAssessmentResponse().equals(tempCaseFour)) {
				  caseFourCount++;
			  } else if (ratingList.getPostAssessmentResponse().equals(tempCaseFive)) {
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
		
		assessmentPostRatingDto.setNotApplicable(String.valueOf(caseOneCount));
		assessmentPostRatingDto.setNonCompliant(String.valueOf(caseTwoCount));
		assessmentPostRatingDto.setPartiallyCompliant(String.valueOf(caseThreeCount));
		assessmentPostRatingDto.setCompliantWithDocuments(String.valueOf(caseFourCount));
		assessmentPostRatingDto.setCompliantWithoutDocuments(String.valueOf(caseFiveCount));
	/*	
		assessmentPostRatingDto.setNotApplicableScore(String.valueOf(caseOneScore));
		assessmentPostRatingDto.setNonCompliantScore(String.valueOf(caseTwoScore));
		assessmentPostRatingDto.setPartiallyCompliantScore(String.valueOf(caseThreeScore));
		assessmentPostRatingDto.setCompliantWithDocumentsScore(String.valueOf(caseFourScore));
		assessmentPostRatingDto.setCompliantWithoutDocumentsScore(String.valueOf(caseFiveScore));		
	*/	
		assessmentPostRatingDto.setTotalCount(String.valueOf(totalCount));
		assessmentPostRatingDto.setPostAssessmentRating(String.valueOf(totalRating));		
		assessmentPostRatingDto.setActiveFlag("Y");
		assessmentPostRatingDto.setDeleteFlag("N");
		
		if(opsFlag.equals("Y")) {
			postAssessmentRatingRepo.updateAssessmentPostRatingToInactive(assessmentPostRatingDto.getAssessmentId());		
				}
		
		AssessmentPostRating postRating = MapperUtils.mapToTargetClass(assessmentPostRatingDto, AssessmentPostRating.class);
		AssessmentPostRatingDTO responsePostRatingDto = MapperUtils.mapToTargetClass(postAssessmentRatingRepo.save(postRating), AssessmentPostRatingDTO.class);
		return responsePostRatingDto;
	}
	
	private long calculateRating(int count, long rating) {
		long toatlRating = count * (rating / 100);
		return toatlRating;		
	}
	
	public PerformPostAssessmentLog updatePostTreatmentAssessmentLog(long postAssessmentId) {			
		PostTreatmentAssessmentDTO existingPostAssessment = getPostTreatmentAssessmentById(postAssessmentId);		
		PerformPostAssessmentLog postAssessmentLog = MapperUtils.mapToTargetClass(existingPostAssessment, PerformPostAssessmentLog.class);
		return this.postAssessmentLogRepo.save(postAssessmentLog);
	}

	
	@Override
	@Transactional
	public PostAssessmentResponseDTO updatePostTreatmentAssessment(List<PostTreatmentAssessmentDTO> intAssessmentDto, String userName) {		
		List<PostTreatmentAssessmentDTO> resList = new ArrayList<PostTreatmentAssessmentDTO>();
		PostAssessmentResponseDTO responseDto = new PostAssessmentResponseDTO();
		String postTreatmentFlag = null, postTreatmentStatus = null;
		
		for(PostTreatmentAssessmentDTO postPerformList:intAssessmentDto) {
		@SuppressWarnings("unused")
		PerformPostAssessmentLog log = updatePostTreatmentAssessmentLog(postPerformList.getPostAssessmentId());
		PerformPostAssessment postAssessment = MapperUtils.mapToTargetClass(postPerformList, PerformPostAssessment.class);		
		if( "Y".equals(postAssessment.getSaveFlag())) {	
				postAssessment.setActiveFlag("Y");
				postAssessment.setDeleteFlag("N");			
				postAssessment.setPostAssessmentFlag("Y");
				postAssessment.setPostAssessmentStatus("In-Progress");
				postTreatmentFlag = "Y";
				postTreatmentStatus = "In-Progress";
				postAssessment.setModifiedBy(userName);
				postAssessment.setSaveFlag("Y");
			} else {			 	
					postAssessment.setActiveFlag("Y");
					postAssessment.setDeleteFlag("N");			
					postAssessment.setPostAssessmentFlag("Y");
					postAssessment.setPostAssessmentStatus("Completed");
					postTreatmentFlag = "Y";
					postTreatmentStatus = "Completed";
					postAssessment.setModifiedBy(userName);
					postAssessment.setSaveFlag("N");
					
			}
		PostTreatmentAssessmentDTO assessPostAssessment = MapperUtils.mapToTargetClass(postAssessmentRepo.save(postAssessment), PostTreatmentAssessmentDTO.class);
		resList.add(assessPostAssessment);
		}
				
		
		AssessmentPostRatingDTO assessmentPostRating = calculateRatingScore(resList, "Y");		
		AssessmentDTO asssessment = assessmentServiceImpl.getAssessmentById(assessmentPostRating.getAssessmentId());
		asssessment.setPostTreatmentFlag(postTreatmentFlag);
		asssessment.setPostTreatmentStatus(postTreatmentStatus);
		asssessment.setStatus("Assessment-Post-Treatment");
		@SuppressWarnings("unused")
		AssessmentDTO asssessmentUpdate = assessmentServiceImpl.updateAssessment(asssessment);		
		
		responseDto.setPostAssessment(resList);
		responseDto.setPostAssessmentRating(assessmentPostRating);
		return responseDto;
	}


}
