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
public class RiskRegisterActiveRiskScoringListDTO {

	private String riskRegId;
	private String wsId;
	private String deptId;
	private long riskId;
	private String riskUniqueId;
	private String riskName;
	private String riskDesc;
	private String inherentRiskRating;
	private String inherentLikelihoodRating;
	private String inherentImpactRating;
	private String residualRiskRating;
	private String ownerName;
	private String approvalInitStatus;
	private String riskType;
	private String riskEventType;
	private String riskCategory;
	private String riskPrimSource;
	private String riskSecondSource;
	private String riskApprStatus;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String deleteFlag;

	public String getRiskRegId() {
		return riskRegId;
	}

	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}

	public String getWsId() {
		return wsId;
	}

	public void setWsId(String wsId) {
		this.wsId = wsId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public long getRiskId() {
		return riskId;
	}

	public void setRiskId(long riskId) {
		this.riskId = riskId;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getRiskDesc() {
		return riskDesc;
	}

	public void setRiskDesc(String riskDesc) {
		this.riskDesc = riskDesc;
	}

	public String getInherentRiskRating() {
		return inherentRiskRating;
	}

	public void setInherentRiskRating(String inherentRiskRating) {
		this.inherentRiskRating = inherentRiskRating;
	}

	public String getInherentLikelihoodRating() {
		return inherentLikelihoodRating;
	}

	public void setInherentLikelihoodRating(String inherentLikelihoodRating) {
		this.inherentLikelihoodRating = inherentLikelihoodRating;
	}

	public String getInherentImpactRating() {
		return inherentImpactRating;
	}

	public void setInherentImpactRating(String inherentImpactRating) {
		this.inherentImpactRating = inherentImpactRating;
	}

	public String getResidualRiskRating() {
		return residualRiskRating;
	}

	public void setResidualRiskRating(String residualRiskRating) {
		this.residualRiskRating = residualRiskRating;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getRiskEventType() {
		return riskEventType;
	}

	public void setRiskEventType(String riskEventType) {
		this.riskEventType = riskEventType;
	}

	public String getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}

	public String getRiskPrimSource() {
		return riskPrimSource;
	}

	public void setRiskPrimSource(String riskPrimSource) {
		this.riskPrimSource = riskPrimSource;
	}

	public String getRiskSecondSource() {
		return riskSecondSource;
	}

	public void setRiskSecondSource(String riskSecondSource) {
		this.riskSecondSource = riskSecondSource;
	}

	public String getRiskApprStatus() {
		return riskApprStatus;
	}

	public void setRiskApprStatus(String riskApprStatus) {
		this.riskApprStatus = riskApprStatus;
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

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRiskUniqueId() {
		return riskUniqueId;
	}

	public void setRiskUniqueId(String riskUniqueId) {
		this.riskUniqueId = riskUniqueId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getApprovalInitStatus() {
		return approvalInitStatus;
	}

	public void setApprovalInitStatus(String approvalInitStatus) {
		this.approvalInitStatus = approvalInitStatus;
	}
	
	

}
