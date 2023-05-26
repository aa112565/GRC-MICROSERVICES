package com.asymmetrix.grc.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.constants.GRCErrorConstants;
import com.asymmetrix.grc.dto.RiskScoringDTO;
import com.asymmetrix.grc.service.RiskRegisterService;

@RestController
@PreAuthorize("isAuthenticated()")
public class RiskScoringController {

	@Resource
	RiskRegisterService riskRegisterService;

//	@PreAuthorize("hasRole('ROLE_ERM_RISK_REGISTSER_CREATE')")
	@PostMapping("/scoring/save")
	public ResponseEntity<?> saveRiskScore(Authentication auth, @RequestBody(required = true) RiskScoringDTO model) {
	
		
		return GRCResponseEntity.success(riskRegisterService.saveRiskScoring(model));
	}

//	@PreAuthorize("hasRole('ROLE_ERM_RISK_REGISTSER_UPDATE')")
	@PutMapping("/scoring/update")
	public ResponseEntity<?> updateRiskScore(Authentication auth, @RequestBody(required = true) RiskScoringDTO model) {
		
		GRCUtils.isValid(model.getSrno(), GRCErrorConstants.ENTITY_NOT_FOUND + model.getSrno());
		return GRCResponseEntity.success(riskRegisterService.saveRiskScoring(model));
	}

//	@PreAuthorize("hasRole('ROLE_ERM_RISK_REGISTSER_READ')") 
	@GetMapping("/{riskRegId}/risk/{riskId}/getScore")
	public ResponseEntity<?> getRiskScore(@PathVariable(required = true, value = "riskRegId") String riskRegId,
			@PathVariable(required = true, value = "riskId") Long riskId) {
		return GRCResponseEntity.success(riskRegisterService.getRiskScoringById(riskRegId, riskId));
	}

	@GetMapping("/scoring/dropdown/currency")
	public ResponseEntity<?> getCurrencyList() {
		return GRCResponseEntity.success(riskRegisterService.getCurrencyList());
	}

	@GetMapping({ "/scoring/dropdown/impactRating", "/scoring/dropdown/impactRating/{impactRating}" })
	public ResponseEntity<?> getImpactRatingList(@PathVariable(required = false, value = "impactRating") String impactRating) {
		return GRCResponseEntity.success(ObjectUtils.isEmpty(impactRating) ? riskRegisterService.getImpactRatingList()
				: riskRegisterService.getImpactRatingListByScore(impactRating.trim()));
	}

	@GetMapping({"/scoring/dropdown/likelihoodRating", "/scoring/dropdown/likelihoodRating/{likeLihoodRating}"})
	public ResponseEntity<?> getlikeLihoodRatingList(@PathVariable(required = false, value = "likeLihoodRating") String likeLihoodRating) {
		return GRCResponseEntity.success(ObjectUtils.isEmpty(likeLihoodRating) ? riskRegisterService.getlikeLihoodRatingList() :
			riskRegisterService.getLikeLihoodRatingListByScore(likeLihoodRating.trim()));
	}

	@GetMapping("/scoring/dropdown/residual/riskRating")
	public ResponseEntity<?> getRiskRating() {
		return GRCResponseEntity.success(riskRegisterService.getRiskRatingList());
	}

//	@PreAuthorize("hasRole('ROLE_ERM_RISK_REGISTSER_READ')") 
	@GetMapping("/scoring/getInherentRiskRating")
	public ResponseEntity<?> getInherentRiskRating(@RequestParam(required = true, value = "impact") String impact,
			@RequestParam(required = true, value = "likelihood") String likelihood) {
		return GRCResponseEntity.success(riskRegisterService.getInherentRiskRating(impact, likelihood));
	}

//	@PreAuthorize("hasRole('ROLE_ERM_RISK_REGISTSER_READ')") 
	@GetMapping("/scoring/getResidualRiskRating")
	public ResponseEntity<?> getResidualRiskRating(@RequestParam(required = true, value = "impact") String impact,
			@RequestParam(required = true, value = "likelihood") String likelihood) {
		return GRCResponseEntity.success(riskRegisterService.getResidualRiskRating(impact, likelihood));
	}

}
