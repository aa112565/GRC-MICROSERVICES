package com.grc.threat.risk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.grc.threat.common.aspect.Loggable;
import com.grc.threat.common.constants.ThreatLibraryErrorConstants;
import com.grc.threat.common.dto.LoginUserDetails;
import com.grc.threat.common.response.ThreatLibraryResponse;
import com.grc.threat.common.response.ThreatLibraryResponseEntity;
import com.grc.threat.common.utils.ExcelHelper;
import com.grc.threat.common.utils.MapperUtils;
import com.grc.threat.risk.dto.ThreatLibraryDTO;
import com.grc.threat.risk.service.ThreatLibraryService;

@RestController
@RequestMapping("/library")
public class ThreatLibraryController {

	@Autowired
	private ThreatLibraryService threatLibService;

	private static final String READ_THREAT_ACTION = "READ-THREAT-LIBRARY-DETAILS";
	private static final String READ_ALL_THREAT_ACTION = "READ-ALL-THREAT-LIBRARY-DETAILS";
//	private static final String READ_LIST_THREAT_ACTION = "READ-LIST-THREAT-LIBRARY-DETAILS";
	private static final String BULK_THREAT_CREATION_ACTION = "BULK-THREAT-CREATION";
	private static final String THREAT_SAVE_ACTION = "SAVE-THREAT-LIBRARY-DETAILS";
	private static final String THREAT_EDIT_ACTION = "EDIT-THREAT-LIBRARY-DETAILS";
	private static final String THREAT_REMOVE_ACTION = "REMOVE-THREAT-LIBRARY-DETAILS";
	private static final String THREAT_REMOVE_LIST_ACTION = "REMOVE-THREAT-LIST-LIBRARY-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_THREAT_ACTION)
	@PostMapping("/threat/find/all")
	public ResponseEntity<?> getAllThreat(Authentication auth) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		@SuppressWarnings("unused")
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		return ThreatLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(threatLibService.getAllThreat(), ThreatLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_THREAT_ACTION)
	@GetMapping("/threat/find/{id}")
	public ResponseEntity<?> getThreatbyId(@NonNull @PathVariable(value = "id") long threatId) {
		return ThreatLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(threatLibService.getThreatById(threatId), ThreatLibraryDTO.class));
	}
	
/*
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_LIST_THREAT_ACTION)
	@PostMapping("/krimap/activelist")
	public ResponseEntity<?> getActiveThreatByList(@NonNull @RequestBody ThreatDetailsDTO threatDetailsDTO) {
		// System.out.println(
		// "---------active-id-list------------size----->" +
		// (threatDetailsDTO.getThreatIdList()).size());
		ThreatDetailsDTO threatDTO = new ThreatDetailsDTO();
		threatDTO
				.setThreatLibraryList(threatLibService.getActiveThreatByList(threatDetailsDTO.getThreatIdList()));
		return ThreatLibraryResponseEntity.success(threatDTO);
	}
*/
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = BULK_THREAT_CREATION_ACTION)
	@PostMapping(value = "/threat/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ThreatLibraryResponse<?>> bulkRiskUpload(Authentication auth,
			@NonNull @RequestPart MultipartFile file) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();

		if (!ExcelHelper.hasExcelFormat(file)) {
			return ThreatLibraryResponseEntity
					.failure(new ThreatLibraryResponse<>(ThreatLibraryErrorConstants.FAILED,
							ThreatLibraryErrorConstants.INVALID_EXCEL_FILE_FORMAT), HttpStatus.BAD_REQUEST);
		}
		return ThreatLibraryResponseEntity.success(threatLibService.bulkThreatCreation(file, uname));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = THREAT_SAVE_ACTION)
	@PostMapping("/threat/new")
	public ResponseEntity<?> creatThreat(Authentication auth, @NonNull @RequestBody ThreatLibraryDTO threatLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		threatLibrary.setCreatedBy(loginUserDetails.getUsername());
		return ThreatLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(threatLibService.createThreat(threatLibrary), ThreatLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = THREAT_EDIT_ACTION)
	@PutMapping("/threat/modify")
	public ResponseEntity<?> updateThreat(Authentication auth,
			@NonNull @RequestBody ThreatLibraryDTO threatLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		threatLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ThreatLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(threatLibService.updateThreat(threatLibrary), ThreatLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = THREAT_REMOVE_ACTION)
	@PutMapping("/threat/remove")
	public ResponseEntity<?> deleteThreat(Authentication auth,
			@NonNull @RequestBody ThreatLibraryDTO threatLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		threatLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ThreatLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(threatLibService.deleteThreat(threatLibrary), ThreatLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = THREAT_REMOVE_LIST_ACTION)
	@PutMapping("/threat/remove/list")
	public ResponseEntity<?> deleteThreatList(Authentication auth,
			@NonNull @RequestBody List<ThreatLibraryDTO> threatLibraryList) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		// threatLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ThreatLibraryResponseEntity
				.success(threatLibService.deleteThreatList(threatLibraryList, loginUserDetails.getUsername()));
	}
}
