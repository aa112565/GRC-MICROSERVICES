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
public class AssetAssessmentDTO {

	private long assessmentId;
	private String assessorId;
	private String assessorName;
	private String assetDetails;
	private String assessmentOwner;

	private Date dateOfAssessment;
	private String regulation;
	private String status;
	private String activeFlag;
	private String deleteFlag;

//	private String compliance;	
//	private String duration;	
//	private String assetClassification;
//	private String questionnaire;	
//	private String evidence;
//	private String remarks;	

	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;

	public long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getAssessorId() {
		return assessorId;
	}

	public void setAssessorId(String assessorId) {
		this.assessorId = assessorId;
	}

	public String getAssessorName() {
		return assessorName;
	}

	public void setAssessorName(String assessorName) {
		this.assessorName = assessorName;
	}

	public String getAssetDetails() {
		return assetDetails;
	}

	public void setAssetDetails(String assetDetails) {
		this.assetDetails = assetDetails;
	}

	public String getAssessmentOwner() {
		return assessmentOwner;
	}

	public void setAssessmentOwner(String assessmentOwner) {
		this.assessmentOwner = assessmentOwner;
	}

	public String getRegulation() {
		return regulation;
	}

	public void setRegulation(String regulation) {
		this.regulation = regulation;
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

	public Date getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(Date dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public AssetAssessmentDTO() {
		super();
	}

	public AssetAssessmentDTO(long assessmentId, String assessorId, String assessorName, String assetDetails,
			String assessmentOwner, Date dateOfAssessment, String regulation, String status, String createdBy,
			String modifiedBy, Date createdDate, Date modifiedDate, String activeFlag, String deleteFlag) {
		// super();
		this.assessmentId = assessmentId;
		this.assessorId = assessorId;
		this.assessorName = assessorName;
		this.assetDetails = assetDetails;
		this.assessmentOwner = assessmentOwner;
		this.dateOfAssessment = dateOfAssessment;
		this.regulation = regulation;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.activeFlag = activeFlag;
		this.deleteFlag = deleteFlag;
	}

	public AssetAssessmentDTO(String assessorId, String assessorName, String assetDetails, String assessmentOwner,
			Date dateOfAssessment, String regulation, String status, String createdBy, String modifiedBy,
			Date createdDate, Date modifiedDate, String activeFlag, String deleteFlag) {
		// super();
		this.assessorId = assessorId;
		this.assessorName = assessorName;
		this.assetDetails = assetDetails;
		this.assessmentOwner = assessmentOwner;
		this.dateOfAssessment = dateOfAssessment;
		this.regulation = regulation;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.activeFlag = activeFlag;
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "AssetAssessmentDTO [assessmentId=" + assessmentId + ", assessorId=" + assessorId + ", assessorName="
				+ assessorName + ", assetDetails=" + assetDetails + ", assessmentOwner=" + assessmentOwner
				+ ", dateOfAssessment=" + dateOfAssessment + ", regulation=" + regulation + ", status=" + status
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", activeFlag=" + activeFlag + ", deleteFlag=" + deleteFlag + "]";
	}

}
