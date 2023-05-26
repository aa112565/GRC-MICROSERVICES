package com.asymmetrix.grc.riskkri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "KRI_RISK_CATEGORY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriRiskCategoryDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String riskCategoryId;

	@Column(name = "NAME")
	private String riskCategoryName;

	@Column(name = "DESCRIPTION")
	private String riskCategoryDesc;
	
	@Column(name = "RC_ORDER")
	private String riskCategoryOrder;

	public String getRiskCategoryId() {
		return riskCategoryId;
	}

	public void setRiskCategoryId(String riskCategoryId) {
		this.riskCategoryId = riskCategoryId;
	}

	public String getRiskCategoryName() {
		return riskCategoryName;
	}

	public void setRiskCategoryName(String riskCategoryName) {
		this.riskCategoryName = riskCategoryName;
	}

	public String getRiskCategoryDesc() {
		return riskCategoryDesc;
	}

	public void setRiskCategoryDesc(String riskCategoryDesc) {
		this.riskCategoryDesc = riskCategoryDesc;
	}

	public String getRiskCategoryOrder() {
		return riskCategoryOrder;
	}

	public void setRiskCategoryOrder(String riskCategoryOrder) {
		this.riskCategoryOrder = riskCategoryOrder;
	}

}
