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
@Table(name = "RISK_TYPE")
@NoArgsConstructor
@AllArgsConstructor

public class RiskTypeDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "RISK_TYPE_ID")
	private String id;

	@Column(name = "RISK_TYPE_NAME")
	private String riskTypeName;

	@Column(name = "RISK_TYPE_DESC")
	private String riskTypeDesc;
	
	@Column(name = "RISK_TYPE_ORDER")
	private String riskTypeOrder;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRiskTypeName() {
		return riskTypeName;
	}

	public void setRiskTypeName(String riskTypeName) {
		this.riskTypeName = riskTypeName;
	}

	public String getRiskTypeDesc() {
		return riskTypeDesc;
	}

	public void setRiskTypeDesc(String riskTypeDesc) {
		this.riskTypeDesc = riskTypeDesc;
	}

	public String getRiskTypeOrder() {
		return riskTypeOrder;
	}

	public void setRiskTypeOrder(String riskTypeOrder) {
		this.riskTypeOrder = riskTypeOrder;
	}
	
	

}
