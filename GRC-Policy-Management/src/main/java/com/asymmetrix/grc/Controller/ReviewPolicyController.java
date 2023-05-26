package com.asymmetrix.grc.Controller;

import javax.annotation.Resource;

import javax.persistence.PostPersist;

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
import com.asymmetrix.grc.Dto.ReviewPolicyDto;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Service.ReviewPolicyService;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;


@RestController
@RequestMapping({ "/PolicyReview" })
public class ReviewPolicyController {
	
	@Resource
	ReviewPolicyService reviewPolicyService;
	
//	@PreAuthorize("permitAll()")
	@GetMapping("/All")
	public ResponseEntity<?> getAllReview() {
		return GRCResponseEntity.success(reviewPolicyService.getAllReview());
	}
	
//	@PreAuthorize("permitAll()")
	@GetMapping("/Policy/All")
	public ResponseEntity<?> getAllPolicy() {
		return GRCResponseEntity.success(reviewPolicyService.getAllPolicy());
	}
	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/create")
	@PostPersist
	public ResponseEntity<?> createReview( Authentication auth,  @RequestBody ReviewPolicyDto reviewPolicyDto ) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			reviewPolicyDto.setCreatedBy(loginUserDetails.getUsername());
			reviewPolicyDto.setCreatedBy(auth.getName());
			reviewPolicyDto.setReview("Z");
//			createPolicyDto.setPolicyId(reviewPolicyDto.getPolicyId());
			return GRCResponseEntity.success(reviewPolicyService.createReview(reviewPolicyDto));
			
		}
	
	@PreAuthorize("permitAll()")
	@PutMapping("/update")
	public ResponseEntity<?> updateReview( Authentication auth,  @RequestBody ReviewPolicyDto reviewPolicyDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		reviewPolicyDto.setCreatedBy(loginUserDetails.getUsername());
		reviewPolicyDto.setCreatedBy(auth.getName());
		reviewPolicyDto.setReview("Z");
		return GRCResponseEntity.success(reviewPolicyService.updateReview(reviewPolicyDto));
		
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getReviewById(@NonNull @PathVariable(value = "id") Long reviewId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(reviewPolicyService.getReviewById(reviewId), ReviewPolicyDto.class));
	}

	@PreAuthorize("permitAll()")
	@PutMapping("/delete")
	public ResponseEntity<?> deleteReview (Authentication auth, @NonNull @RequestBody ReviewPolicyDto reviewPolicyDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		reviewPolicyDto.setModifiedBy(loginUserDetails.getUsername());
		reviewPolicyDto.getDeleteFlag();
		return GRCResponseEntity
			.success(MapperUtils.mapToTargetClass(reviewPolicyService.deleteReview(reviewPolicyDto), ReviewPolicyDto.class));
	}

	@PreAuthorize("permitAll()")
	@GetMapping("/find/policy/{id}")
	public ResponseEntity<?> getReviewByPolicyId(@NonNull @PathVariable(value = "id") Long PolicyId ) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(reviewPolicyService.getReviewByPolicyId(PolicyId), ReviewPolicyDto.class));
	}

	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/approve")
	public ResponseEntity<?> createApprove( Authentication auth,  @RequestBody ReviewPolicyDto reviewPolicyDto , CreatePolicyDto createPolicyDto ) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			reviewPolicyDto.setCreatedBy(loginUserDetails.getUsername());
			reviewPolicyDto.setCreatedBy(auth.getName());
		reviewPolicyDto.setPolicyApprove("AA");
	//	createPolicyDto.setPolicyApprove("X");
			return GRCResponseEntity.success(reviewPolicyService.createApprove(reviewPolicyDto, createPolicyDto));
			
		}
	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/reject")
	public ResponseEntity<?> Reject( Authentication auth,  @RequestBody ReviewPolicyDto reviewPolicyDto, CreatePolicyDto createPolicyDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			reviewPolicyDto.setCreatedBy(loginUserDetails.getUsername());
			reviewPolicyDto.setCreatedBy(auth.getName());
	//		reviewPolicyDto.setReject("RR");
			return GRCResponseEntity.success(reviewPolicyService.Reject(reviewPolicyDto, createPolicyDto));
			
		}
	
	@PostMapping("/review")
	public ResponseEntity<?> updatereview( Authentication auth,  @RequestBody ReviewPolicyDto reviewPolicyDto , CreatePolicyDto createPolicyDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		reviewPolicyDto.setCreatedBy(loginUserDetails.getUsername());
		reviewPolicyDto.setCreatedBy(auth.getName());
		reviewPolicyDto.setReview("Z");
			System.out.println(reviewPolicyDto.getPolicyId());
		return GRCResponseEntity.success(reviewPolicyService.updateReview(reviewPolicyDto));
		
	}
	

	

}
