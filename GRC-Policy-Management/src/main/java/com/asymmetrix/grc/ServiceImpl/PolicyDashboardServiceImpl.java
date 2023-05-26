package com.asymmetrix.grc.ServiceImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.MostAccessedDTO;
import com.asymmetrix.grc.Dto.PolicyDashboardCountDTO;
import com.asymmetrix.grc.Entity.Category;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Repository.CreatePolicyRepo;
import com.asymmetrix.grc.Service.AttestationsService;
import com.asymmetrix.grc.Service.CreatePolicyService;
import com.asymmetrix.grc.Service.DropDownValueService;
import com.asymmetrix.grc.Service.PolicyDashboardService;
import com.asymmetrix.grc.Service.ReviewPolicyService;

@SuppressWarnings("unused")
@Service
public class PolicyDashboardServiceImpl implements PolicyDashboardService {
	
	@Resource
	private CreatePolicyService createPolicyService;
	
	@Autowired
	private ReviewPolicyService reviewPolicyService;
	
	@Autowired
	private AttestationsService attestationsService;
	
	@Autowired
	private DropDownValueService dropDownValueService;
	
	@Resource
	private CreatePolicyRepo createPolicyRepo;

	@Override
	public List<PolicyDashboardCountDTO> getAllPolicyDashboardByActiveflag() {
		List<PolicyDashboardCountDTO> count = new ArrayList<>();
		int policyCreated = getPolicyCountByActiveflag();
		int polictApproved =  getPolicyApproved();
		int policyReviewd =  getPolicyReviewed();
		
		count.add(new PolicyDashboardCountDTO("Policy", policyCreated));
		count.add(new PolicyDashboardCountDTO("Approved", polictApproved));
		count.add(new PolicyDashboardCountDTO("Reveiwed", policyReviewd));
		
		return count;
	}
	
	@Override
	public List<PolicyDashboardCountDTO> getAllPolicyDashboardByAttestation() {
		List<PolicyDashboardCountDTO> completionStatusCount = new ArrayList<>();
		int expired = getpolicyExpired();
		int pending = getpolicyPending();	
		int accepted =getPolicyApproved();
	//	int policyApprov =  getPolicyApprov();
		completionStatusCount.add(new PolicyDashboardCountDTO("Expired", expired));
		completionStatusCount.add(new PolicyDashboardCountDTO("InProgress", pending));
		completionStatusCount.add(new PolicyDashboardCountDTO("Completed", accepted));
		return completionStatusCount;
	}
	
	
	@Override
	public List<PolicyDashboardCountDTO> getAllPolicyDashboardAccessedPolicy() {
		List<PolicyDashboardCountDTO> completionStatusCount = new ArrayList<>();
//		int accessed = frequentlyAccessedPolicy();
		
		completionStatusCount.add(new PolicyDashboardCountDTO());
		return completionStatusCount;
	}

	@Override
	public int getPolicyDashboardCountByActivePolicy() {
		return this.createPolicyService.getPolicyCountByActiveflag();
	}

	@Override
	public int getPolicyDashboardCountByActiveAttestations() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPolicyDashboardReviewCountByActiveflag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPolicyDashboardApproveCountByActiveflag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAttestationAgeingCountByAttestation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFrquentByPolicy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PolicyDashboardCountDTO> getAllPolicyDashboardByPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<PolicyDashboardCountDTO> getAllPolicyDashboardByCompletionStatus() {
		List<PolicyDashboardCountDTO> completionStatusCount = new ArrayList<>();
		int auditCount = getPolicyDashboardCountByActivePolicy();
		int policyReview = getPolicyDashboardReviewCountByActiveflag();	
		int policyApprove =getPolicyDashboardApproveCountByActiveflag();
		
		int initiated = auditCount - policyReview;
		int inprogress = policyReview-policyApprove;
		
		completionStatusCount.add(new PolicyDashboardCountDTO("Completed", policyApprove));
		completionStatusCount.add(new PolicyDashboardCountDTO("InProgress", inprogress));
		completionStatusCount.add(new PolicyDashboardCountDTO("Initiated", initiated));
		
		return completionStatusCount;
	}

	@Override
	public int getInprogresCountByPolicyStatus() {
		return this.createPolicyService.getInprogresCountByPolicyStatus();
	}

	@Override
	public int getCompletedCountByPolicyStatus() {
		String tempStatus = "completed";
		return this.createPolicyService.getCompletedCountByPolicyStatus(tempStatus);
	}

	@Override
	public int getPolicyCountByActiveflag() {
		return this.createPolicyService.getPolicyCountByActiveflag();
	}

	@Override
	public int getPolicyApproved() {
		return this.createPolicyService.getpolicyApproved();
	}
	
	@Override
	public int getPolicyApprov() {
		return this.createPolicyService.getpolicyApprov();
	}

	@Override
	public int getPolicyReviewed() {
		return this.createPolicyService.getpolicyReviewed();
	}

	@Override
	public int getpolicyExpired() {
		return this.createPolicyService.getPolicyExpired();
	}

	@Override
	public int getpolicyPending() {
		return this.createPolicyService.getPolicyPending();
	}

	@Override
	public List<CreatePolicy> getPolicyMostAccessed() {
		return this.createPolicyService.getPolicyMostAccessed();
	}

//	@Override
//	public Float getPolicyAgeing() {
//		
//		return this.createPolicyService.getPolicyAgeing();
//	}

	@Override
	public List<PolicyDashboardCountDTO> getAllPolicyDashboardByAgeing() {
		List<PolicyDashboardCountDTO> auditTypeCount = new ArrayList<>();		
		List<Category>  atType = getAllcategory();		
		for (Category adType:atType) {
			int auditCount = frequentlyAccessedPolicy(adType.getControlCategoryeName());
			auditTypeCount.add(new PolicyDashboardCountDTO(adType.getControlCategoryeName(), auditCount));
		}	
		
		return auditTypeCount;
	}
	
	@Override
	public List<PolicyDashboardCountDTO> getAllPolicyAge() {
		List<PolicyDashboardCountDTO> auditTypeCount = new ArrayList<>();		
		List<Category>  atType = getAllcategory();		
		for (Category adType:atType) {
			int auditCount = frequentlyAccessedPolicy(adType.getControlCategoryeName());
			auditTypeCount.add(new PolicyDashboardCountDTO(adType.getControlCategoryeName(), auditCount));
		}	
		
		return auditTypeCount;
	}
	
//	@Override
//	public List<PolicyDashboardCountDTO> getAllPolicyDashboardWeeks() {
//		List<PolicyDashboardCountDTO> auditTypeCount = new ArrayList<>();
//		
//		return completionStatusCount;
//	}

	@Override
	public int frequentlyAccessedPolicy(String category) {
		return this.createPolicyService.frequentlyAccessedPolicy(category);
	}

//	@Override
//	public int getPolicyAgeing(Date date) {
//		return this.createPolicyService.getPolicyAgeing();
//	}

	public List<Category>  getAllcategory() {
		return this.dropDownValueService.getAllcategory();
	}

//	@Override
//	public List<PolicyDashboardCountDTO> getAllPolicyDashboardByAgeing() {
//		List<PolicyDashboardCountDTO> completionStatusCount = new ArrayList<>();
//		Date PolicyAgeing = getPolicyAgeing();
//		
//		completionStatusCount.add(new PolicyDashboardCountDTO());
//		
//		return completionStatusCount;
//	}

}
