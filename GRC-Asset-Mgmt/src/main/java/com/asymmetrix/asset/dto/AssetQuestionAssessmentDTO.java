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
public class AssetQuestionAssessmentDTO {

	private long assetQuestionAssessmentId;
	private String evidenceType;
	private String responsibility;
	private String remarks;

	private String assetId;
	private String assessmentId;
	private String controlId;
	private String questionId;
	private String status;

	private String activeFlag;
	private String deleteFlag;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;

	public long getAssetQuestionAssessmentId() {
		return assetQuestionAssessmentId;
	}

	public void setAssetQuestionAssessmentId(long assetQuestionAssessmentId) {
		this.assetQuestionAssessmentId = assetQuestionAssessmentId;
	}

	public String getEvidenceType() {
		return evidenceType;
	}

	public void setEvidenceType(String evidenceType) {
		this.evidenceType = evidenceType;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
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

	public AssetQuestionAssessmentDTO() {
		super();

	}

	public AssetQuestionAssessmentDTO(long assetQuestionAssessmentId, String evidenceType, String responsibility,
			String remarks, String assetId, String assessmentId, String controlId, String questionId, String status,
			String activeFlag, String deleteFlag, String createdBy, String modifiedBy, Date createdDate,
			Date modifiedDate) {
		// super();
		this.assetQuestionAssessmentId = assetQuestionAssessmentId;
		this.evidenceType = evidenceType;
		this.responsibility = responsibility;
		this.remarks = remarks;
		this.assetId = assetId;
		this.assessmentId = assessmentId;
		this.controlId = controlId;
		this.questionId = questionId;
		this.status = status;
		this.activeFlag = activeFlag;
		this.deleteFlag = deleteFlag;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public AssetQuestionAssessmentDTO(String evidenceType, String responsibility, String remarks, String assetId,
			String assessmentId, String controlId, String questionId, String status, String activeFlag,
			String deleteFlag, String createdBy, String modifiedBy, Date createdDate, Date modifiedDate) {
		// super();
		// this.assetQuestionAssessmentId = assetQuestionAssessmentId;
		this.evidenceType = evidenceType;
		this.responsibility = responsibility;
		this.remarks = remarks;
		this.assetId = assetId;
		this.assessmentId = assessmentId;
		this.controlId = controlId;
		this.questionId = questionId;
		this.status = status;
		this.activeFlag = activeFlag;
		this.deleteFlag = deleteFlag;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "AssetQuestionAssessmentDTO [assetQuestionAssessmentId=" + assetQuestionAssessmentId + ", evidenceType="
				+ evidenceType + ", responsibility=" + responsibility + ", remarks=" + remarks + ", assetId=" + assetId
				+ ", assessmentId=" + assessmentId + ", controlId=" + controlId + ", questionId=" + questionId
				+ ", status=" + status + ", activeFlag=" + activeFlag + ", deleteFlag=" + deleteFlag + ", createdBy="
				+ createdBy + ", modifiedBy=" + modifiedBy + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

}
