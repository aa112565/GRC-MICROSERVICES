package com.asymmetrix.grc.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.constants.GRCConstants;
import com.asymmetrix.grc.dto.TemplateSectionDTO;
import com.asymmetrix.grc.service.TemplateSectionService;

@RestController
@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_READ_OR_WRITE)
public class TemplateSectionController {

	@Resource
	private TemplateSectionService templateSectionService;

	@PostMapping("/sections/section")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> save(@Valid @RequestBody TemplateSectionDTO templateSectionDto) {
		return GRCResponseEntity.success(templateSectionService.saveOrUpdate(templateSectionDto));
	}

	@PutMapping("/sections/section")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> update(@Valid @RequestBody TemplateSectionDTO templateSectionDto) {
		return GRCResponseEntity.success(templateSectionService.saveOrUpdate(templateSectionDto));
	}

	@GetMapping("/sections/section/{sectionId}")
	public ResponseEntity<?> findById(@Valid @NotEmpty @PathVariable(required = true, value = "sectionId") String sectionId) {
		return GRCResponseEntity.success(templateSectionService.findById(sectionId));
	}

	@GetMapping("/{templateId}/sections")
	public ResponseEntity<?> getTemplateSections(
			@Valid	@NotEmpty @PathVariable(required = true, value = "templateId") String templateId) {
		return GRCResponseEntity.success(templateSectionService.findByTemplateId(templateId));
	}

	@GetMapping("/{templateId}/sections/section/names")
	public ResponseEntity<?> getSectionNamesByTemplateId(
			@Valid @NotEmpty @PathVariable(required = true, value = "templateId") String templateId) {
		return GRCResponseEntity.success(templateSectionService.getSectionNamesByTemplateId(templateId));
	}

	@DeleteMapping("/sections/section/{sectionId}")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> deleteById(@Valid @NotEmpty @PathVariable(required = true, value = "sectionId") String sectionId) {
		templateSectionService.deleteById(sectionId);
		return GRCResponseEntity.success(GRCConstants.DELETE_SUCCESS_MESSAGE);
	}
}
