package com.asymmetrix.grc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "MST_ORG_WEIGHTAGE")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MstOrgWeightage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "N_WEIGHTAGE")
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
