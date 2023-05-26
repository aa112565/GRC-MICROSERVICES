package com.grc.threat.risk.controller;


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

import com.grc.threat.common.aspect.Loggable;
import com.grc.threat.common.dto.LoginUserDetails;
import com.grc.threat.common.response.ThreatLibraryResponseEntity;
import com.grc.threat.common.utils.MapperUtils;
import com.grc.threat.risk.dto.ThreatDetailsDTO;
import com.grc.threat.risk.dto.ThreatIdPreferenceDTO;
import com.grc.threat.risk.service.ThreatIdPreferenceService;




@RestController
public class ThreatIdPreferenceController {

	@Autowired
	private ThreatIdPreferenceService idPreferenceService;


	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-THREAT-ID-PREFERENCE-DETAILS";
	private static final String READ_ACTION = "READ-THREAT-ID-PREFERENCE-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-THREAT-ID-PREFERENCE-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/threat/id/preference/find/all")
	public ResponseEntity<?> getAllThreatIdPreference() {
		return ThreatLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.getAllThreatIdPreferenceByActiveflag(), ThreatIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/threat/id/preference/find/{id}")
	public ThreatDetailsDTO getThreatIdPreferenceById(@NonNull @PathVariable(value = "id") long seriesId) {
		ThreatDetailsDTO resDto = new ThreatDetailsDTO();
		ThreatIdPreferenceDTO preferenceDto = MapperUtils.mapToTargetClass(idPreferenceService.getThreatIdPreferenceById(seriesId), ThreatIdPreferenceDTO.class);
		resDto.setIdPreferenceDto(preferenceDto);	
		return resDto;
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/threat/id/preference/find/new")
	public ResponseEntity<?> getThreatIdPreferenceNew(@NonNull @RequestBody ThreatIdPreferenceDTO preferenceDto) {
	//	ThreatDetailsDTO resDto = new ThreatDetailsDTO();
	//	ThreatIdPreferenceDTO preferenceDto = MapperUtils.mapToTargetClass(idPreferenceService.getThreatIdPreferenceById(seriesId), ThreatIdPreferenceDTO.class);
	//	resDto.setIdPreferenceDto(preferenceDto);	
		return ThreatLibraryResponseEntity
				.success(idPreferenceService.findNewIdPreference(preferenceDto));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/threat/id/preference/new")
	public ResponseEntity<?> createThreatIdPreference(Authentication auth, @NonNull @RequestBody ThreatIdPreferenceDTO preferenceDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();

		return ThreatLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.createThreatIdPreference(preferenceDto, loginUserDetails.getUsername()), ThreatIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/threat/id/preference/modify")
	public ResponseEntity<?> updateThreatIdPreference(Authentication auth, @NonNull @RequestBody ThreatIdPreferenceDTO preferenceDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return ThreatLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.updateThreatIdPreference(preferenceDto, loginUserDetails.getUsername()), ThreatIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/threat/id/preference/remove")
	public ResponseEntity<?> deleteThreatIdPreference(Authentication auth, @NonNull @RequestBody ThreatIdPreferenceDTO preferenceDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return ThreatLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.deleteThreatIdPreference(preferenceDto, loginUserDetails.getUsername()), ThreatIdPreferenceDTO.class));
	}

	
}
