package com.grc.itrisk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;

import javax.persistence.Column;

@SuppressWarnings("unused")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssessmentPostRatingDTO {
	
	
	private long assessmentRatingId;
	private long initAssessmentId;	
	private long assessmentId;
	private long templateId;
	
	private String notApplicable;
	private String nonCompliant;
	private String partiallyCompliant;
	private String compliantWithDocuments;
	private String compliantWithoutDocuments;
	
	private String notApplicableLable;	
	private String nonCompliantLable;		
	private String partiallyCompliantLable;		
	private String compliantWithDocumentsLable;		
	private String compliantWithoutDocumentsLable;
/*	
	private String notApplicableScore;
	private String nonCompliantScore;
	private String partiallyCompliantScore;
	private String compliantWithDocumentsScore;
	private String compliantWithoutDocumentsScore;
*/	
	private String totalCount;
	private String postAssessmentRating;
	private String status;
	private String createdBy;
	private String modifiedBy;	
	private Date createdDate;
	private Date modifiedDate;
	private String activeFlag;
	private String deleteFlag;
	private String saveFlag;	
	
	
	public long getInitAssessmentId() {
		return initAssessmentId;
	}
	public void setInitAssessmentId(long initAssessmentId) {
		this.initAssessmentId = initAssessmentId;
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
	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	public String getNotApplicable() {
		return notApplicable;
	}
	public void setNotApplicable(String notApplicable) {
		this.notApplicable = notApplicable;
	}
	public String getNonCompliant() {
		return nonCompliant;
	}
	public void setNonCompliant(String nonCompliant) {
		this.nonCompliant = nonCompliant;
	}
	public String getPartiallyCompliant() {
		return partiallyCompliant;
	}
	public void setPartiallyCompliant(String partiallyCompliant) {
		this.partiallyCompliant = partiallyCompliant;
	}
	public String getCompliantWithDocuments() {
		return compliantWithDocuments;
	}
	public void setCompliantWithDocuments(String compliantWithDocuments) {
		this.compliantWithDocuments = compliantWithDocuments;
	}
	public String getCompliantWithoutDocuments() {
		return compliantWithoutDocuments;
	}
	public void setCompliantWithoutDocuments(String compliantWithoutDocuments) {
		this.compliantWithoutDocuments = compliantWithoutDocuments;
	}
	public String getNotApplicableLable() {
		return notApplicableLable;
	}
	public void setNotApplicableLable(String notApplicableLable) {
		this.notApplicableLable = notApplicableLable;
	}
	public String getNonCompliantLable() {
		return nonCompliantLable;
	}
	public void setNonCompliantLable(String nonCompliantLable) {
		this.nonCompliantLable = nonCompliantLable;
	}
	public String getPartiallyCompliantLable() {
		return partiallyCompliantLable;
	}
	public void setPartiallyCompliantLable(String partiallyCompliantLable) {
		this.partiallyCompliantLable = partiallyCompliantLable;
	}
	public String getCompliantWithDocumentsLable() {
		return compliantWithDocumentsLable;
	}
	public void setCompliantWithDocumentsLable(String compliantWithDocumentsLable) {
		this.compliantWithDocumentsLable = compliantWithDocumentsLable;
	}
	public String getCompliantWithoutDocumentsLable() {
		return compliantWithoutDocumentsLable;
	}
	public void setCompliantWithoutDocumentsLable(String compliantWithoutDocumentsLable) {
		this.compliantWithoutDocumentsLable = compliantWithoutDocumentsLable;
	}
	public long getAssessmentRatingId() {
		return assessmentRatingId;
	}
	public void setAssessmentRatingId(long assessmentRatingId) {
		this.assessmentRatingId = assessmentRatingId;
	}
	public long getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(long assessmentId) {
		this.assessmentId = assessmentId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getPostAssessmentRating() {
		return postAssessmentRating;
	}
	public void setPostAssessmentRating(String postAssessmentRating) {
		this.postAssessmentRating = postAssessmentRating;
	}
	

}
