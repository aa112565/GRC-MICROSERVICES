package com.asymmetrix.grc.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Entity.ApplicableDepartment;
import com.asymmetrix.grc.Entity.Category;
import com.asymmetrix.grc.Entity.EntityDD;
import com.asymmetrix.grc.Entity.IssuingDepartment;
import com.asymmetrix.grc.Entity.PolicyApprover;
import com.asymmetrix.grc.Entity.PolicyIdPreferenceDD;
import com.asymmetrix.grc.Entity.PolicyLocation;
import com.asymmetrix.grc.Entity.PolicyOrganization;
import com.asymmetrix.grc.Entity.PolicyReviewers;
import com.asymmetrix.grc.Entity.PolicySuisidary;
import com.asymmetrix.grc.Entity.User;
import com.asymmetrix.grc.Entity.UserGroup;
import com.asymmetrix.grc.Repository.ApplicableDepartmentDDRepo;
import com.asymmetrix.grc.Repository.CategoryRepo;
import com.asymmetrix.grc.Repository.EntityDDRepo;
import com.asymmetrix.grc.Repository.IssuingDepartmentRepo;
import com.asymmetrix.grc.Repository.PolicyApproverRepo;
import com.asymmetrix.grc.Repository.PolicyIdModuleRepo;
import com.asymmetrix.grc.Repository.PolicyLocationDDRepo;
import com.asymmetrix.grc.Repository.PolicyOrganizationDDRepo;
import com.asymmetrix.grc.Repository.PolicyReviewersRepo;
import com.asymmetrix.grc.Repository.PolicySuisidaryDDRepo;
import com.asymmetrix.grc.Repository.UserGroupRepo;
import com.asymmetrix.grc.Repository.UserRepo;

@Service
public class DropDownValueService {
	
	@Autowired
	private ApplicableDepartmentDDRepo applicableDepartmentDDRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private EntityDDRepo entityDDRepo;
	
	@Autowired
	private IssuingDepartmentRepo issuingDepartmentRepo;
	
	@Autowired
	private PolicyOrganizationDDRepo policyOrganizationDDRepo;
	
	@Autowired
	private PolicyLocationDDRepo policyLocationDDRepo;
	
	@Autowired
	private PolicySuisidaryDDRepo policySuisidaryDDRepo;
	
	@Autowired
	private PolicyReviewersRepo policyReviewersRepo;
	
	@Autowired
	private PolicyApproverRepo policyApproverRepo;
	
	@Autowired
	private PolicyIdModuleRepo policyIdModuleRepo;
	
	@Autowired
	private UserGroupRepo userGroupRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public List<ApplicableDepartment> getAllapplicableDepartmentDD() {
		return this.applicableDepartmentDDRepo.findAll();
	}

	public List<Category> getAllcategory() {
		return this.categoryRepo.findAll();
	}

	public ApplicableDepartment createApplicableDep(ApplicableDepartment dropDownValue) {
		return this.applicableDepartmentDDRepo.save(dropDownValue);
	}

	public Category createCategory(Category dropDownValue) {
		return this.categoryRepo.save(dropDownValue);
	}
	
	public List<IssuingDepartment> getIssuingDepartment() {
		return this.issuingDepartmentRepo.findAll();
	}

	public List<EntityDD> getAllEntityDD() {
		return this.entityDDRepo.findAll();
	}

	public IssuingDepartment createIssuingDepartment(IssuingDepartment dropDownValue) {
		return this.issuingDepartmentRepo.save(dropDownValue);
	}

	public EntityDD createEntityDD(EntityDD dropDownValue) {
		return this.entityDDRepo.save(dropDownValue);
	}
	
	public List<PolicySuisidary> getAllPolicySuisidary() {
		return this.policySuisidaryDDRepo.findAll();
	}
	
	public PolicySuisidary createPolicySuisidary(PolicySuisidary dropDownValue) {
		return this.policySuisidaryDDRepo.save(dropDownValue);
	}
	
	
	public List<PolicyOrganization> getAllPolicyOrganization() {
		return this.policyOrganizationDDRepo.findAll();
	}
	
	public PolicyOrganization createpolicyOrganization(PolicyOrganization dropDownValue) {
		return this.policyOrganizationDDRepo.save(dropDownValue);
	}
	
	public List<PolicyLocation> getAllPolicyLocation() {
		return this.policyLocationDDRepo.findAll();
	}
	
	public PolicyLocation createPolicyLocation(PolicyLocation dropDownValue) {
		return this.policyLocationDDRepo.save(dropDownValue);
	}

	public List<PolicyReviewers> getAllRevivers() {
		return this.policyReviewersRepo.findAll();	
	}
	
	public PolicyReviewers createRevivers(PolicyReviewers dropDownValue) {
		return this.policyReviewersRepo.save(dropDownValue);
	}

	public List<PolicyApprover> getAllApprovers() {
		return this.policyApproverRepo.findAll();	
	}
	
	public PolicyApprover createRApprovers(PolicyApprover dropDownValue) {
		return this.policyApproverRepo.save(dropDownValue);
	}
	
	public List<PolicyIdPreferenceDD> getPolicyIdModule() {
		return this.policyIdModuleRepo.findAll();
	}
	
	public PolicyIdPreferenceDD createPolicyIdModule(PolicyIdPreferenceDD dropDownValue) {
		return this.policyIdModuleRepo.save(dropDownValue);
	}
	
	public List<UserGroup> getAllUserGroup() {
		return this.userGroupRepo.findAll();
	}
	
	public UserGroup createUserGroup(UserGroup dropDownValue) {
		return this.userGroupRepo.save(dropDownValue);
	}
	
	public List<User> getAllUser() {
		return this.userRepo.findAll();
	}
	
	public User createUser(User dropDownValue) {
		return this.userRepo.save(dropDownValue);
	}
	
	
	
}
