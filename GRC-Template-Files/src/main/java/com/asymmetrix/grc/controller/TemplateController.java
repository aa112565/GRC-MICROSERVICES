package com.asymmetrix.grc.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.config.service.IAuthenticationDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.constants.GRCConstants;
import com.asymmetrix.grc.dto.TemplateDTO;
import com.asymmetrix.grc.service.TemplateSectionService;
import com.asymmetrix.grc.service.TemplateService;

@RestController
@RequestMapping("/templates")
@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_READ_OR_WRITE)
public class TemplateController {

	@Resource
	private TemplateService templateService;

	@Resource
	private TemplateSectionService templateSectionService;

	@Resource
	private IAuthenticationDetails authService;

	@PostMapping("/template")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> save(@Valid @RequestBody(required = true) TemplateDTO templateDto) {
		templateDto.setCreatedBy(authService.getLoginUserDetails().getUsername());
		return GRCResponseEntity.success(templateService.saveOrUpdate(templateDto));
	}

	@PutMapping("/template")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> update(@Valid @RequestBody(required = true) TemplateDTO templateDto) {
		templateDto.setLastUpdatedBy(authService.getLoginUserDetails().getUsername());
		return GRCResponseEntity.success(templateService.saveOrUpdate(templateDto));
	}

	@DeleteMapping("/template/{templateId}")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> delete(
			@Valid @NotBlank @PathVariable(required = true, value = "templateId") String templateId) {
		templateService.deleteById(templateId);
		return GRCResponseEntity.success(GRCConstants.DELETE_SUCCESS_MESSAGE);
	}

	@GetMapping("/template/{templateId}")
	public ResponseEntity<?> get(
			@Valid @NotBlank @PathVariable(required = true, value = "templateId") String templateId) {
		return GRCResponseEntity.success(templateService.findById(templateId));
	}

	@GetMapping("/template/names/{templateName}")
	public ResponseEntity<?> findByTemplateName(
			@Valid @NotBlank @PathVariable(required = true, value = "templateName") String templateName) {
		return GRCResponseEntity.success(templateService.findByTemplateName(templateName));
	}

	@GetMapping("")
	public ResponseEntity<?> getAll() {
		return GRCResponseEntity.success(templateService.getAll());
	}

	@GetMapping("/template/status/{templateStatus}")
	public ResponseEntity<?> findByTemplateStatus(
			@Valid @NotBlank @PathVariable(required = true, value = "templateStatus") String templateStatus) {
		return GRCResponseEntity.success(templateService.findByTemplateStatus(templateStatus));
	}
	
	@GetMapping("/top/{count}/template")
	public ResponseEntity<?> findTemplateByCreateDateWithLimit(@PathVariable(value = "count") int limitByCount) {
		return GRCResponseEntity.success(templateService.findTemplateByCreateDateWithLimit(limitByCount));
	}

}
