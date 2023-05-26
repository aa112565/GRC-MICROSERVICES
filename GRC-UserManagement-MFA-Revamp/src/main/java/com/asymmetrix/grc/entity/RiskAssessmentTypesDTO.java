package com.asymmetrix.grc.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskAssessmentTypesDTO implements Serializable {

	private static final long serialVersionUID = 1L;		
	private long id;	
	private long assessmentType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(long assessmentType) {
		this.assessmentType = assessmentType;
	}

}
