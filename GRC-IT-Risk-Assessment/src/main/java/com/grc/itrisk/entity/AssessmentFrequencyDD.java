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
@Table(name = "ITRISK_FREQUENCY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentFrequencyDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String assessmentFrequencyId;

	@Column(name = "FREQUENCY")
	private String assessmentFrequency;

	@Column(name = "FREQUENCY_ORDER")
	private String assessmentFrequencyOrder;

	public String getAssessmentFrequencyId() {
		return assessmentFrequencyId;
	}

	public void setAssessmentFrequencyId(String assessmentFrequencyId) {
		this.assessmentFrequencyId = assessmentFrequencyId;
	}

	public String getAssessmentFrequency() {
		return assessmentFrequency;
	}

	public void setAssessmentFrequency(String assessmentFrequency) {
		this.assessmentFrequency = assessmentFrequency;
	}

	public String getAssessmentFrequencyOrder() {
		return assessmentFrequencyOrder;
	}

	public void setAssessmentFrequencyOrder(String assessmentFrequencyOrder) {
		this.assessmentFrequencyOrder = assessmentFrequencyOrder;
	}

	

}
