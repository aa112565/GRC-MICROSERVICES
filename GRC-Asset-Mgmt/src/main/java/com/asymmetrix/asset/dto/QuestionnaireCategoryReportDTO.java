package com.asymmetrix.asset.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionnaireCategoryReportDTO {
	private String questionnaireId;
	private String categoryId;
	private String category;
	private String requirementId;
	private String requirementNo;
	private String requirment;
	private String classification;
	private String minMandatoryClass;
	private String complianceClassAndApplicability;
	private String primaryKeyWord;
	private String secondaryKeyWord;
	private String applicabilityLevel;
	private String requiredAssessmentMethod;
	private String evidenceType;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	public String getRequirementNo() {
		return requirementNo;
	}

	public void setRequirementNo(String requirementNo) {
		this.requirementNo = requirementNo;
	}

	public String getRequirment() {
		return requirment;
	}

	public void setRequirment(String requirment) {
		this.requirment = requirment;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getMinMandatoryClass() {
		return minMandatoryClass;
	}

	public void setMinMandatoryClass(String minMandatoryClass) {
		this.minMandatoryClass = minMandatoryClass;
	}

	public String getComplianceClassAndApplicability() {
		return complianceClassAndApplicability;
	}

	public void setComplianceClassAndApplicability(String complianceClassAndApplicability) {
		this.complianceClassAndApplicability = complianceClassAndApplicability;
	}

	public String getPrimaryKeyWord() {
		return primaryKeyWord;
	}

	public void setPrimaryKeyWord(String primaryKeyWord) {
		this.primaryKeyWord = primaryKeyWord;
	}

	public String getSecondaryKeyWord() {
		return secondaryKeyWord;
	}

	public void setSecondaryKeyWord(String secondaryKeyWord) {
		this.secondaryKeyWord = secondaryKeyWord;
	}

	public String getApplicabilityLevel() {
		return applicabilityLevel;
	}

	public void setApplicabilityLevel(String applicabilityLevel) {
		this.applicabilityLevel = applicabilityLevel;
	}

	public String getRequiredAssessmentMethod() {
		return requiredAssessmentMethod;
	}

	public void setRequiredAssessmentMethod(String requiredAssessmentMethod) {
		this.requiredAssessmentMethod = requiredAssessmentMethod;
	}

	public String getEvidenceType() {
		return evidenceType;
	}

	public void setEvidenceType(String evidenceType) {
		this.evidenceType = evidenceType;
	}

}
