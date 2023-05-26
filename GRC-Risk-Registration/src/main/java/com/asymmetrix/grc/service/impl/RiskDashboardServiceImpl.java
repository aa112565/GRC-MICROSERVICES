package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.HeatMapDTO;
import com.asymmetrix.grc.dto.ImpactRiskRatingDTO;
import com.asymmetrix.grc.dto.LikelihoodRiskRatingDTO;
import com.asymmetrix.grc.dto.RiskDetailsDTO;
import com.asymmetrix.grc.dto.RiskScoringDTO;
import com.asymmetrix.grc.dto.SeriesDataDTO;
import com.asymmetrix.grc.entity.RiskScoring;
import com.asymmetrix.grc.repository.ImpactRiskRatingRepository;
import com.asymmetrix.grc.repository.RiskRatingRepository;
import com.asymmetrix.grc.repository.RiskScoringRepository;
import com.asymmetrix.grc.service.RiskDashboardService;
import com.asymmetrix.grc.service.RiskRegisterService;

@Service
public class RiskDashboardServiceImpl implements RiskDashboardService {

	private static final String INHERENT = "Inherent";
	private static final String RESIDUAL = "Residual";

	@Resource
	RiskScoringRepository riskScoringRepo;

	@Resource
	RiskRegisterService riskRegisterService;

	@Resource
	ImpactRiskRatingRepository impactRatingRepo;

	@Resource
	RiskRatingRepository riskRatingRepo;

	public List<HeatMapDTO> getInherentHeatMapData() {
		Map<String, Map<String, Long>> heatMap = setDefaultValueForMissingAndGetMap(
				groupingData(getAllScore(), INHERENT));
		return heatMap.entrySet().stream().map(e -> new HeatMapDTO(getSeriesData(e.getValue()), e.getKey()))
				.collect(Collectors.toList());
	}

	public List<HeatMapDTO> getResidualHeatMapData() {
		Map<String, Map<String, Long>> heatMap = setDefaultValueForMissingAndGetMap(
				groupingData(getAllScore(), RESIDUAL));
		return heatMap.entrySet().stream().map(e -> new HeatMapDTO(getSeriesData(e.getValue()), e.getKey()))
				.collect(Collectors.toList());
	}

	private Map<String, Map<String, Long>> groupingData(List<RiskScoringDTO> scoreList, String type) {
		if (type.equals(INHERENT)) {
			return scoreList.stream().collect(Collectors.groupingBy(RiskScoringDTO::getInherentImpactRating,
					Collectors.groupingBy(RiskScoringDTO::getInherentRiskRating, Collectors.counting())));
		} else {
			return scoreList.stream().collect(Collectors.groupingBy(RiskScoringDTO::getResidualImpactRating,
					Collectors.groupingBy(RiskScoringDTO::getResidualRiskRating, Collectors.counting())));
		}
	}

	private List<SeriesDataDTO> getSeriesData(Map<String, Long> seriesMap) {
		return seriesMap.entrySet().stream().map(e -> new SeriesDataDTO(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

	@Override

	public List<RiskScoringDTO> getAllScore() {
		List<RiskScoring> scoreList = riskScoringRepo.findAll();
	//	List<RiskScoring> scoreList = riskScoringRepo.findAllByBranchName();
		return MapperUtils.mapToTargetClass(scoreList, RiskScoringDTO.class);
	}

	private Map<String, Map<String, Long>> setDefaultValueForMissingAndGetMap(
			Map<String, Map<String, Long>> scoreMapFromDB) {
		Long defaultCount = 0l;
		List<String> impactRating = impactRatingRepo.findAllImpatingRating();
		List<String> riskRating = riskRatingRepo.findAllRiskRating();
		return impactRating.stream().collect(Collectors.toMap(x -> x, x -> riskRating.stream()
				.collect(Collectors.toMap(y -> y, y -> getCount(scoreMapFromDB, x, y, defaultCount)))));
	}

	private Long getCount(Map<String, Map<String, Long>> scoreMapFromDB, String impactData, String riskData,
			Long defaultCount) {
		if (scoreMapFromDB.containsKey(impactData)) {
			return scoreMapFromDB.get(impactData).containsKey(riskData) ? scoreMapFromDB.get(impactData).get(riskData)
					: defaultCount;
		} else {
			return defaultCount;
		}
	}

	@Override
	public RiskDetailsDTO getInherentImpactRatingList(String impact, String likelihood) {
		List<RiskScoring> listScoring = riskScoringRepo.getInherentImpactRatingList(impact, likelihood);
		RiskDetailsDTO riskdetailDTO = new RiskDetailsDTO();
		List<Long> riskIdList = new ArrayList<>();
		for (RiskScoring riskDetalId : listScoring) {
			Long riskId = riskDetalId.getRiskId();
			riskIdList.add(riskId);
		}
		riskdetailDTO.setRiskListId(riskIdList);
		return riskdetailDTO;
	}

	@Override
	public RiskDetailsDTO getResidualImpactRatingList(String impact, String likelihood) {
		List<RiskScoring> listScoring = riskScoringRepo.getResidualImpactRatingList(impact, likelihood);
		RiskDetailsDTO riskdetailDTO = new RiskDetailsDTO();
		List<Long> riskIdList = new ArrayList<>();
		for (RiskScoring riskDetalId : listScoring) {
			Long riskId = riskDetalId.getRiskId();
			riskIdList.add(riskId);
		}
		riskdetailDTO.setRiskListId(riskIdList);
		return riskdetailDTO;
	}

	@Override
	public List<RiskScoringDTO> getInherentImpactRatingListForMap(String impact, String likelihood) {
		List<RiskScoring> listScoring = riskScoringRepo.getInherentImpactRatingList(impact, likelihood);
		return MapperUtils.mapToTargetClass(listScoring, RiskScoringDTO.class);
	}

	@Override
	public List<RiskScoringDTO> getResidualImpactRatingListForMap(String impact, String likelihood) {
		List<RiskScoring> listScoring = riskScoringRepo.getResidualImpactRatingList(impact, likelihood);
		return MapperUtils.mapToTargetClass(listScoring, RiskScoringDTO.class);
	}

	@Override
	public Long getInherentImpactRatingCount(String impact, String likelihood) {
		Long listScoringCount = riskScoringRepo.getInherentImpactRatingCount(impact, likelihood);
		return listScoringCount;
	}

	@Override
	public Long getResidualImpactRatingCount(String impact, String likelihood) {
		Long listScoringCount = riskScoringRepo.getResidualImpactRatingCount(impact, likelihood);
		return listScoringCount;
	}

	public List<HeatMapDTO> getInherentHeatMapCounts() {
		Map<String, Map<String, Long>> HeatMapConut = new LinkedHashMap<>();
		List<ImpactRiskRatingDTO> impactRating = riskRegisterService.getImpactRatingListDesc();
		for (ImpactRiskRatingDTO impRating : impactRating) {
			Map<String, Long> TempCountMap = new LinkedHashMap<>();
			List<LikelihoodRiskRatingDTO> likelihoodRatingList = riskRegisterService.getlikeLihoodRatingListAsc();
			for (LikelihoodRiskRatingDTO likeRating : likelihoodRatingList) {
				Long InherentImpactRatingCount = getInherentImpactRatingCount(impRating.getImpactRating(),
						likeRating.getLikeLihoodRating());
				TempCountMap.put(likeRating.getLikeLihoodRating(), InherentImpactRatingCount);
			}
			HeatMapConut.put(impRating.getImpactRating(), TempCountMap);
		}
		return HeatMapConut.entrySet().stream().map(e -> new HeatMapDTO(getSeriesData(e.getValue()), e.getKey()))
				.collect(Collectors.toList());
	}

	public List<HeatMapDTO> getResidualHeatMapCounts() {
		Map<String, Map<String, Long>> HeatMapConut = new LinkedHashMap<>();
		List<ImpactRiskRatingDTO> impactRating = riskRegisterService.getImpactRatingListDesc();
		for (ImpactRiskRatingDTO impRating : impactRating) {
			Map<String, Long> TempCountMap = new LinkedHashMap<>();
			List<LikelihoodRiskRatingDTO> likelihoodRatingList = riskRegisterService.getlikeLihoodRatingListAsc();
			for (LikelihoodRiskRatingDTO likeRating : likelihoodRatingList) {
				Long ResidualImpactRatingCount = getResidualImpactRatingCount(impRating.getImpactRating(),
						likeRating.getLikeLihoodRating());
				TempCountMap.put(likeRating.getLikeLihoodRating(), ResidualImpactRatingCount);
			}
			HeatMapConut.put(impRating.getImpactRating(), TempCountMap);
		}
		return HeatMapConut.entrySet().stream().map(e -> new HeatMapDTO(getSeriesData(e.getValue()), e.getKey()))
				.collect(Collectors.toList());
	}

	public List<RiskScoringDTO> getInherentHeatMapList() {
		List<RiskScoringDTO> inherentHeatMapList = new ArrayList<>();
		List<ImpactRiskRatingDTO> impactRating = riskRegisterService.getImpactRatingListDesc();
		for (ImpactRiskRatingDTO impRating : impactRating) {
			List<RiskScoringDTO> riskListTemp = new ArrayList<>();
			List<LikelihoodRiskRatingDTO> likelihoodRatingList = riskRegisterService.getlikeLihoodRatingListAsc();
			for (LikelihoodRiskRatingDTO likeRating : likelihoodRatingList) {
				Long InherentImpactRatingCount = getInherentImpactRatingCount(impRating.getImpactRating(),
						likeRating.getLikeLihoodRating());
				if (InherentImpactRatingCount > 0) {
					riskListTemp = getInherentImpactRatingListForMap(impRating.getImpactRating(),
							likeRating.getLikeLihoodRating());
					inherentHeatMapList.addAll(riskListTemp);
				}
				continue;
			}
		}
		return inherentHeatMapList;
	}

	public List<RiskScoringDTO> getResidualHeatMapList() {

		List<RiskScoringDTO> residualHeatMapList = new ArrayList<>();
		List<ImpactRiskRatingDTO> impactRating = riskRegisterService.getImpactRatingListDesc();
		for (ImpactRiskRatingDTO impRating : impactRating) {
			List<RiskScoringDTO> riskListTemp = new ArrayList<>();
			List<LikelihoodRiskRatingDTO> likelihoodRatingList = riskRegisterService.getlikeLihoodRatingListAsc();
			for (LikelihoodRiskRatingDTO likeRating : likelihoodRatingList) {
				Long ResidualImpactRatingCount = getResidualImpactRatingCount(impRating.getImpactRating(),
						likeRating.getLikeLihoodRating());
				if (ResidualImpactRatingCount > 0) {
					riskListTemp = getResidualImpactRatingListForMap(impRating.getImpactRating(),
							likeRating.getLikeLihoodRating());
					residualHeatMapList.addAll(riskListTemp);
				}
				continue;
			}
		}
		return residualHeatMapList;
	}


}