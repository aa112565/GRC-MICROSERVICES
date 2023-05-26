package com.asymmetrix.grc.controller;

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
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.OrganizationMasterDDDTO;
import com.asymmetrix.grc.dto.OrganizationMasterDTO;
import com.asymmetrix.grc.service.OrganizationNewService;

@SuppressWarnings("unused")
@RestController

public class OrganizationController {

	@Autowired
	private OrganizationNewService orgService;

	private static final String READ_ACTION = "READ-ORG-MASTER-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ORG-MASTER-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ORG-MASTER-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/find/all")
	public ResponseEntity<?> getAllOrganization(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrganization(), OrganizationMasterDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/dropdown")
	public ResponseEntity<?> getAllOrganizationDD(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrganizationDD(), OrganizationMasterDDDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/org/find/{id}")
	public ResponseEntity<?> getOrganizationbyId(Authentication auth, @NonNull @PathVariable(value = "id") long orgMasterId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getOrganizationById(orgMasterId), OrganizationMasterDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/org/new")
	public ResponseEntity<?> creatOrganization(Authentication auth, @NonNull @RequestBody OrganizationMasterDTO orgMaster) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		orgMaster.setCreatedBy(uname);		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createOrganization(orgMaster), OrganizationMasterDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/modify")	
	public ResponseEntity<?> updateOrganization(Authentication auth, @NonNull @RequestBody OrganizationMasterDTO orgMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateOrganization(orgMaster), OrganizationMasterDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/inactive")
	public ResponseEntity<?> inActiveOrganization(Authentication auth, @NonNull @RequestBody OrganizationMasterDTO orgMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.inActiveOrganization(orgMaster));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/active")
	public ResponseEntity<?> activeOrganization(Authentication auth, @NonNull @RequestBody OrganizationMasterDTO orgMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.activeOrganization(orgMaster));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/remove")
	public ResponseEntity<?> deleteOrganization(Authentication auth, @NonNull @RequestBody OrganizationMasterDTO orgMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.deleteOrganization(orgMaster));
	}

}
