package com.asymmetrix.asset.controller;

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
import com.asymmetrix.asset.common.aspect.Loggable;
import com.asymmetrix.asset.common.dto.LoginUserDetails;
import com.asymmetrix.asset.common.response.AssetResponseEntity;
import com.asymmetrix.asset.common.utils.MapperUtils;

import com.asymmetrix.asset.dto.AssetReqResDTO;

import com.asymmetrix.asset.dto.CMAssetQuestionCategoryAssessmentDTO;

import com.asymmetrix.asset.dto.AssetQuestionCategoryAssessmentDTO;
import com.asymmetrix.asset.service.AssetQuestionnaireCategoryAssessmentService;

@RestController
public class AssetQuestionnaireCategoryAssessmentController {

	@Autowired
	private AssetQuestionnaireCategoryAssessmentService assetQuestionnaireCategoryAssessmentLibService;
	
	private static final String SAVE_ASSET_QUESTIONNAIRE_CATEGORY_ACTION = "SAVE-ASSET-QUESTIONNAIRE-CATEGORY-ASSESSMENT-DETAILS";
	private static final String EDIT_ASSET_QUESTIONNAIRE_CATEGORY_ACTION = "EDIT-ASSET-QUESTIONNAIRE-CATEGORY-ASSESSMENT-DETAILS";
	private static final String REMOVE_ASSET_QUESTIONNAIRE_CATEGORY_ACTION = "DELTE-ASSET-QUESTIONNAIRE-CATEGORY-ASSESSMENT-DETAILS";
	private static final String READ_ACTION = "READ-ASSET-QUESTIONNAIRE-CATEGORY-ASSESSMENT-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ASSET-QUESTIONNAIRE-CATEGORY-ASSESSMENT-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
//	@GetMapping("/asset/questionnaire/category/assessment/find/all")
	@PostMapping("/asset/questionnaire/category/assessment/find/all")
	public ResponseEntity<?> getAllAssetQuestionnaireCategoryAssessment() {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireCategoryAssessmentLibService.getAllAssetQuestionnaireCategoryAssessmentByActiveflag(),
				CMAssetQuestionCategoryAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/category/assessment/find/{id}")
	public AssetReqResDTO getAssetQuestionnaireCategoryCategoryAssessmentById(
			@NonNull @PathVariable(value = "id") long assessmentId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		AssetQuestionCategoryAssessmentDTO categoryAssessmentDto = MapperUtils.mapToTargetClass(
				assetQuestionnaireCategoryAssessmentLibService.getAssetQuestionnaireCategoryAssessmentById(
						assessmentId),
				AssetQuestionCategoryAssessmentDTO.class);
		resDto.setCategorydto(categoryAssessmentDto);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/category/assessment/find/assessment/{aid}/control/{cid}")
	public AssetReqResDTO getAssetQuestionnaireCategoryAssessmentByQuestionId(
			@NonNull @PathVariable(value = "aid") String assessmentId,
			@NonNull @PathVariable(value = "cid") String controlId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		AssetQuestionCategoryAssessmentDTO categoryAssessmentDto = MapperUtils
				.mapToTargetClass(
						assetQuestionnaireCategoryAssessmentLibService
								.getAssetQuestionnaireCategoryAssessmentByControlId(assessmentId, controlId),
						AssetQuestionCategoryAssessmentDTO.class);
		resDto.setCategorydto(categoryAssessmentDto);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/category/assessment/find/asset/{id}")
	public AssetReqResDTO getAssetQuestionnaireCategoryAssessmentByAssetId(
			@NonNull @PathVariable(value = "id") String assetId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		List<AssetQuestionCategoryAssessmentDTO> categoryAssessmentDto = MapperUtils.mapToTargetClass(
				assetQuestionnaireCategoryAssessmentLibService.getAssetQuestionnaireCategoryAssessmentByAssetId(
						assetId),
				AssetQuestionCategoryAssessmentDTO.class);
		resDto.setCategorylistdto(categoryAssessmentDto);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/questionnaire/category/assessment/find/assessment/{id}")
	public AssetReqResDTO getAssetQuestionnaireCategoryAssessmentByAssessmentId(
			@NonNull @PathVariable(value = "id") String assessmentId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		List<AssetQuestionCategoryAssessmentDTO> categoryAssessmentDto = MapperUtils
				.mapToTargetClass(
						assetQuestionnaireCategoryAssessmentLibService
								.getAssetQuestionnaireCategoryAssessmentByAssessmentId(assessmentId),
						AssetQuestionCategoryAssessmentDTO.class);
		resDto.setCategorylistdto(categoryAssessmentDto);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_ASSET_QUESTIONNAIRE_CATEGORY_ACTION)
	@PostMapping("/asset/questionnaire/category/assessment/new")
	public ResponseEntity<?> createQuestionnaireCategoryAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetQuestionCategoryAssessmentDTO categoryAssessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		categoryAssessmentDto.setCreatedBy(loginUserDetails.getUsername());
		
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireCategoryAssessmentLibService.createQuestionnaireCategoryAssessment(categoryAssessmentDto),
				CMAssetQuestionCategoryAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = EDIT_ASSET_QUESTIONNAIRE_CATEGORY_ACTION)
	@PutMapping("/asset/questionnaire/category/assessment/modify")
	public ResponseEntity<?> updateQuestionnaireCategoryAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetQuestionCategoryAssessmentDTO categoryAssessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		categoryAssessmentDto.setModifiedBy(loginUserDetails.getUsername());
		
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireCategoryAssessmentLibService.updateQuestionnaireCategoryAssessment(categoryAssessmentDto),
				CMAssetQuestionCategoryAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_ASSET_QUESTIONNAIRE_CATEGORY_ACTION)
	@PutMapping("/asset/questionnaire/category/assessment/remove")
	public ResponseEntity<?> deleteQuestionnaireCategoryAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetQuestionCategoryAssessmentDTO categoryAssessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		categoryAssessmentDto.setModifiedBy(loginUserDetails.getUsername());		
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetQuestionnaireCategoryAssessmentLibService.deleteQuestionnaireCategoryAssessment(categoryAssessmentDto),
				CMAssetQuestionCategoryAssessmentDTO.class));
	}

	
}
