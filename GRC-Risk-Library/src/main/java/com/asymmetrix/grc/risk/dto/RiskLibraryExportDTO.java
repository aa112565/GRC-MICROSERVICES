package com.asymmetrix.grc.risk.dto;

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
public class RiskLibraryExportDTO {

	private long riskId;
	private String riskUniqueId;
	private String riskName;
	private String riskDesc;
	private String riskType;
	private String riskEventType;
	private String riskCategory;
	private String riskPrimSource;
	private String riskSecondSource;
	private String riskApprStatus;

//	private Date riskCreationDate;
//	private String riskCreatedBy;
//	private Date riskUpdateDate;
//	private String riskLastUpdatedBy;

	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;

	private String deleteFlag;

	private String inherentImpactRating;
	private String inherentLikelihoodRating;
	private String residualImpactRating;
	private String residualLikelihoodRating;

	public long getRiskId() {
		return riskId;
	}

	public String getRiskName() {
		return riskName;
	}

	public String getRiskDesc() {
		return riskDesc;
	}

	public String getRiskType() {
		return riskType;
	}

	public String getRiskEventType() {
		return riskEventType;
	}

	public String getRiskCategory() {
		return riskCategory;
	}

	public String getRiskPrimSource() {
		return riskPrimSource;
	}

	public String getRiskSecondSource() {
		return riskSecondSource;
	}

	public String getRiskApprStatus() {
		return riskApprStatus;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public String getInherentLikelihoodRating() {
		return inherentLikelihoodRating;
	}

	public String getResidualLikelihoodRating() {
		return residualLikelihoodRating;
	}

	public String getInherentImpactRating() {
		return inherentImpactRating;
	}

	public String getResidualImpactRating() {
		return residualImpactRating;
	}

	public void setRiskId(long riskId) {
		this.riskId = riskId;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public void setRiskDesc(String riskDesc) {
		this.riskDesc = riskDesc;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public void setRiskEventType(String riskEventType) {
		this.riskEventType = riskEventType;
	}

	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}

	public void setRiskPrimSource(String riskPrimSource) {
		this.riskPrimSource = riskPrimSource;
	}

	public void setRiskSecondSource(String riskSecondSource) {
		this.riskSecondSource = riskSecondSource;
	}

	public void setRiskApprStatus(String riskApprStatus) {
		this.riskApprStatus = riskApprStatus;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setInherentLikelihoodRating(String inherentLikelihoodRating) {
		this.inherentLikelihoodRating = inherentLikelihoodRating;
	}

	public void setResidualLikelihoodRating(String residualLikelihoodRating) {
		this.residualLikelihoodRating = residualLikelihoodRating;
	}

	public void setInherentImpactRating(String inherentImpactRating) {
		this.inherentImpactRating = inherentImpactRating;
	}

	public void setResidualImpactRating(String residualImpactRating) {
		this.residualImpactRating = residualImpactRating;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getRiskUniqueId() {
		return riskUniqueId;
	}

	public void setRiskUniqueId(String riskUniqueId) {
		this.riskUniqueId = riskUniqueId;
	}
	
	

}
