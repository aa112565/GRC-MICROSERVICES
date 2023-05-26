package com.asymmetrix.asset.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CM_ASSET_SCORE_FINANCIAL_IMPACT_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreFinancialImpactDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String financialImpactId;

	@Column(name = "NAME")
	private String financialImpactName;

	@Column(name = "VALUE")
	private String financialImpactValue;

	public String getFinancialImpactId() {
		return financialImpactId;
	}

	public void setFinancialImpactId(String financialImpactId) {
		this.financialImpactId = financialImpactId;
	}

	public String getFinancialImpactName() {
		return financialImpactName;
	}

	public void setFinancialImpactName(String financialImpactName) {
		this.financialImpactName = financialImpactName;
	}

	public String getFinancialImpactValue() {
		return financialImpactValue;
	}

	public void setFinancialImpactValue(String financialImpactValue) {
		this.financialImpactValue = financialImpactValue;
	}

}
