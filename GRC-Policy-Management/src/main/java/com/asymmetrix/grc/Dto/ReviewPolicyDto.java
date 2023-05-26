package com.asymmetrix.grc.Dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewPolicyDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long reviewId;
	private Long PolicyId;
	private Date reviewDate;
	private Date reviewNextDate;
	private String reviewComments;
	private Date createdDate;
	private String createdBy;
	private String approve;
	private String review;
	private String publishAttestation;
	private String reject;
	private Date modifiedDate;
	private String modifiedBy;
	private String activeFlag = "Y";
	private String deleteFlag = "N";
    private String policyApprove;
	
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public Date getReviewNextDate() {
		return reviewNextDate;
	}
	public void setReviewNextDate(Date reviewNextDate) {
		this.reviewNextDate = reviewNextDate;
	}
	public String getReviewComments() {
		return reviewComments;
	}
	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
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
	
	public String getApprove() {
		return approve;
	}
	
	
	
	public Long getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(Long policyId) {
		PolicyId = policyId;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getReject() {
		return reject;
	}
	public void setReject(String reject) {
		this.reject = reject;
	}
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getPublishAttestation() {
		return publishAttestation;
	}
	public void setPublishAttestation(String publishAttestation) {
		this.publishAttestation = publishAttestation;
	}
	public String getPolicyApprove() {
		return policyApprove;
	}
	public void setPolicyApprove(String policyApprove) {
		this.policyApprove = policyApprove;
	}

	

}
