package com.asymmetrix.grc.Service;

import java.util.Date;
import java.util.List;

import com.asymmetrix.grc.Dto.MostAccessedDTO;
import com.asymmetrix.grc.Dto.PolicyDashboardCountDTO;
import com.asymmetrix.grc.Entity.CreatePolicy;

public interface PolicyDashboardService {
	
	List<PolicyDashboardCountDTO> getAllPolicyDashboardByActiveflag();	

	int getPolicyDashboardCountByActivePolicy();
	
	int getPolicyDashboardCountByActiveAttestations();
	
	int getPolicyDashboardReviewCountByActiveflag();
	
	int getPolicyDashboardApproveCountByActiveflag();
	
	int getAttestationAgeingCountByAttestation();
	
	int getFrquentByPolicy();
	
    int getInprogresCountByPolicyStatus();
	
	int getCompletedCountByPolicyStatus();
	
	int getPolicyCountByActiveflag();
	
	int getPolicyApproved();
	int getPolicyApprov();
	int getPolicyReviewed();
	int getpolicyExpired();
	int getpolicyPending();
//	int getPolicyAgeing(Date date);
	
	int frequentlyAccessedPolicy(String category);
	List<CreatePolicy> getPolicyMostAccessed();
	public List<PolicyDashboardCountDTO> getAllPolicyAge();
	List<PolicyDashboardCountDTO> getAllPolicyDashboardByPolicy();

	List<PolicyDashboardCountDTO> getAllPolicyDashboardByAttestation();

	List<PolicyDashboardCountDTO> getAllPolicyDashboardByCompletionStatus();
	List<PolicyDashboardCountDTO> getAllPolicyDashboardByAgeing();
	List<PolicyDashboardCountDTO> getAllPolicyDashboardAccessedPolicy();
//	List<PolicyDashboardCountDTO> getAllPolicyDashboardWeeks();
//	public int getPolicyAgeing();

}
