package com.asymmetrix.grc.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest
{
    private String assessmentId;
    private String policyUniqueId;
    private String policyId;
    private RatingColor ratingColor;
  private ResidualImpactType residualImpactType;   // Final in Dto
    private String remarks;
    
	public String getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}
	public String getPolicyUniqueId() {
		return policyUniqueId;
	}
	public void setPolicyUniqueId(String policyUniqueId) {
		this.policyUniqueId = policyUniqueId;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public RatingColor getRatingColor() {
		return ratingColor;
	}
	public void setRatingColor(final RatingColor ratingColor) {
		this.ratingColor = ratingColor;
	}
	public ResidualImpactType getResidualImpactType() {
		return residualImpactType;
	}
	public void setResidualImpactType(ResidualImpactType residualImpactType) {
		this.residualImpactType = residualImpactType;
	}
    
    
    
}
