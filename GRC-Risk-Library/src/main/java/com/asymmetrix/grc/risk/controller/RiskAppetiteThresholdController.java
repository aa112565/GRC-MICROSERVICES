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

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.RiskResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.risk.dto.RiskAppetiteThresholdDTO;
import com.asymmetrix.grc.risk.service.RiskAppetiteThresholdService;

@RestController
public class RiskAppetiteThresholdController {

	@Autowired
	private RiskAppetiteThresholdService appetiteThresholdService;

	private static final String READ_ACTION = "READ-RISK-APPETITE-THRESHOLD-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-RISK-APPETITE-THRESHOLD-DETAILS";
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-RISK-APPETITE-THRESHOLD-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/risk/appetite/threshold/find/all")
	public ResponseEntity<?> getAllRiskAppetiteThreshold(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return RiskResponseEntity.success(MapperUtils.mapToTargetClass(
				appetiteThresholdService.getAllRiskAppetiteThreshold(), RiskAppetiteThresholdDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/risk/appetite/threshold/find/{id}")
	public ResponseEntity<?> getRiskAppetiteThresholdbyId(Authentication auth,
			@NonNull @PathVariable(value = "id") String thresholdId) {
		return RiskResponseEntity.success(MapperUtils.mapToTargetClass(
				appetiteThresholdService.getRiskAppetiteThresholdById(thresholdId), RiskAppetiteThresholdDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/risk/appetite/threshold/find/appetite/{id}")
	public ResponseEntity<?> getRiskAppetiteThresholdbyId(Authentication auth,
			@NonNull @PathVariable(value = "id") long appetiteId) {
		return RiskResponseEntity.success(
				MapperUtils.mapToTargetClass(appetiteThresholdService.getRiskAppetiteThresholdByAppetiteID(appetiteId),
						RiskAppetiteThresholdDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/risk/appetite/threshold/new")
	public ResponseEntity<?> creatRiskAppetiteThreshold(Authentication auth,
			@NonNull @RequestBody RiskAppetiteThresholdDTO appetiteThresholdDTO) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		appetiteThresholdDTO.setCreatedBy(uname);		
		return RiskResponseEntity.success(
				MapperUtils.mapToTargetClass(appetiteThresholdService.createRiskAppetiteThreshold(appetiteThresholdDTO),
						RiskAppetiteThresholdDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/risk/appetite/threshold/modify")
	public ResponseEntity<?> updateRiskAppetiteThreshold(Authentication auth,
			@NonNull @RequestBody RiskAppetiteThresholdDTO appetiteThresholdDTO) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		appetiteThresholdDTO.setModifiedBy(loginUserDetails.getUsername());
		return RiskResponseEntity.success(
				MapperUtils.mapToTargetClass(appetiteThresholdService.updateRiskAppetiteThreshold(appetiteThresholdDTO),
						RiskAppetiteThresholdDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/risk/appetite/threshold/remove")
	public ResponseEntity<?> deleteRiskAppetiteThreshold(Authentication auth,
			@NonNull @RequestBody RiskAppetiteThresholdDTO appetiteThresholdDTO) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		appetiteThresholdDTO.setModifiedBy(loginUserDetails.getUsername());
		return RiskResponseEntity.success(
				MapperUtils.mapToTargetClass(appetiteThresholdService.deleteRiskAppetiteThreshold(appetiteThresholdDTO),
						RiskAppetiteThresholdDTO.class));
	}

}
