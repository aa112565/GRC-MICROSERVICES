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
@Table(name = "ITRISK_ASSESSMENT_TYPE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentTypeDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String assessmentTypeId;

	@Column(name = "ASSESSMENT_TYPE")
	private String assessmentType;

	@Column(name = "TYPE_ORDER")
	private String assessmentTypeOrder;

	public String getAssessmentTypeId() {
		return assessmentTypeId;
	}

	public void setAssessmentTypeId(String assessmentTypeId) {
		this.assessmentTypeId = assessmentTypeId;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public String getAssessmentTypeOrder() {
		return assessmentTypeOrder;
	}

	public void setAssessmentTypeOrder(String assessmentTypeOrder) {
		this.assessmentTypeOrder = assessmentTypeOrder;
	}

	

}
