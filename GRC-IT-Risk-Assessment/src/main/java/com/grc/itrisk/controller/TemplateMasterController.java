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
import com.grc.itrisk.dto.TemplateMasterDTO;
import com.grc.itrisk.service.TemplateMasterService;

@SuppressWarnings("unused")
@RestController
public class TemplateMasterController {

	@Autowired
	private TemplateMasterService orgService;
	
	

	private static final String READ_ACTION = "READ-TEMPLATE-MASTER-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-TEMPLATE-MASTER-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-TEMPLATE-MASTER-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/template/find/all")
	public ResponseEntity<?> getAllTemplate(Authentication auth) {
		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplate(), TemplateMasterDTO.class));
	}
	
/*	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/folder/dropdown")
	public ResponseEntity<?> getAllTemplateDD(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplateDD(), TemplateMasterDDDTO.class));
	}
*/

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/template/find/{id}")
	public ResponseEntity<?> getTemplatebyId(Authentication auth, @NonNull @PathVariable(value = "id") long folderMasterId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getTemplateById(folderMasterId), TemplateMasterDTO.class));
	}
/*	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ACTION)	
	@GetMapping("/template/find/ref/{refId}")
	public ResponseEntity<?> getAllTemplateByRefId(Authentication auth, @NonNull @PathVariable(value = "refId") String refId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplateByRefId(refId), TemplateMasterDTO.class));
	}

*/
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/template/new")
	public ResponseEntity<?> creatTemplate(Authentication auth, @NonNull @RequestBody TemplateMasterDTO folderMaster) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		folderMaster.setCreatedBy(uname);		
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createTemplate(folderMaster), TemplateMasterDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/modify")	
	public ResponseEntity<?> updateTemplate(Authentication auth, @NonNull @RequestBody TemplateMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateTemplate(folderMaster), TemplateMasterDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/inactive")
	public ResponseEntity<?> inActiveTemplate(Authentication auth, @NonNull @RequestBody TemplateMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.inActiveTemplate(folderMaster));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/active")
	public ResponseEntity<?> activeTemplate(Authentication auth, @NonNull @RequestBody TemplateMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.activeTemplate(folderMaster));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/remove")
	public ResponseEntity<?> deleteTemplate(Authentication auth, @NonNull @RequestBody TemplateMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.deleteTemplate(folderMaster));
	}

}
