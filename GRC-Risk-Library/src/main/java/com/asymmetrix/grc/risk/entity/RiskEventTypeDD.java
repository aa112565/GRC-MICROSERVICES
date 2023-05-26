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
@Table(name = "RISK_EVENT_TYPE")
@NoArgsConstructor
@AllArgsConstructor

public class RiskEventTypeDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "RISK_EVENT_TYPE_ID")
	private String id;

	@Column(name = "RISK_EVENT_TYPE_NAME")
	private String riskEventTypeName;

	@Column(name = "RISK_EVENT_TYPE_DESC")
	private String riskEventTypeDesc;
	
	@Column(name = "RISK_EVENT_TYPE_ORDER")
	private String riskEventTypeOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRiskEventTypeName() {
		return riskEventTypeName;
	}

	public void setRiskEventTypeName(String riskEventTypeName) {
		this.riskEventTypeName = riskEventTypeName;
	}

	public String getRiskEventTypeDesc() {
		return riskEventTypeDesc;
	}

	public void setRiskEventTypeDesc(String riskEventTypeDesc) {
		this.riskEventTypeDesc = riskEventTypeDesc;
	}

	public String getRiskEventTypeOrder() {
		return riskEventTypeOrder;
	}

	public void setRiskEventTypeOrder(String riskEventTypeOrder) {
		this.riskEventTypeOrder = riskEventTypeOrder;
	}

	
}
