package com.asymmetrix.grc.Controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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
import com.asymmetrix.grc.Dto.PeriodicReviewDTO;
import com.asymmetrix.grc.Service.PeriodicReviewService;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;

@RestController
@Transactional
@RequestMapping({ "/PeriodicReview" })
public class PeriodicReviewController {
	
	@Resource
	PeriodicReviewService periodicReviewService;
	
	
	@PreAuthorize("permitAll()")
	@GetMapping("/All")
	public ResponseEntity<?> getAllPeriodicReview() {
		return GRCResponseEntity.success(periodicReviewService.getAllPeriodicReview());
	}
	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/create")
	public ResponseEntity<?> createPeriodicReview( Authentication auth,  @RequestBody PeriodicReviewDTO createPolicyDto ) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();	
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			createPolicyDto.setCreatedBy(loginUserDetails.getUsername());
		createPolicyDto.setCreatedBy(auth.getName());
			return GRCResponseEntity.success(MapperUtils
					.mapToTargetClass(periodicReviewService.createPeriodicReview(createPolicyDto, loginUserDetails.getUsername()), CreatePolicyDto.class));
			
		}
		
        @PreAuthorize("permitAll()")
		@PutMapping("/update")
		public ResponseEntity<?> updatePeriodicReview(Authentication auth,  @RequestBody PeriodicReviewDTO createPolicyDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			createPolicyDto.setCreatedBy(loginUserDetails.getUsername());
			createPolicyDto.setCreatedBy(auth.getName());
			return GRCResponseEntity.success(periodicReviewService.updatePeriodicReview(createPolicyDto));
		}
		
	@PreAuthorize("permitAll()")
		@GetMapping("/find/{id}")
		public ResponseEntity<?> getPeriodicReviewById(@NonNull @PathVariable(value = "id") long PolicyId) {
			return GRCResponseEntity
					.success(MapperUtils.mapToTargetClass(periodicReviewService.getPeriodicReviewById(PolicyId), PeriodicReviewDTO.class));
		}
	
	@PreAuthorize("permitAll()")
		@PutMapping("/delete")
		public ResponseEntity<?> deletePeriodicReview (Authentication auth, @NonNull @RequestBody PeriodicReviewDTO createPolicyDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			createPolicyDto.setModifiedBy(loginUserDetails.getUsername());
			return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(periodicReviewService.deletePeriodicReview(createPolicyDto), PeriodicReviewDTO.class));
		}
	
	@PostMapping("/approve")
	public ResponseEntity<?> approvePeriodicReview( Authentication auth,  @RequestBody PeriodicReviewDTO createPolicyDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			createPolicyDto.setCreatedBy(loginUserDetails.getUsername());
			createPolicyDto.setCreatedBy(auth.getName());
		createPolicyDto.setApprove("A");
			return GRCResponseEntity.success(periodicReviewService.approvePeriodicReview(createPolicyDto));
	
}
	
}
