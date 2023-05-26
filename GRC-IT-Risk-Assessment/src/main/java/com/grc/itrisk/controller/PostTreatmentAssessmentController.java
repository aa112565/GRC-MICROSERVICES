package com.grc.itrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grc.itrisk.common.aspect.Loggable;
import com.grc.itrisk.common.dto.LoginUserDetails;
import com.grc.itrisk.common.response.ITRiskResponseEntity;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dto.PostAssessmentResponseDTO;
import com.grc.itrisk.dto.PostTreatmentAssessmentDTO;
import com.grc.itrisk.service.PostTreatmentAssessmentService;


@RestController
public class PostTreatmentAssessmentController {

	@Autowired
	private PostTreatmentAssessmentService postTreatmentAssessmentService;

	private static final String READ_ACTION = "READ-POST-TREATMENT-ASSESSMENT-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-POST-TREATMENT-ASSESSMENT-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-POST-TREATMENT-ASSESSMENT-DETAILS";
//	private static final String SAVE_OR_EDIT_FILE_UPLOAD_ACTION = "SAVE-OR-EDIT-FILE-UPLOAD-IT-RISK-POST-TREATMENT-ASSESSMENT-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/assessment/posttreatment/find/all")
	public ResponseEntity<?> getAllPostTreatmentAssessment(Authentication auth) {
		
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(postTreatmentAssessmentService.getAllPostTreatmentAssessment(), PostTreatmentAssessmentDTO.class));
	}
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/assessment/posttreatment/find/{id}")
	public ResponseEntity<?> getPostTreatmentAssessmentbyId(Authentication auth, @NonNull @PathVariable(value = "id") long postAssessmentId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(postTreatmentAssessmentService.getPostTreatmentAssessmentById(postAssessmentId), PostTreatmentAssessmentDTO.class));
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@PostMapping("/assessment/posttreatment/find/ref/{assessmentId}")
	public ResponseEntity<?> getAllPostTreatmentAssessmentByTemplateId(Authentication auth, @NonNull @PathVariable(value = "assessmentId") long assessmentId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(postTreatmentAssessmentService.getPostTreatmentAssessmentByAssessmentId(assessmentId), PostAssessmentResponseDTO.class));
	}


	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/assessment/posttreatment/new")
	public ResponseEntity<?> creatPostTreatmentAssessment(Authentication auth, @NonNull @RequestBody List<PostTreatmentAssessmentDTO> postAssessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uName = loginUserDetails.getUsername();
	
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(postTreatmentAssessmentService.createPostTreatmentAssessment(postAssessmentDto, uName), PostAssessmentResponseDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/posttreatment/modify")	
	public ResponseEntity<?> updatePostTreatmentAssessment(Authentication auth, @NonNull @RequestBody List<PostTreatmentAssessmentDTO> postAssessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uName = loginUserDetails.getUsername();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(postTreatmentAssessmentService.updatePostTreatmentAssessment(postAssessmentDto, uName), PostAssessmentResponseDTO.class));
	}



}
