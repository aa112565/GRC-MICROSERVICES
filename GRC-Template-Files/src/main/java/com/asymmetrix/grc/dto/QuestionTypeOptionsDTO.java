package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionTypeOptionsDTO {

	private Integer questTypeOptId;

	private Integer qtypeId;

	private String questTypeOptKey;

	private String questTypeOptValue;

	public int getQuestTypeOptId() {
		return questTypeOptId;
	}

	public void setQuestTypeOptId(int questTypeOptId) {
		this.questTypeOptId = questTypeOptId;
	}

	public int getQtypeId() {
		return qtypeId;
	}

	public void setQtypeId(int qtypeId) {
		this.qtypeId = qtypeId;
	}

	public String getQuestTypeOptKey() {
		return questTypeOptKey;
	}

	public void setQuestTypeOptKey(String questTypeOptKey) {
		this.questTypeOptKey = questTypeOptKey;
	}

	public String getQuestTypeOptValue() {
		return questTypeOptValue;
	}

	public void setQuestTypeOptValue(String questTypeOptValue) {
		this.questTypeOptValue = questTypeOptValue;
	}

	public QuestionTypeOptionsDTO(int questTypeOptId, int qtypeId, String questTypeOptKey, String questTypeOptValue) {
		super();
		this.questTypeOptId = questTypeOptId;
		this.qtypeId = qtypeId;
		this.questTypeOptKey = questTypeOptKey;
		this.questTypeOptValue = questTypeOptValue;
	}

	public QuestionTypeOptionsDTO() {
		super();
	}

}
