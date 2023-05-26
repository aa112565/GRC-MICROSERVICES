package com.asymmetrix.grc.riskkri.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.KRIResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dto.KriThresholdDefinitionDTO;
import com.asymmetrix.grc.riskkri.service.KriThresholdDefinitionService;


@RestController
@RequestMapping("/kri")
public class KriThresholdDefinitonController {

	@Autowired
	private KriThresholdDefinitionService thresholdService;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-KRI-THRESHOLD-DEFINITION";
	private static final String READ_ACTION = "READ-KRI-THRESHOLD-DEFINITION";
	private static final String READ_ALL_ACTION = "READ-KRI-THRESHOLD-DEFINITION";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/threshold/find/all")
	public ResponseEntity<?> getKriThresholdList() {
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(thresholdService.getKriThresholdDefiniton(),
				KriThresholdDefinitionDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/threshold/find/{id}")
	public ResponseEntity<?> getKriThresholdById(@NonNull @PathVariable(value = "id") long kriThresholdId) {
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(
				thresholdService.getKriThresholdDefById(kriThresholdId), KriThresholdDefinitionDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/threshold/kri/{id}")
	public ResponseEntity<?> getKriThresholdByKriId(@NonNull @PathVariable(value = "id") String kriId) {
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(thresholdService.getKriThresholdDefByKriId(kriId),
				KriThresholdDefinitionDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/threshold/new")
	public ResponseEntity<?> creatKriThreshold(Authentication auth,
			@NonNull @RequestBody KriThresholdDefinitionDTO kriThresholdDef) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriThresholdDef.setCreatedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(
				thresholdService.createKriThresholdDefiniton(kriThresholdDef), KriThresholdDefinitionDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/threshold/modify/{id}")
	public ResponseEntity<?> updateKriThreshold(Authentication auth, @NonNull @PathVariable(value = "id") String kriId,
			@NonNull @RequestBody KriThresholdDefinitionDTO kriThresholdDef) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriThresholdDef.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(
				thresholdService.updateKriThresholdDefiniton(kriId, kriThresholdDef), KriThresholdDefinitionDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/threshold/remove")
	public ResponseEntity<?> deleteKriThreshold(Authentication auth,
			@NonNull @RequestBody KriThresholdDefinitionDTO kriThresholdDef) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriThresholdDef.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(
				thresholdService.deleteKriThresholdDefiniton(kriThresholdDef), KriThresholdDefinitionDTO.class));
	}

}
