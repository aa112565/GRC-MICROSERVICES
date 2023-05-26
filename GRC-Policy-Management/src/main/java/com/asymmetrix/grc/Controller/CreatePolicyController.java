package com.asymmetrix.grc.Controller;


import java.sql.Timestamp;

import javax.annotation.Resource;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.PolicyDashboardCountDTO;
import com.asymmetrix.grc.Dto.ReviewPolicyDto;
import com.asymmetrix.grc.Service.CreatePolicyService;
import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;



@RestController
@RequestMapping({ "/Policy" })
public class CreatePolicyController {
	
//	@Autowired
	@Resource
	private CreatePolicyService createPolicyService;
	
	
//	@PreAuthorize("permitAll()")
	@GetMapping("/All")
	
	public ResponseEntity<?> getAllPolicy() {
		return GRCResponseEntity.success(createPolicyService.getAllPolicy());
	}
	
	@GetMapping("/Collabrate/Selcted")
	public ResponseEntity<?> getWithCollabrate() {
		return GRCResponseEntity.success(createPolicyService.getWithCollabrate());
	}
	
	@GetMapping("/Collabrate/Not/Selected")
	public ResponseEntity<?> getNoCollabrate() {
		return GRCResponseEntity.success(createPolicyService.getNoCollabrate());
	}
	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/create")
	public ResponseEntity<?> createPolicy( Authentication auth,  @RequestBody CreatePolicyDto createPolicyDto ) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		createPolicyDto.setCreatedBy(loginUserDetails.getUsername());
		createPolicyDto.setCreatedBy(auth.getName());
	//	reviewPolicyDto.setReject("Z");
		createPolicyDto.setAlertMessage("Alert Required");
	//	createPolicyDto.setReviewpolicy("A");
	//	System.out.println(createPolicyDto.getDocId());
	//	createPolicyDto.setCollabrateFlag("Y");
			return GRCResponseEntity.success(MapperUtils.mapToTargetClass(createPolicyService.createPolicy(createPolicyDto), CreatePolicyDto.class));
		}
		
        @PreAuthorize("permitAll()")
		@PutMapping("/update")
		public ResponseEntity<?> updatePolicy(Authentication auth,  @RequestBody CreatePolicyDto createPolicyDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			createPolicyDto.setCreatedBy(loginUserDetails.getUsername());
			createPolicyDto.setCreatedBy(auth.getName());
			return GRCResponseEntity.success(createPolicyService.updatePolicy(createPolicyDto) );
		}
		
	@PreAuthorize("permitAll()")
		@GetMapping("/find/{id}")
		public ResponseEntity<?> getPolicyById(@NonNull @PathVariable(value = "id") long PolicyId) {
			return GRCResponseEntity
					.success(MapperUtils.mapToTargetClass(createPolicyService.getPolicyById(PolicyId), CreatePolicyDto.class));
		}
	
	@PreAuthorize("permitAll()")
		@PutMapping("/delete")
		public ResponseEntity<?> deletePolicy (Authentication auth, @NonNull @RequestBody CreatePolicyDto createPolicyDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			createPolicyDto.setModifiedBy(loginUserDetails.getUsername());
			return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(createPolicyService.deletePolicy(createPolicyDto), CreatePolicyDto.class));
		}
	
	@PutMapping("/Deactive")
	public ResponseEntity<?> deactive (Authentication auth, @NonNull @RequestBody CreatePolicyDto createPolicyDto) {
//		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
//		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
//		createPolicyDto.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
			.success(MapperUtils.mapToTargetClass(createPolicyService.deactive(createPolicyDto), CreatePolicyDto.class));
	}
	
	@PostMapping("/approve") // for collabrate approval
	public ResponseEntity<?> approvePolicy( Authentication auth,  @RequestBody CreatePolicyDto createPolicyDto) {
//			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
//			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
//			createPolicyDto.setCreatedBy(loginUserDetails.getUsername());
//			createPolicyDto.setCreatedBy(auth.getName());
			createPolicyDto.setApprove("A");
			return GRCResponseEntity.success(createPolicyService.approvePolicy(createPolicyDto));
			
		}
	
	@PostMapping("/reject")
	public ResponseEntity<?> rejectPolicy( Authentication auth,  @RequestBody CreatePolicyDto createPolicyDto) {
	//		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
	//		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	//		createPolicyDto.setCreatedBy(loginUserDetails.getUsername());
	//		createPolicyDto.setCreatedBy(auth.getName());
	//	createPolicyDto.setReject("R");
//		createPolicyDto.setReject("R");
//		createPolicyDto.setApprove("R");
//		createPolicyDto.setPolicyApprove("R");
//		createPolicyDto.setReview("R");
		
	//	createPolicyDto.setPolicyApprove("R");
			return GRCResponseEntity.success(createPolicyService.rejectPolicy(createPolicyDto));
			
		}
	
	@GetMapping("/date")
	public ResponseEntity<?> getlocaldate() {
		return GRCResponseEntity.success(createPolicyService.getlocaldate());
	}
	
	@GetMapping("/date2")
	public ResponseEntity<?> getPolicyAgeing() {
		return GRCResponseEntity.success(createPolicyService.getlocaldate());
	}
	
//	@GetMapping("/approv")
//	public ResponseEntity<?> getpolicyApprov() {
//		return GRCResponseEntity.success(createPolicyService.getpolicyApprov());
//	}
//	
	

}
