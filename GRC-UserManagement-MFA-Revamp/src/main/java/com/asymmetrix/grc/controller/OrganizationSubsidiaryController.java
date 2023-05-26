package com.asymmetrix.grc.controller;

import java.util.List;

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
import com.asymmetrix.grc.dto.OrganizationSubsidiaryDTO;
import com.asymmetrix.grc.service.OrganizationSubsidiaryService;

@SuppressWarnings("unused")
@RestController
public class OrganizationSubsidiaryController {

	@Autowired
	private OrganizationSubsidiaryService orgService;

	private static final String READ_ACTION = "READ-ORG-SUBSIDAIARY-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ORG-SUBSIDAIARY-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ORG-SUBSIDAIARY-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/subs/find/all")
	public ResponseEntity<?> getAllOrgSubsidiary(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrgSubsidiary(), OrganizationSubsidiaryDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/subs/dropdown/{id}")
	public ResponseEntity<?> getAllOrgSubsidiaryDDByOrgId(Authentication auth, @NonNull @PathVariable(value = "id") String orgId) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrgSubsidiaryDDByOrgId(orgId), OrganizationSubsidiaryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/subs/find/org/{id}")
	public ResponseEntity<?> getAllOrgSubsidiaryByOrgId(Authentication auth, @NonNull @PathVariable(value = "id") String orgId) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrgSubsidiaryByOrgId(orgId), OrganizationSubsidiaryDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/org/subs/find/{id}")
	public ResponseEntity<?> getOrgSubsidiaryById(Authentication auth, @NonNull @PathVariable(value = "id") long orgSubsId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getOrgSubsidiaryById(orgSubsId), OrganizationSubsidiaryDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/org/subs/new")
	public ResponseEntity<?> creatOrgSubsidiary(Authentication auth, @NonNull @RequestBody OrganizationSubsidiaryDTO orgSubs) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		orgSubs.setCreatedBy(uname);		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createOrgSubsidiary(orgSubs), OrganizationSubsidiaryDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/org/subs/new/list")
	public ResponseEntity<?> creatOrgSubsidiaryList(Authentication auth, @NonNull @RequestBody List<OrganizationSubsidiaryDTO> orgSubsList) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createOrgSubsidiaryList(orgSubsList, uname), OrganizationSubsidiaryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/modify")	
	public ResponseEntity<?> updateOrgSubsidiary(Authentication auth, @NonNull @RequestBody OrganizationSubsidiaryDTO orgSubs) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubs.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateOrgSubsidiary(orgSubs), OrganizationSubsidiaryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/remove")
	public ResponseEntity<?> deleteOrgSubsidiary(Authentication auth, @NonNull @RequestBody OrganizationSubsidiaryDTO orgSubs) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubs.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.deleteOrgSubsidiary(orgSubs));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/active")
	public ResponseEntity<?> activeOrgSubsidiary(Authentication auth, @NonNull @RequestBody OrganizationSubsidiaryDTO orgSubs) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubs.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.activeOrgSubsidiary(orgSubs));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/inactive")
	public ResponseEntity<?> inActiveOrgSubsidiary(Authentication auth, @NonNull @RequestBody OrganizationSubsidiaryDTO orgSubs) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubs.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.inActiveOrgSubsidiary(orgSubs));
	}

}
