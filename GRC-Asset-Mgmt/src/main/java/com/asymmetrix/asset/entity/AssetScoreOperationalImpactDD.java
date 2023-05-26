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
@Table(name = "CM_ASSET_SCORE_OPERATIONAL_IMPACT_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreOperationalImpactDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String operationalImpactId;

	@Column(name = "NAME")
	private String operationalImpactName;

	@Column(name = "VALUE")
	private String operationalImpactValue;

	public String getOperationalImpactId() {
		return operationalImpactId;
	}

	public void setOperationalImpactId(String operationalImpactId) {
		this.operationalImpactId = operationalImpactId;
	}

	public String getOperationalImpactName() {
		return operationalImpactName;
	}

	public void setOperationalImpactName(String operationalImpactName) {
		this.operationalImpactName = operationalImpactName;
	}

	public String getOperationalImpactValue() {
		return operationalImpactValue;
	}

	public void setOperationalImpactValue(String operationalImpactValue) {
		this.operationalImpactValue = operationalImpactValue;
	}

}
