package com.asymmetrix.grc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.asymmetrix.grc.entity.seq.QuestionIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "QUESTIONS")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Questions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen_seq")
	@GenericGenerator(name = "idGen_seq", strategy = "com.asymmetrix.grc.entity.seq.QuestionIdGenerator", parameters = {
			@Parameter(name = QuestionIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = QuestionIdGenerator.VALUE_PREFIX_PARAMETER, value = "QT_"),
			@Parameter(name = QuestionIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%1d") })
	@Column(name = "v_question_id")
	private String questionId;

	@Column(name = "v_template_id", updatable = false, nullable = false)
	private String templateId;

	@Column(name = "v_template_section_id", updatable = false, nullable = false)
	private String templateSectionId;

	@Column(name = "n_qsrno", nullable = false)
	private Integer qsrno;

	@Column(name = "n_qtype_id", nullable = false)
	private Integer qtypeId;

	@Column(name = "n_quest_type_opt_id", nullable = false)
	private Integer questTypeOptId;

	@Column(name = "b_is_multi_choice", nullable = false)
	private Boolean isMultiChoice = Boolean.FALSE;

	@Column(name = "v_question", nullable = false)
	private String question;

	@Column(name = "b_question_hint", nullable = false)
	private Boolean questionHint = Boolean.FALSE;
	
	@Column(name = "b_justification", nullable = false)
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

	public Questions() {
		super();
	}

	public Questions(String questionId, String templateId, String templateSectionId, Integer qsrno, Integer qtypeId,
			Integer questTypeOptId, Boolean isMultiChoice, String question, Boolean questionHint, Boolean justification) {
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

}
