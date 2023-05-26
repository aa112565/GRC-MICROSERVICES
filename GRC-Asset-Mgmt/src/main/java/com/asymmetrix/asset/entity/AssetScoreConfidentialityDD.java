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
@Table(name = "CM_ASSET_SCORE_CONFIDENTIALITY_INFO_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreConfidentialityDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String confidentialityId;

	@Column(name = "DESCRIPTION")
	private String confidentialityDesc;

	@Column(name = "VALUE")
	private String confidentialityValue;

	public String getConfidentialityId() {
		return confidentialityId;
	}

	public void setConfidentialityId(String confidentialityId) {
		this.confidentialityId = confidentialityId;
	}

	public String getConfidentialityDesc() {
		return confidentialityDesc;
	}

	public void setConfidentialityDesc(String confidentialityDesc) {
		this.confidentialityDesc = confidentialityDesc;
	}

	public String getConfidentialityValue() {
		return confidentialityValue;
	}

	public void setConfidentialityValue(String confidentialityValue) {
		this.confidentialityValue = confidentialityValue;
	}

}
