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
import com.asymmetrix.grc.riskkri.dto.KriMapBusinessLineDTO;
import com.asymmetrix.grc.riskkri.service.KriMapBusinessLineService;


@RestController
@RequestMapping("/kri")
public class KriMapBusinessLineController {

	@Autowired
	private KriMapBusinessLineService mapService;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-KRI-MAP-DETAILS";
	private static final String READ_ACTION = "READ-KRI-MAP-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-KRI-MAP-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/map/find/all")
	public ResponseEntity<?> getKriMapList() {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(mapService.getKriMapping(), KriMapBusinessLineDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/map/find/{id}")
	public ResponseEntity<?> getKriMapById(@NonNull @PathVariable(value = "id") long kriMapId) {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(mapService.getKriMapById(kriMapId), KriMapBusinessLineDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/map/kri/{id}")
	public ResponseEntity<?> getKriMapByKriId(@NonNull @PathVariable(value = "id") String kriId) {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(mapService.getKriMapByKriId(kriId), KriMapBusinessLineDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/map/new")
	public ResponseEntity<?> creatKriMap(Authentication auth, @NonNull @RequestBody KriMapBusinessLineDTO kriMap) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriMap.setCreatedBy(loginUserDetails.getUsername());
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(mapService.createKriMap(kriMap), KriMapBusinessLineDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/map/modify/{id}")
	public ResponseEntity<?> updateKri(Authentication auth, @NonNull @PathVariable(value = "id") String kriId,
			@NonNull @RequestBody KriMapBusinessLineDTO kriMap) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriMap.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(
				MapperUtils.mapToTargetClass(mapService.updateKriMap(kriId, kriMap), KriMapBusinessLineDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/map/remove")
	public ResponseEntity<?> deleteKri(Authentication auth, @NonNull @RequestBody KriMapBusinessLineDTO kriMap) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriMap.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(mapService.deleteKriMap(kriMap), KriMapBusinessLineDTO.class));
	}

}
