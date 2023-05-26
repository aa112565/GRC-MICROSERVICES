package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.OrderRequest;
import com.asymmetrix.grc.dto.RiskApprovalHistoryDTO;
import com.asymmetrix.grc.dto.RiskApprovalLevelDTO;
import com.asymmetrix.grc.dto.RiskApprovalStatusDTO;
import com.asymmetrix.grc.dto.RiskScoringApprovalDTO;
import com.asymmetrix.grc.entity.RiskApprovalStatus;




public interface WorkflowService {
	 
	    RiskScoringApprovalDTO getApprovals(OrderRequest orderRequest, String userName, String userDept);	
		RiskApprovalLevelDTO newApprovals(RiskScoringApprovalDTO approval, String userName, String userDept);
		List<RiskApprovalStatus> findAllApprovalStatus();
		List<RiskApprovalStatus> findApprovalStatusByApprovalId(String approvalId);
		RiskApprovalStatusDTO newApprovalStatus(RiskApprovalStatusDTO orderRequest, String username, String department);
		List<RiskApprovalHistoryDTO> findApprovalStatus(String riskregId, String riskId);
		RiskApprovalLevelDTO findApprovalLevelStatus(String riskregId, String riskId);
	    
	
	   
}
