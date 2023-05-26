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
//@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetAssessmentCountDTO {

	private String assetTotalCount;
	private String assessmentTotalCount;
	private String assessmentInitiatedCount;
	private String assessmentInprogressCount;
	private String assessmentCompletedCount;

	public String getAssessmentTotalCount() {
		return assessmentTotalCount;
	}

	public void setAssessmentTotalCount(String assessmentTotalCount) {
		this.assessmentTotalCount = assessmentTotalCount;
	}

	public String getAssessmentInitiatedCount() {
		return assessmentInitiatedCount;
	}

	public void setAssessmentInitiatedCount(String assessmentInitiatedCount) {
		this.assessmentInitiatedCount = assessmentInitiatedCount;
	}

	public String getAssessmentInprogressCount() {
		return assessmentInprogressCount;
	}

	public void setAssessmentInprogressCount(String assessmentInprogressCount) {
		this.assessmentInprogressCount = assessmentInprogressCount;
	}

	public String getAssessmentCompletedCount() {
		return assessmentCompletedCount;
	}

	public void setAssessmentCompletedCount(String assessmentCompletedCount) {
		this.assessmentCompletedCount = assessmentCompletedCount;
	}

	public String getAssetTotalCount() {
		return assetTotalCount;
	}

	public void setAssetTotalCount(String assetTotalCount) {
		this.assetTotalCount = assetTotalCount;
	}

}
