package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImpactRiskRatingDTO {
	
	private long srno;
	private String impactRating;
	private String impactRatingScoreVal;
	private String valueWithScore;

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

	public String getValueWithScore() {
		return valueWithScore;
	}

	public void setValueWithScore(String valueWithScore) {
		this.valueWithScore = valueWithScore;
	}

	public ImpactRiskRatingDTO() {
		super();
	}

	public ImpactRiskRatingDTO(long srno, String impactRating, String impactRatingScoreVal) {
		super();
		this.srno = srno;
		this.impactRating = impactRating;
		this.impactRatingScoreVal = impactRatingScoreVal;
		this.valueWithScore = impactRating.concat("-").concat(impactRatingScoreVal);
	}
	
}
