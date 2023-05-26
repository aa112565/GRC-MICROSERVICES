package com.asymmetrix.grc.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.dto.RiskRegisterDTO;
import com.asymmetrix.grc.repository.RiskRegisterMappingRepository;
import com.asymmetrix.grc.service.RiskRegisterService;

@RestController
@RequestMapping("/register/risks")
@PreAuthorize("isAuthenticated()")
public class RiskRegisterController {

	@Resource
	RiskRegisterService riskRegisterService;
	
	@Resource
	RiskRegisterMappingRepository  riskRegMapRepo;

	@PostMapping("/ActiveRiskIds/All")
	public ResponseEntity<?> getAllActiveRiskIds() {
		
	  	
		
		return GRCResponseEntity.success(riskRegisterService.getAllActiveRiskIds());
	}
	
	@PostMapping("/ActiveRiskIds/Scoring/All")
	public ResponseEntity<?> getAllActiveRiskIdswithScoring() {		
		
		return GRCResponseEntity.success(riskRegisterService.getAllActiveRiskIdswithScoring());
	}
	
	@PostMapping("/Approval/All")
	public ResponseEntity<?> getApprovalListswithScoring() {		
		
		return GRCResponseEntity.success(riskRegisterService.getApprovalListwithScoring());
	}
	
	@PostMapping("/Approval/Action")
	public ResponseEntity<?> getApprovalActionListwithScoring() {
		
		return GRCResponseEntity.success(riskRegisterService.getApprovalActionwithScoring());
	}
		
	@GetMapping("/getActiveRiskIds")
	public ResponseEntity<?> getActiveRiskIds(@RequestParam(required = true) String wsId,
			@RequestParam(required = true) String deptId) {
		
		
		return GRCResponseEntity.success(riskRegisterService.getActiveRiskIds(wsId, deptId));
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveToRiskRegAndRiskRegMapping(Authentication auth, @RequestBody(required = true) RiskRegisterDTO model) {
		 OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	  	  LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	  //	  String uname = loginUserDetails.getUsername();
	 // 	  String branchname = loginUserDetails.getBranchCode();
	  	  model.setCreatedBy(loginUserDetails.getUsername());	  	  
	//  	  model.setBranchName(branchname);
	//  	 System.out.println("auth name"+uname+"---------------"+" additonal info--------"+branchname);
		
		return GRCResponseEntity.success(riskRegisterService.saveToRiskRegAndRiskRegMapping(model));
	}

}
