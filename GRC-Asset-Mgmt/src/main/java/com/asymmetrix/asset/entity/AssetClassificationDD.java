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
@Table(name = "CM_ASSET_CLASSIFICATION_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetClassificationDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String assetClassificationId;

	@Column(name = "NAME")
	private String assetClassificationName;

	@Column(name = "DESCRIPTION")
	private String assetClassificationDesc;

	public String getAssetClassificationId() {
		return assetClassificationId;
	}

	public void setAssetClassificationId(String assetClassificationId) {
		this.assetClassificationId = assetClassificationId;
	}

	public String getAssetClassificationName() {
		return assetClassificationName;
	}

	public void setAssetClassificationName(String assetClassificationName) {
		this.assetClassificationName = assetClassificationName;
	}

	public String getAssetClassificationDesc() {
		return assetClassificationDesc;
	}

	public void setAssetClassificationDesc(String assetClassificationDesc) {
		this.assetClassificationDesc = assetClassificationDesc;
	}

}
