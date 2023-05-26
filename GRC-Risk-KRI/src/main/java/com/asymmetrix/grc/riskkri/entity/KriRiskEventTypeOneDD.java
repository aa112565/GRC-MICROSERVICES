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
@Table(name = "KRI_RISK_EVENT_TYPE_ONE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriRiskEventTypeOneDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String riskEventTypeOneId;

	@Column(name = "NAME")
	private String riskEventTypeOneName;

	@Column(name = "DESCRIPTION")
	private String riskEventTypeOneDesc;
	
	@Column(name = "ET_ORDER")
	private String riskEventTypeOneOrder;

	public String getRiskEventTypeOneId() {
		return riskEventTypeOneId;
	}

	public void setRiskEventTypeOneId(String riskEventTypeOneId) {
		this.riskEventTypeOneId = riskEventTypeOneId;
	}

	public String getRiskEventTypeOneName() {
		return riskEventTypeOneName;
	}

	public void setRiskEventTypeOneName(String riskEventTypeOneName) {
		this.riskEventTypeOneName = riskEventTypeOneName;
	}

	public String getRiskEventTypeOneDesc() {
		return riskEventTypeOneDesc;
	}

	public void setRiskEventTypeOneDesc(String riskEventTypeOneDesc) {
		this.riskEventTypeOneDesc = riskEventTypeOneDesc;
	}

	public String getRiskEventTypeOneOrder() {
		return riskEventTypeOneOrder;
	}

	public void setRiskEventTypeOneOrder(String riskEventTypeOneOrder) {
		this.riskEventTypeOneOrder = riskEventTypeOneOrder;
	}

	
}
