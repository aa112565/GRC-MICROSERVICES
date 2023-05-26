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
import org.springframework.web.bind.annotation.RestController;


import com.asymmetrix.grc.common.response.KRIResponseEntity;

import com.asymmetrix.grc.riskkri.dto.KriIdPreferenceDTO;
import com.asymmetrix.grc.riskkri.service.KriIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;




@RestController
public class KriIdPreferenceController {

	@Autowired
	private KriIdPreferenceService idPreferenceService;


	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ACTION = "READ-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-RISK-ID-PREFERENCE-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/kri/id/preference/find/all")
	public ResponseEntity<?> getAllKriIdPreference() {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.getAllKriIdPreferenceByActiveflag(), KriIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/kri/id/preference/find/{id}")
	public KriIdPreferenceDTO getKriIdPreferenceById(@NonNull @PathVariable(value = "id") long seriesId) {
	//	ControlDetailsDTO resDto = new ControlDetailsDTO();
		KriIdPreferenceDTO findingDto = MapperUtils.mapToTargetClass(idPreferenceService.getKriIdPreferenceById(seriesId), KriIdPreferenceDTO.class);
	//	resDto.setIdPreferenceDto(findingDto);	
		return findingDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/kri/id/preference/find/new")
	public ResponseEntity<?> getKriIdPreferenceNew(@NonNull @RequestBody KriIdPreferenceDTO findingDto) {
		return KRIResponseEntity.success(idPreferenceService.findNewIdPreference(findingDto));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/kri/id/preference/new")
	public ResponseEntity<?> createKriIdPreference(Authentication auth, @NonNull @RequestBody KriIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();

		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.createKriIdPreference(findingDto, loginUserDetails.getUsername()), KriIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/kri/id/preference/modify")
	public ResponseEntity<?> updateKriIdPreference(Authentication auth, @NonNull @RequestBody KriIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.updateKriIdPreference(findingDto, loginUserDetails.getUsername()), KriIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/kri/id/preference/remove")
	public ResponseEntity<?> deleteKriIdPreference(Authentication auth, @NonNull @RequestBody KriIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.deleteKriIdPreference(findingDto, loginUserDetails.getUsername()), KriIdPreferenceDTO.class));
	}

	
}
