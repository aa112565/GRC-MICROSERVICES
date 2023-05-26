package com.asymmetrix.grc.service;

import java.util.List;


import com.asymmetrix.grc.dto.HeatMapDTO;
import com.asymmetrix.grc.dto.RiskDetailsDTO;
import com.asymmetrix.grc.dto.RiskScoringDTO;


public interface RiskDashboardService {

	public List<HeatMapDTO> getInherentHeatMapData();
	
	public List<HeatMapDTO> getResidualHeatMapData();
	
	RiskDetailsDTO getInherentImpactRatingList(String impact, String likelihood);

	RiskDetailsDTO getResidualImpactRatingList(String impact, String likelihood);
	
	List<RiskScoringDTO> getAllScore();

	Long getInherentImpactRatingCount(String impact, String likelihood);

	Long getResidualImpactRatingCount(String impact, String likelihood);

	public List<HeatMapDTO> getInherentHeatMapCounts();

	public List<HeatMapDTO> getResidualHeatMapCounts();

	List<RiskScoringDTO> getInherentImpactRatingListForMap(String impact, String likelihood);

	List<RiskScoringDTO> getResidualImpactRatingListForMap(String impact, String likelihood);

	public List<RiskScoringDTO>  getInherentHeatMapList();

	public List<RiskScoringDTO>  getResidualHeatMapList();

	
	
}