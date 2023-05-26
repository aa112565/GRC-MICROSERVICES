package com.asymmetrix.grc.riskcontrol.controller;


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

import com.asymmetrix.grc.common.response.ControlLibraryResponseEntity;


import com.asymmetrix.grc.riskcontrol.dto.ControlDetailsDTO;
import com.asymmetrix.grc.riskcontrol.dto.ControlIdPreferenceDTO;
import com.asymmetrix.grc.riskcontrol.service.ControlIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;




@RestController
public class ControlIdPreferenceController {

	@Autowired
	private ControlIdPreferenceService idPreferenceService;


	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ACTION = "READ-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-RISK-ID-PREFERENCE-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/control/id/preference/find/all")
	public ResponseEntity<?> getAllRiskIdPreference() {
		return ControlLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.getAllControlIdPreferenceByActiveflag(), ControlIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/control/id/preference/find/{id}")
	public ControlDetailsDTO getRiskIdPreferenceById(@NonNull @PathVariable(value = "id") long seriesId) {
		ControlDetailsDTO resDto = new ControlDetailsDTO();
		ControlIdPreferenceDTO findingDto = MapperUtils.mapToTargetClass(idPreferenceService.getControlIdPreferenceById(seriesId), ControlIdPreferenceDTO.class);
		resDto.setIdPreferenceDto(findingDto);	
		return resDto;
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/control/id/preference/find/new")
	public ResponseEntity<?> getRiskIdPreferenceNew(@NonNull @RequestBody ControlIdPreferenceDTO findingDto) {
	//	ControlDetailsDTO resDto = new ControlDetailsDTO();
	//	ControlIdPreferenceDTO findingDto = MapperUtils.mapToTargetClass(idPreferenceService.getControlIdPreferenceById(seriesId), ControlIdPreferenceDTO.class);
	//	resDto.setIdPreferenceDto(findingDto);	
		return ControlLibraryResponseEntity
				.success(idPreferenceService.findNewIdPreference(findingDto));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/control/id/preference/new")
	public ResponseEntity<?> createRiskIdPreference(Authentication auth, @NonNull @RequestBody ControlIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();

		return ControlLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.createControlIdPreference(findingDto, loginUserDetails.getUsername()), ControlIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/control/id/preference/modify")
	public ResponseEntity<?> updateRiskIdPreference(Authentication auth, @NonNull @RequestBody ControlIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return ControlLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.updateControlIdPreference(findingDto, loginUserDetails.getUsername()), ControlIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/control/id/preference/remove")
	public ResponseEntity<?> deleteRiskIdPreference(Authentication auth, @NonNull @RequestBody ControlIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return ControlLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.deleteControlIdPreference(findingDto, loginUserDetails.getUsername()), ControlIdPreferenceDTO.class));
	}

	
}
