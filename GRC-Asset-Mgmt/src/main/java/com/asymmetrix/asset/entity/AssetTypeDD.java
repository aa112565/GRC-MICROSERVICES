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
@Table(name = "CM_ASSET_ASSET_TYPE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetTypeDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String assetTypeId;

	@Column(name = "NAME")
	private String assetTypeName;

	@Column(name = "DESCRIPTION")
	private String assetTypeDesc;

	public String getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(String assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public String getAssetTypeName() {
		return assetTypeName;
	}

	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
	}

	public String getAssetTypeDesc() {
		return assetTypeDesc;
	}

	public void setAssetTypeDesc(String assetTypeDesc) {
		this.assetTypeDesc = assetTypeDesc;
	}

}
