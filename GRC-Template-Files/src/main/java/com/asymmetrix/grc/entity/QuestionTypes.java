package com.asymmetrix.grc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS_TYPES")
public class QuestionTypes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_qtype_id")
	private Integer qtypeId;

	@Column(name = "v_qtype")
	private String qtype;

	public int getQtypeId() {
		return qtypeId;
	}

	public void setQtypeId(int qtypeId) {
		this.qtypeId = qtypeId;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public QuestionTypes(int qtypeId, String qtype) {
		super();
		this.qtypeId = qtypeId;
		this.qtype = qtype;
	}

	public QuestionTypes() {
		super();
	}
}
