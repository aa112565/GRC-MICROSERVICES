package com.asymmetrix.grc.dto;

import java.util.List;

public class HeatMapDTO {
	private String name;
	List<SeriesDataDTO> series;

	public List<SeriesDataDTO> getSeries() {
		return series;
	}

	public void setSeries(List<SeriesDataDTO> seriesData) {
		this.series = seriesData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeatMapDTO(List<SeriesDataDTO> seriesData, String name) {
		super();
		this.series = seriesData;
		this.name = name;
	}

	public HeatMapDTO() {
		super();
	}

	@Override
	public String toString() {
		return "HeatMapDTO [seriesData=" + series + ", name=" + name + "]";
	}

}
