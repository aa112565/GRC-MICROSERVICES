package com.asymmetrix.grc.Controller;

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

import com.asymmetrix.grc.Dto.PolicyIdPreferenceDTO;
import com.asymmetrix.grc.Dto.PolicyPreferenceDTO;
import com.asymmetrix.grc.Dto.PolicyReqResDTO;
import com.asymmetrix.grc.Service.PolicyIdPreferenceService;
import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;



@RestController
public class PolicyIdPreferenceController {

	@Autowired
	private PolicyIdPreferenceService idPreferenceService;
	

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ACTION = "READ-RISK-ID-PREFERENCE-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-RISK-ID-PREFERENCE-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/policy/id/preference/find/all")
	public ResponseEntity<?> getAllRiskIdPreference() {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.getAllPolicyIdPreferenceByActiveflag(), PolicyIdPreferenceDTO.class));
	}


	
	//@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@PostMapping("/policy/id/preference/find/new")
	public ResponseEntity<?> getPolicyIdPreferenceFindNew(@NonNull @RequestBody PolicyIdPreferenceDTO findingDto) {
		return GRCResponseEntity            
				.success(idPreferenceService.findNewIdPreference(findingDto));
	}


	//@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/policy/id/preference/new")
	public ResponseEntity<?> createPolicyIdPreference(Authentication auth, @NonNull @RequestBody PolicyIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();

		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.createPolicyIdPreference(findingDto, loginUserDetails.getUsername()), PolicyIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/policy/id/preference/modify")
	public ResponseEntity<?> updatePolicyIdPreference(Authentication auth, @NonNull @RequestBody PolicyIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.updatePolicyIdPreference(findingDto, loginUserDetails.getUsername()), PolicyIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/policy/id/preference/remove")
	public ResponseEntity<?> deletePolicyIdPreference(Authentication auth, @NonNull @RequestBody PolicyIdPreferenceDTO findingDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(idPreferenceService.deletePolicyIdPreference(findingDto, loginUserDetails.getUsername()), PolicyIdPreferenceDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/policy/id/preference/find/{id}")
	public PolicyReqResDTO getPolicyIdPreferenceById(@NonNull @PathVariable(value = "id") long seriesId) {
		PolicyReqResDTO resDto = new PolicyReqResDTO();
		PolicyIdPreferenceDTO findingDto = MapperUtils.mapToTargetClass(idPreferenceService.getPolicyIdPreferenceById(seriesId), PolicyIdPreferenceDTO.class);
		resDto.setPolicyIdPreferenceDTO(findingDto);
		return resDto;
	}
	
}
