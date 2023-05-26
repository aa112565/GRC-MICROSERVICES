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
import com.asymmetrix.grc.risk.dto.RiskAppetiteDTO;
import com.asymmetrix.grc.risk.service.RiskAppetiteService;

@RestController
public class RiskAppetiteController {

	@Autowired
	private RiskAppetiteService riskAppetiteService;

	private static final String READ_ACTION = "READ-RISK-APPETITE-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-RISK-APPETITE-DETAILS";
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-RISK-APPETITE-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/risk/appetite/find/all")
	public ResponseEntity<?> getAllRiskAppetite(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(riskAppetiteService.getAllAppetite(), RiskAppetiteDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/risk/appetite/find/{id}")
	public ResponseEntity<?> getRiskAppetitebyId(Authentication auth,
			@NonNull @PathVariable(value = "id") long appetiteId) {
		return RiskResponseEntity.success(
				MapperUtils.mapToTargetClass(riskAppetiteService.getAppetiteById(appetiteId), RiskAppetiteDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/risk/appetite/new")
	public ResponseEntity<?> creatRiskAppetite(Authentication auth,
			@NonNull @RequestBody RiskAppetiteDTO riskAppetite) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		riskAppetite.setCreatedBy(uname);
		// System.out.println("auth name"+uname+"---------------"+" additonal
		// info--------"+branchname);
		return RiskResponseEntity.success(MapperUtils
				.mapToTargetClass(riskAppetiteService.createRiskAppetite(riskAppetite), RiskAppetiteDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/risk/appetite/modify")
	public ResponseEntity<?> updateRiskAppetite(Authentication auth,
			@NonNull @RequestBody RiskAppetiteDTO riskAppetite) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		riskAppetite.setModifiedBy(loginUserDetails.getUsername());
		return RiskResponseEntity.success(MapperUtils
				.mapToTargetClass(riskAppetiteService.updateRiskAppetite(riskAppetite), RiskAppetiteDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/risk/appetite/remove")
	public ResponseEntity<?> deleteRiskAppetite(Authentication auth,
			@NonNull @RequestBody RiskAppetiteDTO riskAppetite) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		riskAppetite.setModifiedBy(loginUserDetails.getUsername());
		return RiskResponseEntity.success(MapperUtils
				.mapToTargetClass(riskAppetiteService.deleteRiskAppetite(riskAppetite), RiskAppetiteDTO.class));
	}

	

}
