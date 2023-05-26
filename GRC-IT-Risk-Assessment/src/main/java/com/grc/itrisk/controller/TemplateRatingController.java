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
import com.grc.itrisk.dto.TemplateRatingDTO;
import com.grc.itrisk.service.TemplateRatingService;

@SuppressWarnings("unused")
@RestController
public class TemplateRatingController {

	@Autowired
	private TemplateRatingService orgService;

	private static final String READ_ACTION = "READ-TEMPLATE-RATING-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-TEMPLATE-RATING-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-TEMPLATE-RATING-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/template/rating/find/all")
	public ResponseEntity<?> getAllTemplateRating(Authentication auth) {
		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplateRating(), TemplateRatingDTO.class));
	}
	
/*	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/folder/dropdown")
	public ResponseEntity<?> getAllTemplateDD(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplateDD(), TemplateRatingDDDTO.class));
	}
*/

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/template/rating/find/{id}")
	public ResponseEntity<?> getTemplateRatingbyId(Authentication auth, @NonNull @PathVariable(value = "id") long folderMasterId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getTemplateRatingById(folderMasterId), TemplateRatingDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@PostMapping("/template/rating/find/ref/{templateId}")
	public ResponseEntity<?> getAllTemplateRatingByRefId(Authentication auth, @NonNull @PathVariable(value = "templateId") long templateId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getTemplateRatingByRefId(templateId), TemplateRatingDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/template/rating/new")
	public ResponseEntity<?> creatTemplateRating(Authentication auth, @NonNull @RequestBody TemplateRatingDTO folderMaster) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		folderMaster.setCreatedBy(uname);		
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createTemplateRating(folderMaster), TemplateRatingDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/rating/modify")	
	public ResponseEntity<?> updateTemplateRating(Authentication auth, @NonNull @RequestBody TemplateRatingDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateTemplateRating(folderMaster), TemplateRatingDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/rating/inactive")
	public ResponseEntity<?> inActiveTemplateRating(Authentication auth, @NonNull @RequestBody TemplateRatingDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.inActiveTemplateRating(folderMaster));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/rating/active")
	public ResponseEntity<?> activeTemplateRating(Authentication auth, @NonNull @RequestBody TemplateRatingDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.activeTemplateRating(folderMaster));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/rating/remove")
	public ResponseEntity<?> deleteTemplateRating(Authentication auth, @NonNull @RequestBody TemplateRatingDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.deleteTemplateRating(folderMaster));
	}

}
