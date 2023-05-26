package com.asymmetrix.asset.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetScoreImliedLevelDTO {

	private String impliedScoreId;
	private String impliedConfidentialityScore;
	private String impliedAvailabilityScore;
	private String impliedIntegrityScore;
	private String impliedScore;

	public String getImpliedScoreId() {
		return impliedScoreId;
	}

	public void setImpliedScoreId(String impliedScoreId) {
		this.impliedScoreId = impliedScoreId;
	}

	public String getImpliedConfidentialityScore() {
		return impliedConfidentialityScore;
	}

	public void setImpliedConfidentialityScore(String impliedConfidentialityScore) {
		this.impliedConfidentialityScore = impliedConfidentialityScore;
	}

	public String getImpliedAvailabilityScore() {
		return impliedAvailabilityScore;
	}

	public void setImpliedAvailabilityScore(String impliedAvailabilityScore) {
		this.impliedAvailabilityScore = impliedAvailabilityScore;
	}

	public String getImpliedIntegrityScore() {
		return impliedIntegrityScore;
	}

	public void setImpliedIntegrityScore(String impliedIntegrityScore) {
		this.impliedIntegrityScore = impliedIntegrityScore;
	}

	public String getImpliedScore() {
		return impliedScore;
	}

	public void setImpliedScore(String impliedScore) {
		this.impliedScore = impliedScore;
	}

}
