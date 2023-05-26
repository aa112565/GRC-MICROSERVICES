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
@Table(name = "KRI_METRICS_FINANCIALYEAR_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriMetricsFinancialYearDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String financialYearId;

	@Column(name = "NAME")
	private String financialYearName;

	@Column(name = "DESCRIPTION")
	private String financialYearDesc;

	@Column(name = "FY_ORDER")
	private int financialYearOrder;

	public String getFinancialYearId() {
		return financialYearId;
	}

	public void setFinancialYearId(String financialYearId) {
		this.financialYearId = financialYearId;
	}

	public String getFinancialYearName() {
		return financialYearName;
	}

	public void setFinancialYearName(String financialYearName) {
		this.financialYearName = financialYearName;
	}

	public String getFinancialYearDesc() {
		return financialYearDesc;
	}

	public void setFinancialYearDesc(String financialYearDesc) {
		this.financialYearDesc = financialYearDesc;
	}

	public int getFinancialYearOrder() {
		return financialYearOrder;
	}

	public void setFinancialYearOrder(int financialYearOrder) {
		this.financialYearOrder = financialYearOrder;
	}

}
