package com.asymmetrix.asset.dto;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetScoreCountByComplianceClassDTO {

	private String totalCount;
	private String greenCount;
	private String lightGreenCount;
	private String amberCount;
	private String redCount;

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getGreenCount() {
		return greenCount;
	}

	public void setGreenCount(String greenCount) {
		this.greenCount = greenCount;
	}

	public String getLightGreenCount() {
		return lightGreenCount;
	}

	public void setLightGreenCount(String lightGreenCount) {
		this.lightGreenCount = lightGreenCount;
	}

	public String getAmberCount() {
		return amberCount;
	}

	public void setAmberCount(String amberCount) {
		this.amberCount = amberCount;
	}

	public String getRedCount() {
		return redCount;
	}

	public void setRedCount(String redCount) {
		this.redCount = redCount;
	}

	public String getDarkRed() {
		return darkRed;
	}

	public void setDarkRed(String darkRed) {
		this.darkRed = darkRed;
	}

	private String darkRed;

}
