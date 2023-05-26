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
@Table(name = "CM_ASSET_SCORE_RECOVERY_POINT_OBJECTIVE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreRecoveryPointObjectiveDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String recoveryPointObjectiveId;

	@Column(name = "NAME")
	private String recoveryPointObjectiveName;

	@Column(name = "VALUE")
	private String recoveryPointObjectiveValue;

	public String getRecoveryPointObjectiveId() {
		return recoveryPointObjectiveId;
	}

	public void setRecoveryPointObjectiveId(String recoveryPointObjectiveId) {
		this.recoveryPointObjectiveId = recoveryPointObjectiveId;
	}

	public String getRecoveryPointObjectiveName() {
		return recoveryPointObjectiveName;
	}

	public void setRecoveryPointObjectiveName(String recoveryPointObjectiveName) {
		this.recoveryPointObjectiveName = recoveryPointObjectiveName;
	}

	public String getRecoveryPointObjectiveValue() {
		return recoveryPointObjectiveValue;
	}

	public void setRecoveryPointObjectiveValue(String recoveryPointObjectiveValue) {
		this.recoveryPointObjectiveValue = recoveryPointObjectiveValue;
	}

}
