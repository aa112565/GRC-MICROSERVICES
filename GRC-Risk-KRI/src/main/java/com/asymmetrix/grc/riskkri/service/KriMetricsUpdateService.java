package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KriMetricsUpdateDTO;
import com.asymmetrix.grc.riskkri.entity.KriFormula;
import com.asymmetrix.grc.riskkri.entity.KriMetricsUpdate;

public interface KriMetricsUpdateService {
	
	List<KriMetricsUpdate> getKriMetricsUpdate();
	KriMetricsUpdate getKriMetricsUpdateById(long metricsId);
	List<KriMetricsUpdate> getKriMetricsByKriId(String kriId);
	KriMetricsUpdate getKriMetricsLatestByKriId(String kriId);
	List<KriMetricsUpdate> findAllRecentMetrics();
	int getMetricsUpdateCount(String frequency, String financialYear, String kriId);
	int getMetricsUpdateCountFrequencyNull(String financialYear, String kriId);
	KriFormula getKriFormulaByKriId(String kriId);
	double getMetricsUpdateCurrentLevel(String kriId, String valueOne, String ValueTwo);
	KriMetricsUpdate createKriMetricsUpdate(KriMetricsUpdateDTO metricsDto);
	KriMetricsUpdate updateKriMetricsUpdate(KriMetricsUpdateDTO metricsDto);
	KriMetricsUpdate deleteKriMetricsUpdate(KriMetricsUpdateDTO otherdetailDto);

}
