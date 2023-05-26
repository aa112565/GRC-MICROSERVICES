package com.asymmetrix.asset.entity;

//import java.io.File;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "CM_ASSET_SCORING")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetScoring extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIASCORESEQUENCE")
	@SequenceGenerator(name = "CIASCORESEQUENCE", sequenceName = "CIA_SCORE_SEQUENCE", allocationSize = 1)
	@Column(name = "ID")
	private long ciaScoreId;

	@Column(name = "ASSET_ID")
	private String assetId;

	@Column(name = "DESIRED_CONFIDENTIALITY_SCORE")
	private String desiredConfidentialityScore;

	@Column(name = "DESIRED_AVAILABILITY_SCORE")
	private String desiredAvailabilityScore;

	@Column(name = "DESIRED_INTEGRITY_SCORE")
	private String desiredIntegrityScore;

	@Column(name = "IMPLIED_CONFIDENTIALITY_SCORE")
	private String impliedConfidentialityScore;

	@Column(name = "IMPLIED_AVAILABILITY_SCORE")
	private String impliedAvailabilityScore;

	@Column(name = "IMPLIED_INTEGRITY_SCORE")
	private String impliedIntegrityScore;

//	@Column(name = "MINIMUM_COMPLIANCE_SCORE")
//	private String minimumComplianceScore;	

//	@Column(name = "MAXIMUM_COMPLIANCE_SCORE")
//	private String maximumComplianceScore;

	@Column(name = "MINIMUM_COMPLIANCE_SCORE")
	private String minimumComplianceClassRecomanded;

	@Column(name = "CHOSEN_MINIMUM_COMPLIANCE_SCORE")
	private String choosenMinimumComplianceClass;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	public long getCiaScoreId() {
		return ciaScoreId;
	}

	public void setCiaScoreId(long ciaScoreId) {
		this.ciaScoreId = ciaScoreId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
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
	/*
	 * public String getMinimumComplianceScore() { return minimumComplianceScore; }
	 * 
	 * public void setMinimumComplianceScore(String minimumComplianceScore) {
	 * this.minimumComplianceScore = minimumComplianceScore; }
	 * 
	 * public String getMaximumComplianceScore() { return maximumComplianceScore; }
	 * 
	 * public void setMaximumComplianceScore(String maximumComplianceScore) {
	 * this.maximumComplianceScore = maximumComplianceScore; }
	 * 
	 */

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
