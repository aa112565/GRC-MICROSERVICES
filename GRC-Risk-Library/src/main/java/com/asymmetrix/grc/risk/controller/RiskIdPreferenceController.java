package com.asymmetrix.grc.risk.controller;


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

import com.asymmetrix.grc.common.response.RiskResponseEntity;
import com.asymmetrix.grc.risk.dto.RiskDetailsDTO;
import com.asymmetrix.grc.risk.dto.RiskIdPreferenceDTO;
import com.asymmetrix.grc.risk.service.RiskIdPreferenceService;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;




@RestController
public class RiskIdPreferenceController {

	@Autowired
	private RiskIdPreferenceService idPreferenceService;


	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ACTION = "READ-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-RISK-ID-PREFERENCE-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/risk/id/preference/find/all")
	public ResponseEntity<?> getAllRiskIdPreference() {
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.getAllRiskIdPreferenceByActiveflag(), RiskIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/risk/id/preference/find/{id}")
	public RiskDetailsDTO getRiskIdPreferenceById(@NonNull @PathVariable(value = "id") long seriesId) {
		RiskDetailsDTO resDto = new RiskDetailsDTO();
		RiskIdPreferenceDTO findingDto = MapperUtils.mapToTargetClass(idPreferenceService.getRiskIdPreferenceById(seriesId), RiskIdPreferenceDTO.class);
		resDto.setIdPreferenceDto(findingDto);	
		return resDto;
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/risk/id/preference/find/new")
	public ResponseEntity<?> getRiskIdPreferenceFindNew(@NonNull @RequestBody RiskIdPreferenceDTO findingDto) {
	//	RiskDetailsDTO resDto = new RiskDetailsDTO();
	//	RiskIdPreferenceDTO findingDto = MapperUtils.mapToTargetClass(idPreferenceService.findNewIdPreference(findingDto), RiskIdPreferenceDTO.class);
	//	resDto.setIdPreferenceDto(findingDto);	
		return RiskResponseEntity
				.success(idPreferenceService.findNewIdPreference(findingDto));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/risk/id/preference/new")
	public ResponseEntity<?> createRiskIdPreference(Authentication auth, @NonNull @RequestBody RiskIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();

		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.createRiskIdPreference(findingDto, loginUserDetails.getUsername()), RiskIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/risk/id/preference/modify")
	public ResponseEntity<?> updateRiskIdPreference(Authentication auth, @NonNull @RequestBody RiskIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.updateRiskIdPreference(findingDto, loginUserDetails.getUsername()), RiskIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/risk/id/preference/remove")
	public ResponseEntity<?> deleteRiskIdPreference(Authentication auth, @NonNull @RequestBody RiskIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.deleteRiskIdPreference(findingDto, loginUserDetails.getUsername()), RiskIdPreferenceDTO.class));
	}

	
}
