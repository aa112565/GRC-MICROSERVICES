package com.asymmetrix.grc.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

	private String questionId;

	@NotBlank
	private String templateId;

	@NotBlank
	private String templateSectionId;

	@NotNull
	private Integer qsrno;

	@NotNull
	private Integer qtypeId;

	private QuestionTypesDTO questionTypes;

	@NotNull
	private Integer questTypeOptId;

	private QuestionTypeOptionsDTO questionTypeOptions;

	private Boolean isMultiChoice = Boolean.FALSE;

	@Valid
	private List<MultiChoiceOptionsDTO> muiltiChoiceOptions;

	@NotBlank
	private String question;

	private Boolean questionHint = Boolean.FALSE;

	private Boolean justification = Boolean.FALSE;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateSectionId() {
		return templateSectionId;
	}

	public void setTemplateSectionId(String templateSectionId) {
		this.templateSectionId = templateSectionId;
	}

	public Integer getQsrno() {
		return qsrno;
	}

	public void setQsrno(Integer qsrno) {
		this.qsrno = qsrno;
	}

	public Integer getQtypeId() {
		return qtypeId;
	}

	public void setQtypeId(Integer qtypeId) {
		this.qtypeId = qtypeId;
	}

	public Integer getQuestTypeOptId() {
		return questTypeOptId;
	}

	public void setQuestTypeOptId(Integer questTypeOptId) {
		this.questTypeOptId = questTypeOptId;
	}

	public Boolean getIsMultiChoice() {
		return isMultiChoice;
	}

	public void setIsMultiChoice(Boolean isMultiChoice) {
		this.isMultiChoice = isMultiChoice;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<MultiChoiceOptionsDTO> getMuiltiChoiceOptions() {
		return muiltiChoiceOptions;
	}

	public void setMuiltiChoiceOptions(List<MultiChoiceOptionsDTO> muiltiChoiceOptions) {
		this.muiltiChoiceOptions = muiltiChoiceOptions;
	}

	public QuestionTypesDTO getQuestionTypes() {
		return questionTypes;
	}

	public void setQuestionTypes(QuestionTypesDTO questionTypes) {
		this.questionTypes = questionTypes;
	}

	public QuestionTypeOptionsDTO getQuestionTypeOptions() {
		return questionTypeOptions;
	}

	public void setQuestionTypeOptions(QuestionTypeOptionsDTO questionTypeOptions) {
		this.questionTypeOptions = questionTypeOptions;
	}

	public Boolean getQuestionHint() {
		return questionHint;
	}

	public void setQuestionHint(Boolean questionHint) {
		this.questionHint = questionHint;
	}

	public Boolean getJustification() {
		return justification;
	}

	public void setJustification(Boolean justification) {
		this.justification = justification;
	}

	public QuestionDTO() {
		super();
	}

	public QuestionDTO(String questionId, String templateId, String templateSectionId, Integer qsrno, Integer qtypeId,
			Integer questTypeOptId, Boolean isMultiChoice, String question, Boolean questionHint,
			Boolean justification) {
		super();
		this.questionId = questionId;
		this.templateId = templateId;
		this.templateSectionId = templateSectionId;
		this.qsrno = qsrno;
		this.qtypeId = qtypeId;
		this.questTypeOptId = questTypeOptId;
		this.isMultiChoice = isMultiChoice;
		this.question = question;
		this.questionHint = questionHint;
		this.justification = justification;
	}

	public QuestionDTO(QuestionTypesDTO questionTypes, QuestionTypeOptionsDTO questionTypeOptions,
			List<MultiChoiceOptionsDTO> muiltiChoiceOptions) {
		super();
		this.questionTypes = questionTypes;
		this.questionTypeOptions = questionTypeOptions;
		this.muiltiChoiceOptions = muiltiChoiceOptions;
	}

}
