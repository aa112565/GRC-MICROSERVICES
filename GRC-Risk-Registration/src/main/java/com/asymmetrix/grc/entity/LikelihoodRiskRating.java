package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RR_LIKELIHOOD_RISK_RATING", schema = "GRC_TEST_ENV_DB")
public class LikelihoodRiskRating {

	@Id
	@Column(name = "N_SRNO")
	private long srno;

	@Column(name = "V_LIKELIHOOD_RATING", nullable = false)
	private String likeLihoodRating;

	@Column(name = "V_LIKELIHOOD_RATING_SCORE", nullable = false)
	private String likeLihoodRatingScoreVal;

	public long getSrno() {
		return srno;
	}

	public void setSrno(long srno) {
		this.srno = srno;
	}

	public String getLikeLihoodRating() {
		return likeLihoodRating;
	}

	public void setLikeLihoodRating(String likeLihoodRating) {
		this.likeLihoodRating = likeLihoodRating;
	}

	public String getLikeLihoodRatingScoreVal() {
		return likeLihoodRatingScoreVal;
	}

	public void setLikeLihoodRatingScoreVal(String likeLihoodRatingScoreVal) {
		this.likeLihoodRatingScoreVal = likeLihoodRatingScoreVal;
	}

	public LikelihoodRiskRating() {
		super();
	}

}
