package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
	
	 //	  private String customerNumber;
	 //   private Integer age;
	 //   private Integer amount;
	 //   private CustomerType customerType;
	    
	    private String riskRegId;
		private String riskId;
	    private RatingColor ratingColor;
	    private ResidualImpactType residualImpactType;	   
	    private String remarks;	
/*	    
		public String getCustomerNumber() {
			return customerNumber;
		}
		public void setCustomerNumber(String customerNumber) {
			this.customerNumber = customerNumber;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		public CustomerType getCustomerType() {
			return customerType;
		}
		public void setCustomerType(CustomerType customerType) {
			this.customerType = customerType;
		}
		
	*/	
		
		
		
		public String getRiskRegId() {
			return riskRegId;
		}
		public void setRiskRegId(String riskRegId) {
			this.riskRegId = riskRegId;
		}
		public String getRiskId() {
			return riskId;
		}
		public void setRiskId(String riskId) {
			this.riskId = riskId;
		}
		public RatingColor getRatingColor() {
			return ratingColor;
		}
		public void setRatingColor(RatingColor ratingColor) {
			this.ratingColor = ratingColor;
		}
		public ResidualImpactType getResidualImpactType() {
			return residualImpactType;
		}
		public void setResidualImpactType(ResidualImpactType residualImpactType) {
			this.residualImpactType = residualImpactType;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
	    
	    

}
