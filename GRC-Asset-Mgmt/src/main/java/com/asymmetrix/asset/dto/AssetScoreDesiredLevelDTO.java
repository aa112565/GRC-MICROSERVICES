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
public class AssetScoreDesiredLevelDTO {

	private String desiredScoreId;
	private String desiredConfidentialityScore;
	private String desiredAvailabilityScore;
	private String desiredIntegrityScore;
	private String desiredScore;

	public String getDesiredScoreId() {
		return desiredScoreId;
	}

	public void setDesiredScoreId(String desiredScoreId) {
		this.desiredScoreId = desiredScoreId;
	}

	public String getDesiredConfidentialityScore() {
		return desiredConfidentialityScore;
	}

	public void setDesiredConfidentialityScore(String desiredConfidentialityScore) {
		this.desiredConfidentialityScore = desiredConfidentialityScore;
	}

	public String getDesiredAvailabilityScore() {
		return desiredAvailabilityScore;
	}

	public void setDesiredAvailabilityScore(String desiredAvailabilityScore) {
		this.desiredAvailabilityScore = desiredAvailabilityScore;
	}

	public String getDesiredIntegrityScore() {
		return desiredIntegrityScore;
	}

	public void setDesiredIntegrityScore(String desiredIntegrityScore) {
		this.desiredIntegrityScore = desiredIntegrityScore;
	}

	public String getDesiredScore() {
		return desiredScore;
	}

	public void setDesiredScore(String desiredScore) {
		this.desiredScore = desiredScore;
	}

}
