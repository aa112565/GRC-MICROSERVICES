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
@Table(name = "CM_ASSET_SCORE_LEGAL_REGULATORY_IMPACT_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreLegalRegulatoryImpactDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String legalRegulatoryImpactId;

	@Column(name = "NAME")
	private String legalRegulatoryImpactName;

	@Column(name = "VALUE")
	private String legalRegulatoryImpactValue;

	public String getLegalRegulatoryImpactId() {
		return legalRegulatoryImpactId;
	}

	public void setLegalRegulatoryImpactId(String legalRegulatoryImpactId) {
		this.legalRegulatoryImpactId = legalRegulatoryImpactId;
	}

	public String getLegalRegulatoryImpactName() {
		return legalRegulatoryImpactName;
	}

	public void setLegalRegulatoryImpactName(String legalRegulatoryImpactName) {
		this.legalRegulatoryImpactName = legalRegulatoryImpactName;
	}

	public String getLegalRegulatoryImpactValue() {
		return legalRegulatoryImpactValue;
	}

	public void setLegalRegulatoryImpactValue(String legalRegulatoryImpactValue) {
		this.legalRegulatoryImpactValue = legalRegulatoryImpactValue;
	}

}
