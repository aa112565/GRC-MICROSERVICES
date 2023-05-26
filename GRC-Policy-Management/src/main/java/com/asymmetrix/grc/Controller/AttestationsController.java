package com.asymmetrix.grc.Controller;

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

import com.asymmetrix.grc.Dto.AttestationsDto;
import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.PolicyCollaborateDTO;
import com.asymmetrix.grc.Service.AttestationsService;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;

@RestController
@RequestMapping({ "/Attestations" })
public class AttestationsController {
	
	@Resource
	AttestationsService attestationsService;
	
	@PreAuthorize("permitAll()")
	@GetMapping("/All")
	public ResponseEntity<?> getAllAttestations() {
		return GRCResponseEntity.success(attestationsService.getAllAttestations());
	}
	
	@PreAuthorize("permitAll()")
	@PostMapping("/create")
	public ResponseEntity<?> createAttestations( Authentication auth,  @RequestBody AttestationsDto attestationsDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			attestationsDto.setCreatedBy(loginUserDetails.getUsername());
			attestationsDto.setCreatedBy(auth.getName());
			return GRCResponseEntity.success(attestationsService.createAttestations(attestationsDto));
			
		}
	@PreAuthorize("permitAll()")
		@PutMapping("/update")
		public ResponseEntity<?> updateAttestations(Authentication auth,  @RequestBody AttestationsDto attestationsDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			attestationsDto.setCreatedBy(loginUserDetails.getUsername());
			attestationsDto.setCreatedBy(auth.getName());
			return GRCResponseEntity.success(attestationsService.updateAttestations(attestationsDto));
		}
		
	@PreAuthorize("permitAll()")
		@GetMapping("/find/{id}")
		public ResponseEntity<?> getAttestationsById(@NonNull @PathVariable(value = "id") long attestaionsId) {
			return GRCResponseEntity
					.success(MapperUtils.mapToTargetClass(attestationsService.getAttestationsById(attestaionsId), AttestationsDto.class));
		}
		
	@PreAuthorize("permitAll()")
		@GetMapping("/find/policy/{id}")
		public ResponseEntity<?> getAttestationsByPolicyId(@NonNull @PathVariable(value = "id") String PolicyId) {
			return GRCResponseEntity
					.success(MapperUtils.mapToTargetClass(attestationsService.getAttestationsByPolicyId(PolicyId), AttestationsDto.class));
		}
		
	@PreAuthorize("permitAll()")
		@PutMapping("/delete")
		public ResponseEntity<?> deleteAttestations (Authentication auth, @NonNull @RequestBody AttestationsDto attestationsDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			attestationsDto.setModifiedBy(loginUserDetails.getUsername());
			attestationsDto.getDeleteFlag();
			return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(attestationsService.deleteAttestations(attestationsDto), AttestationsDto.class));
		}

}
