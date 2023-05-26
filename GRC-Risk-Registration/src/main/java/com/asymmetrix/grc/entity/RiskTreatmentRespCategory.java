package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RISK_TREATMENT_RESP_CATEGORY", schema = "GRC_TEST_ENV_DB")
public class RiskTreatmentRespCategory {
	
	@Id
	@Column(name = "N_RESP_CATEGORY_ID")
	private long responseCategoryId;

	@Column(name = "V_RESP_CATEGORY")
	private String responseCategory;

	public long getResponseCategoryId() {
		return responseCategoryId;
	}

	public void setResponseCategoryId(long responseCategoryId) {
		this.responseCategoryId = responseCategoryId;
	}

	public String getResponseCategory() {
		return responseCategory;
	}

	public void setResponseCategory(String responseCategory) {
		this.responseCategory = responseCategory;
	}

}
