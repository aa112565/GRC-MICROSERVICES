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
@Table(name = "CM_ASSET_SCORE_INTEGRITY_INFO_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreIntegrityDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String integrityId;

	@Column(name = "DESCRIPTION")
	private String integrityDesc;

	@Column(name = "VALUE")
	private String integrityValue;

	public String getIntegrityId() {
		return integrityId;
	}

	public void setIntegrityId(String integrityId) {
		this.integrityId = integrityId;
	}

	public String getIntegrityDesc() {
		return integrityDesc;
	}

	public void setIntegrityDesc(String integrityDesc) {
		this.integrityDesc = integrityDesc;
	}

	public String getIntegrityValue() {
		return integrityValue;
	}

	public void setIntegrityValue(String integrityValue) {
		this.integrityValue = integrityValue;
	}

}
