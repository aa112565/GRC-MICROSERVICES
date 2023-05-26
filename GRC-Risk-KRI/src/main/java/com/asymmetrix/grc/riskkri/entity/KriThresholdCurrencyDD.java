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
@Table(name = "KRI_THRESHOLD_CURRENCY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriThresholdCurrencyDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String currencyId;

	@Column(name = "NAME")
	private String currnecyName;

	@Column(name = "DESCRIPTION")
	private String currencyDesc;
	
	@Column(name = "C_ORDER")
	private String currencyOrder;

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrnecyName() {
		return currnecyName;
	}

	public void setCurrnecyName(String currnecyName) {
		this.currnecyName = currnecyName;
	}

	public String getCurrencyDesc() {
		return currencyDesc;
	}

	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}

	public String getCurrencyOrder() {
		return currencyOrder;
	}

	public void setCurrencyOrder(String currencyOrder) {
		this.currencyOrder = currencyOrder;
	}

	
}
