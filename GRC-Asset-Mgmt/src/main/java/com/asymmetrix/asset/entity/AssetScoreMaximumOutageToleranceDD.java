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
@Table(name = "CM_ASSET_SCORE_MAXIMUM_OUTAGE_TOLERENCE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreMaximumOutageToleranceDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String maximumOutageToleranceId;

	@Column(name = "NAME")
	private String maximumOutageToleranceName;

	@Column(name = "VALUE")
	private String maximumOutageToleranceValue;

	public String getMaximumOutageToleranceId() {
		return maximumOutageToleranceId;
	}

	public void setMaximumOutageToleranceId(String maximumOutageToleranceId) {
		this.maximumOutageToleranceId = maximumOutageToleranceId;
	}

	public String getMaximumOutageToleranceName() {
		return maximumOutageToleranceName;
	}

	public void setMaximumOutageToleranceName(String maximumOutageToleranceName) {
		this.maximumOutageToleranceName = maximumOutageToleranceName;
	}

	public String getMaximumOutageToleranceValue() {
		return maximumOutageToleranceValue;
	}

	public void setMaximumOutageToleranceValue(String maximumOutageToleranceValue) {
		this.maximumOutageToleranceValue = maximumOutageToleranceValue;
	}

}
