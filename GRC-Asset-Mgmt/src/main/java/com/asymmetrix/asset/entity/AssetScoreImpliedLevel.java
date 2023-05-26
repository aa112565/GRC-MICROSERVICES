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
@Table(name = "CM_ASSET_SCORE_IMPLIED_LEVEL")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreImpliedLevel {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String impliedScoreId;

	@Column(name = "IMPLIED_CONFIDENTIALITY_SCORE")
	private String impliedConfidentialityScore;

	@Column(name = "IMPLIED_AVAILABILITY_SCORE")
	private String impliedAvailabilityScore;

	@Column(name = "IMPLIED_INTEGRITY_SCORE")
	private String impliedIntegrityScore;

	@Column(name = "IMPLIED_SCORE")
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
