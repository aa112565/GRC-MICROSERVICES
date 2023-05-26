package com.asymmetrix.grc.Controller;

import java.sql.Timestamp;

import javax.annotation.Resource;



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
import com.asymmetrix.grc.Dto.PolicyCollaborateDTO;
import com.asymmetrix.grc.Service.PolicyCollaborateService;
import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;

@RestController
@RequestMapping({ "/PolicyCollaborate" })
public class PolicyCollaborateController {
	
	@Resource
	PolicyCollaborateService policyCollaborateService;
	
	@PreAuthorize("permitAll()")
	@GetMapping("/All")
	public ResponseEntity<?> getAllPolicyCollaborate() {
		return GRCResponseEntity.success(policyCollaborateService.getAllPolicyCollaborate());
	}
	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/create")
	public ResponseEntity<?> createPolicyCollaborate( Authentication auth,  @RequestBody PolicyCollaborateDTO policyCollaborateDTO , CreatePolicyDto createPolicyDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		policyCollaborateDTO.setCreatedBy(loginUserDetails.getUsername());
		policyCollaborateDTO.setCreatedBy(auth.getName());
		createPolicyDto.setApprove("A");
		policyCollaborateDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		System.out.print(createPolicyDto.getPolicyId());
			return GRCResponseEntity.success(policyCollaborateService.createPolicyCollaborate(policyCollaborateDTO, createPolicyDto));
			
		}
	
	@PreAuthorize("permitAll()")
	@PutMapping("/update")
	public ResponseEntity<?> updatePolicyCollaborate( Authentication auth,  @RequestBody PolicyCollaborateDTO policyCollaborateDTO) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		policyCollaborateDTO.setCreatedBy(loginUserDetails.getUsername());
		policyCollaborateDTO.setCreatedBy(auth.getName());
		policyCollaborateDTO.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return GRCResponseEntity.success(policyCollaborateService.updatePolicyCollaborate(policyCollaborateDTO));
		
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getCollaborateById(@NonNull @PathVariable(value = "id") long collabrateId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(policyCollaborateService.getCollaborateById(collabrateId), PolicyCollaborateDTO.class));
	}

//	@PreAuthorize("permitAll()")
//	@PutMapping("/delete")
//	public ResponseEntity<?> deletePolicyCollaborate (Authentication auth, @NonNull @RequestBody PolicyCollaborateDTO policyCollaborateDTO) {
//		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
//		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
//		policyCollaborateDTO.setModifiedBy(loginUserDetails.getUsername());
//		policyCollaborateDTO.getDeleteFlag();
//		return GRCResponseEntity
//			.success(MapperUtils.mapToTargetClass(policyCollaborateService.deletePolicyCollaborate(policyCollaborateDTO), PolicyCollaborateDTO.class));
//	}

	@GetMapping("/find/policy/{id}")
	public ResponseEntity<?> getCollaborateByPolicyId(@NonNull @PathVariable(value = "id") String PolicyId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(policyCollaborateService.getCollaborateByPolicyId(PolicyId), PolicyCollaborateDTO.class));
	}

}
