package com.asymmetrix.asset.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDetailsDTO {

	private List<AssetWithComplianceClassDTO> assetListWithComplianceClass;

	public List<AssetWithComplianceClassDTO> getAssetListWithComplianceClass() {
		return assetListWithComplianceClass;
	}

	public void setAssetListWithComplianceClass(List<AssetWithComplianceClassDTO> assetListWithComplianceClass) {
		this.assetListWithComplianceClass = assetListWithComplianceClass;
	}

}
