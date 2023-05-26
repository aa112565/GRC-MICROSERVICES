package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RR_RESIDUAL_RISK_RATING_MATRIX", schema = "GRC_TEST_ENV_DB")
public class ResidualRiskRatingMatrix {

	@Id
	@Column(name = "N_SRNO")
	private long srno;

	@Column(name = "V_IMPACT")
	private String impact;

	@Column(name = "V_LIKELIHOOD")
	private String likelihood;

	@Column(name = "V_RISK_RATING")
	private String riskRating;

	public long getSrno() {
		return srno;
	}

	public void setSrno(long srno) {
		this.srno = srno;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getLikelihood() {
		return likelihood;
	}

	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}

	public String getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(String riskRating) {
		this.riskRating = riskRating;
	}

	public ResidualRiskRatingMatrix() {
		super();
	}

}
