package com.asymmetrix.grc.Service;

import java.util.Date;
import java.util.List;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.PolicyDashboardCountDTO;
import com.asymmetrix.grc.Entity.CreatePolicy;


public interface CreatePolicyService {
	
	public List<CreatePolicy> getAllPolicy();
	public CreatePolicyDto  createPolicy(CreatePolicyDto createPolicyDto);
	public CreatePolicy updatePolicy(CreatePolicyDto createPolicyDto);
	public CreatePolicy getPolicyById(long PolicyId);
	public CreatePolicy deletePolicy(CreatePolicyDto createPolicyDto);
	public CreatePolicy deactive(CreatePolicyDto createPolicyDto);
	public CreatePolicy approvePolicy(CreatePolicyDto createPolicyDto);
	public CreatePolicy PolicyDateConvert(CreatePolicyDto createPolicyDto);
	public CreatePolicy rejectPolicy(CreatePolicyDto createPolicyDto);
	public List<CreatePolicy> getWithCollabrate();
	public List<CreatePolicy> getNoCollabrate();
//	public CreatePolicy createPolicy(CreatePolicyDto cmVendorDto , String userName);
	
	int getInprogresCountByPolicyStatus();

	int getCompletedCountByPolicyStatus(String status);
	
	int getPolicyCountByActiveflag();
	
	int getpolicyApproved();
	
	int getpolicyApprov();
	
	int getpolicyReviewed();
	
	int getPolicyExpired();
	
	int getPolicyPending();
	
	//int frequentlyAccessedPolicy();
	
//	public int getPolicyAgeing();
	
	List<CreatePolicy> getPolicyMostAccessed();
//	int frequentlyAccessedPolicy(String Category);
	int frequentlyAccessedPolicy(String category);
	
	public String getlocaldate();
	

	

}
