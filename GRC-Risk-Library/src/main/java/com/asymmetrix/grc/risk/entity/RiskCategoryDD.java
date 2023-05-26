package com.asymmetrix.grc.risk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "RISK_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor

public class RiskCategoryDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "RISK_CATEGORY_ID")
	private String id;

	@Column(name = "RISK_CATEGORY_NAME")
	private String riskCategoryeName;

	@Column(name = "RISK_CATEGORY_DESC")
	private String riskCategoryDesc;
	
	@Column(name = "RISK_CATEGORY_ORDER")
	private String riskCategoryOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRiskCategoryeName() {
		return riskCategoryeName;
	}

	public void setRiskCategoryeName(String riskCategoryeName) {
		this.riskCategoryeName = riskCategoryeName;
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
