package com.asymmetrix.grc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.Dto.MostAccessedDTO;
import com.asymmetrix.grc.Dto.PolicyDashboardCountDTO;
import com.asymmetrix.grc.Service.PolicyDashboardService;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;

@RestController
public class PolicyDashboardController {
	
	
	@Autowired
	private PolicyDashboardService policyDashboardService;
	
	
	@GetMapping("/policy/dashboard/count/policy")
	public ResponseEntity<?> getAuditDashboardCountByAudit() {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(policyDashboardService.getAllPolicyDashboardByActiveflag(), PolicyDashboardCountDTO.class));
	}
	
	@GetMapping("/policy/dashboard/count/attestation")
	public ResponseEntity<?> getAllPolicyDashboardByAttestation() {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(policyDashboardService.getAllPolicyDashboardByAttestation(), PolicyDashboardCountDTO.class));
	}
	
	
	
	@GetMapping("/policy/dashboard/count/viewed")
	public ResponseEntity<?> getPolicyMostAccessed() {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(policyDashboardService.getPolicyMostAccessed(), PolicyDashboardCountDTO.class));
	}
	
//	@GetMapping("/policy/dashboard/count/ageing")
//	public ResponseEntity<?> getPolicyAgeing(PolicyDashboardCountDTO policyDashboardCountDTO) {
//		policyDashboardCountDTO.setCount(15);
//		policyDashboardCountDTO.setKey("34");
//		return GRCResponseEntity
//				.success(MapperUtils.mapToTargetClass(policyDashboardService.getPolicyAgeing(), PolicyDashboardCountDTO.class));
//	}
	
	@GetMapping("/frequently/accessed/policies")
	public ResponseEntity<?> getAllPolicyDashboardByAgeing() {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(policyDashboardService.getAllPolicyDashboardByAgeing(), PolicyDashboardCountDTO.class));
	}
	
	@GetMapping("/ageing/analysis")
	public ResponseEntity<?> getAllPolicyAge() {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(policyDashboardService.getAllPolicyAge(), PolicyDashboardCountDTO.class));
	}
	
	
}
