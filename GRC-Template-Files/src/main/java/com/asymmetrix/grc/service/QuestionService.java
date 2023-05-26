package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.QuestionDTO;

public interface QuestionService {

	public void saveOrUpdate(QuestionDTO questionDTO);

	public List<QuestionDTO> findQuestionsByTemplateId(String templateId);

	public List<QuestionDTO> findQuestionsBySectionId(String templateSectionId);
	
	public QuestionDTO findQuestionById(String questionId);
	
	public void deleteById(String questionId);

	public Integer findQuestionsCountBySectionId(String templateSectionId);
	
	public void saveOrUpdate(List<QuestionDTO> questionDTOs);
	
}
