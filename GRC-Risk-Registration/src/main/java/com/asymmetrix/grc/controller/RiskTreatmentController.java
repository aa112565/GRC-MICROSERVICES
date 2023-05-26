package com.asymmetrix.grc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.dto.RiskTreatmentDTO;
import com.asymmetrix.grc.service.RiskTreatmentService;


@RestController
@RequestMapping("/riskTreatment")
@PreAuthorize("isAuthenticated()")  
public class RiskTreatmentController {
	
	@Resource
	RiskTreatmentService riskTreatmentService;
	
	@GetMapping("/allResponseCategories")	
	public ResponseEntity<GRCResponse<?>> getAllResponseCategories() {
	    return GRCResponseEntity.success(riskTreatmentService.getAllResponseCategoryList());
	}
	
	@GetMapping("/allusers")	
	public ResponseEntity<GRCResponse<?>> getAllUsers() {
	    return GRCResponseEntity.success(riskTreatmentService.getAllUsers());
	}
	
	@PostMapping("/updateRiskTreatment")
	public ResponseEntity<GRCResponse<?>> updateRiskTreatment(@RequestBody List<RiskTreatmentDTO> riskTreatmentDTO) {
	    return GRCResponseEntity.success(riskTreatmentService.updateRiskTreatment(riskTreatmentDTO));
	}
	
	@GetMapping("/getRiskTreatments/{riskRegID}/{riskID}")
	public ResponseEntity<GRCResponse<?>> getRiskTreatments(@PathVariable(required = true) String riskRegID,
			@PathVariable(required = true) String riskID) {
		return GRCResponseEntity.success(riskTreatmentService.getRiskTreatmentsForRiskID(riskRegID, riskID));
	}

}
