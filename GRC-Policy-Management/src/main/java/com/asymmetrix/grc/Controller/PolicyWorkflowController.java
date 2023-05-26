package com.asymmetrix.grc.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.Dto.OrderRequest;
import com.asymmetrix.grc.Dto.PolicyApprovalHistoryDTO;
import com.asymmetrix.grc.Dto.PolicyApprovalLevelDTO;
import com.asymmetrix.grc.Dto.PolicyApprovalStatusDTO;
import com.asymmetrix.grc.Dto.PolicyScoringApprovalDTO;
import com.asymmetrix.grc.Entity.PolicyApprovalStatus;
import com.asymmetrix.grc.Service.PolicyWorkflowService;
import com.asymmetrix.grc.common.dto.LoginUserDetails;

import io.micrometer.core.lang.NonNull;

@RestController
@RequestMapping({ "/workflow" })
public class PolicyWorkflowController {
	
	@Autowired
    private PolicyWorkflowService workFlowService;
	
	
	 @PostMapping({ "/approval/status/find/all" })
	//    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<List<PolicyApprovalStatus>> findAllApprovalStatus(final Authentication auth) {
	        final OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	        final LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	        final List<PolicyApprovalStatus> approvalStatus = (List<PolicyApprovalStatus>)this.workFlowService.findAllApprovalStatus();
	        return (ResponseEntity<List<PolicyApprovalStatus>>)new ResponseEntity(approvalStatus, HttpStatus.OK);
	    }
	    
	    @GetMapping({ "/approval/status/find/approval/{id}" })
//	    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<List<PolicyApprovalStatus>> findApprovalStatusByApprovalId(final Authentication auth, @NonNull @PathVariable("id") final String approvalId) {
	        final OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	        final LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	        final List<PolicyApprovalStatus> approvalStatus = (List<PolicyApprovalStatus>)this.workFlowService.findApprovalStatusByApprovalId(approvalId);
	        return (ResponseEntity<List<PolicyApprovalStatus>>)new ResponseEntity(approvalStatus, HttpStatus.OK);
	    }
	    
	    @PostMapping({ "/approval" })
	//    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<PolicyScoringApprovalDTO> getApprovals(final Authentication auth, @RequestBody final OrderRequest orderRequest) {
	        final OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	        final LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	        System.out.println("+approvals+++name++++++++++++++  " + loginUserDetails.getUsername() + "+++++++++++++++++deptName++++++++++++++++  " + loginUserDetails.getDepartment());
	   
        final PolicyScoringApprovalDTO approval = this.workFlowService.getApprovals(orderRequest, loginUserDetails.getUsername(), loginUserDetails.getDepartment());
	    	
	        return (ResponseEntity<PolicyScoringApprovalDTO>)new ResponseEntity(approval, HttpStatus.OK);
	    }
	    
	    @PostMapping({ "/approval/history/find" })
	 //   @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<List<PolicyApprovalHistoryDTO>> findApprovalStatus(final Authentication auth, @RequestBody final OrderRequest orderRequest) {
	        final OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	        final LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	        System.out.println("++++findApprovalStatus++++++++++++++  " + loginUserDetails.getUsername() + "+++++++++++++++++deptName++++++++++++++++  " + loginUserDetails.getDepartment());
	        final List<PolicyApprovalHistoryDTO> approvalStatus = (List<PolicyApprovalHistoryDTO>)this.workFlowService.findApprovalStatus(orderRequest.getPolicyUniqueId(), orderRequest.getPolicyId());
	        return (ResponseEntity<List<PolicyApprovalHistoryDTO>>)new ResponseEntity((Object)approvalStatus, HttpStatus.OK);
	    }
	    
	    @PostMapping({ "/approval/level/find" })
	 //   @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<PolicyApprovalLevelDTO> findApprovalLevel(final Authentication auth, @RequestBody final OrderRequest orderRequest) {
	        final OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	        final LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	        final PolicyApprovalLevelDTO approvalLevel = this.workFlowService.findApprovalLevelStatus(orderRequest.getPolicyUniqueId(), orderRequest.getPolicyId());
	        return (ResponseEntity<PolicyApprovalLevelDTO>)new ResponseEntity((Object)approvalLevel, HttpStatus.OK);
	    }
	    
	    @PostMapping({ "/approval/status/new" })
//	    @PreAuthorize("isAuthenticated()")
	    public ResponseEntity<PolicyApprovalStatusDTO> newApprovals(final Authentication auth, @RequestBody final PolicyApprovalStatusDTO orderRequest) {
	        final OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	        final LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	        final PolicyApprovalStatusDTO approvalStatus = this.workFlowService.newApprovalStatus(orderRequest, loginUserDetails.getUsername(), loginUserDetails.getDepartment());
	        return (ResponseEntity<PolicyApprovalStatusDTO>)new ResponseEntity((Object)approvalStatus, HttpStatus.OK);
	    }

}
