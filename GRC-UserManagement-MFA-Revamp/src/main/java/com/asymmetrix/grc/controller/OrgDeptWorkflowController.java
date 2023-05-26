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
import com.asymmetrix.grc.dto.OrgDeptWorkflowDTO;
import com.asymmetrix.grc.dto.OrganizationDepartmentsDTO;
import com.asymmetrix.grc.service.OrgDeptWorkflowService;

@SuppressWarnings("unused")
@RestController
public class OrgDeptWorkflowController {

	@Autowired
	private OrgDeptWorkflowService orgService;

	private static final String READ_ACTION = "READ-ORG-DEPT-WORKFLOW-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ORG-DEPT-WORKFLOW-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ORG-DEPT-WORKFLOW-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/departments/workflow/findall")
	public ResponseEntity<?> getAllOrgDeptWorkflow(Authentication auth) {		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrgDeptWorkflow(), OrgDeptWorkflowDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/departments/workflow/find/all")
	public ResponseEntity<?> getAllOrgDeptWorkflowByOrgIdAndSubsIdAndDeptId(Authentication auth, @NonNull @RequestBody OrgDeptWorkflowDTO orgDeptWorkflowDto) {
		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrgDeptWorkflowByOrgIdAndSubsIdAndDeptId(orgDeptWorkflowDto), OrgDeptWorkflowDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/org/departments/workflow/find/{id}")
	public ResponseEntity<?> getOrgDeptWorkflowById(Authentication auth, @NonNull @PathVariable(value = "id") long orgSubsDeptId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getOrgDeptWorkflowById(orgSubsDeptId), OrgDeptWorkflowDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/org/departments/workflow/new")
	public ResponseEntity<?> creatOrgDeptWorkflow(Authentication auth, @NonNull @RequestBody OrgDeptWorkflowDTO orgDeptWorkflowDto) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		orgDeptWorkflowDto.setCreatedBy(uname);		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createOrgDeptWorkflow(orgDeptWorkflowDto), OrgDeptWorkflowDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/org/departments/workflow/new/list")
	public ResponseEntity<?> creatOrgDeptWorkflowList(Authentication auth, @NonNull @RequestBody List<OrgDeptWorkflowDTO> orgDeptWorkflowDto) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createOrgDeptWorkflowList(orgDeptWorkflowDto, uname), OrgDeptWorkflowDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/departments/workflow/modify")	
	public ResponseEntity<?> updateOrgDeptWorkflow(Authentication auth, @NonNull @RequestBody OrgDeptWorkflowDTO orgDeptWorkflowDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgDeptWorkflowDto.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateOrgDeptWorkflow(orgDeptWorkflowDto), OrgDeptWorkflowDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/departments/workflow/remove")
	public ResponseEntity<?> deleteOrgDeptWorkflow(Authentication auth, @NonNull @RequestBody OrgDeptWorkflowDTO orgDeptWorkflowDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgDeptWorkflowDto.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.deleteOrgDeptWorkflow(orgDeptWorkflowDto));
	}

}
