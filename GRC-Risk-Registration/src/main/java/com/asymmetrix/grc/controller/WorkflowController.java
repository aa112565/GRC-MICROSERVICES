package com.asymmetrix.grc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.dto.LoginUserDetails;
//import com.asymmetrix.grc.dto.OrderDiscount;
import com.asymmetrix.grc.dto.OrderRequest;
import com.asymmetrix.grc.dto.RiskApprovalHistoryDTO;
import com.asymmetrix.grc.dto.RiskApprovalLevelDTO;
import com.asymmetrix.grc.dto.RiskApprovalStatusDTO;
import com.asymmetrix.grc.dto.RiskScoringApprovalDTO;
import com.asymmetrix.grc.entity.RiskApprovalStatus;
import com.asymmetrix.grc.service.WorkflowService;


@RestController
@RequestMapping("/riskregister")
public class WorkflowController {

	   @Autowired
	    private WorkflowService workFlowService;
	   
	    @PostMapping("/approval/status/find/all")
	    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<List<RiskApprovalStatus>>  findAllApprovalStatus(Authentication auth) {
	    	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			@SuppressWarnings("unused")
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();			
		//	System.out.println("++++name++++++++++++++  "+ loginUserDetails.getUsername() + "+++++++++++++++++deptName++++++++++++++++  " + loginUserDetails.getDepartment());
			List<RiskApprovalStatus> approvalStatus= workFlowService.findAllApprovalStatus();	
	        return new ResponseEntity<>(approvalStatus, HttpStatus.OK);
	    }
	      
	    @GetMapping("/approval/status/find/approval/{id}")
	    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<List<RiskApprovalStatus>>  findApprovalStatusByApprovalId(Authentication auth, @NonNull @PathVariable(value = "id") String approvalId) {
	    	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			@SuppressWarnings("unused")
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();			
	//		System.out.println("++++name++++++++++++++  "+ loginUserDetails.getUsername() + "+++++++++++++++++deptName++++++++++++++++  " + loginUserDetails.getDepartment());
		
			List<RiskApprovalStatus> approvalStatus= workFlowService.findApprovalStatusByApprovalId(approvalId);	
	        return new ResponseEntity<>(approvalStatus, HttpStatus.OK);
	    }
	    
	    @GetMapping("/approval/history/find/riskreg/{riskregId}/risk/{riskId}")
	    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<List<RiskApprovalHistoryDTO>>  findApprovalStatus(Authentication auth, @NonNull @PathVariable(value = "riskregId") String riskregId, @NonNull @PathVariable(value = "riskId") String riskId) {
	    	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			@SuppressWarnings("unused")
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();			
	//		System.out.println("++++name++++++++++++++  "+ loginUserDetails.getUsername() + "+++++++++++++++++deptName++++++++++++++++  " + loginUserDetails.getDepartment());
		
			List<RiskApprovalHistoryDTO> approvalStatus= workFlowService.findApprovalStatus(riskregId, riskId);	
	        return new ResponseEntity<>(approvalStatus, HttpStatus.OK);
	    }

	    @GetMapping("/approval/level/find/riskreg/{riskregId}/risk/{riskId}")
	    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<RiskApprovalLevelDTO>  findApprovalLevel(Authentication auth, @NonNull @PathVariable(value = "riskregId") String riskregId, @NonNull @PathVariable(value = "riskId") String riskId) {
	    	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			@SuppressWarnings("unused")
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();			
	//		System.out.println("++++name++++++++++++++  "+ loginUserDetails.getUsername() + "+++++++++++++++++deptName++++++++++++++++  " + loginUserDetails.getDepartment());
		
			RiskApprovalLevelDTO approvalLevel= workFlowService.findApprovalLevelStatus(riskregId, riskId);	
	        return new ResponseEntity<>(approvalLevel, HttpStatus.OK);
	    }
	 
	    @PostMapping("/approvals")
	    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<RiskScoringApprovalDTO> getApprovals(Authentication auth, @RequestBody OrderRequest orderRequest) {
	    	
	    	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();			
	//		System.out.println("+approvals+++name++++++++++++++  "+ loginUserDetails.getUsername() + "+++++++++++++++++deptName++++++++++++++++  " + loginUserDetails.getDepartment());
	    	RiskScoringApprovalDTO approval = workFlowService.getApprovals(orderRequest, loginUserDetails.getUsername(), loginUserDetails.getDepartment());
	        return new ResponseEntity<>(approval, HttpStatus.OK);
	    }
	    
	    @PostMapping("/approval/status/new")
		@PreAuthorize("hasAnyRole('ROLE_RISK_SUPERVISOR_WRITE', 'ROLE_RISK_APPROVER_WRITE', 'ROLE_RISK_BU_APPROVER_WRITE')") 
	    public ResponseEntity<RiskApprovalStatusDTO> newApprovals(Authentication auth, @RequestBody RiskApprovalStatusDTO orderRequest) {
	    	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();		
	//		System.out.println("++status/new++name++++++++++++++  "+ loginUserDetails.getUsername() + "+++++++++++++++++LEVEL++++++++++++++++  " + loginUserDetails.getUserLevel());
			RiskApprovalStatusDTO  approvalStatus = workFlowService.newApprovalStatus(orderRequest, loginUserDetails.getUsername(), loginUserDetails.getDepartment());
	        return new ResponseEntity<>(approvalStatus, HttpStatus.OK);
	    }
	    
	
	}
