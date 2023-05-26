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
@Table(name = "CM_ASSET_CATEGORY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetCategoryDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String assetCategoryId;

	@Column(name = "NAME")
	private String assetCategoryName;

	@Column(name = "DESCRIPTION")
	private String assetCategoryDesc;

	public String getAssetCategoryId() {
		return assetCategoryId;
	}

	public void setAssetCategoryId(String assetCategoryId) {
		this.assetCategoryId = assetCategoryId;
	}

	public String getAssetCategoryName() {
		return assetCategoryName;
	}

	public void setAssetCategoryName(String assetCategoryName) {
		this.assetCategoryName = assetCategoryName;
	}

	public String getAssetCategoryDesc() {
		return assetCategoryDesc;
	}

	public void setAssetCategoryDesc(String assetCategoryDesc) {
		this.assetCategoryDesc = assetCategoryDesc;
	}

}
