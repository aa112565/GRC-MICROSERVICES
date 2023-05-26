package com.asymmetrix.grc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.dto.OrganizationHierarchyDTO;
import com.asymmetrix.grc.entity.OrganizationDTO;
import com.asymmetrix.grc.service.DepartmentService;
import com.asymmetrix.grc.service.EmployeeService;
import com.asymmetrix.grc.service.OrganizationService;

@RestController
@RequestMapping({ "/organization" })
@PreAuthorize("isAuthenticated()") 
public class OrganizationHierarchyController {

	@Resource
	OrganizationService organizationService;
	
	@Resource
	DepartmentService departmentService;
	
	@Resource
	EmployeeService employeeService;

	@GetMapping("/hierarchy/version/all")
	public ResponseEntity<GRCResponse<?>> getAllOrganizationVersions() {
		return GRCResponseEntity.success(organizationService.getAllOrganizationVersions());
	}
	
	@PostMapping("/hierarchy/version/create")
	public ResponseEntity<GRCResponse<?>> createOrganizationVersion(Authentication auth, @RequestBody OrganizationDTO organizationDTO) {
		organizationDTO.setCreatedBy(auth.getName());
		organizationDTO = organizationService.createOrganizationVersion(organizationDTO);  		
	    return GRCResponseEntity.success(organizationDTO);
	}
	
	@GetMapping("/hierarchy/version/{version}/level/{level}")
	public ResponseEntity<GRCResponse<?>> getOrganizationHierarchyOfLevel(@PathVariable(required = true) String version, @PathVariable(required = true) int level) {
		return GRCResponseEntity.success(organizationService.getOrganizatinHierarchy(version, level));
	}
	
	@GetMapping("/hierarchy/version/{version}/level/{level}/parent/mapping")
	public ResponseEntity<GRCResponse<?>> getHierarchyParentMapping(@PathVariable(required = true) String version, @PathVariable(required = true) int level) {
		return GRCResponseEntity.success(organizationService.getParentMappingOfVersionAndLevel(version, level));
	}
	
	@GetMapping("/hierarchy/version/{version}/parent/{parentID}/info")
	public ResponseEntity<GRCResponse<?>> getHierarchyParentInfo(@PathVariable(required = true) String version, @PathVariable(required = true) String parentID) {
		return GRCResponseEntity.success(organizationService.getOrganizationParentInformation(version, parentID));
	}
	
	@PostMapping("/hierarchy/version/level/create")
	public ResponseEntity<GRCResponse<?>> createHierarchyLevel(Authentication auth, @RequestBody List<OrganizationHierarchyDTO> organizationHierarchyDTO) {		
		List<OrganizationHierarchyDTO> organizationDTOList = organizationService.createOrganizationHierarchyLevel(organizationHierarchyDTO, auth.getName());  		
	    return GRCResponseEntity.success(organizationDTOList);
	}
	
	@GetMapping("/department/all")
	public ResponseEntity<GRCResponse<?>> getAllDepartments() {
		return GRCResponseEntity.success(departmentService.getAllDepartments());
	}
	
	@GetMapping("/department/{departmentCode}/employees/all")
	public ResponseEntity<GRCResponse<?>> getEmployeesOfDepartment(@PathVariable(required = true) String departmentCode) {
		return GRCResponseEntity.success(employeeService.getEmployeesOfDepartment(departmentCode));
	}
	
	@GetMapping("/employees/directors")
	public ResponseEntity<GRCResponse<?>> getBoardOfDirectors() {
		return GRCResponseEntity.success(employeeService.getBoardOfDirectors());
	}
	
	@GetMapping("/hierarchy/version/{version}/chart")
	public ResponseEntity<GRCResponse<?>> getOrganizatinHierarchyChart(@PathVariable(required = true) String version) {
		return GRCResponseEntity.success(organizationService.getOrganizationChart(version));
	}
	
	@GetMapping("/hierarchy/weightages")
	public ResponseEntity<GRCResponse<?>> getAllWeightages() {
		return GRCResponseEntity.success(organizationService.getAllWeightages());
	}
	
	@GetMapping("/hierarchy/version/{version}/created/levels")
	public int getCreatedMaxLevelOfHierarchy(@PathVariable(required = true) String version) {
		return organizationService.getMaxLevelCompleted(version);
	}

}
