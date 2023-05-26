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
import com.grc.itrisk.dto.InitAssessmentResponseDTO;
import com.grc.itrisk.dto.PerformInitAssessmentDTO;
import com.grc.itrisk.service.PerformInitAssessmentService;

@SuppressWarnings("unused")
@RestController
public class PerformInitAssessmentController {

	@Autowired
	private PerformInitAssessmentService performInitAssessmentService;

	private static final String READ_ACTION = "READ-INITIAL-ASSESSMENT-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-INITIAL-ASSESSMENT-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-INITIAL-ASSESSMENT-DETAILS";
	private static final String SAVE_OR_EDIT_FILE_UPLOAD_ACTION = "SAVE-OR-EDIT-FILE-UPLOAD-IT-RISK-INITIAL-ASSESSMENT-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/assessment/initial/find/all")
	public ResponseEntity<?> getAllPerformInitAssessment(Authentication auth) {
		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(performInitAssessmentService.getAllPerformInitAssessment(), PerformInitAssessmentDTO.class));
	}
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/assessment/initial/find/{id}")
	public ResponseEntity<?> getPerformInitAssessmentbyId(Authentication auth, @NonNull @PathVariable(value = "id") long initAssessmentId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(performInitAssessmentService.getPerformInitAssessmentById(initAssessmentId), PerformInitAssessmentDTO.class));
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@PostMapping("/assessment/initial/find/ref/{assessmentId}")
	public ResponseEntity<?> getAllPerformInitAssessmentByTemplateId(Authentication auth, @NonNull @PathVariable(value = "assessmentId") long assessmentId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(performInitAssessmentService.getPerformInitAssessmentByAssessmentId(assessmentId), InitAssessmentResponseDTO.class));
	}


	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/assessment/initial/new")
	public ResponseEntity<?> creatPerformInitAssessment(Authentication auth, @NonNull @RequestBody List<PerformInitAssessmentDTO> initAssessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uName = loginUserDetails.getUsername();
	//	initAssessmentDto.setCreatedBy(uname);		
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(performInitAssessmentService.createPerformInitAssessment(initAssessmentDto, uName), InitAssessmentResponseDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/initial/modify")	
	public ResponseEntity<?> updatePerformInitAssessment(Authentication auth, @NonNull @RequestBody List<PerformInitAssessmentDTO> initAssessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uName = loginUserDetails.getUsername();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(performInitAssessmentService.updatePerformInitAssessment(initAssessmentDto, uName), InitAssessmentResponseDTO.class));
	}



}
