package com.grc.itrisk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITRISK_ASSESSMENT_RATING_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentRatingResponseDD {
	
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String assessmentRatingResponseId;

	@Column(name = "RATING_RESPONSE")
	private String assessmentRatingResponse;

	@Column(name = "RESPONSE_ORDER")
	private String responseOrder;

	
	
	public String getAssessmentRatingResponseId() {
		return assessmentRatingResponseId;
	}

	public void setAssessmentRatingResponseId(String assessmentRatingResponseId) {
		this.assessmentRatingResponseId = assessmentRatingResponseId;
	}

	public String getAssessmentRatingResponse() {
		return assessmentRatingResponse;
	}

	public void setAssessmentRatingResponse(String assessmentRatingResponse) {
		this.assessmentRatingResponse = assessmentRatingResponse;
	}

	public String getResponseOrder() {
		return responseOrder;
	}

	public void setResponseOrder(String responseOrder) {
		this.responseOrder = responseOrder;
	}

	
}
