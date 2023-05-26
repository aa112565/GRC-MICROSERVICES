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
@Table(name = "KRI_RISK_EVENT_TYPE_TWO_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriRiskEventTypeTwoDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String riskEventTypeTwoId;

	@Column(name = "NAME")
	private String riskEventTypeTwoName;

	@Column(name = "DESCRIPTION")
	private String riskEventTypeTwoDesc;
	
	@Column(name = "ET_ORDER")
	private String riskEventTypeTwoOrder;

	public String getRiskEventTypeTwoId() {
		return riskEventTypeTwoId;
	}

	public void setRiskEventTypeTwoId(String riskEventTypeTwoId) {
		this.riskEventTypeTwoId = riskEventTypeTwoId;
	}

	public String getRiskEventTypeTwoName() {
		return riskEventTypeTwoName;
	}

	public void setRiskEventTypeTwoName(String riskEventTypeTwoName) {
		this.riskEventTypeTwoName = riskEventTypeTwoName;
	}

	public String getRiskEventTypeTwoDesc() {
		return riskEventTypeTwoDesc;
	}

	public void setRiskEventTypeTwoDesc(String riskEventTypeTwoDesc) {
		this.riskEventTypeTwoDesc = riskEventTypeTwoDesc;
	}

	public String getRiskEventTypeTwoOrder() {
		return riskEventTypeTwoOrder;
	}

	public void setRiskEventTypeTwoOrder(String riskEventTypeTwoOrder) {
		this.riskEventTypeTwoOrder = riskEventTypeTwoOrder;
	}

	
}
