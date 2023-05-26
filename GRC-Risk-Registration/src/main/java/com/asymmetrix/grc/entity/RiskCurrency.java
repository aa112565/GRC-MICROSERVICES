package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RR_RISK_CURRENCY", schema = "GRC_TEST_ENV_DB")
public class RiskCurrency {

	@Id
	@Column(name = "N_SRNO")
	private long srno;

	@Column(name = "V_CURRENCY")
	private String currency;

	public long getSrno() {
		return srno;
	}

	public void setSrno(long srno) {
		this.srno = srno;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public RiskCurrency() {
		super();
	}

}
