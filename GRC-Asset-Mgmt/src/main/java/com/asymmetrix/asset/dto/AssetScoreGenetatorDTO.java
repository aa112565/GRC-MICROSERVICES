package com.asymmetrix.asset.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AssetScoreGenetatorDTO {

	private String desiredConfidentialityScore;
	private String desiredAvailabilityScore;
	private String desiredIntegrityScore;
	private String impliedConfidentialityScore;
	private String impliedAvailabilityScore;
	private String impliedIntegrityScore;

//	private String desiredComplianceScore;
//	private String impliedComplianceScore;

	private String minimumComplianceClassRecomanded;
	private String choosenMinimumComplianceClass;

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

	public String getMinimumComplianceClassRecomanded() {
		return minimumComplianceClassRecomanded;
	}

	public void setMinimumComplianceClassRecomanded(String minimumComplianceClassRecomanded) {
		this.minimumComplianceClassRecomanded = minimumComplianceClassRecomanded;
	}

	public String getChoosenMinimumComplianceClass() {
		return choosenMinimumComplianceClass;
	}

	public void setChoosenMinimumComplianceClass(String choosenMinimumComplianceClass) {
		this.choosenMinimumComplianceClass = choosenMinimumComplianceClass;
	}

}
