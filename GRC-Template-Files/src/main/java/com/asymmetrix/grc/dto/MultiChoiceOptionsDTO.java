package com.asymmetrix.grc.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiChoiceOptionsDTO {

	private Integer mcoId;

	private String questionId;

	@NotBlank
	private String key;

	@NotBlank
	private String value;

	public Integer getMcoId() {
		return mcoId;
	}

	public void setMcoId(Integer mcoId) {
		this.mcoId = mcoId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MultiChoiceOptionsDTO() {
		super();
	}

	public MultiChoiceOptionsDTO(Integer mcoId, String questionId, String key, String value) {
		super();
		this.mcoId = mcoId;
		this.questionId = questionId;
		this.key = key;
		this.value = value;
	}
	
}
