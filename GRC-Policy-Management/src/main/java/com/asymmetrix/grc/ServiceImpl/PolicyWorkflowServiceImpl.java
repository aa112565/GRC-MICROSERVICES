package com.asymmetrix.grc.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.Dto.OrderRequest;
import com.asymmetrix.grc.Dto.PolicyApprovalHistoryDTO;
import com.asymmetrix.grc.Dto.PolicyApprovalLevelDTO;
import com.asymmetrix.grc.Dto.PolicyApprovalStatusDTO;
import com.asymmetrix.grc.Dto.PolicyScoringApprovalDTO;
import com.asymmetrix.grc.Entity.PolicyApprovalLevel;
import com.asymmetrix.grc.Entity.PolicyApprovalStatus;
import com.asymmetrix.grc.Repository.CreatePolicyRepo;
import com.asymmetrix.grc.Repository.PolicyApprovalLevelRepo;
import com.asymmetrix.grc.Repository.PolicyApprovalStatusRepo;
import com.asymmetrix.grc.Service.PolicyWorkflowService;
import com.asymmetrix.grc.common.utils.MapperUtils;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


@Service
public class PolicyWorkflowServiceImpl implements PolicyWorkflowService {
	
	@Autowired
    private KieContainer kieContainer;
	
	 @Resource
	 PolicyApprovalLevelRepo policyApprovalLevelRepo;
	 
	    @Resource
	    PolicyApprovalStatusRepo policyApprovalStatusRepo;
	    
	    @Autowired
	    private CreatePolicyRepo policyRepo;

	    
	    @Transactional
	@Override
	public PolicyScoringApprovalDTO getApprovals(OrderRequest orderRequest, String userName, String userDept) {
		 System.out.println("+++++++++++++++++getApprovals+++++++++++++++++  ");
	        final PolicyScoringApprovalDTO policyScoringApprovalDTO = new PolicyScoringApprovalDTO();
	        policyScoringApprovalDTO.setPolicyUniqueId(orderRequest.getPolicyUniqueId());
	        policyScoringApprovalDTO.setPolicyId(orderRequest.getPolicyId());
	        policyScoringApprovalDTO.setRemarks(orderRequest.getRemarks());
	        final KieSession kieSession = this.kieContainer.newKieSession();
	        kieSession.setGlobal("policyScoringApprovalDTO", (Object)policyScoringApprovalDTO);
	        kieSession.insert((Object)orderRequest);
	        kieSession.fireAllRules();
	        kieSession.dispose();
	        final PolicyApprovalLevelDTO tempLevel = this.newApprovals(policyScoringApprovalDTO, userName, userDept);
	        return policyScoringApprovalDTO;
	}

	@Transactional
	@Override
	public PolicyApprovalLevelDTO newApprovals(final PolicyScoringApprovalDTO approval,final String userName,final String userDept) {
		  final long count = this.policyApprovalLevelRepo.countByPolicyUniqueIdAndPolicyId(approval.getPolicyUniqueId(), approval.getPolicyId());
		  PolicyApprovalLevel approvalLevel = null;
	        final PolicyApprovalStatusDTO approvalStatustDto = new PolicyApprovalStatusDTO();
	        final PolicyApprovalLevelDTO approvalLevelDto = (PolicyApprovalLevelDTO)MapperUtils.mapToTargetClass(approval, PolicyApprovalLevelDTO.class);
	        approvalLevelDto.setActiveFlag("Y");
	        approvalLevelDto.setDeleteFlag("N");
	        approvalLevelDto.setPolicyBusinessUnit(userDept);
	        approvalLevelDto.setCreatedBy(userName);
	        approvalLevelDto.setModifiedBy(userName);
	        approvalLevelDto.setLevelOneStatus("Initiated");
	        if (approval.getLevelTwoApprover().equalsIgnoreCase("NA")) {
	            approvalLevelDto.setLevelTwoStatus("NA");
	        }
	        else {
	            approvalLevelDto.setLevelTwoStatus("Initiated");
	        }
	        approvalLevelDto.setLevelThreeStatus("Initiated");
	        approvalLevelDto.setStatus("Initiated");
	        if (count <= 0L) {
	            System.out.println("+++++++++++++++++newApprovals+++++++++++++++++  ");
	            approvalLevel = (PolicyApprovalLevel)this.policyApprovalLevelRepo.save(MapperUtils.mapToTargetClass(approvalLevelDto, PolicyApprovalLevel.class));
	            approvalStatustDto.setApprovalId(approvalLevel.getApprovalId());
	            approvalStatustDto.setPolicyUniqueId(approvalLevel.getPolicyUniqueId());
	            approvalStatustDto.setPolicyId(approvalLevel.getPolicyId());
	            approvalStatustDto.setApprovalLevel("L1");
	            approvalStatustDto.setApprovalStatus("Initiated");
	            approvalStatustDto.setActiveFlag("Y");
	            approvalStatustDto.setDeleteFlag("N");
	            approvalStatustDto.setComments(approval.getRemarks());
	            if (!ObjectUtils.isEmpty((Object)approvalLevel)) {
	                this.policyRepo.updatePolicyApprovalInitToActive("Initiated", "L1", Long.valueOf(Long.parseLong(approvalLevel.getPolicyId())));
	                final PolicyApprovalStatus policyApprovalStatus = (PolicyApprovalStatus)this.policyApprovalStatusRepo.save(MapperUtils.mapToTargetClass(approvalStatustDto, PolicyApprovalStatus.class));
	            }
	            return (PolicyApprovalLevelDTO)MapperUtils.mapToTargetClass((Object)approvalLevel, PolicyApprovalLevelDTO.class);
	        }
	        return (PolicyApprovalLevelDTO)MapperUtils.mapToTargetClass((Object)this.policyApprovalLevelRepo.findByPolicyUniqueIdAndPolicyId(approval.getPolicyUniqueId(), approval.getPolicyId()), PolicyApprovalLevelDTO.class);
	    }
	    
	

	@Override
	 public PolicyApprovalLevelDTO findApprovalLevelStatus(final String policyuniqueid, final String policyId) {
        return (PolicyApprovalLevelDTO)MapperUtils.mapToTargetClass((Object)this.policyApprovalLevelRepo.findByPolicyUniqueIdAndPolicyId(policyuniqueid, policyId), PolicyApprovalLevelDTO.class);
    }

	@Override
	public List<PolicyApprovalStatus> findAllApprovalStatus() {
        return (List<PolicyApprovalStatus>)this.policyApprovalStatusRepo.findAll();
    }

	@Override
	public List<PolicyApprovalStatus> findApprovalStatusByApprovalId(final String approvalId) {
        return (List<PolicyApprovalStatus>)this.policyApprovalStatusRepo.findByApprovalId(approvalId);
    }

	@Override
	public List<PolicyApprovalHistoryDTO> findApprovalStatus(final String policyUniqueId, final String policyId) {
        return (List<PolicyApprovalHistoryDTO>)this.policyApprovalStatusRepo.findByPolicyUniqueIdAndPolicyId(policyUniqueId, policyId);
    }

	@Override
	public PolicyApprovalStatusDTO newApprovalStatus(PolicyApprovalStatusDTO orderRequest, String username,
			String department) {
		 String levelOneStatus = null;
	        String levelTwoStatus = null;
	        String levelThreeStatus = null;
	        String approvalLevelStatus = null;
	        final PolicyApprovalLevel approvalLevel = this.policyApprovalLevelRepo.findByPolicyUniqueIdAndPolicyId(orderRequest.getPolicyUniqueId(), orderRequest.getPolicyId());
	        orderRequest.setActiveFlag("Y");
	        orderRequest.setDeleteFlag("N");
	        orderRequest.setCreatedBy(username);
	        orderRequest.setModifiedBy(username);
	        orderRequest.setApprovalId(approvalLevel.getApprovalId());
	        if (approvalLevel.getLevelOneStatus() != null) {
	            levelOneStatus = approvalLevel.getLevelOneStatus();
	            System.out.println("=======approvalLevel=L1===" + approvalLevel.getLevelOneStatus());
	            final String s = levelOneStatus;
	            switch (s) {
	                case "Initiated": {
	                    orderRequest.setApprovalLevel("L1");
	                    break;
	                }
	                case "Approved": {
	                    if (approvalLevel.getLevelTwoStatus() == null) {
	                        break;
	                    }
	                    levelTwoStatus = approvalLevel.getLevelTwoStatus();
	                    if (levelTwoStatus.equalsIgnoreCase("NA")) {
	                        orderRequest.setApprovalLevel("L3");
	                        break;
	                    }
	                    orderRequest.setApprovalLevel("L2");
	                    break;
	                }
	                case "Rejected": {
	                    orderRequest.setApprovalLevel("L1");
	                    break;
	                }
	                case "Pending": {
	                    orderRequest.setApprovalLevel("L1");
	                    break;
	                }
	            }
	        }
	        if (approvalLevel.getLevelTwoStatus() != null) {
	            levelTwoStatus = approvalLevel.getLevelTwoStatus();
	            System.out.println("=======approvalLevel=L2===" + approvalLevel.getLevelTwoStatus());
	            final String s2 = levelTwoStatus;
	            switch (s2) {
	                case "Approved": {
	                    orderRequest.setApprovalLevel("L3");
	                    break;
	                }
	                case "Rejected": {
	                    orderRequest.setApprovalLevel("L2");
	                    break;
	                }
	                case "Pending": {
	                    orderRequest.setApprovalLevel("L2");
	                    break;
	                }
	            }
	        }
	        if (approvalLevel.getLevelThreeStatus() != null) {
	            levelThreeStatus = approvalLevel.getLevelThreeStatus();
	            System.out.println("=======approvalLevel==L3==" + approvalLevel.getLevelTwoStatus());
	            final String s3 = levelThreeStatus;
	            switch (s3) {
	                case "Approved": {
	                    orderRequest.setApprovalLevel("L3");
	                    break;
	                }
	                case "Rejected": {
	                    orderRequest.setApprovalLevel("L3");
	                    break;
	                }
	                case "Pending": {
	                    orderRequest.setApprovalLevel("L3");
	                    break;
	                }
	            }
	        }
	        final PolicyApprovalStatus approvalStatus = (PolicyApprovalStatus)this.policyApprovalStatusRepo.save(MapperUtils.mapToTargetClass((Object)orderRequest, PolicyApprovalStatus.class));
	        if (!ObjectUtils.isEmpty((Object)approvalStatus)) {
	            final String approvalLevel2;
	            approvalLevelStatus = (approvalLevel2 = approvalStatus.getApprovalLevel());
	            switch (approvalLevel2) {
	                case "L1": {
	                    this.policyApprovalLevelRepo.updatePolicyApprovalLevelOneStatus(approvalStatus.getApprovalStatus(), "L1-" + approvalStatus.getApprovalStatus(), approvalStatus.getPolicyUniqueId(), approvalStatus.getPolicyId());
	                    this.policyRepo.updatePolicyApprovalInitToActive(approvalStatus.getApprovalStatus(), "L1", Long.valueOf(Long.parseLong(approvalStatus.getPolicyId())));
	                    break;
	                }
	                case "L2": {
	                    this.policyApprovalLevelRepo.updatePolicyApprovalLevelTwoStatus(approvalStatus.getApprovalStatus(), "L2-" + approvalStatus.getApprovalStatus(), approvalStatus.getPolicyUniqueId(), approvalStatus.getPolicyId());
	                    this.policyRepo.updatePolicyApprovalInitToActive(approvalStatus.getApprovalStatus(), "L2", Long.valueOf(Long.parseLong(approvalStatus.getPolicyId())));
	                    break;
	                }
	                case "L3": {
	                    this.policyApprovalLevelRepo.updatePolicyApprovalLevelThreeStatus(approvalStatus.getApprovalStatus(), "L3-" + approvalStatus.getApprovalStatus(), approvalStatus.getPolicyUniqueId(), approvalStatus.getPolicyId());
	                    this.policyRepo.updatePolicyApprovalInitToActive(approvalStatus.getApprovalStatus(), "L3", Long.valueOf(Long.parseLong(approvalStatus.getPolicyId())));
	                    break;
	                }
	            }
	        }
	        return (PolicyApprovalStatusDTO)MapperUtils.mapToTargetClass((Object)approvalStatus, PolicyApprovalStatusDTO.class);
	    }
	}


