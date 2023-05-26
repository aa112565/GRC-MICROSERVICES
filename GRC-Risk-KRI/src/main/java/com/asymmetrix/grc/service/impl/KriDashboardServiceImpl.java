package com.asymmetrix.grc.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dao.KriFormulaRepo;
import com.asymmetrix.grc.riskkri.dao.KriMapBusinessLineRepo;
import com.asymmetrix.grc.riskkri.dao.KriMetricUpdateRepo;
import com.asymmetrix.grc.riskkri.dao.KriOtherDetailsRepo;
import com.asymmetrix.grc.riskkri.dao.KriRiskRegistryRiskMappingRepo;
import com.asymmetrix.grc.riskkri.dao.KriThresholdDefinitionRepo;
import com.asymmetrix.grc.riskkri.dao.RiskKriRepository;
import com.asymmetrix.grc.riskkri.dto.KriDashboardDTO;
import com.asymmetrix.grc.riskkri.entity.KriFormula;
import com.asymmetrix.grc.riskkri.entity.KriMapBusinessLine;
import com.asymmetrix.grc.riskkri.entity.KriMetricsUpdate;
import com.asymmetrix.grc.riskkri.entity.KriOtherDetails;
import com.asymmetrix.grc.riskkri.entity.KriRiskRegistryRiskMapping;
import com.asymmetrix.grc.riskkri.entity.KriThresholdDefinition;
import com.asymmetrix.grc.riskkri.entity.RiskKri;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KriDashboardService;

@Service
public class KriDashboardServiceImpl implements KriDashboardService {

	@Autowired
	private RiskKriRepository riskKriRepo;

	@Autowired
	private KriMetricUpdateRepo metricsRepo;

	@Autowired
	private KriMapBusinessLineRepo mapRepo;

	@Autowired
	private KriFormulaRepo formulaRepo;

	@Autowired
	private KriOtherDetailsRepo detailsRepo;

	@Autowired
	private KriThresholdDefinitionRepo thresholdDefRepo;

	@Autowired
	private KriRiskRegistryRiskMappingRepo kriRegistryMapRepo;

	@Override
	public List<KriMetricsUpdate> findAllMetrics() {
		return metricsRepo.findAllMetrics();
	}

	@Override
	public List<KriMetricsUpdate> findAllMetricsBetweenDates(Date sdate, Date edate) {
		return metricsRepo.findAllMetricsBetweenDates(sdate, edate);
	}

	@Override
	public RiskKri getKriById(long kriId) {
		return riskKriRepo.findById(kriId)
				.orElseThrow(() -> new ResourceNotFoundException("Risk-KRI not found with  Id----> " + kriId));
	}

	@Override
	public KriMapBusinessLine getKriMapById(long mapId) {
		return mapRepo.findById(mapId)
				.orElseThrow(() -> new ResourceNotFoundException("Kri-Map not found with  Id----> " + mapId));
	}

	@Override
	public KriFormula getKriFormulaId(long formId) {
		return formulaRepo.findById(formId)
				.orElseThrow(() -> new ResourceNotFoundException("Kri-Formula not found with  Id----> " + formId));
	}

	@Override
	public KriOtherDetails getKriOtherDetailById(long detailId) {
		return detailsRepo.findById(detailId).orElseThrow(
				() -> new ResourceNotFoundException("Kri-Other Detail not found with  Id----> " + detailId));
	}

	@Override
	public KriThresholdDefinition getKriThresholdDefById(long thresholdId) {
		return thresholdDefRepo.findById(thresholdId).orElseThrow(
				() -> new ResourceNotFoundException("Kri-Threshold Definition not found with  Id----> " + thresholdId));
	}

	@Override
	public KriMapBusinessLine getKriMapByKriId(String kriId) {
		return mapRepo.findByKriId(kriId);
	}

	@Override
	public KriThresholdDefinition getKriThresholdDefByKriId(String kriId) {
		return thresholdDefRepo.findByKriId(kriId);
	}

	@Override
	public KriFormula getKriFormulaByKriId(String kriId) {
		return formulaRepo.findByKriId(kriId);
	}

	@Override
	public KriOtherDetails getKriOtherDetailByKriId(String kriId) {
		return detailsRepo.findByKriId(kriId);
	}

	@Override
	public List<KriRiskRegistryRiskMapping> getKriRiskRegistryRiskMappingByKriId(String kriId) {
		return kriRegistryMapRepo.findByKriId(kriId);
	}

	@Override
	public KriMetricsUpdate getKriMetricsLatestByKriId(String kriId) {
		return metricsRepo.findLatestByKriId(kriId);
	}

	@Override
	public List<KriDashboardDTO> findAllKriWithMetrics() {
		// System.out.println("+++++++++++++++++++++findAllKriWithMetrics++++++++++++++++++++++++++++");
		List<KriMetricsUpdate> mertricsupdatelist = findAllMetrics();
		List<KriDashboardDTO> kriwithmetricslist = generateKriWithMetricsList(mertricsupdatelist);
		return kriwithmetricslist;
	}

	@Override
	public List<KriDashboardDTO> findAllKriWithMetricsBetweenDates(String fromdate, String todate) {
		List<KriMetricsUpdate> kridasboardlist = new ArrayList<>();
		String startdate = fromdate.trim().replace("-", "/");
		String enddate = todate.trim().replace("-", "/");
		Date sdate = null, edate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			sdate = formatter.parse(startdate);
			edate = formatter.parse(enddate);
			// System.out.println("Date is: "+sdate+"+++++++"+edate);
			kridasboardlist = findAllMetricsBetweenDates(sdate, edate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<KriDashboardDTO> kriwithmetricslist = generateKriWithMetricsList(kridasboardlist);
		return kriwithmetricslist;
	}

	@Override
	public List<KriDashboardDTO> generateKriWithMetricsList(List<KriMetricsUpdate> mertricsupdatelist) {

	//	System.out.println("+++++++++++++++++++++KriWithMetrics++++++++++++++++mertricsupdatelist-size++++++++++++"
	//			+ mertricsupdatelist.size());
		List<KriDashboardDTO> kriwithmetricslist = new ArrayList<>();

		for (KriMetricsUpdate mertric : mertricsupdatelist) {
			KriDashboardDTO krimetricsdashboard = new KriDashboardDTO();

			RiskKri kridetail = getKriById(Long.parseLong(mertric.getKriId()));
			krimetricsdashboard = MapperUtils.mapToTargetClass(kridetail, KriDashboardDTO.class);

			// KriMapBusinessLine kribusinessline = getKriMapByKriId(mertric.getKriId());
			KriMapBusinessLine kribusinessline = getKriMapById(Long.parseLong(mertric.getBuninessLineId()));
			krimetricsdashboard.setBuninessLineOne(kribusinessline.getBuninessLineOne());
			krimetricsdashboard.setBuninessLineTwo(kribusinessline.getBuninessLineTwo());

			// KriThresholdDefinition krithreshold =
			// getKriThresholdDefByKriId(mertric.getKriId());
			KriThresholdDefinition krithreshold = getKriThresholdDefById(Long.parseLong(mertric.getThresholdDefId()));
			krimetricsdashboard.setEscalationLevel(krithreshold.getEscalationLevel());
			krimetricsdashboard.setWarningLevel(krithreshold.getWarningLevel());
			krimetricsdashboard.setThreshold(krithreshold.getThreshold());
			krimetricsdashboard.setMeasuringScale(krithreshold.getMeasuringScale());

			// KriOtherDetails kriotherdetail =
			// getKriOtherDetailByKriId(mertric.getKriId());
			KriOtherDetails kriotherdetail = getKriOtherDetailById(Long.parseLong(mertric.getOtherDetailId()));
			krimetricsdashboard.setReviewFrequency(kriotherdetail.getReviewFrequency());

			krimetricsdashboard.setFinancialYear(mertric.getFinancialYear());
			krimetricsdashboard.setCurrentLevel(mertric.getCurrentLevel());
			// krimetricsdashboard.setCreatedDate(mertric.getCreatedDate());
			krimetricsdashboard.setModifiedDate(mertric.getCreatedDate());

			kriwithmetricslist.add(krimetricsdashboard);
		}

		return kriwithmetricslist;
	}

}
