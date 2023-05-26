package com.asymmetrix.grc.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.constants.GRCConstants;
import com.asymmetrix.grc.dto.QuestionDTO;
import com.asymmetrix.grc.service.QuestionService;

@RestController
@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_READ_OR_WRITE)
public class QuestionsController {

	@Resource
	private QuestionService questionService;

	
	@PostMapping("/questions/question")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> save(@Valid @RequestBody(required = true) QuestionDTO questionDTO) {
		questionService.saveOrUpdate(questionDTO);
		return GRCResponseEntity.success(GRCConstants.SAVE_OR_UPDATE_SUCCESS_MESSAGE);
	}

	@PutMapping("/questions/question")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> update(@Valid @RequestBody(required = true) QuestionDTO questionDTO) {
		questionService.saveOrUpdate(questionDTO);
		return GRCResponseEntity.success(GRCConstants.SAVE_OR_UPDATE_SUCCESS_MESSAGE);
	}

	@GetMapping("/{templateId}/section/questions")
	public ResponseEntity<?> findQuestionsByTemplateId(
			@Valid @NotBlank @PathVariable(required = true, value = "templateId") String templateId) {
		return GRCResponseEntity.success(questionService.findQuestionsByTemplateId(templateId));
	}

	@GetMapping("/{templateSectionId}/questions")
	public ResponseEntity<?> findQuestionsBySectionId(
			@Valid @NotBlank @PathVariable(required = true, value = "templateSectionId") String templateSectionId) {
		return GRCResponseEntity.success(questionService.findQuestionsBySectionId(templateSectionId));
	}

	@GetMapping("/questions/question/{questionId}")
	public ResponseEntity<?> findQuestionById(
			@Valid @NotBlank @PathVariable(required = true, value = "questionId") String questionId) {
		return GRCResponseEntity.success(questionService.findQuestionById(questionId));
	}

	@DeleteMapping("/questions/question/{questionId}")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> deleteById(
			@Valid @NotBlank @PathVariable(required = true, value = "questionId") String questionId) {
		questionService.deleteById(questionId);
		return GRCResponseEntity.success(GRCConstants.DELETE_SUCCESS_MESSAGE);
	}
	
	@GetMapping("/{templateSectionId}/questions/count")
	public ResponseEntity<?> findQuestionsCountBySectionId(
			@Valid @NotBlank @PathVariable(required = true, value = "templateSectionId") String templateSectionId) {
		return GRCResponseEntity.success(questionService.findQuestionsCountBySectionId(templateSectionId));
	}
	
	@PutMapping("/questions")
	@PreAuthorize(GRCConstants.HAS_ROLE_TEMPLATE_WRITE)
	public ResponseEntity<?> updateQuestions(@Valid @RequestBody(required = true) List<QuestionDTO> questionDTOs) {
		questionService.saveOrUpdate(questionDTOs);
		return GRCResponseEntity.success(GRCConstants.SAVE_OR_UPDATE_SUCCESS_MESSAGE);
	}

}
