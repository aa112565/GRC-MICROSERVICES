package com.asymmetrix.asset.dto;

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
public class AssetAssessmentCountByPieChartDTO {

	private String name;
	private String value;

	/*
	 * private String assetTotalCountPercentage; private String
	 * assessmentTotalCountPercentage; private String
	 * assessmentInitiatedCountPercentage; private String
	 * assessmentInprogressCountPercentage; private String
	 * assessmentCompletedCountPercentage;
	 * 
	 * public String getAssetTotalCountPercentage() { return
	 * assetTotalCountPercentage; } public void setAssetTotalCountPercentage(String
	 * assetTotalCountPercentage) { this.assetTotalCountPercentage =
	 * assetTotalCountPercentage; } public String
	 * getAssessmentTotalCountPercentage() { return assessmentTotalCountPercentage;
	 * } public void setAssessmentTotalCountPercentage(String
	 * assessmentTotalCountPercentage) { this.assessmentTotalCountPercentage =
	 * assessmentTotalCountPercentage; } public String
	 * getAssessmentInitiatedCountPercentage() { return
	 * assessmentInitiatedCountPercentage; } public void
	 * setAssessmentInitiatedCountPercentage(String
	 * assessmentInitiatedCountPercentage) { this.assessmentInitiatedCountPercentage
	 * = assessmentInitiatedCountPercentage; } public String
	 * getAssessmentInprogressCountPercentage() { return
	 * assessmentInprogressCountPercentage; } public void
	 * setAssessmentInprogressCountPercentage(String
	 * assessmentInprogressCountPercentage) {
	 * this.assessmentInprogressCountPercentage =
	 * assessmentInprogressCountPercentage; } public String
	 * getAssessmentCompletedCountPercentage() { return
	 * assessmentCompletedCountPercentage; } public void
	 * setAssessmentCompletedCountPercentage(String
	 * assessmentCompletedCountPercentage) { this.assessmentCompletedCountPercentage
	 * = assessmentCompletedCountPercentage; }
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
