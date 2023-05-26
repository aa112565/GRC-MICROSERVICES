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

import com.asymmetrix.asset.service.AssetScoringService;
import com.asymmetrix.asset.common.aspect.Loggable;
import com.asymmetrix.asset.common.dto.LoginUserDetails;
//import com.asymmetrix.asset.common.response.AssetResponse;
import com.asymmetrix.asset.common.response.AssetResponseEntity;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.dto.AssetScoreGenetatorDTO;
import com.asymmetrix.asset.dto.AssetScoringDTO;

@RestController
public class AssetScoreController {

	@Autowired
	private AssetScoringService AssetLibService;

	private static final String SAVE_ASSET_SCORE_ACTION = "SAVE-ASSET-SCORE-DETAILS";
	private static final String EDIT_ASSET_SCORE_ACTION = "EDIT-ASSET-SCORE-DETAILS";
	private static final String REMOVE_ASSET_SCORE_ACTION = "DELETE-ASSET-SCORE-DETAILS";
	private static final String REMOVE_LIST_ASSET_SCORE_ACTION = "DELETE-LIST-ASSET-SCORE-DETAILS";
	private static final String READ_ASSET_SCORE_ACTION = "READ-ASSET-SCORE-DETAILS";
	private static final String READ_ALL_ASSET_SCORE_ACTION = "READ-ALL-ASSET-SCORE-DETAILS";
	private static final String READ_CALCULATED_IMPLIEDSCORE_ACTION = "READ-CALCULATED-IMPLIEDSCORE-ASSET-SCORE-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ASSET_SCORE_ACTION)
//	@GetMapping("/asset/score/find/all")
	@PostMapping("/asset/score/find/all")
	public ResponseEntity<?> getAllAssetScore() {
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(AssetLibService.getAllActiveAssetScore(), AssetScoringDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_SCORE_ACTION)
	@GetMapping("/asset/score/find/{id}")
	public ResponseEntity<?> getAssetScoreById(@NonNull @PathVariable(value = "id") long ciaScoreId) {
		return AssetResponseEntity.success(
				MapperUtils.mapToTargetClass(AssetLibService.getAssetScoreById(ciaScoreId), AssetScoringDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_SCORE_ACTION)
	@GetMapping("/asset/score/asset/{id}")
	public ResponseEntity<?> getAssetScoreByAssetId(@NonNull @PathVariable(value = "id") String assetId) {
		return AssetResponseEntity.success(
				MapperUtils.mapToTargetClass(AssetLibService.getAssetScoreByAssetId(assetId), AssetScoringDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_CALCULATED_IMPLIEDSCORE_ACTION)
	@PostMapping("/asset/score/impliedscore")
	public ResponseEntity<?> findAssetImpliedScore(@NonNull @RequestBody AssetScoreGenetatorDTO assetScoreDto) {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				AssetLibService.calculateScore(assetScoreDto.getDesiredConfidentialityScore(),
						assetScoreDto.getDesiredIntegrityScore(), assetScoreDto.getDesiredAvailabilityScore()),
				AssetScoreGenetatorDTO.class));
	}



	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_ASSET_SCORE_ACTION)
	@PostMapping("/asset/score/new")
	public ResponseEntity<?> createAssetScore(Authentication auth, @NonNull @RequestBody AssetScoringDTO assetScoreDto) {
		// BcmAssetReqResDTO resDTO = new BcmAssetReqResDTO();
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assetScoreDto.setCreatedBy(loginUserDetails.getUsername());
		return AssetResponseEntity.success(
				MapperUtils.mapToTargetClass(AssetLibService.createAssetScore(assetScoreDto), AssetScoringDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = EDIT_ASSET_SCORE_ACTION)
	@PutMapping("/asset/score/modify")
	public ResponseEntity<?> updateAssetScore(Authentication auth, @NonNull @RequestBody AssetScoringDTO assetScoreDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assetScoreDto.setModifiedBy(loginUserDetails.getUsername());
		return AssetResponseEntity.success(
				MapperUtils.mapToTargetClass(AssetLibService.updateAssetScore(assetScoreDto), AssetScoringDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_ASSET_SCORE_ACTION)
	@PutMapping("/asset/score/remove")
	public ResponseEntity<?> deleteAssetScore(Authentication auth, @NonNull @RequestBody AssetScoringDTO assetScoreDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assetScoreDto.setModifiedBy(loginUserDetails.getUsername());
		return AssetResponseEntity.success(
				MapperUtils.mapToTargetClass(AssetLibService.deleteAssetScore(assetScoreDto), AssetScoringDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_LIST_ASSET_SCORE_ACTION)
	@PutMapping("/asset/score/remove/list")
	public ResponseEntity<?> deleteAssetScoreList(Authentication auth, @NonNull @RequestBody List<AssetScoringDTO> assetScoreDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	//	assetScoreDto.setModifiedBy(loginUserDetails.getUsername());
		return AssetResponseEntity.success(AssetLibService.deleteAssetScoreList(assetScoreDto, loginUserDetails.getUsername()));
	}
	
}
