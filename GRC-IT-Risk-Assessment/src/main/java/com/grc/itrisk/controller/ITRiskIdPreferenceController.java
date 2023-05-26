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
import com.grc.itrisk.dto.ITRiskPreferenceDTO;
import com.grc.itrisk.service.ITRiskIdPreferenceService;



@RestController
public class ITRiskIdPreferenceController {

	@Autowired
	private ITRiskIdPreferenceService idPreferenceService;


	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ITRISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ACTION = "READ-ITRISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ITRISK-ID-PREFERENCE-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/itrisk/id/preference/find/all")
	public ResponseEntity<?> getAllITRiskIdPreference() {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.getAllITRiskIdPreferenceByActiveflag(), ITRiskPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/itrisk/id/preference/find/{id}")
	public ITRiskPreferenceDTO getITRiskIdPreferenceById(@NonNull @PathVariable(value = "id") long seriesId) {
	//	ITRiskReqResDTO resDto = new ITRiskReqResDTO();
		ITRiskPreferenceDTO findingDto = MapperUtils.mapToTargetClass(idPreferenceService.getITRiskIdPreferenceById(seriesId), ITRiskPreferenceDTO.class);
	//	resDto.setIdPreferenceDto(findingDto);	
		return findingDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/itrisk/id/preference/find/new")
	public ResponseEntity<?> getITRiskIdPreferenceNew(@NonNull @RequestBody ITRiskPreferenceDTO findingDto) {
	return ITRiskResponseEntity.success(idPreferenceService.findNewIdPreference(findingDto));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/itrisk/id/preference/new")
	public ResponseEntity<?> createITRiskIdPreference(Authentication auth, @NonNull @RequestBody ITRiskPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();

		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.createITRiskIdPreference(findingDto, loginUserDetails.getUsername()), ITRiskPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/itrisk/id/preference/modify")
	public ResponseEntity<?> updateITRiskIdPreference(Authentication auth, @NonNull @RequestBody ITRiskPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.updateITRiskIdPreference(findingDto, loginUserDetails.getUsername()), ITRiskPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/itrisk/id/preference/remove")
	public ResponseEntity<?> deleteITRiskIdPreference(Authentication auth, @NonNull @RequestBody ITRiskPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.deleteITRiskIdPreference(findingDto, loginUserDetails.getUsername()), ITRiskPreferenceDTO.class));
	}

	
}
