package com.asymmetrix.grc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionTypesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer qtypeId;

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

	public QuestionTypesDTO(int qtypeId, String qtype) {
		super();
		this.qtypeId = qtypeId;
		this.qtype = qtype;
	}

	public QuestionTypesDTO() {
		super();
	}
}
