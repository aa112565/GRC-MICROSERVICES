package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MULTI_CHOICE_OPTIONS")
public class MultiChoiceOptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "n_mc_id")
	private Integer mcoId;

	@Column(name = "v_question_id", nullable = false)
	private String questionId;

	@Column(name = "v_key", nullable = false)
	private String key;

	@Column(name = "v_value", nullable = false)
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

	public MultiChoiceOptions() {
		super();
	}

	public MultiChoiceOptions(Integer mcoId, String questionId, String key, String value) {
		super();
		this.mcoId = mcoId;
		this.questionId = questionId;
		this.key = key;
		this.value = value;
	}

}
