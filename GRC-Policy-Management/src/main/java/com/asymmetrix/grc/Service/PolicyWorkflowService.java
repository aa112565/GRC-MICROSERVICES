package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.OrderRequest;
import com.asymmetrix.grc.Dto.PolicyApprovalHistoryDTO;
import com.asymmetrix.grc.Dto.PolicyApprovalLevelDTO;
import com.asymmetrix.grc.Dto.PolicyApprovalStatusDTO;
import com.asymmetrix.grc.Dto.PolicyScoringApprovalDTO;
import com.asymmetrix.grc.Entity.PolicyApprovalStatus;

public interface PolicyWorkflowService {
	
	PolicyScoringApprovalDTO getApprovals(final OrderRequest orderRequest, final String userName, final String userDept);
    
	PolicyApprovalLevelDTO newApprovals(final PolicyScoringApprovalDTO approval, final String userName, final String userDept);
    
	PolicyApprovalLevelDTO findApprovalLevelStatus(final String policyUniqueId, final String policyId);
    
    List<PolicyApprovalStatus> findAllApprovalStatus();
    
    List<PolicyApprovalStatus> findApprovalStatusByApprovalId(final String approvalId);
    
    List<PolicyApprovalHistoryDTO> findApprovalStatus(final String policyUniqueId, final String policyId);
    
    PolicyApprovalStatusDTO newApprovalStatus(final PolicyApprovalStatusDTO orderRequest, final String username, final String department);

}
