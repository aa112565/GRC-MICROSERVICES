package com.asymmetrix.grc.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.constants.GRCConstants;
import com.asymmetrix.grc.service.QuestionTypeOptionsService;
import com.asymmetrix.grc.service.QuestionTypesService;

@RestController
@RequestMapping("/question")
@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_READ_OR_WRITE)
public class QuestionTypesController {

	@Resource
	private QuestionTypesService questionTypeService;
	
	@Resource
	private QuestionTypeOptionsService questionTypeOptionsService;

	@GetMapping("/types")
	public ResponseEntity<?> getAll() {
		return GRCResponseEntity.success(questionTypeService.getAllTypes());
	}
	
	@GetMapping("/types/{typeId}/options")
	public ResponseEntity<?> getOptionsById(@Valid @NotBlank @PathVariable(required = true, value = "typeId") Integer typeId) {
		return GRCResponseEntity.success(questionTypeOptionsService.findByQtypeId(typeId));
	}

}
