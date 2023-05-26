package com.grc.itrisk.controller;

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
import com.grc.itrisk.dto.AssessmentApprovalDTO;
import com.grc.itrisk.dto.AssessmentDTO;
import com.grc.itrisk.service.AssessmentApprovalService;

@SuppressWarnings("unused")
@RestController
public class AssessmentApprovalController {

	@Autowired
	private AssessmentApprovalService assessmentApprovalSeervice;

	private static final String READ_ACTION = "READ-ASSESSMENT-APPROVAL-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ASSESSMENT-APPROVAL-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ASSESSMENT-APPROVAL-DETAILS";
	private static final String SAVE_OR_EDIT_FILE_UPLOAD_ACTION = "SAVE-OR-EDIT-FILE-UPLOAD-IT-RISK-ASSESSMENT-APPROVAL-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/assessment/approval/find/all")
	public ResponseEntity<?> getAllAssessmentApproval(Authentication auth) {
		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentApprovalSeervice.getAllAssessmentApproval(), AssessmentDTO.class));
	}
	
/*
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/assessment/approval/find/{id}")
	public ResponseEntity<?> getAssessmentApprovalbyId(Authentication auth, @NonNull @PathVariable(value = "id") long approvalId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentApprovalSeervice.getAssessmentApprovalById(approvalId), AssessmentDTO.class));
	}
*/	
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/assessment/approval/find/ref/{assessmentId}")
	public ResponseEntity<?> getAssessmentApprovalByAssessmentId(Authentication auth, @NonNull @PathVariable(value = "assessmentId") long assessmentId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentApprovalSeervice.getAssessmentApprovalByAssessmentId(assessmentId), AssessmentDTO.class));
	}


	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/assessment/approval/new")
	public ResponseEntity<?> creatAssessmentApproval(Authentication auth, @NonNull @RequestBody AssessmentApprovalDTO assessmentApprovalDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		assessmentApprovalDto.setCreatedBy(uname);		
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentApprovalSeervice.createAssessmentApproval(assessmentApprovalDto), AssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/approval/modify")	
	public ResponseEntity<?> updateAssessmentApproval(Authentication auth, @NonNull @RequestBody AssessmentApprovalDTO assessmentApprovalDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentApprovalDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentApprovalSeervice.updateAssessmentApproval(assessmentApprovalDto), AssessmentDTO.class));
	}

/*
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/approval/inactive")
	public ResponseEntity<?> inActiveAssessmentApproval(Authentication auth, @NonNull @RequestBody AssessmentApprovalDTO assessmentApprovalDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentApprovalDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(assessmentApprovalSeervice.inActiveAssessmentApproval(assessmentApprovalDto));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/approval/active")
	public ResponseEntity<?> activeAssessmentApproval(Authentication auth, @NonNull @RequestBody AssessmentApprovalDTO assessmentApprovalDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentApprovalDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(assessmentApprovalSeervice.activeAssessmentApproval(assessmentApprovalDto));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/approval/remove")
	public ResponseEntity<?> deleteAssessmentApproval(Authentication auth, @NonNull @RequestBody AssessmentApprovalDTO assessmentApprovalDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentApprovalDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(assessmentApprovalSeervice.deleteAssessmentApproval(assessmentApprovalDto));
	}
	
*/	

}
