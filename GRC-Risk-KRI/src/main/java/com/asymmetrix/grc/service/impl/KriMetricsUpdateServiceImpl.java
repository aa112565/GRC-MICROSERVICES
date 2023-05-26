package com.asymmetrix.grc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dao.KriFormulaRepo;
import com.asymmetrix.grc.riskkri.dao.KriMapBusinessLineRepo;
import com.asymmetrix.grc.riskkri.dao.KriMetricUpdateRepo;
import com.asymmetrix.grc.riskkri.dao.KriOtherDetailsRepo;
import com.asymmetrix.grc.riskkri.dao.KriThresholdDefinitionRepo;
import com.asymmetrix.grc.riskkri.dto.KriMetricsUpdateDTO;
import com.asymmetrix.grc.riskkri.entity.KriFormula;
import com.asymmetrix.grc.riskkri.entity.KriMapBusinessLine;
import com.asymmetrix.grc.riskkri.entity.KriMetricsUpdate;
import com.asymmetrix.grc.riskkri.entity.KriOtherDetails;
import com.asymmetrix.grc.riskkri.entity.KriThresholdDefinition;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KriMetricsUpdateService;

@Service
public class KriMetricsUpdateServiceImpl implements KriMetricsUpdateService{

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

	@Override
	public List<KriMetricsUpdate> getKriMetricsUpdate() {
		return this.metricsRepo.findAll();
	}

	@Override
	public KriMetricsUpdate getKriMetricsUpdateById(long metricsId) {
		return metricsRepo.findById(metricsId)
				.orElseThrow(() -> new ResourceNotFoundException("Kri-Metrics not found with  Id----> " + metricsId));
	}

	@Override
	public List<KriMetricsUpdate> getKriMetricsByKriId(String kriId) {
		return metricsRepo.findByKriId(kriId);
	}

	@Override
	public KriMetricsUpdate getKriMetricsLatestByKriId(String kriId) {
		return metricsRepo.findLatestByKriId(kriId);
	}

	@Override
	public List<KriMetricsUpdate> findAllRecentMetrics() {
		return metricsRepo.findAllMetrics();
	}

	@Override
	public int getMetricsUpdateCount(String frequency, String financialYear, String kriId) {
		int metricsCount = metricsRepo.getMetricsUpdateCount(frequency, financialYear, kriId);
		return metricsCount;
	}

	@Override
	public int getMetricsUpdateCountFrequencyNull(String financialYear, String kriId) {
		int metricsCount = metricsRepo.getMetricsUpdateCountFrequencyNull(financialYear, kriId);
		return metricsCount;
	}

	@Override
	public KriFormula getKriFormulaByKriId(String kriId) {
		return formulaRepo.findByKriId(kriId);
	}

	@Override
	public double getMetricsUpdateCurrentLevel(String kriId, String valueOne, String ValueTwo) {
		KriFormula metricsCountFormula = getKriFormulaByKriId(kriId);
		String formulaId = metricsCountFormula.getFormulaId();
		double currentLevelScore = calculateScore(valueOne, ValueTwo, formulaId);
		return currentLevelScore;
	}

	private double calculateScore(String valueOne, String ValueTwo, String formulaId) {
		double fieldonevalue = Double.parseDouble(valueOne);
		double fieldtwovalue = Double.parseDouble(ValueTwo);

		double currentvalue = 0;
		switch (formulaId) {
		case "one":
			currentvalue = fieldonevalue - fieldtwovalue;
			break;
		case "two":
			currentvalue = fieldonevalue / fieldtwovalue;
			break;
		case "three":
			currentvalue = (fieldonevalue - fieldtwovalue) / fieldtwovalue;
			break;

		case "four":
			currentvalue = fieldonevalue;
			break;
		}

		return currentvalue;
	}

	@Override
	public KriMetricsUpdate createKriMetricsUpdate(KriMetricsUpdateDTO metricsDto) {
		String updatedby = null;
		updatedby = metricsDto.getModifiedBy();
		KriMetricsUpdate krimetric = MapperUtils.mapToTargetClass(metricsDto, KriMetricsUpdate.class);

		KriMapBusinessLine kribusinessline = mapRepo.findByKriId(metricsDto.getKriId());
		String bussLineId = Long.toString(kribusinessline.getBuninessLineId());

		KriFormula metricsCountFormula = getKriFormulaByKriId(metricsDto.getKriId());
		String formulaId = Long.toString(metricsCountFormula.getFormId());

		KriThresholdDefinition krithreshold = thresholdDefRepo.findByKriId(metricsDto.getKriId());
		String thresholdId = Long.toString(krithreshold.getThresholdDefId());

		KriOtherDetails kriotherdetail = detailsRepo.findByKriId(metricsDto.getKriId());
		String otherdetailId = Long.toString(kriotherdetail.getDetailId());

		int metricsCountNum = metricsRepo.getLatestCountByKriId(metricsDto.getKriId());

		int metricsCount = 0;
		if (krimetric.getFrequency() == null || krimetric.getFrequency().isEmpty()) {
			metricsCount = getMetricsUpdateCountFrequencyNull(krimetric.getFinancialYear(), krimetric.getKriId());
		} else {
			metricsCount = getMetricsUpdateCount(krimetric.getFrequency(), krimetric.getFinancialYear(),
					krimetric.getKriId());
		}

		if (metricsCount <= 0) {
			if (metricsCountNum > 0) {
				KriMetricsUpdate latestkrimetric = getKriMetricsLatestByKriId(metricsDto.getKriId());
				@SuppressWarnings("unused")
				boolean modifyLatest = changeLatestUpdate(latestkrimetric);
			}

			double currlevelscore = getMetricsUpdateCurrentLevel(krimetric.getKriId(), krimetric.getFieldOneValue(),
					krimetric.getFieldTwoValue());
			krimetric.setCurrentLevel(String.valueOf(currlevelscore));

			krimetric.setBuninessLineId(bussLineId);
			krimetric.setFormulaId(formulaId);
			krimetric.setThresholdDefId(thresholdId);
			krimetric.setOtherDetailId(otherdetailId);

			krimetric.setActiveFlag("Y");
			krimetric.setDeleteFlag("N");
			krimetric.setModifiedBy(updatedby);
			return metricsRepo.save(krimetric);
		}
		return new KriMetricsUpdate();
	}

	@Override
	public KriMetricsUpdate updateKriMetricsUpdate(KriMetricsUpdateDTO metricsDto) {
		/*
		 * KriMetricsUpdate krimetric = MapperUtils.mapToTargetClass(metricsDto,
		 * KriMetricsUpdate.class);
		 * 
		 * @SuppressWarnings("unused") KriMetricsUpdate existingkrimetric =
		 * getKriMetricsUpdateById(krimetric.getMetricsId()); return
		 * this.metricsRepo.save(krimetric);
		 */
		return createKriMetricsUpdate(metricsDto);
	}

	public boolean changeLatestUpdate(KriMetricsUpdate metrics) {
		int metricsCountNum = metricsRepo.getLatestCountByKriId(metrics.getKriId());
		if (metricsCountNum > 0) {
			KriMetricsUpdate existingkrimetric = getKriMetricsLatestByKriId(metrics.getKriId());
			existingkrimetric.setActiveFlag("N");
			metricsRepo.save(existingkrimetric);
			return true;
		} else
			return false;
	}

	@Override
	public KriMetricsUpdate deleteKriMetricsUpdate(KriMetricsUpdateDTO otherdetailDto) {
		KriMetricsUpdate krimetric = MapperUtils.mapToTargetClass(otherdetailDto, KriMetricsUpdate.class);
		KriMetricsUpdate existingkrimetric = getKriMetricsUpdateById(krimetric.getMetricsId());
		existingkrimetric.setActiveFlag("N");
		existingkrimetric.setDeleteFlag("D");
		return this.metricsRepo.save(existingkrimetric);
	}
}
