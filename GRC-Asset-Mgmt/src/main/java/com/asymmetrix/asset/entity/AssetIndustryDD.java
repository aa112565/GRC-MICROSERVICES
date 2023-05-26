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
@Table(name = "CM_ASSET_INDUSTRY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetIndustryDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String assetIndustryId;

	@Column(name = "NAME")
	private String assetIndustryName;

	@Column(name = "DESCRIPTION")
	private String assetIndustryDesc;

	public String getAssetIndustryId() {
		return assetIndustryId;
	}

	public void setAssetIndustryId(String assetIndustryId) {
		this.assetIndustryId = assetIndustryId;
	}

	public String getAssetIndustryName() {
		return assetIndustryName;
	}

	public void setAssetIndustryName(String assetIndustryName) {
		this.assetIndustryName = assetIndustryName;
	}

	public String getAssetIndustryDesc() {
		return assetIndustryDesc;
	}

	public void setAssetIndustryDesc(String assetIndustryDesc) {
		this.assetIndustryDesc = assetIndustryDesc;
	}

}
