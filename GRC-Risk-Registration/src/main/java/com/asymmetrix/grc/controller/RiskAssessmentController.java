package com.asymmetrix.grc.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.service.RiskAssessmentService;


@RestController
@RequestMapping("/risk/assessment")
@PreAuthorize("isAuthenticated()")
public class RiskAssessmentController {

	@Resource
	RiskAssessmentService riskAssessmentService;	
	
//	@PreAuthorize("hasRole('ROLE_ERM_RISK_REGISTSER_READ')") 
	@GetMapping("riskRegID/{riskRegID}/riskID/{riskID}/history")
	public ResponseEntity<?> getRiskAssessmentHistory(@PathVariable(required = true) String riskRegID, @PathVariable(required = true) String riskID) {
		return GRCResponseEntity.success(riskAssessmentService.getAssessmentHistory(riskRegID, riskID));
	}	
	

}
