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
@Table(name = "KI_RISK_INDICATOR_TYPE_DD")
@NoArgsConstructor
@AllArgsConstructor

public class RiskIndicatorTypeDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "RISK_INDICATOR_ID")
	private String id;

	@Column(name = "RISK_INDICATOR_NAME")
	private String riskIndicatorType;

	@Column(name = "RISK_INDICATOR_DESC")
	private String riskIndicatorDesc;
	
	@Column(name = "RISK_INDICATOR_ORDER")
	private String riskIndicatorOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRiskIndicatorDesc() {
		return riskIndicatorDesc;
	}

	public void setRiskIndicatorDesc(String riskIndicatorDesc) {
		this.riskIndicatorDesc = riskIndicatorDesc;
	}

	public String getRiskIndicatorType() {
		return riskIndicatorType;
	}

	public void setRiskIndicatorType(String riskIndicatorType) {
		this.riskIndicatorType = riskIndicatorType;
	}

	public String getRiskIndicatorOrder() {
		return riskIndicatorOrder;
	}

	public void setRiskIndicatorOrder(String riskIndicatorOrder) {
		this.riskIndicatorOrder = riskIndicatorOrder;
	}

	
}
