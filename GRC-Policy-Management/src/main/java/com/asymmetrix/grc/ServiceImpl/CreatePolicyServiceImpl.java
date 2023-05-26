package com.asymmetrix.grc.ServiceImpl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import java.util.regex.Matcher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.PolicyDTO;
import com.asymmetrix.grc.Dto.PolicyDashboardCountDTO;
import com.asymmetrix.grc.Dto.PolicyIdPreferenceDTO;
import com.asymmetrix.grc.Dto.PolicyPreferenceDTO;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.PolicyIdPreference;
import com.asymmetrix.grc.Repository.CreatePolicyRepo;
import com.asymmetrix.grc.Repository.IssuingDepartmentRepo;
import com.asymmetrix.grc.Service.CreatePolicyService;
import com.asymmetrix.grc.Service.PolicyIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;



@Service
public class CreatePolicyServiceImpl implements CreatePolicyService {
	
//	@Autowired
	@Resource
	private CreatePolicyRepo createPolicyRepo;
	
	@Autowired
	IssuingDepartmentRepo issuingDepartmentRepo;
	
	
	@Resource
//	@Autowired
     PolicyIdPreferenceService idPreference;
	
	private static final String VERSION_PREFIX = "Policy/";

	@Override
	public List<CreatePolicy> getAllPolicy() {
		
		return this.createPolicyRepo.findAllByActiveflag();
	}
	
	@Override
	public List<CreatePolicy> getWithCollabrate() {
		
		return this.createPolicyRepo.findAllByWithCollabrate();
	}
	
	@Override
	public List<CreatePolicy> getNoCollabrate() {
		return this.createPolicyRepo.findAllByNoCollabrate();
	}

	@SuppressWarnings("unused")
	@Override
	public CreatePolicyDto  createPolicy(CreatePolicyDto createPolicyDto ) {
		
		PolicyIdPreference preference = null;
		String preOrg = null, preYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		String uniqueId = null, module = "Policy";

		PolicyDTO aDto = MapperUtils.mapToTargetClass(createPolicyDto, PolicyDTO.class);
		int count = idPreference.getPolicyIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
			preference = idPreference.getPolicyIdPreferenceByModule(module);
		}

//		try {
		
		if (preference.getPreferenceOganization() != null) {
			uniqueIdPartOne = preference.getPreferenceOganization() + "/";
			if (preference.getPreferenceYear() != null) {
				uniqueIdPartOne = uniqueIdPartOne + preference.getPreferenceYear() + "/";
			}
		} else if (preference.getPreferenceYear() != null) {
			uniqueIdPartOne = preference.getPreferenceYear() + "/";
		}
//		}
//		catch(NullPointerException e) {
//			System.out.println("NullPointerException thrown!");
//		}
		
	uniqueIdPartTwo = generateNewVersion(preference, newCount);
//				

		if (uniqueIdPartOne != null) {
			uniqueId = uniqueIdPartOne + uniqueIdPartTwo;
		} else {
			uniqueId = uniqueIdPartTwo;
		}
//
		// apDto.setStatus("Initiated");
		aDto.setPolicyUniqueId(uniqueIdPartTwo);
	
		if (preference.getPreferenceOganization() != null) {
			aDto.setPreferenceOganization(preference.getPreferenceOganization());
		}
		if (preference.getPreferenceYear() != null) {
			aDto.setPreferenceYear(preference.getPreferenceYear());
		}
		
		
		
		aDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		aDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		aDto.setActiveFlag("Y");
		aDto.setDeleteFlag("N");
		
	CreatePolicy cmAudit = createPolicyRepo.save(MapperUtils.mapToTargetClass(aDto, CreatePolicy.class));
	CreatePolicyDto resAudit = MapperUtils.mapToTargetClass(cmAudit, CreatePolicyDto.class);
	 resAudit.setPolicyUniqueId(uniqueId);
	 return resAudit;
//	 return this.createPolicyRepo.save(cmAudit);
//		CreatePolicy policy = createPolicyRepo.save(MapperUtils.mapToTargetClass(aDto, CreatePolicy.class));
//       return policy;
        
//        CreatePolicy policyUpdate = MapperUtils.mapToTargetClass(aDto, CreatePolicy.class);
//	return this.createPolicyRepo.save(policyUpdate);
   
	}
	
	 private String generateNewVersion( PolicyIdPreference idPref ,int count) {
		
       String prefix = idPref.getPreferenceOganization() +"/" + idPref.getPreferenceYear()+"/" + idPref.getRunningSeries().trim() + "/";
	//	 String prefix = "BCT/2023/PC" + idPref.getRunningSeries().trim();
	         CreatePolicy policy = this.createPolicyRepo.findFirstByOrderByCreatedDateDescPolicyIdDesc();
	        int numberPartOfLastCreatedID = 0; 
	        if (count > 0) {
	             String res = prefix + 1 ;
	            idPref.setStatus("N");
	            PolicyIdPreferenceDTO preference = this.idPreference.updatePolicyIdPreference(MapperUtils.mapToTargetClass(idPref, PolicyIdPreferenceDTO.class), "Admin");
	            return res;
	        }
	        if (policy.getPolicyUniqueId() != null) {
	             String lastCreatedworkshopID = policy.getPolicyUniqueId();
	             Pattern pattern = Pattern.compile("\\d+");
	             Matcher matcher = pattern.matcher(lastCreatedworkshopID);
	            while (matcher.find()) {
	                numberPartOfLastCreatedID = 0;
	                numberPartOfLastCreatedID = Integer.parseInt(matcher.group());
	            }
	             int newVersionID = numberPartOfLastCreatedID + 1;
	            return prefix + newVersionID;
	        }
	        return prefix + 1 ;
	        
	    }	 


	@Override
	public CreatePolicy updatePolicy(CreatePolicyDto createPolicyDto ) {
		createPolicyDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		createPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		createPolicyDto.setActiveFlag("Y");
		createPolicyDto.setDeleteFlag("N");
		createPolicyDto.setReject(null);
		
		CreatePolicy policyUpdate = MapperUtils.mapToTargetClass(createPolicyDto, CreatePolicy.class);
		return this.createPolicyRepo.save(policyUpdate);
	}

	@Override
	public CreatePolicy getPolicyById(long PolicyId) {
	//	long count = createPolicyRepo.count();
		return createPolicyRepo.findById(PolicyId)
				.orElseThrow(() -> new ResourceNotFoundException("Policy not found with  Id----> " + PolicyId));
	}

	@Override
	public CreatePolicy deletePolicy(CreatePolicyDto createPolicyDto) {
		CreatePolicy existingPolicy = getPolicyById(createPolicyDto.getPolicyId());
		existingPolicy.setActiveFlag("Y");
		existingPolicy.setDeleteFlag("D");
		return this.createPolicyRepo.save(existingPolicy);
	}
	
	@Override
	public CreatePolicy deactive(CreatePolicyDto createPolicyDto) {
		CreatePolicy Policy = getPolicyById(createPolicyDto.getPolicyId());
		Policy.setDeleteFlag("D");
		return this.createPolicyRepo.save(Policy);
	}

	@Override
	public CreatePolicy approvePolicy(CreatePolicyDto createPolicyDto) {
		createPolicyDto.setApprove("A");
	//	createPolicyDto.setCollabrateFlag(null);
//		createPolicyDto.setReview(null);
		createPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CreatePolicy policyApprove = MapperUtils.mapToTargetClass(createPolicyDto, CreatePolicy.class);
		return this.createPolicyRepo.save(policyApprove);
	}
	@Override
	public int getInprogresCountByPolicyStatus() {
		return this.createPolicyRepo.findInprogresCountByPolicyStatus();
	}
	@Override
	public int getCompletedCountByPolicyStatus(String status) {
		return this.createPolicyRepo.findCompletedCountByPolicyStatus(status);
	}
	@Override
	public int getPolicyCountByActiveflag() {    //created policy
		return this.createPolicyRepo.getPolicyCountByActiveflag();
	}
	@Override
	public int getpolicyApproved() {
		return this.createPolicyRepo.getPolicyApproved();
	}
	
	@Override
	public int getpolicyApprov() {
		return this.createPolicyRepo.getPolicyApprov();
	}
	@Override
	public int getpolicyReviewed() {
		return this.createPolicyRepo.getPolicyReview();
	}
	@Override
	public int getPolicyExpired() {
		return this.createPolicyRepo.getPolicyExpired();
	}
	@Override
	public int getPolicyPending() {
		return this.createPolicyRepo.getPolicyPending();
	}
	@Override
	public List<CreatePolicy> getPolicyMostAccessed() {
		return this.createPolicyRepo.getPolicyMostAccessed();
	}
//	@Override
//	public int getPolicyAgeing() {
//		return this.createPolicyRepo.getPolicyAgeing();
//	}
	


	@Override
	public int frequentlyAccessedPolicy(String category) {
		return this.createPolicyRepo.frequentlyAccessedPolicy(category);
	}

	@Override
	public CreatePolicy rejectPolicy(CreatePolicyDto createPolicyDto) {
		createPolicyDto.setReject("R");
		createPolicyDto.setApprove(null);
		createPolicyDto.setPolicyApprove(null);
		createPolicyDto.setReview(null);
		createPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		createPolicyRepo.updateReject(createPolicyDto.getPolicyId());
		createPolicyRepo.updateRejectReview(createPolicyDto.getPolicyId());
		
		CreatePolicy policyReject = MapperUtils.mapToTargetClass(createPolicyDto, CreatePolicy.class);
		return this.createPolicyRepo.save(policyReject);
		
	}
	
	public String getlocaldate() {
		Date input = new Date();
		Instant instant = input.toInstant();
	return this.createPolicyRepo.toString();
	
	}

	@Override
	public CreatePolicy PolicyDateConvert(CreatePolicyDto createPolicyDto) {
//		List<CreatePolicy> playerList = (List<CreatePolicy>)session.createCriteria(CreatePolicy.class)
//				.add(Restrictions.sqlRestriction("(a- b) > 5")).list();
		CreatePolicy policyUpdate = MapperUtils.mapToTargetClass(createPolicyDto, CreatePolicy.class);
		return this.createPolicyRepo.save(policyUpdate);
	}

	
	
	
}
