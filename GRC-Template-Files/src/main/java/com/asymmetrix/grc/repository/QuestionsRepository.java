package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.QuestionDTO;
import com.asymmetrix.grc.entity.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, String> {

	@Query("Select new com.asymmetrix.grc.dto.QuestionDTO(q.questionId, q.templateId, q.templateSectionId, q.qsrno, q.qtypeId,"
			+ "	q.questTypeOptId, q.isMultiChoice, q.question, q.questionHint, q.justification) FROM Questions q"
			+ " WHERE q.templateId = :templateId")
	public List<QuestionDTO> findQuestionsByTemplateId(String templateId);

	@Query("Select new com.asymmetrix.grc.dto.QuestionDTO(q.questionId, q.templateId, q.templateSectionId, q.qsrno, q.qtypeId,"
			+ " q.questTypeOptId, q.isMultiChoice, q.question, q.questionHint, q.justification) FROM Questions q WHERE q.templateSectionId = :templateSectionId"
			+ " ORDER BY q.qsrno ASC")
	public List<QuestionDTO> findQuestionsBySectionId(String templateSectionId);
	
	public Integer countByTemplateSectionId(String templateSectionId);

}
