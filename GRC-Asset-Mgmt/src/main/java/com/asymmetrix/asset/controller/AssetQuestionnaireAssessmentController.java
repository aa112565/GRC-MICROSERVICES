package com.asymmetrix.asset.controller;

import java.util.List;
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
import com.asymmetrix.asset.common.aspect.Loggable;
import com.asymmetrix.asset.common.dto.LoginUserDetails;
import com.asymmetrix.asset.common.response.AssetResponseEntity;
import com.asymmetrix.asset.common.utils.MapperUtils;

import com.asymmetrix.asset.dto.AssetReqResDTO;
import com.asymmetrix.asset.dto.CMAssetQuestionAssessmentDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryAssessmentReportDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryCountDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryReportDTO;
import com.asymmetrix.asset.dto.AssessmentAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetQuestionAssessmentDTO;
import com.asymmetrix.asset.service.AssessmentFileUploadService;
import com.asymmetrix.asset.service.AssetQuestionnaireAssessmentService;

@RestController
public class AssetQuestionnaireAssessmentController {

	@Autowired
	private AssetQuestionnaireAssessmentService assetQuestionnaireAssessmentLibService;
	@Autowired
	private AssessmentFileUploadService docService;
	
	private static final String SAVE_ASSET_QUESTIONNAIRE_ACTION = "SAVE-ASSET-QUESTIONNAIRE-ASSESSMENT-DETAILS";
	private static final String EDIT_ASSET_QUESTIONNAIRE_ACTION = "EDIT-ASSET-QUESTIONNAIRE-ASSESSMENT-DETAILS";
	private static final String REMOVE_ASSET_QUESTIONNAIRE_ACTION = "DELETE-ASSET-QUESTIONNAIRE-ASSESSMENT-DETAILS";
	private static final String SAVE_OR_EDIT_FILE_UPLOAD_ACTION = "SAVE-OR-EDIT-FILE-UPLOAD-ASSET-QUESTIONNAIRE-ASSESSMENT-DETAILS";
	private static final String READ_ACTION = "READ-ASSET-QUESTIONNAIRE-ASSESSMENT-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ASSET-QUESTIONNAIRE-ASSESSMENT-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
//	@GetMapping("/asset/questionnaire/assessment/find/all")
	@PostMapping("/asset/questionnaire/assessment/find/all")
	public ResponseEntity<?> getAllAssetQuestionnaireAssessment() {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.getAllAssetQuestionnaireAssessmentByActiveflag(),
				CMAssetQuestionAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/assessment/find/{id}")
	public AssetReqResDTO getAssetQuestionnaireAssessmentById(@NonNull @PathVariable(value = "id") long assessmentId) {
		AssetReqResDTO resDTO = new AssetReqResDTO();
		AssetQuestionAssessmentDTO assessmentDto = MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.getAssetQuestionnaireAssessmentById(assessmentId),
				AssetQuestionAssessmentDTO.class);
		resDTO.setQuestassessmentdto(assessmentDto);
		return resDTO;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/assessment/find/assessment/{aid}/control/{cid}/question/{qid}")
	public AssetReqResDTO getAssetQuestionnaireAssessmentByQuestionId(
			@NonNull @PathVariable(value = "aid") String assessmentId,
			@NonNull @PathVariable(value = "cid") String controlId,
			@NonNull @PathVariable(value = "qid") String questionId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		AssetQuestionAssessmentDTO assessmentDto = MapperUtils.mapToTargetClass(assetQuestionnaireAssessmentLibService
				.getAssetQuestionnaireAssessmentByQuestionId(assessmentId, controlId, questionId),
				AssetQuestionAssessmentDTO.class);
		resDto.setQuestassessmentdto(assessmentDto);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/assessment/find/asset/{id}")
	public AssetReqResDTO getAssetQuestionnaireAssessmentByAssetId(
			@NonNull @PathVariable(value = "id") String assetId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		List<AssetQuestionAssessmentDTO> assessmentDto = MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.getAssetQuestionnaireAssessmentByAssetId(assetId),
				AssetQuestionAssessmentDTO.class);
		resDto.setAssetquestassessmentdto(assessmentDto);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/assessment/find/assessment/{id}")
	public AssetReqResDTO getAssetQuestionnaireAssessmentByAssessmentId(
			@NonNull @PathVariable(value = "id") String assessmentId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		List<AssetQuestionAssessmentDTO> assessmentDto = MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.getAssetQuestionnaireAssessmentByAssessmentId(assessmentId),
				AssetQuestionAssessmentDTO.class);
		resDto.setAssetquestassessmentdto(assessmentDto);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/asset/questionnaire/assessment/find/count/{id}")
	public ResponseEntity<?> getAssetQuestionnaireAssessmentCountByAssessmentId(
			@NonNull @PathVariable(value = "id") String assessmentId,
			@NonNull @RequestBody List<QuestionnaireCategoryCountDTO> assetCountDto) {
		System.out.println(
				"Assessment-Id" + assessmentId + "==========================" + "DTO-Size" + assetCountDto.size());
		// String assessmentId = "Test";
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(assetQuestionnaireAssessmentLibService
				.getAssetQuestionnaireAssessmentCountByAssessmentIdAndControlId(assessmentId, assetCountDto),
				QuestionnaireCategoryCountDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/asset/questionnaire/assessment/reports/{id}")
	public ResponseEntity<?> getAssetQuestionnaireAssessmentReportsByAssessmentId(
			@NonNull @PathVariable(value = "id") String assessmentId,
			@NonNull @RequestBody List<QuestionnaireCategoryReportDTO> assetReportDto) {
		System.out.println(
				"Assessment-Id" + assessmentId + "==========================" + "DTO-Size" + assetReportDto.size());
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(assetQuestionnaireAssessmentLibService
				.getAssetQuestionnaireAssessmentReportByAssessmentId(assessmentId, assetReportDto),
				QuestionnaireCategoryAssessmentReportDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_FILE_UPLOAD_ACTION)
	@PostMapping("/asset/questionnaire/assessment/attachment/new")
	public AssetReqResDTO createAssetQuestionnaireAssessmentAttachment(
			@NonNull @ModelAttribute AssessmentAttachmentsDTO assetAttachment) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		String result = assetQuestionnaireAssessmentLibService.createFiles(assetAttachment);
		System.out.println("file Upload result  => " + result);
		List<AssessmentAttachmentsDTO> fileList = MapperUtils.mapToTargetClass(
				docService.getAllDocByRefId(assetAttachment.getRefId()), AssessmentAttachmentsDTO.class);
		resDto.setAssessmentfiles(fileList);
		return resDto;
	}

	@GetMapping("/asset/questionnaire/assessment/attachment/download/{refId}")
	public ResponseEntity<?> downloadFile(@NonNull @PathVariable String refId) {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.downloadFile(refId), AssessmentAttachmentsDTO.class));
	}

	@PutMapping("/asset/questionnaire/assessment/attachment/remove/{docId}")
	public ResponseEntity<?> deleteFile(@NonNull @PathVariable String docId) {
		String attachment = null;
		try {
			attachment = assetQuestionnaireAssessmentLibService.fileDeleteByDocId(docId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AssetResponseEntity.success(attachment);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_ASSET_QUESTIONNAIRE_ACTION)
	@PostMapping("/asset/questionnaire/assessment/new")
	public ResponseEntity<?> createQuestionnaireAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetQuestionAssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setCreatedBy(loginUserDetails.getUsername());		
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.createQuestionnaireAssessment(assessmentDto),
				CMAssetQuestionAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = EDIT_ASSET_QUESTIONNAIRE_ACTION)
	@PutMapping("/asset/questionnaire/assessment/modify")
	public ResponseEntity<?> updateQuestionnaireAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetQuestionAssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());		
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.updateQuestionnaireAssessment(assessmentDto),
				CMAssetQuestionAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_ASSET_QUESTIONNAIRE_ACTION)
	@PutMapping("/asset/questionnaire/assessment/remove")
	public ResponseEntity<?> deleteQuestionnaireAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetQuestionAssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());		
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireAssessmentLibService.deleteQuestionnaireAssessment(assessmentDto),
				CMAssetQuestionAssessmentDTO.class));
	}

	/*
	 * @PreAuthorize("isAuthenticated()")
	 * 
	 * @Loggable(action = READ_ACTION)
	 * 
	 * @GetMapping("/asset/questionnaire/assessment/find/contorl/{id}") public
	 * AssetReqResDTO
	 * getAssetQuestionnaireAssessmentByControlId(@NonNull @PathVariable (value =
	 * "id") String controlId) { AssetReqResDTO resDTO = new AssetReqResDTO();
	 * List<AssetQuestionAssessmentDTO> assetDTO =
	 * MapperUtils.mapToTargetClass(assetQuestionnaireAssessmentLibService.
	 * getAssetQuestionnaireAssessmentByControlId(controlId),
	 * AssetQuestionAssessmentDTO.class);
	 * resDTO.setAssetquestassessmentdto(assetDTO); return resDTO; }
	 */

}
