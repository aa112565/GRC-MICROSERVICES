package com.asymmetrix.grc.riskkri.service;

import java.util.Date;
import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KriDashboardDTO;
import com.asymmetrix.grc.riskkri.entity.KriFormula;
import com.asymmetrix.grc.riskkri.entity.KriMapBusinessLine;
import com.asymmetrix.grc.riskkri.entity.KriMetricsUpdate;
import com.asymmetrix.grc.riskkri.entity.KriOtherDetails;
import com.asymmetrix.grc.riskkri.entity.KriRiskRegistryRiskMapping;
import com.asymmetrix.grc.riskkri.entity.KriThresholdDefinition;
import com.asymmetrix.grc.riskkri.entity.RiskKri;

public interface KriDashboardService {
	
	List<KriMetricsUpdate> findAllMetrics();
	List<KriMetricsUpdate> findAllMetricsBetweenDates(Date sdate, Date edate);
	RiskKri getKriById(long kriId);
	KriMapBusinessLine getKriMapById(long mapId);
	KriFormula getKriFormulaId(long formId);
	KriOtherDetails getKriOtherDetailById(long detailId);
	KriThresholdDefinition getKriThresholdDefById(long thresholdId);
	KriMapBusinessLine getKriMapByKriId(String kriId);
	KriThresholdDefinition getKriThresholdDefByKriId(String kriId);
	KriFormula getKriFormulaByKriId(String kriId);
	KriOtherDetails getKriOtherDetailByKriId(String kriId);
	List<KriRiskRegistryRiskMapping> getKriRiskRegistryRiskMappingByKriId(String kriId);
	KriMetricsUpdate getKriMetricsLatestByKriId(String kriId);
	List<KriDashboardDTO> findAllKriWithMetrics();
	List<KriDashboardDTO> findAllKriWithMetricsBetweenDates(String fromdate, String todate);
	List<KriDashboardDTO> generateKriWithMetricsList(List<KriMetricsUpdate> mertricsupdatelist);

}
