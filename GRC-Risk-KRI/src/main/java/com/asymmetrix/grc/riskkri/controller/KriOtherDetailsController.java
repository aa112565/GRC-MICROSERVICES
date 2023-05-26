package com.asymmetrix.grc.riskkri.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.KRIResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dto.KriOtherDetailsDTO;
import com.asymmetrix.grc.riskkri.service.KriOtherDetailsService;



@RestController
@RequestMapping("/kri")
public class KriOtherDetailsController {

	@Autowired
	private KriOtherDetailsService otherDetailsService;

	KriOtherDetailsDTO fileuploaddto;
	boolean fileadd = false;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-KRI-OTHER-DETAILS";
	private static final String SAVE_OR_EDIT_DOC_ACTION = "SAVE-OR-EDIT-DOC_KRI-OTHER-DETAILS";
	private static final String READ_ACTION = "READ-KRI-OTHER-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-KRI-OTHER-DETAILS";
	private static final String READ_FREQUENCY_ACTION = "READ-FREQUENCY-KRI-OTHER-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/otherdetail/find/all")
	public ResponseEntity<?> getKriOtherDetailList() {
		return KRIResponseEntity.success(
				MapperUtils.mapToTargetClass(otherDetailsService.getKriOtherDetails(), KriOtherDetailsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/otherdetail/find/{id}")
	public ResponseEntity<?> getKriOtherDetailById(@NonNull @PathVariable(value = "id") long detailId) {
		return KRIResponseEntity.success(MapperUtils
				.mapToTargetClass(otherDetailsService.getKriOtherDetailById(detailId), KriOtherDetailsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/otherdetail/kri/{id}")
	public ResponseEntity<?> getKriOtherDetailByKriId(@NonNull @PathVariable(value = "id") String kriId) {
		return KRIResponseEntity.success(MapperUtils
				.mapToTargetClass(otherDetailsService.getKriOtherDetailByKriId(kriId), KriOtherDetailsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_FREQUENCY_ACTION)
	@GetMapping("/otherdetail/kri/frequency/{id}")
	public ResponseEntity<?> getKriFrequencyByKriId(@NonNull @PathVariable(value = "id") String kriId) {
		return KRIResponseEntity.success(otherDetailsService.getKriFrequencyByKriId(kriId));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_DOC_ACTION)
	@PostMapping(value = "/otherdetail/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> otherDetailkUpload(@NonNull @RequestPart MultipartFile file) throws IOException {

		// String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		byte[] uploadFile = file.getBytes();
		// System.out.println("File-Name----->" + fileName +""+ "Content-Type----->" +
		// contentType + " "+ "File-Size" + fileSize);
		if (fileSize > 0) {
			fileuploaddto = new KriOtherDetailsDTO();
			fileuploaddto.setUploadFileName(fileName);
			fileuploaddto.setUploadFile(uploadFile);
			fileadd = true;
		}
		uploadFile = null;
		return KRIResponseEntity.success("File Added");
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/otherdetail/new")
	public ResponseEntity<?> creatKriOtherDetail(Authentication auth, @RequestBody KriOtherDetailsDTO otherDetail) {
		if (fileadd) {
			otherDetail.setUploadFileName(fileuploaddto.getUploadFileName());
			otherDetail.setUploadFile(fileuploaddto.getUploadFile());
			fileuploaddto = null;
		}
		fileadd = false;
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		otherDetail.setCreatedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils
				.mapToTargetClass(otherDetailsService.createKriOtherDetail(otherDetail), KriOtherDetailsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/otherdetail/modify/{id}")
	public ResponseEntity<?> updateKriOtherDetail(Authentication auth,
			@NonNull @PathVariable(value = "id") String kriId, @NonNull @RequestBody KriOtherDetailsDTO otherDetail) {
		if (fileadd) {
			otherDetail.setUploadFileName(fileuploaddto.getUploadFileName());
			otherDetail.setUploadFile(fileuploaddto.getUploadFile());
			fileuploaddto = null;
		}
		fileadd = false;
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		otherDetail.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(
				otherDetailsService.updateKriOtherDetail(kriId, otherDetail), KriOtherDetailsDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/otherdetail/remove")
	public ResponseEntity<?> deleteKriOtherDetail(Authentication auth,
			@NonNull @RequestBody KriOtherDetailsDTO otherDetail) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		otherDetail.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils
				.mapToTargetClass(otherDetailsService.deleteKriOtherDetail(otherDetail), KriOtherDetailsDTO.class));
	}

}
