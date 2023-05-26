package com.asymmetrix.asset.dto;

import java.util.Date;

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
public class AssetScoringDTO {

	private long ciaScoreId;
	private String assetId;
	private String desiredConfidentialityScore;
	private String desiredAvailabilityScore;
	private String desiredIntegrityScore;
	private String impliedConfidentialityScore;
	private String impliedAvailabilityScore;
	private String impliedIntegrityScore;
	private String minimumComplianceClassRecomanded;
//	private String minimumComplianceScore;
//	private String maximumComplianceScore;	
//	private String choosenMinimumComplianceScore;
//	private String choosenMaximumComplianceScore;	
	private String choosenMinimumComplianceClass;
	private String comments;
	private String status;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	private String activeFlag;
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
	 * public void setMinimumComplianceScore(String minimumComplianceScore) {
	 * this.minimumComplianceScore = minimumComplianceScore; } public String
	 * getMaximumComplianceScore() { return maximumComplianceScore; } public void
	 * setMaximumComplianceScore(String maximumComplianceScore) {
	 * this.maximumComplianceScore = maximumComplianceScore; }
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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
