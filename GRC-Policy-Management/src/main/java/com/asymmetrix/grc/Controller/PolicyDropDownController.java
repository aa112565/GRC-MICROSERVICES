package com.asymmetrix.grc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.Dto.DropDownValues;
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
import com.asymmetrix.grc.Service.DropDownValueService;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;

@RestController
@RequestMapping("/Policy")
@ComponentScan
public class PolicyDropDownController {
	
	@Autowired
	private DropDownValueService dropDwonValueService;

	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@GetMapping("/getAllDropDownValues")
	public ResponseEntity<GRCResponse<?>> getAllDropDownValues() {
		DropDownValues dropDwonValuesDto = new DropDownValues();

		List<Category> cd = getAllcategory();
		dropDwonValuesDto.setCategory(cd);
		List<PolicyLocation> ld = getAllPolicyLocation();
		dropDwonValuesDto.setLocation(ld);
		List<PolicyReviewers> pr = getAllRevivers();
		dropDwonValuesDto.setReviewers(pr);
		List<PolicyApprover> pa = getAllApprovers();
		dropDwonValuesDto.setApprovers(pa);
		List<PolicyIdPreferenceDD>  preferenceModule= getPolicyIdModule();
		dropDwonValuesDto.setIdPreferenceModule(preferenceModule);
		
		return GRCResponseEntity.success(dropDwonValuesDto);
	}
	
	@GetMapping("/getAllID")
	public ResponseEntity<GRCResponse<?>> getAllIdprefrence() {
		DropDownValues dropDwonValuesDto = new DropDownValues();
		List<PolicyIdPreferenceDD>  preferenceModule= getPolicyIdModule();
		dropDwonValuesDto.setIdPreferenceModule(preferenceModule);
		
		return GRCResponseEntity.success(dropDwonValuesDto);
	}
	
	@GetMapping("/getUser")
	private List<User> getAllUser() {
		return this.dropDwonValueService.getAllUser();
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User dropDownValue) {
		return this.dropDwonValueService.createUser(dropDownValue);
	}
		
	@GetMapping("/getPolicyIdModule")
	private List<PolicyIdPreferenceDD> getPolicyIdModule() {
		return this.dropDwonValueService.getPolicyIdModule();
	
	
    }
	@PostMapping("/createPolicyModule")
	public PolicyIdPreferenceDD createPolicyIdModule(@RequestBody PolicyIdPreferenceDD dropDownValue) {
		return this.dropDwonValueService.createPolicyIdModule(dropDownValue);
	}
	
	@GetMapping("/getcategory")
	public List<Category> getAllcategory() {
		return this.dropDwonValueService.getAllcategory();
	}

	@PostMapping("/createcategory")
	public Category createCategory(@RequestBody Category dropDownValue) {
		return this.dropDwonValueService.createCategory(dropDownValue);
	}
	
	
	@GetMapping("/getLocationDD")
	public List<PolicyLocation> getAllPolicyLocation() {
		return this.dropDwonValueService.getAllPolicyLocation();
	}

	@PostMapping("/createLocationDD")
	public PolicyLocation createPolicyLocation(@RequestBody PolicyLocation dropDownValue) {
		return this.dropDwonValueService.createPolicyLocation(dropDownValue);
	}
	
	@GetMapping("/getSuisidaryDD")
	public List<PolicySuisidary> getAllPolicySuisidary() {
		return this.dropDwonValueService.getAllPolicySuisidary();
	}

	@PostMapping("/createSuisidaryDD")
	public PolicySuisidary createPolicySuisidary(@RequestBody PolicySuisidary dropDownValue) {
		return this.dropDwonValueService.createPolicySuisidary(dropDownValue);
	}
	
	@GetMapping("/getPolicyReviewers")
	public List<PolicyReviewers> getAllRevivers() {
		return this.dropDwonValueService.getAllRevivers();
	}

	@PostMapping("/createPolicyReviewers")
	public PolicyReviewers createRevivers(@RequestBody PolicyReviewers dropDownValue) {
		return this.dropDwonValueService.createRevivers(dropDownValue);
	}
	
	@GetMapping("/getPolicyApprover")
	public List<PolicyApprover> getAllApprovers() {
		return this.dropDwonValueService.getAllApprovers();
	}

	@PostMapping("/createPolicyApprover")
	public PolicyApprover createRApprovers(@RequestBody PolicyApprover dropDownValue) {
		return this.dropDwonValueService.createRApprovers(dropDownValue);
	}
	
}
