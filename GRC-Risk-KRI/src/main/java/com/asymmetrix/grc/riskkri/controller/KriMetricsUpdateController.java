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
import com.asymmetrix.grc.riskkri.dto.KriMetricsUpdateDTO;
import com.asymmetrix.grc.riskkri.service.KriMetricsUpdateService;



@RestController
@RequestMapping("/kri")
public class KriMetricsUpdateController {

	@Autowired
	private KriMetricsUpdateService metricsService;

	KriMetricsUpdateDTO uploaddto;
	boolean fileadd = false;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-KRI-METRICS-DETAILS";
	private static final String SAVE_OR_EDIT__DOC_ACTION = "SAVE-OR-EDIT-WITH-DOC-KRI-METRICS-DETAILS";
	private static final String READ_ACTION = "READ-KRI-METRICS-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-KRI-METRICS-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/metricsupdate/find/all")
	public ResponseEntity<?> getKriMetricsUpdateList() {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(metricsService.getKriMetricsUpdate(), KriMetricsUpdateDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/metricsupdate/find/{id}")
	public ResponseEntity<?> getKriMetricsUpdateById(@NonNull @PathVariable(value = "id") long metricsId) {
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(metricsService.getKriMetricsUpdateById(metricsId),
				KriMetricsUpdateDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/metricsupdate/kri/{id}")
	public ResponseEntity<?> getKriMetricsUpdateByKriId(@NonNull @PathVariable(value = "id") String kriId) {
		return KRIResponseEntity.success(
				MapperUtils.mapToTargetClass(metricsService.getKriMetricsByKriId(kriId), KriMetricsUpdateDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT__DOC_ACTION)
	@PostMapping(value = "/metricsupdate/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> metricsUpdateUpload(@NonNull @RequestPart MultipartFile file) throws IOException {

		// String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		byte[] uploadFile = file.getBytes();
		// System.out.println("File-Name----->" + fileName +""+ "Content-Type----->" +
		// contentType + " "+ "File-Size" + fileSize);
		if (fileSize > 0) {
			uploaddto = new KriMetricsUpdateDTO();
			uploaddto.setUploadFileName(fileName);
			uploaddto.setUploadFile(uploadFile);
			fileadd = true;
		}
		uploadFile = null;
		return KRIResponseEntity.success("File Added");
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/metricsupdate/new")
	public ResponseEntity<?> createKriMetricsUpdate(Authentication auth,
			@RequestBody KriMetricsUpdateDTO metricsUppdate) {
		if (fileadd) {
			metricsUppdate.setUploadFileName(uploaddto.getUploadFileName());
			metricsUppdate.setUploadFile(uploaddto.getUploadFile());
			uploaddto = null;
		}
		fileadd = false;
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		metricsUppdate.setCreatedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils
				.mapToTargetClass(metricsService.createKriMetricsUpdate(metricsUppdate), KriMetricsUpdateDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/metricsupdate/modify")
	public ResponseEntity<?> updateKriMetricsUpdate(Authentication auth,
			@NonNull @RequestBody KriMetricsUpdateDTO metricsUppdate) {
		if (fileadd) {
			metricsUppdate.setUploadFileName(uploaddto.getUploadFileName());
			metricsUppdate.setUploadFile(uploaddto.getUploadFile());
			uploaddto = null;
		}
		fileadd = false;
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		metricsUppdate.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils
				.mapToTargetClass(metricsService.updateKriMetricsUpdate(metricsUppdate), KriMetricsUpdateDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/metricsupdate/remove")
	public ResponseEntity<?> deleteKriMetricsUpdate(Authentication auth,
			@NonNull @RequestBody KriMetricsUpdateDTO metricsUppdate) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		metricsUppdate.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(MapperUtils
				.mapToTargetClass(metricsService.deleteKriMetricsUpdate(metricsUppdate), KriMetricsUpdateDTO.class));
	}

}
