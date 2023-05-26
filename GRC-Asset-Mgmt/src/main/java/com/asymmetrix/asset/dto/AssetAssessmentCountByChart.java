package com.asymmetrix.asset.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssetAssessmentCountByChart {

	private List<AssetAssessmentCountByPieChartDTO> pieChart;

	private List<AssetAssessmentCountByPieChartDTO> countScoreChart;

	public List<AssetAssessmentCountByPieChartDTO> getPieChart() {
		return pieChart;
	}

	public void setPieChart(List<AssetAssessmentCountByPieChartDTO> pieChart) {
		this.pieChart = pieChart;
	}

	public List<AssetAssessmentCountByPieChartDTO> getCountScoreChart() {
		return countScoreChart;
	}

	public void setCountScoreChart(List<AssetAssessmentCountByPieChartDTO> countScoreChart) {
		this.countScoreChart = countScoreChart;
	}

}
