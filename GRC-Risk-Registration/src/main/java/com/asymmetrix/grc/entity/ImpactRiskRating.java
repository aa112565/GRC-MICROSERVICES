package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RR_IMPACT_RISK_RATING", schema = "GRC_TEST_ENV_DB")
public class ImpactRiskRating {

	@Id
	@Column(name = "N_SRNO")
	private long srno;

	@Column(name = "V_IMPACT_RATING", nullable = false)
	private String impactRating;
	
	@Column(name = "V_IMPACT_RATING_SCORE", nullable = false)
	private String impactRatingScoreVal;

	public long getSrno() {
		return srno;
	}

	public void setSrno(long srno) {
		this.srno = srno;
	}

	public String getImpactRating() {
		return impactRating;
	}

	public void setImpactRating(String impactRating) {
		this.impactRating = impactRating;
	}
	
	public String getImpactRatingScoreVal() {
		return impactRatingScoreVal;
	}

	public void setImpactRatingScoreVal(String impactRatingScoreVal) {
		this.impactRatingScoreVal = impactRatingScoreVal;
	}

	public ImpactRiskRating() {
		super();
	}

}
