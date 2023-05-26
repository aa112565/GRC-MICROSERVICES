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
import com.asymmetrix.grc.dto.OrgDepartmentsDDDTO;
import com.asymmetrix.grc.dto.OrganizationDepartmentsDTO;
import com.asymmetrix.grc.service.OrganizationDepartmentService;

@SuppressWarnings("unused")
@RestController
public class OrganizationDepartmentController {

	@Autowired
	private OrganizationDepartmentService orgService;

	private static final String READ_ACTION = "READ-ORG-SUBSIDAIARY-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-ORG-SUBSIDAIARY-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ORG-SUBSIDAIARY-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/subs/departments/findall")
	public ResponseEntity<?> getAllOrgSubsDepartments(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllOrgSubsidiaryDepartments(), OrganizationDepartmentsDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/subs/departments/find/all")
	public ResponseEntity<?> getAllOrgSubsidiaryDepartments(Authentication auth, @NonNull @RequestBody OrganizationDepartmentsDTO orgSubsDeptDto) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllByOrganizationIdAndSubsidiaryId(orgSubsDeptDto), OrganizationDepartmentsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/org/subs/departments/dropdown")
	public ResponseEntity<?> getOrgSubsidiaryDepartmentsDropdown(Authentication auth, @NonNull @RequestBody OrganizationDepartmentsDTO orgSubsDeptDto) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getOrgSubsidiaryDepartmentsDropdown(orgSubsDeptDto), OrgDepartmentsDDDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/org/subs/departments/find/{id}")
	public ResponseEntity<?> getOrgSubsidiaryDepartmentsById(Authentication auth, @NonNull @PathVariable(value = "id") long orgSubsDeptId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getOrgSubsidiaryDepartmentsById(orgSubsDeptId), OrganizationDepartmentsDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/org/subs/departments/new")
	public ResponseEntity<?> creatOrgSubsidiaryDepartments(Authentication auth, @NonNull @RequestBody OrganizationDepartmentsDTO orgSubsDeptDto) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		orgSubsDeptDto.setCreatedBy(uname);		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createOrgSubsidiaryDepartments(orgSubsDeptDto), OrganizationDepartmentsDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/org/subs/departments/new/list")
	public ResponseEntity<?> creatOrgSubsidiaryDepartmentsList(Authentication auth, @NonNull @RequestBody List<OrganizationDepartmentsDTO> orgSubsDeptDtoList) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createOrgSubsidiaryDepartmentsList(orgSubsDeptDtoList, uname), OrganizationDepartmentsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/departments/modify")	
	public ResponseEntity<?> updateOrgSubsidiaryDepartments(Authentication auth, @NonNull @RequestBody OrganizationDepartmentsDTO orgSubsDeptDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubsDeptDto.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateOrgSubsidiaryDepartments(orgSubsDeptDto), OrganizationDepartmentsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/departments/remove")
	public ResponseEntity<?> deleteOrgSubsidiaryDepartments(Authentication auth, @NonNull @RequestBody OrganizationDepartmentsDTO orgSubsDeptDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubsDeptDto.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.deleteOrgSubsidiaryDepartments(orgSubsDeptDto));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/departments/active")
	public ResponseEntity<?> activeOrgSubsidiaryDepartments(Authentication auth, @NonNull @RequestBody OrganizationDepartmentsDTO orgSubsDeptDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubsDeptDto.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.activeOrgSubsidiaryDepartments(orgSubsDeptDto));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/org/subs/departments/inactive")
	public ResponseEntity<?> inActiveOrgSubsidiaryDepartments(Authentication auth, @NonNull @RequestBody OrganizationDepartmentsDTO orgSubsDeptDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		orgSubsDeptDto.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.inActiveOrgSubsidiaryDepartments(orgSubsDeptDto));
	}

}
