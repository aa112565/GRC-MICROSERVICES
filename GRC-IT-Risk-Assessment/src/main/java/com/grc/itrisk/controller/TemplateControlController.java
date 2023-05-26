package com.grc.itrisk.controller;

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

import com.grc.itrisk.common.aspect.Loggable;
import com.grc.itrisk.common.dto.LoginUserDetails;
import com.grc.itrisk.common.response.ITRiskResponseEntity;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dto.TemplateControlDTO;
import com.grc.itrisk.service.TemplateControlService;

@SuppressWarnings("unused")
@RestController
public class TemplateControlController {

	@Autowired
	private TemplateControlService orgService;

	private static final String READ_ACTION = "READ-TEMPLATE-CONTROL-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-TEMPLATE-CONTROL-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-TEMPLATE-CONTROL-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/template/control/find/all")
	public ResponseEntity<?> getAllTemplateControl(Authentication auth) {		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplateControl(), TemplateControlDTO.class));
	}
	
/*	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/folder/dropdown")
	public ResponseEntity<?> getAllTemplateDD(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplateDD(), TemplateControlDDDTO.class));
	}
*/

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/template/control/find/{id}")
	public ResponseEntity<?> getTemplateControlById(Authentication auth, @NonNull @PathVariable(value = "id") long templateControlId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getTemplateControlById(templateControlId), TemplateControlDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@PostMapping("/template/control/find/ref/{templateId}")
	public ResponseEntity<?> getAllTemplateByRefId(Authentication auth, @NonNull @PathVariable(value = "templateId") long templateId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllTemplateControlByRefId(templateId), TemplateControlDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/template/control/new")
	public ResponseEntity<?> creatTemplateControl(Authentication auth, @NonNull @RequestBody List<TemplateControlDTO> templateControl) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
	//	templateControl.setCreatedBy(uname);		
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createTemplateControl(templateControl, uname), TemplateControlDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/control/modify")	
	public ResponseEntity<?> updateTemplateControl(Authentication auth, @NonNull @RequestBody TemplateControlDTO templateControl) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		templateControl.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateTemplateControl(templateControl), TemplateControlDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/control/inactive")
	public ResponseEntity<?> inActiveTemplateControl(Authentication auth, @NonNull @RequestBody TemplateControlDTO templateControl) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		templateControl.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.inActiveTemplateControl(templateControl));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/control/active")
	public ResponseEntity<?> activeTemplateControl(Authentication auth, @NonNull @RequestBody TemplateControlDTO templateControl) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		templateControl.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.activeTemplateControl(templateControl));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/control/remove")
	public ResponseEntity<?> deleteTemplateControl(Authentication auth, @NonNull @RequestBody TemplateControlDTO templateControl) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		templateControl.setModifiedBy(loginUserDetails.getUsername());
		return ITRiskResponseEntity
				.success(orgService.deleteTemplateControl(templateControl));
	}

}
