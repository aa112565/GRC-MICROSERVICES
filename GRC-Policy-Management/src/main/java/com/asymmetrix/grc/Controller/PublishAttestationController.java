package com.asymmetrix.grc.Controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.Dto.CollabratorDto;
import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.PolicyAttachmentsDTO;
import com.asymmetrix.grc.Dto.PolicyReqResDTO;
import com.asymmetrix.grc.Dto.PublishAttestationDTO;
import com.asymmetrix.grc.Service.PublishAttestationService;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;

@RestController
public class PublishAttestationController {
	
	@Autowired
	private PublishAttestationService publishAttestationService;
	
	@PreAuthorize("isAuthenticated()")
	
//	@GetMapping("/audit/program/find/all")
	@PostMapping("/publish/attestation/find/all")
	public ResponseEntity<?> getAllPublishAttestationByActiveflag() {
		return GRCResponseEntity.success(MapperUtils.mapToTargetClass(
				publishAttestationService.getAllPublishAttestationByActiveflag(), PublishAttestationDTO.class));
	}
	
////	@PreAuthorize("permitAll()")
	@GetMapping("publishAttestation/Policy/All")
	public ResponseEntity<?> getAllPolicy() {
		return GRCResponseEntity.success(publishAttestationService.getAllPolicy());
	}

	
	@PreAuthorize("isAuthenticated()")

	@GetMapping("/publish/attestation/find/{id}")
	public PolicyReqResDTO getPublishAttestationById(@NonNull @PathVariable(value = "id") Long publishAttestationID) {
	//	String refId = Long.toString(auditProgramId);
		PolicyReqResDTO resDto = new PolicyReqResDTO();
		PublishAttestationDTO paDto = MapperUtils.mapToTargetClass(
				publishAttestationService.getPublishAttestationById(publishAttestationID), PublishAttestationDTO.class);	
/*	
		List<AuditAttachmentsDTO> fileList = MapperUtils.mapToTargetClass(
				auditProgramService.findAllAttachment(refId), AuditAttachmentsDTO.class);				
*/
		resDto.setPublishAttestationDTO(paDto);
	//	resDto.setAuditDocs(fileList);
		return resDto;
	}
	
	@GetMapping("/publish/attestation/find/policy/{id}")
	public ResponseEntity<?> getPublishAttestationByPolicyId(@NonNull @PathVariable(value = "id") long PolicyId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(publishAttestationService.getPublishAttestationByPolicyId(PolicyId), PublishAttestationDTO.class));
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/publish/attestation/new")
	public ResponseEntity<?> createPublishAttestation(Authentication auth,
			@NonNull @RequestBody PublishAttestationDTO ProgramDto ) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	//	auditProgramDto.setCreatedBy(loginUserDetails.getUsername());	
		ProgramDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		ProgramDto.setPublishAttestation("P");
		
//		createPolicyDto.setPublishAttestation("P");
//		ProgramDto.getPolicyId();
		return GRCResponseEntity.success(MapperUtils
				.mapToTargetClass(publishAttestationService.createPublishAttestation(ProgramDto, loginUserDetails.getUsername()), PublishAttestationDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping("/publish/attestation/modify")
	public ResponseEntity<?> updatePublishAttestation(Authentication auth,
			@NonNull @RequestBody PublishAttestationDTO auditProgramDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		auditProgramDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//		auditProgramDto.setModifiedBy(loginUserDetails.getUsername());
		
		return GRCResponseEntity.success(MapperUtils
				.mapToTargetClass(publishAttestationService.updatePublishAttestation(auditProgramDto, loginUserDetails.getUsername()), PublishAttestationDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	
	@PutMapping("/publish/attestation/remove")
	public ResponseEntity<?> deletePublishAttestation(Authentication auth,
			@NonNull @RequestBody PublishAttestationDTO auditProgramDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
//		auditProgramDto.setModifiedBy(loginUserDetails.getUsername());		
		return GRCResponseEntity.success(MapperUtils
				.mapToTargetClass(publishAttestationService.deletePublishAttestation(auditProgramDto, loginUserDetails.getUsername()), PublishAttestationDTO.class));
	}

	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/publish/attestation/attachment/new")
	public ResponseEntity<?> createPublishAttestationAttachment(Authentication auth,
			@NonNull @ModelAttribute PolicyAttachmentsDTO Attachment) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
//		AuditReqResDTO resDto = new AuditReqResDTO();
		String result = null;
		result = publishAttestationService.createFiles(Attachment, loginUserDetails.getUsername());
		System.out.println("file Upload result  => " + result);
	//	List<AuditAttachmentsDTO> fileList = MapperUtils.mapToTargetClass(
	//			docService.getAllDocByRefId(auditAttachment.getRefId()), AuditAttachmentsDTO.class);
	//	resDto.setAuditDocs(fileList);
	//	return resDto;
		return GRCResponseEntity.success(result);
	}

	
	@PutMapping("/publish/attestation/attachment/remove/{docId}")
	public ResponseEntity<?> deleteFile(@NonNull @PathVariable String docId) {
		String attachment = null;
		try {
			attachment = publishAttestationService.fileDeleteByDocId(docId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GRCResponseEntity.success(attachment);
	}

	
	@GetMapping("/publish/attestation/attachment/find/{refId}")
	public ResponseEntity<?> findAllAttachment(@NonNull @PathVariable String refId) {
		return GRCResponseEntity.success(MapperUtils.mapToTargetClass(publishAttestationService.findAllAttachment(refId),
				PolicyAttachmentsDTO.class));
	}
	
	@GetMapping("/publish/attestation/attachment/download/{docId}")
	public ResponseEntity<?> downloadFile(@NonNull @PathVariable String docId) {
		return GRCResponseEntity.success(MapperUtils.mapToTargetClass(publishAttestationService.downloadFile(docId),
				PolicyAttachmentsDTO.class));
	}
	



}
