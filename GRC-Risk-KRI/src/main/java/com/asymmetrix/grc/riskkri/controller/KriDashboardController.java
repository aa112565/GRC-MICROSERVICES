package com.asymmetrix.grc.riskkri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.response.KRIResponseEntity;
import com.asymmetrix.grc.riskkri.dto.KriDashboardDTO;
import com.asymmetrix.grc.riskkri.dto.KriDetailsDTO;
import com.asymmetrix.grc.riskkri.service.KriDashboardService;


@RestController
@RequestMapping("/kri/dashboard")
public class KriDashboardController {

	@Autowired
	private KriDashboardService dashboardService;

	private static final String READ_ALL_ACTION = "READ-ALL-KRI-METRICS-DETAILS";
	private static final String READ_ALL_DATES_ACTION = "READ-ALL-BETWEEN-DATES-KRI-METRICS-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/find/all/metrics")
	public ResponseEntity<?> getKriMetricsUpdateList() {
		List<KriDashboardDTO> kridasboardlist = dashboardService.findAllKriWithMetrics();
		KriDetailsDTO kridto = new KriDetailsDTO();
		kridto.setKridashboard(kridasboardlist);
		return KRIResponseEntity.success(kridto);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_DATES_ACTION)
	@GetMapping("/find/all/metrics/{fromdate}/{todate}")
	public ResponseEntity<?> getKriMetricsUpdateListBetweenDates(@PathVariable("fromdate") String fromdate,
			@PathVariable("todate") String todate) {
		// System.out.println("++++++StartDate+++++"+fromdate +"End Date"+todate);
		List<KriDashboardDTO> kridasboardlist = dashboardService.findAllKriWithMetricsBetweenDates(fromdate, todate);
		KriDetailsDTO kridto = new KriDetailsDTO();
		kridto.setKridashboard(kridasboardlist);
		return KRIResponseEntity.success(kridto);
	}
}
