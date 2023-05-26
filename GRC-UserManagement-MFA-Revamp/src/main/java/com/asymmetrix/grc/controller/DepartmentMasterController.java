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
import com.asymmetrix.grc.dto.DepartmentMasterDTO;
import com.asymmetrix.grc.dto.DeptMasterDTO;
import com.asymmetrix.grc.service.DepartmentMasterService;

@SuppressWarnings("unused")
@RestController

public class DepartmentMasterController {

	@Autowired
	private DepartmentMasterService orgService;

	private static final String READ_ACTION = "READ-DEPARTMENTS-MASTER-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-DEPARTMENTS-MASTER-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-DEPARTMENTS-MASTER-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/department/find/all")
	public ResponseEntity<?> getAllDepartment(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllDepartment(), DepartmentMasterDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)	
	@GetMapping("/department/find/{id}")
	public ResponseEntity<?> getDepartmentById(Authentication auth, @NonNull @PathVariable(value = "id") long departmentId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getDepartmentById(departmentId), DepartmentMasterDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/department/dropdown")
	public ResponseEntity<?> getAllDepartmentDD(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllDepartmentDD(), DeptMasterDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/department/new")
	public ResponseEntity<?> creatDepartment(Authentication auth, @NonNull @RequestBody DepartmentMasterDTO departmentMaster) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		departmentMaster.setCreatedBy(uname);		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createDepartment(departmentMaster), DepartmentMasterDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/department/new/list")
	public ResponseEntity<?> creatDepartmentList(Authentication auth, @NonNull @RequestBody List<DepartmentMasterDTO> departmentMasterList) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();	
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createDepartmentList(departmentMasterList, uname), DepartmentMasterDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/department/modify")	
	public ResponseEntity<?> updateDepartment(Authentication auth, @NonNull @RequestBody DepartmentMasterDTO departmentMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		departmentMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateDepartment(departmentMaster), DepartmentMasterDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/department/remove")
	public ResponseEntity<?> deleteDepartment(Authentication auth, @NonNull @RequestBody DepartmentMasterDTO departmentMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		departmentMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.deleteDepartment(departmentMaster));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/department/active")
	public ResponseEntity<?> activeDepartment(Authentication auth, @NonNull @RequestBody DepartmentMasterDTO departmentMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		departmentMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.activeDepartment(departmentMaster));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/department/inactive")
	public ResponseEntity<?> inActiveDepartment(Authentication auth, @NonNull @RequestBody DepartmentMasterDTO departmentMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		departmentMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.inActiveDepartment(departmentMaster));
	}
}
