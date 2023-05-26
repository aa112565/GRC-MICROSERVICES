package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.OrderRequest;
import com.asymmetrix.grc.dto.RiskApprovalHistoryDTO;
import com.asymmetrix.grc.dto.RiskApprovalLevelDTO;
import com.asymmetrix.grc.dto.RiskApprovalStatusDTO;
import com.asymmetrix.grc.dto.RiskScoringApprovalDTO;
import com.asymmetrix.grc.entity.RiskApprovalLevel;
import com.asymmetrix.grc.entity.RiskApprovalStatus;
import com.asymmetrix.grc.entity.RiskRegister;
import com.asymmetrix.grc.repository.RiskApprovalLevelRepo;
import com.asymmetrix.grc.repository.RiskApprovalStatusRepo;
import com.asymmetrix.grc.repository.RiskRegisterRepository;
import com.asymmetrix.grc.repository.RiskScoringRepository;
import com.asymmetrix.grc.service.WorkflowService;



@Service
public class WorkflowServiceImpl implements WorkflowService{
	
		@Autowired
	    private KieContainer kieContainer;
		
		@Resource
		RiskApprovalLevelRepo riskApprovalLevelRepo;
		
		@Resource
		RiskApprovalStatusRepo riskApprovalStatusRepo;
		
		
		@Resource
		RiskScoringRepository riskScoringRepo;
		
		@Resource
		RiskRegisterRepository registryRepo;
		
		@Transactional
		@Override
	    public RiskScoringApprovalDTO getApprovals(OrderRequest orderRequest, String userName, String userDept) {
			
			System.out.println("+++++++++++++++++getApprovals+++++++++++++++++  ");

	  //  	 OrderDiscount orderDiscount = new OrderDiscount();
	    	RiskScoringApprovalDTO riskScoringApprovalDTO = new RiskScoringApprovalDTO();
	    	riskScoringApprovalDTO.setRiskRegId(orderRequest.getRiskRegId());
	    	riskScoringApprovalDTO.setRiskId(orderRequest.getRiskId());
	    	riskScoringApprovalDTO.setRemarks(orderRequest.getRemarks());
	        KieSession kieSession = kieContainer.newKieSession();
	        kieSession.setGlobal("riskScoringApprovalDTO", riskScoringApprovalDTO);
	        kieSession.insert(orderRequest);
	        kieSession.fireAllRules();
	        kieSession.dispose();
	        @SuppressWarnings("unused")
			RiskApprovalLevelDTO tempLevel = newApprovals(riskScoringApprovalDTO, userName, userDept);
	        return riskScoringApprovalDTO;
	    }

		
		@Transactional
		@Override
		public RiskApprovalLevelDTO newApprovals(RiskScoringApprovalDTO approval, String userName, String userDept) {
			// TODO Auto-generated method stub
			long count = riskApprovalLevelRepo.countByRiskRegIdAndRiskId(approval.getRiskRegId(), approval.getRiskId());
			RiskApprovalLevel approvalLevel = null;
						
			RiskRegister riskRegis = registryRepo.findByRiskRegId(approval.getRiskRegId());
			RiskApprovalStatusDTO approvalStatustDto = new RiskApprovalStatusDTO();			
			
			RiskApprovalLevelDTO approvalLevelDto =  MapperUtils.mapToTargetClass(approval, RiskApprovalLevelDTO.class);
			approvalLevelDto.setActiveFlag("Y");
			approvalLevelDto.setDeleteFlag("N");
			approvalLevelDto.setRiskDeptId(riskRegis.getDeptId());
			approvalLevelDto.setRiskOwnerName(riskRegis.getOwnerName());	
			approvalLevelDto.setRiskBusinessUnit(userDept);			
			approvalLevelDto.setCreatedBy(userName);
			approvalLevelDto.setModifiedBy(userName);
			
			approvalLevelDto.setLevelOneStatus("Initiated");
			if (approval.getLevelTwoApprover().equalsIgnoreCase("NA")) {
				approvalLevelDto.setLevelTwoStatus("NA");
				} else {
					approvalLevelDto.setLevelTwoStatus("Initiated");
				}
			approvalLevelDto.setLevelThreeStatus("Initiated");
			approvalLevelDto.setStatus("Initiated");
			
			if(count <= 0) {
				System.out.println("+++++++++++++++++newApprovals+++++++++++++++++  ");	
			approvalLevel = riskApprovalLevelRepo.save(MapperUtils.mapToTargetClass(approvalLevelDto, RiskApprovalLevel.class));
			}else {
				return MapperUtils.mapToTargetClass(riskApprovalLevelRepo.findByRiskRegIdAndRiskId(approval.getRiskRegId(), approval.getRiskId()), RiskApprovalLevelDTO.class);
			}
			
			approvalStatustDto.setApprovalId(approvalLevel.getApprovalId());
			approvalStatustDto.setRiskRegId(approvalLevel.getRiskRegId());
			approvalStatustDto.setRiskId(approvalLevel.getRiskId());
			approvalStatustDto.setApprovalLevel("L1");
			approvalStatustDto.setApprovalStatus("Initiated");
			approvalStatustDto.setComments(approval.getRemarks());			
			
			if (!ObjectUtils.isEmpty(approvalLevel)) {			
			riskScoringRepo.updateRiskApprovalInitToActive("Initiated", approvalLevel.getRiskRegId(), Long.parseLong(approvalLevel.getRiskId()));
			@SuppressWarnings("unused")
			RiskApprovalStatus approvalStatus = riskApprovalStatusRepo.save(MapperUtils.mapToTargetClass(approvalStatustDto, RiskApprovalStatus.class));
			}
			return MapperUtils.mapToTargetClass(approvalLevel, RiskApprovalLevelDTO.class);
		}
		
		
		
		@Override
		public RiskApprovalLevelDTO findApprovalLevelStatus(String riskregId, String riskId) {		
			return MapperUtils.mapToTargetClass(riskApprovalLevelRepo.findByRiskRegIdAndRiskId(riskregId, riskId), RiskApprovalLevelDTO.class);
		}


		@Override
		public List<RiskApprovalStatus> findAllApprovalStatus() {		
			return riskApprovalStatusRepo.findAll();
		}


		@Override
		public List<RiskApprovalStatus> findApprovalStatusByApprovalId(String approvalId) {			
			return riskApprovalStatusRepo.findByApprovalId(approvalId);
		}
		
		@Override
		public List<RiskApprovalHistoryDTO> findApprovalStatus(String riskregId, String riskId) {			
			return riskApprovalStatusRepo.findByRiskRegIdAndRiskId(riskregId, riskId);
		}
	    


		@Override
		public RiskApprovalStatusDTO newApprovalStatus(RiskApprovalStatusDTO orderRequest, String username,
				String department) {
			 String levelOneStatus = null;
			 String levelTwoStatus = null;
			 String levelThreeStatus = null;
			 String approvalLevelStatus = null;
			 
			RiskApprovalLevel approvalLevel = riskApprovalLevelRepo.findByRiskRegIdAndRiskId(orderRequest.getRiskRegId(), orderRequest.getRiskId());
		
			orderRequest.setActiveFlag("Y");
			orderRequest.setDeleteFlag("N");
			orderRequest.setCreatedBy(username);
			orderRequest.setModifiedBy(username);
			orderRequest.setApprovalId(approvalLevel.getApprovalId());
			
			
			 
			if (approvalLevel.getLevelOneStatus() != null) {
				levelOneStatus = approvalLevel.getLevelOneStatus();
				System.out.println("=======approvalLevel=L1==="+approvalLevel.getLevelOneStatus());
				     switch (levelOneStatus) {
				     case "Initiated":
				    	 orderRequest.setApprovalLevel("L1");
				    	  break;
				     case "Approved":
				    	 if (approvalLevel.getLevelTwoStatus() != null) {
								levelTwoStatus = approvalLevel.getLevelTwoStatus();
								if (levelTwoStatus.equalsIgnoreCase("NA")) {
									 orderRequest.setApprovalLevel("L3");
									}
								else {
									orderRequest.setApprovalLevel("L2");
									}
								}				    	 
				    	  break;
				     case "Rejected":
				    	 orderRequest.setApprovalLevel("L1");
				    	  break;
				     case "Pending":
				    	 orderRequest.setApprovalLevel("L1");
				    	  break;	  
				 	}	
			}
			
			if (approvalLevel.getLevelTwoStatus() != null) {
				levelTwoStatus = approvalLevel.getLevelTwoStatus();
				System.out.println("=======approvalLevel=L2==="+approvalLevel.getLevelTwoStatus());
				     switch (levelTwoStatus) {
				  /*   case "NA":
				    	 orderRequest.setApprovalLevel("L3");
				    	  break;	
				   */ 	  			   	  
				     case "Approved":
				    	 orderRequest.setApprovalLevel("L3");
				    	  break;
				     case "Rejected":
				    	 orderRequest.setApprovalLevel("L2");
				    	  break;
				     case "Pending":
				    	 orderRequest.setApprovalLevel("L2");
				    	  break;	  
				 	}	
			}
			
			if (approvalLevel.getLevelThreeStatus() != null) {
				levelThreeStatus = approvalLevel.getLevelThreeStatus();
				System.out.println("=======approvalLevel==L3=="+approvalLevel.getLevelTwoStatus());
				     switch (levelThreeStatus) {
				/*     case "Initiated":
				    	 orderRequest.setApprovalLevel("L3");
				    	  break;		
				  */  	  		    	  
				     case "Approved":
				    	 orderRequest.setApprovalLevel("L3");
				    	  break;
				     case "Rejected":
				    	 orderRequest.setApprovalLevel("L3");
				    	  break;				    	  
				     case "Pending":
				    	 orderRequest.setApprovalLevel("L3");
				    	  break;	  
				 	}	
			}
			
	/*		
			if (approvalLevel.getLevelOneStatus().equals("Initiated")) {
				orderRequest.setApprovalLevel("L1");
				System.out.println("=======approvalLevel=L1==="+approvalLevel.getLevelOneStatus());
				}
			else if (approvalLevel.getLevelOneStatus().equals("Approved") && approvalLevel.getLevelTwoStatus().equals("Initiated")) {
				orderRequest.setApprovalLevel("L2");
				System.out.println("=======approvalLevel==L2=="+approvalLevel.getLevelOneStatus());}
			else if (approvalLevel.getLevelTwoStatus().equals("Approved")) {
				orderRequest.setApprovalLevel("L3");
				System.out.println("=======approvalLevel==L3=="+approvalLevel.getLevelTwoStatus());}
				
			else if (approvalLevel.getLevelOneStatus().equals("Rejected")){
				orderRequest.setApprovalLevel("L1");}	
			else if (approvalLevel.getLevelTwoStatus().equals("Rejected")){
				orderRequest.setApprovalLevel("L2");}
			else if (approvalLevel.getLevelThreeStatus().equals("Rejected")){
				orderRequest.setApprovalLevel("L3");}
			else {
				orderRequest.setApprovalLevel("L1");
				}
		*/	
			
			RiskApprovalStatus approvalStatus = riskApprovalStatusRepo.save(MapperUtils.mapToTargetClass(orderRequest, RiskApprovalStatus.class));

			if (!ObjectUtils.isEmpty(approvalStatus)) {	
				approvalLevelStatus = approvalStatus.getApprovalLevel();
				  switch (approvalLevelStatus) {
				  case "L1":
					  	riskApprovalLevelRepo.updateRiskApprovalLevelOneStatus(approvalStatus.getApprovalStatus(), "L1-"+approvalStatus.getApprovalStatus(), 
								approvalStatus.getRiskRegId(), approvalStatus.getRiskId());	
						riskScoringRepo.updateRiskApprovalInitToActive("L1-"+approvalStatus.getApprovalStatus(), approvalStatus.getRiskRegId(), Long.parseLong(approvalStatus.getRiskId()));
						break;
				  case "L2":
					  	riskApprovalLevelRepo.updateRiskApprovalLevelTwoStatus(approvalStatus.getApprovalStatus(), "L2-"+approvalStatus.getApprovalStatus(), 
								approvalStatus.getRiskRegId(), approvalStatus.getRiskId());	
						riskScoringRepo.updateRiskApprovalInitToActive("L2-"+approvalStatus.getApprovalStatus(), approvalStatus.getRiskRegId(), Long.parseLong(approvalStatus.getRiskId()));
						break;
				  case "L3":
					  	riskApprovalLevelRepo.updateRiskApprovalLevelThreeStatus(approvalStatus.getApprovalStatus(), "L3-"+approvalStatus.getApprovalStatus(), 
								approvalStatus.getRiskRegId(), approvalStatus.getRiskId());	
						riskScoringRepo.updateRiskApprovalInitToActive("L3-"+approvalStatus.getApprovalStatus(), approvalStatus.getRiskRegId(), Long.parseLong(approvalStatus.getRiskId()));
						break;
				  }				  
					
			}
			
	/*			
				if (approvalStatus.getApprovalLevel() == "L1") {
				riskApprovalLevelRepo.updateRiskApprovalLevelOneStatus(approvalStatus.getApprovalStatus(), "L1-"+approvalStatus.getApprovalStatus(), 
						approvalStatus.getRiskRegId(), approvalStatus.getRiskId());	
				riskScoringRepo.updateRiskApprovalInitToActive("L1-"+approvalStatus.getApprovalStatus(), approvalStatus.getRiskRegId(), Long.parseLong(approvalStatus.getRiskId()));
				}
				else if (approvalStatus.getApprovalLevel() == "L2") {
					riskApprovalLevelRepo.updateRiskApprovalLevelTwoStatus(approvalStatus.getApprovalStatus(), "L2-"+approvalStatus.getApprovalStatus(), 
							approvalStatus.getRiskRegId(), approvalStatus.getRiskId());	
					riskScoringRepo.updateRiskApprovalInitToActive("L2-"+approvalStatus.getApprovalStatus(), approvalStatus.getRiskRegId(), Long.parseLong(approvalStatus.getRiskId()));
				}	
				else if (approvalStatus.getApprovalLevel() == "L3") {
					riskApprovalLevelRepo.updateRiskApprovalLevelThreeStatus(approvalStatus.getApprovalStatus(), "L3-"+approvalStatus.getApprovalStatus(), 
							approvalStatus.getRiskRegId(), approvalStatus.getRiskId());	
					riskScoringRepo.updateRiskApprovalInitToActive("L3-"+approvalStatus.getApprovalStatus(), approvalStatus.getRiskRegId(), Long.parseLong(approvalStatus.getRiskId()));
				}	
	*/			
					
			return MapperUtils.mapToTargetClass(approvalStatus, RiskApprovalStatusDTO.class);
		}


		
	   
}
