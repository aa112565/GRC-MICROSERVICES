package com.asymmetrix.grc.controller;



import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.service.RiskDashboardService;

@RestController
//@PreAuthorize("isAuthenticated()")
@RequestMapping("/dashboard")
public class RiskDashBoardController {

	@Resource
	RiskDashboardService dashBoardService;

	@GetMapping("/inherent/heatmap")
	public ResponseEntity<?> getInherentHeatMapData(Authentication auth) {
		 
		return GRCResponseEntity.success(dashBoardService.getInherentHeatMapData());
	}
	
	@GetMapping("/residual/heatmap")
	public ResponseEntity<?> getResidualHeatMapData(Authentication auth) {
		
		return GRCResponseEntity.success(dashBoardService.getResidualHeatMapData());
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/inherent/map/getdetails/{inherentImpactRating}/{inherentLikelihoodRating}")
	public ResponseEntity<?> getInherentHeatMapDetailData(Authentication auth, @NonNull @PathVariable(required = true) String inherentImpactRating, @PathVariable(required = true) String inherentLikelihoodRating) {
		
		return GRCResponseEntity.success( dashBoardService.getInherentImpactRatingList(inherentImpactRating, inherentLikelihoodRating));
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/residual/map/getdetails/{residualImpactRating}/{residualLikelihoodRating}")
	public ResponseEntity<?> getResidualHeatMapDetailData(Authentication auth,@NonNull @PathVariable(required = true) String residualImpactRating, @PathVariable(required = true) String residualLikelihoodRating) {
		 
		return GRCResponseEntity.success(dashBoardService.getResidualImpactRatingList(residualImpactRating, residualLikelihoodRating));
	}
	
	@GetMapping("/inherent/heatmapcounts")
	public ResponseEntity<?> getInherentHeatMapCounts(Authentication auth) {
		 
		return  GRCResponseEntity.success(dashBoardService.getInherentHeatMapCounts());
	}
	
	@GetMapping("/residual/heatmapcounts")
	public ResponseEntity<?> getResidualHeatMapCounts(Authentication auth) {
	
	  	
		return  GRCResponseEntity.success(dashBoardService.getResidualHeatMapCounts());
	}
	
	@GetMapping("/inherent/heatmapexport")
	public ResponseEntity<?> getInherentHeatMapDataExport(Authentication auth) {
		
		return GRCResponseEntity.success(dashBoardService.getInherentHeatMapList());
	}
	
	@GetMapping("/residual/heatmapexport")
	public ResponseEntity<?> getResidualHeatMapDataExport(Authentication auth) {
		
		return GRCResponseEntity.success(dashBoardService.getResidualHeatMapList());
	}
	

}
