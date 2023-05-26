package com.asymmetrix.grc.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) throws JsonProcessingException {
		Map<String, Map<String, Long>> groupedDataMap = groupingData(getScoreFromDB());
		List<HeatMapDTO> heatMapDTO = groupedDataMap.entrySet().stream()
				.map(e -> new HeatMapDTO(getSeriesData(e.getValue()), e.getKey())).collect(Collectors.toList());
		printJsonString(heatMapDTO);
	}

	private static void printJsonString(List<HeatMapDTO> heatMapData) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(heatMapData);
		System.out.println(newJsonData);
	}

	private static Map<String, Map<String, Long>> groupingData(List<RiskScoringDTO> scoreList) {
		return scoreList.stream().collect(Collectors.groupingBy(RiskScoringDTO::getInherentImpactRating,
				Collectors.groupingBy(RiskScoringDTO::getInherentRiskRating, Collectors.counting())));
	}

	private static List<SeriesDataDTO> getSeriesData(Map<String, Long> seriesMap) {
		return seriesMap.entrySet().stream().map(e -> new SeriesDataDTO(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

	public static List<RiskScoringDTO> getScoreFromDB() {
		List<RiskScoringDTO> inherentList = new ArrayList<>();
		RiskScoringDTO dto1 = new RiskScoringDTO("very low", "low");
		RiskScoringDTO dto11 = new RiskScoringDTO("very low", "very low");
		inherentList.add(dto1);
		inherentList.add(dto11);

		RiskScoringDTO dto2 = new RiskScoringDTO("low", "low");
		RiskScoringDTO dto22 = new RiskScoringDTO("low", "low");
		inherentList.add(dto2);
		inherentList.add(dto22);

		RiskScoringDTO dto3 = new RiskScoringDTO("medium", "low");
		RiskScoringDTO dto33 = new RiskScoringDTO("medium", "low");
		RiskScoringDTO dto333 = new RiskScoringDTO("medium", "very low");
		inherentList.add(dto3);
		inherentList.add(dto33);
		inherentList.add(dto333);

		RiskScoringDTO dto4 = new RiskScoringDTO("high", "low");
		inherentList.add(dto4);

		return inherentList;
	}

}
