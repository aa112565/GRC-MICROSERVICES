package com.asymmetrix.asset.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CM_ASSET_SCORE_DESIRED_LEVEL")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreDesiredLevel {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String desiredScoreId;

	@Column(name = "DESIRED_CONFIDENTIALITY_SCORE")
	private String desiredConfidentialityScore;

	@Column(name = "DESIRED_INTEGRITY_SCORE")
	private String desiredIntegrityScore;

	@Column(name = "DESIRED_AVAILABILITY_SCORE")
	private String desiredAvailabilityScore;

	@Column(name = "DESIRED_SCORE")
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
