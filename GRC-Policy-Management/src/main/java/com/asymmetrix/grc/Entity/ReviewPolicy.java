package com.asymmetrix.grc.Entity;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PM_POLICY_REVIEW")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReviewPolicy implements Serializable {   
	
	private static final long serialVersionUID = 1L;  
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "PM_REVIEW_ID")
	private long reviewId;
	
	@Column(name = "PM_PolicyID")
	private Long PolicyId;

	@Column(name = "PM_REVIEWDATE")
	private Date reviewDate;
	
	@Column(name = "PM_REVIEWNEXTDATE")
	private Date reviewNextDate;
	
	@Column(name = "PM_REVIEWCOMMENTS")
	private String reviewComments;
	
	@Column(name = "D_CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "V_CREATED_BY")
	private String createdBy;
	
	@Column(name = "PM_APPROVE")
	private String approve;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "PM_POLICY_CREATION",
//			   joinColumns = {@JoinColumn(name = "PMM_REVIEW")},
//			   inverseJoinColumns = {@JoinColumn(name = "PMM_REVIEW")})
	@Column(name = "PMM_REVIEW")
	private String review;
	
	@Column(name = "PUBLISHATTESTATION")
	private String publishAttestation;
	
	@Column(name = "PM_REJECT")
	private String reject;
	
	@Column(name = "POLICY_APPROVE")
    private String policyApprove;
	
	@Column(name = "D_MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name = "V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag = "Y";
		 
	@Column(name = "DELETE_FLAG")
	private String deleteFlag = "N";

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

	
	public Long getPolicyId() {
		return PolicyId;
	}

	public void setPolicyId(Long policyId) {
		PolicyId = policyId;
	}

	public String getPolicyApprove() {
		return policyApprove;
	}

	public void setPolicyApprove(String policyApprove) {
		this.policyApprove = policyApprove;
	}

	
	


	
	
}
