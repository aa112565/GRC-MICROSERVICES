package com.asymmetrix.grc.dto;

import java.util.ArrayList;
import java.util.List;

public class DashBoardHeatMapDTO {
	private String heatMapName;
	private String xaxis;
	private String yaxis;
	private String count;
	private String value;
	private List<String> riskIds = new ArrayList<>();

	public String getHeatMapName() {
		return heatMapName;
	}

	public void setHeatMapName(String heatMapName) {
		this.heatMapName = heatMapName;
	}

	public String getXaxis() {
		return xaxis;
	}

	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}

	public String getYaxis() {
		return yaxis;
	}

	public void setYaxis(String yaxis) {
		this.yaxis = yaxis;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getRiskIds() {
		return riskIds;
	}

	public void setRiskIds(List<String> riskIds) {
		this.riskIds = riskIds;
	}

	public DashBoardHeatMapDTO(String heatMapName, String xaxis, String yaxis, String count, String value,
			List<String> riskIds) {
		super();
		this.heatMapName = heatMapName;
		this.xaxis = xaxis;
		this.yaxis = yaxis;
		this.count = count;
		this.value = value;
		this.riskIds = riskIds;
	}

	public DashBoardHeatMapDTO() {

	}

}
