package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.utils.constants.GRCErrorConstants;
import com.asymmetrix.grc.dto.MultiChoiceOptionsDTO;
import com.asymmetrix.grc.dto.QuestionDTO;
import com.asymmetrix.grc.dto.QuestionTypeOptionsDTO;
import com.asymmetrix.grc.dto.QuestionTypesDTO;
import com.asymmetrix.grc.entity.MultiChoiceOptions;
import com.asymmetrix.grc.entity.Questions;
import com.asymmetrix.grc.repository.MultiChoiceOptionsRepository;
import com.asymmetrix.grc.repository.QuestionTypeOptionsRepository;
import com.asymmetrix.grc.repository.QuestionTypesRepository;
import com.asymmetrix.grc.repository.QuestionsRepository;
import com.asymmetrix.grc.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Resource
	QuestionsRepository questionRepo;

	@Resource
	QuestionTypesRepository questionTypesRepo;

	@Resource
	QuestionTypeOptionsRepository questionTypeOptionsRepo;

	@Resource
	MultiChoiceOptionsRepository multiChoiceOptRepo;

	@Override
	public void saveOrUpdate(QuestionDTO questionDTO) {
		QuestionDTO qDTO = MapperUtils.mapToTargetClass(
				questionRepo.save(MapperUtils.mapToTargetClass(questionDTO, Questions.class)), QuestionDTO.class);
		if (qDTO.getIsMultiChoice()) {
			questionDTO.getMuiltiChoiceOptions().stream().forEach(e -> e.setQuestionId(qDTO.getQuestionId()));
			if (!ObjectUtils.isEmpty(questionDTO.getQuestionId())) {
				multiChoiceOptRepo.deleteByQuestionId(qDTO.getQuestionId());
			}
			multiChoiceOptRepo.saveAll(
					MapperUtils.mapToTargetClass(questionDTO.getMuiltiChoiceOptions(), MultiChoiceOptions.class));
		}
	}

	public List<QuestionDTO> findQuestionsByTemplateId(String templateId) {
		List<QuestionDTO> questionDTOs = GRCUtils.isValid(questionRepo.findQuestionsByTemplateId(templateId),
				GRCErrorConstants.ENTITY_NOT_FOUND + templateId);
		questionDTOs.stream().forEach(q -> setQtypeAndQtypeOptions(q));
		return questionDTOs;
	}

	public List<QuestionDTO> findQuestionsBySectionId(String templateSectionId) {
		List<QuestionDTO> questionDTOs = GRCUtils.isValid(questionRepo.findQuestionsBySectionId(templateSectionId),
				GRCErrorConstants.ENTITY_NOT_FOUND + templateSectionId);
		questionDTOs.stream().forEach(q -> setQtypeAndQtypeOptions(q));
		return questionDTOs;
	}

	public QuestionDTO findQuestionById(String questionId) {
		QuestionDTO questionDTO = MapperUtils.mapToTargetClass(questionRepo.findById(questionId).orElseThrow(
				() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + questionId)), QuestionDTO.class);
		setQtypeAndQtypeOptions(questionDTO);
		return questionDTO;
	}

	private void setQtypeAndQtypeOptions(QuestionDTO questionDTO) {
		questionDTO.setQuestionTypes(getQuestionTypeById(questionDTO.getQtypeId()));
		questionDTO.setQuestionTypeOptions(getQuestTypeOptById(questionDTO.getQuestTypeOptId()));
		if (questionDTO.getIsMultiChoice()) {
			questionDTO.setMuiltiChoiceOptions(getMultiChoiceOptions(questionDTO.getQuestionId()));
		}
	}

	private QuestionTypesDTO getQuestionTypeById(Integer qtypeId) {
		return MapperUtils.mapToTargetClass(questionTypesRepo.findById(qtypeId).orElseThrow(
				() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + qtypeId)), QuestionTypesDTO.class);
	}

	private QuestionTypeOptionsDTO getQuestTypeOptById(Integer questTypeOptId) {
		return MapperUtils.mapToTargetClass(
				questionTypeOptionsRepo.findById(questTypeOptId)
						.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + questTypeOptId)),
				QuestionTypeOptionsDTO.class);
	}

	private List<MultiChoiceOptionsDTO> getMultiChoiceOptions(String questionId) {
		return MapperUtils.mapToTargetClass(multiChoiceOptRepo.findByQuestionId(questionId),
				MultiChoiceOptionsDTO.class);
	}

	@Override
	public void deleteById(String questionId) {
		 questionRepo.deleteById(questionId);
	}

	@Override
	public Integer findQuestionsCountBySectionId(String templateSectionId) {
		return questionRepo.countByTemplateSectionId(templateSectionId);
	}
	
	@Override
	public void saveOrUpdate(List<QuestionDTO> questionDTOs) {
		MapperUtils.mapToTargetClass(questionRepo.saveAll(MapperUtils.mapToTargetClass(questionDTOs, Questions.class)),
				QuestionDTO.class);
	}
	
}
