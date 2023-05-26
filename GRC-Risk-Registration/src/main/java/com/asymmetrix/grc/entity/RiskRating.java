package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RR_RISK_RATING", schema = "GRC_TEST_ENV_DB")
public class RiskRating {

	@Id
	@Column(name = "N_SRNO")
	private long srno;

	@Column(name = "V_RISK_RATING")
	private String riskRatingVal;

	@Column(name = "V_RISK_RATING_SCORE")
	private String riskRatingScoreVal;
	
	public long getSrno() {
		return srno;
	}

	public void setSrno(long srno) {
		this.srno = srno;
	}

	public String getRiskRatingVal() {
		return riskRatingVal;
	}

	public void setRiskRatingVal(String riskRatingVal) {
		this.riskRatingVal = riskRatingVal;
	}

	public String getRiskRatingScoreVal() {
		return riskRatingScoreVal;
	}

	public void setRiskRatingScoreVal(String riskRatingScoreVal) {
		this.riskRatingScoreVal = riskRatingScoreVal;
	}

	public RiskRating() {
		super();
	}

}
