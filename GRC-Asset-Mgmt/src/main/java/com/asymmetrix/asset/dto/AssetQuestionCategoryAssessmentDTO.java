package com.asymmetrix.asset.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetQuestionCategoryAssessmentDTO {

	private long assetQuestionCategoryAssessmentId;
	private String assetId;
	private String assessmentId;
	private String controlId;
	private String status;

	private String activeFlag;
	private String deleteFlag;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;

	public AssetQuestionCategoryAssessmentDTO() {
		super();

	}

	public AssetQuestionCategoryAssessmentDTO(long assetQuestionCategoryAssessmentId, String assetId,
			String assessmentId, String controlId, String status, String activeFlag, String deleteFlag,
			String createdBy, String modifiedBy, Date createdDate, Date modifiedDate) {
		// super();
		this.assetQuestionCategoryAssessmentId = assetQuestionCategoryAssessmentId;
		this.assetId = assetId;
		this.assessmentId = assessmentId;
		this.controlId = controlId;
		this.status = status;
		this.activeFlag = activeFlag;
		this.deleteFlag = deleteFlag;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public AssetQuestionCategoryAssessmentDTO(String assetId, String assessmentId, String controlId, String status,
			String activeFlag, String deleteFlag, String createdBy, String modifiedBy, Date createdDate,
			Date modifiedDate) {
		// super();
		// this.assetQuestionCategoryAssessmentId = assetQuestionCategoryAssessmentId;
		this.assetId = assetId;
		this.assessmentId = assessmentId;
		this.controlId = controlId;
		this.status = status;
		this.activeFlag = activeFlag;
		this.deleteFlag = deleteFlag;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public long getAssetQuestionCategoryAssessmentId() {
		return assetQuestionCategoryAssessmentId;
	}

	public void setAssetQuestionCategoryAssessmentId(long assetQuestionCategoryAssessmentId) {
		this.assetQuestionCategoryAssessmentId = assetQuestionCategoryAssessmentId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getControlId() {
		return controlId;
	}

	public void setControlId(String controlId) {
		this.controlId = controlId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "AssetQuestionCategoryAssessmentDTO [assetQuestionCategoryAssessmentId="
				+ assetQuestionCategoryAssessmentId + ", assetId=" + assetId + ", assessmentId=" + assessmentId
				+ ", controlId=" + controlId + ", status=" + status + ", activeFlag=" + activeFlag + ", deleteFlag="
				+ deleteFlag + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
