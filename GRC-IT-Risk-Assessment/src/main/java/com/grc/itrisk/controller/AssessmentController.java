package com.grc.itrisk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grc.itrisk.common.aspect.Loggable;
import com.grc.itrisk.common.dto.LoginUserDetails;
import com.grc.itrisk.common.response.ITRiskResponseEntity;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dto.AssessmentDTO;
import com.grc.itrisk.dto.AssessmentAttachmentsDTO;
import com.grc.itrisk.service.AssessmentService;

@SuppressWarnings("unused")
@RestController
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentSeervice;

	private static final String READ_ACTION = "READ-ASSESSMENT-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ASSESSMENT-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ASSESSMENT-DETAILS";
	private static final String SAVE_OR_EDIT_FILE_UPLOAD_ACTION = "SAVE-OR-EDIT-FILE-UPLOAD-IT-RISK-ASSESSMENT-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/assessment/find/all")
	public ResponseEntity<?> getAllAssessment(Authentication auth) {
		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentSeervice.getAllAssessment(), AssessmentDTO.class));
	}
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/assessment/find/{id}")
	public ResponseEntity<?> getAssessmentbyId(Authentication auth, @NonNull @PathVariable(value = "id") long assessmentDtoId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentSeervice.getAssessmentById(assessmentDtoId), AssessmentDTO.class));
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@PostMapping("/assessment/find/ref/{templateId}")
	public ResponseEntity<?> getAllAssessmentByTemplateId(Authentication auth, @NonNull @PathVariable(value = "templateId") long templateId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentSeervice.getAllAssessmentByTemplateId(templateId), AssessmentDTO.class));
	}


	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/assessment/new")
	public ResponseEntity<?> creatAssessment(Authentication auth, @NonNull @RequestBody AssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		assessmentDto.setCreatedBy(uname);		
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentSeervice.createAssessment(assessmentDto), AssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/modify")	
	public ResponseEntity<?> updateAssessment(Authentication auth, @NonNull @RequestBody AssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(assessmentSeervice.updateAssessment(assessmentDto), AssessmentDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/inactive")
	public ResponseEntity<?> inActiveAssessment(Authentication auth, @NonNull @RequestBody AssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(assessmentSeervice.inActiveAssessment(assessmentDto));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/active")
	public ResponseEntity<?> activeAssessment(Authentication auth, @NonNull @RequestBody AssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(assessmentSeervice.activeAssessment(assessmentDto));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/remove")
	public ResponseEntity<?> deleteAssessment(Authentication auth, @NonNull @RequestBody AssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(assessmentSeervice.deleteAssessment(assessmentDto));
	}
	
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_FILE_UPLOAD_ACTION)
	@PostMapping("/assessment/attachment/new")
	public ResponseEntity<?> createAssessmentAttachment(Authentication auth,
			@NonNull @ModelAttribute AssessmentAttachmentsDTO vendorAttachment) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String result = null;
		result = assessmentSeervice.createFiles(vendorAttachment, loginUserDetails.getUsername());	
		return ITRiskResponseEntity.success(result);
	}

	
	@PutMapping("/assessment/attachment/remove/{docId}")
	public ResponseEntity<?> deleteFile(@NonNull @PathVariable String docId) {
		String attachment = null;
		try {
			attachment = assessmentSeervice.fileDeleteByDocId(docId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ITRiskResponseEntity.success(attachment);
	}

	
	@GetMapping("/assessment/attachment/view/{refId}")
	public ResponseEntity<?> findAllAttachment(@NonNull @PathVariable String refId) {
		return ITRiskResponseEntity.success(MapperUtils.mapToTargetClass(assessmentSeervice.findAllAttachment(refId),
				AssessmentAttachmentsDTO.class));
	}
	
	@GetMapping("/assessment/attachment/download/{docId}")
	public ResponseEntity<?> downloadFile(@NonNull @PathVariable String docId) {
		return ITRiskResponseEntity.success(MapperUtils.mapToTargetClass(assessmentSeervice.downloadFile(docId),
				AssessmentAttachmentsDTO.class));
	}
	




}
