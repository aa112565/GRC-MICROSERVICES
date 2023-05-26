package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_TYPES_OPTIONS")
public class QuestionTypeOptions {

	@Id
	@Column(name = "n_quest_type_opt_id")
	private Integer questTypeOptId;

	@Column(name = "n_qtype_id")
	private Integer qtypeId;

	@Column(name = "v_quest_type_opt_key")
	private String questTypeOptKey;

	@Column(name = "v_quest_type_opt_value")
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

	public QuestionTypeOptions(int questTypeOptId, int qtypeId, String questTypeOptKey, String questTypeOptValue) {
		super();
		this.questTypeOptId = questTypeOptId;
		this.qtypeId = qtypeId;
		this.questTypeOptKey = questTypeOptKey;
		this.questTypeOptValue = questTypeOptValue;
	}

	public QuestionTypeOptions() {
		super();
	}

}
