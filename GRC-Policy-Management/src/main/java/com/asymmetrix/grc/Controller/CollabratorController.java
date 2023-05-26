package com.asymmetrix.grc.Controller;

import java.sql.Timestamp;

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

import com.asymmetrix.grc.Dto.CollabratorDto;
import com.asymmetrix.grc.Service.CollabratorService;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;

@RestController
@Transactional
@RequestMapping({ "/Collabrator" })
public class CollabratorController {
	
	@Resource
	CollabratorService collabratorService;
	
//	@PreAuthorize("permitAll()")
	@GetMapping("/All")
	public ResponseEntity<?> getAllcollabrator() {
		return GRCResponseEntity.success(collabratorService.getAllcollabrator());
	}
	
	@PreAuthorize("permitAll()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/create")
	public ResponseEntity<?> createCollabrator( Authentication auth,  @RequestBody CollabratorDto cDto) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
			cDto.setCreatedBy(loginUserDetails.getUsername());
			cDto.setCreatedBy(auth.getName());
			cDto.setModifiedBy(auth.getName());
			cDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
	//		cDto.setActiveFlag("A");
		    cDto.setApprove("A");
			return GRCResponseEntity.success(collabratorService.createCollabrator(cDto));
		}
	
//	@PreAuthorize("permitAll()")
	@PutMapping("/update")
	public ResponseEntity<?> updateCollabrator( Authentication auth,  @RequestBody CollabratorDto cDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		cDto.setCreatedBy(loginUserDetails.getUsername());
		cDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//		cDto.setCreatedBy(auth.getName());
		return GRCResponseEntity.success(collabratorService.updateCollabrator(cDto));
		
	}
	
//	@PreAuthorize("permitAll()")
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getCollabratorById(@NonNull @PathVariable(value = "id") long collabratorId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(collabratorService.getCollabratorById(collabratorId), CollabratorDto.class));
	}
	
//	@PreAuthorize("permitAll()")
	@PutMapping("/delete")
	public ResponseEntity<?> deleteCollabrator (Authentication auth, @NonNull @RequestBody CollabratorDto cDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		cDto.setModifiedBy(loginUserDetails.getUsername());
		cDto.getDeleteFlag();
		return GRCResponseEntity
			.success(MapperUtils.mapToTargetClass(collabratorService.deleteCollabrator(cDto), CollabratorDto.class));
	}

	@GetMapping("/find/policy/{id}")
	public ResponseEntity<?> getCollabratorByPolicyId(@NonNull @PathVariable(value = "id") String PolicyId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(collabratorService.getCollabratorByPolicyId(PolicyId), CollabratorDto.class));
	}
	
	

}
