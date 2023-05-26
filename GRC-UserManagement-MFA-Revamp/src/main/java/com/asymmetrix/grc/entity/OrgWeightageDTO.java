package com.asymmetrix.grc.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrgWeightageDTO implements Serializable {

	private static final long serialVersionUID = 1L;	
	private long id;	
	private long weightage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getWeightage() {
		return weightage;
	}

	public void setWeightage(long weightage) {
		this.weightage = weightage;
	}

}
