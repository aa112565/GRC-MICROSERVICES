package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LikelihoodRiskRatingDTO {

	private long srno;
	private String likeLihoodRating;
	private String likeLihoodRatingScoreVal;
	private String valueWithScore;

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

	public String getValueWithScore() {
		return valueWithScore;
	}

	public void setValueWithScore(String valueWithScore) {
		this.valueWithScore = valueWithScore;
	}

	public LikelihoodRiskRatingDTO() {
		super();
	}

	public LikelihoodRiskRatingDTO(long srno, String likeLihoodRating, String likeLihoodRatingScoreVal) {
		super();
		this.srno = srno;
		this.likeLihoodRating = likeLihoodRating;
		this.likeLihoodRatingScoreVal = likeLihoodRatingScoreVal;
		this.valueWithScore = likeLihoodRating.concat("-").concat(likeLihoodRatingScoreVal);
	}

}
