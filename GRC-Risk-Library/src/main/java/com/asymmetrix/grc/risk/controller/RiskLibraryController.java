package com.asymmetrix.grc.risk.controller;

import java.util.List;

//import java.util.List;

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

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.constants.RiskErrorConstants;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.RiskResponse;
import com.asymmetrix.grc.common.response.RiskResponseEntity;
import com.asymmetrix.grc.common.utils.ExcelHelper;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.risk.dto.RiskDetailsDTO;
import com.asymmetrix.grc.risk.dto.RiskLibraryDTO;
import com.asymmetrix.grc.risk.dto.RiskRegistWithScoringDTO;
import com.asymmetrix.grc.risk.service.RiskLibraryService;

@RestController
@RequestMapping("/risklibrary")
public class RiskLibraryController {

	@Autowired
	private RiskLibraryService riskLibService;

	private static final String READ_RISK_ACTION = "READ-RISK-LIBRARY-DETAILS";
	private static final String READ_ALL__RISK_ACTION = "READ-ALL-RISK-LIBRARY-DETAILS";
	private static final String READ_LIST_RISK_ACTION = "READ-LIST-RISK-LIBRARY-DETAILS";
	private static final String RISK_READ_EXPORT_ACTION = "READ-EXPORT-RISK-LIBRARY-DETAILS";
	private static final String RISK_READ_REGISTER_LIST_ACTION = "READ-REGISTER-LIST-RISK-LIBRARY-DETAILS";
	private static final String RISK_READ_REGISTER_SCORE_ACTION = "READ-REGISTER-SCORE-RISK-LIBRARY-DETAILS";
	private static final String RISK_SAVE_ACTION = "SAVE-RISK-LIBRARY-DETAILS";
	private static final String RISK_EDIT_ACTION = "EDIT-RISK-LIBRARY-DETAILS";
	private static final String RISK_REMOVE_ACTION = "DELETE-RISK-LIBRARY-DETAILS";
	private static final String RISK_LIST_REMOVE_ACTION = "DELETE-RISK-LIST_LIBRARY-DETAILS";
	private static final String BULK_RISK_CREATION_ACTION = "BULK-RISK-CREATION";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL__RISK_ACTION)
//	@GetMapping("/getAllRisk")
	@PostMapping("/risk/find/all")
	public ResponseEntity<?> getAllRisk(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(riskLibService.getAllRisk(), RiskLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_RISK_ACTION)
//	@GetMapping("/getRisk/{id}")
	@GetMapping("/risk/find/{id}")
	public ResponseEntity<?> getRiskbyId(Authentication auth, @NonNull @PathVariable(value = "id") long riskId) {
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(riskLibService.getRiskById(riskId), RiskLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_LIST_RISK_ACTION)
	@PostMapping("/getRiskDetatilList")
//	@PostMapping("/riskidarray/list")
	public ResponseEntity<?> getRiskbyList(@NonNull @RequestBody RiskDetailsDTO riskDetailsDTO) {
		RiskDetailsDTO riskDTO = new RiskDetailsDTO();
		riskDTO.setRiskLibraryList(riskLibService.getRiskbyList(riskDetailsDTO.getRiskListId()));
		return RiskResponseEntity.success(riskDTO);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = RISK_READ_EXPORT_ACTION)
	@PostMapping("/getRiskExportList")
//	@PostMapping("/dashboard/exportlist")
	public ResponseEntity<?> getRiskExportList(@NonNull @RequestBody RiskDetailsDTO listRiskScoringDTO) {
		RiskDetailsDTO riskDTO = new RiskDetailsDTO();
		riskDTO.setRiskLibraryExportDTO(riskLibService.getRiskExportList(listRiskScoringDTO.getListRiskScoringDTO()));
		return RiskResponseEntity.success(riskDTO);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = RISK_READ_REGISTER_LIST_ACTION)
	@PostMapping("/risk/riskregisterlist")
	public ResponseEntity<?> getActiveRiskIdsList(@NonNull @RequestBody RiskDetailsDTO riskDetailsDTO) {
		RiskDetailsDTO riskDTO = new RiskDetailsDTO();
		riskDTO.setRiskRegisterActiveRiskListDTO(
				riskLibService.getActiveRiskIdsList(riskDetailsDTO.getActiveRiskIdsList()));
		return RiskResponseEntity.success(riskDTO);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = RISK_READ_REGISTER_SCORE_ACTION)
	@PostMapping("/risk/riskregisterscoringlist")
	public ResponseEntity<?> getActiveRiskIdsScoringList(
			@NonNull @RequestBody List<RiskRegistWithScoringDTO> riskScoringDTO) {
		RiskDetailsDTO riskDTO = new RiskDetailsDTO();
		riskDTO.setActiveRiskRegisterScoringList(riskLibService.getActiveRiskIdsScoringList(riskScoringDTO));
		return RiskResponseEntity.success(riskDTO);

	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = BULK_RISK_CREATION_ACTION)
	@PostMapping(value = "/risk/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<RiskResponse<?>> bulkRiskUpload(Authentication auth,
			@NonNull @RequestPart MultipartFile file) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();

		if (!ExcelHelper.hasExcelFormat(file)) {
			return RiskResponseEntity.failure(
					new RiskResponse<>(RiskErrorConstants.FAILED, RiskErrorConstants.INVALID_EXCEL_FILE_FORMAT),
					HttpStatus.BAD_REQUEST);
		}
		return RiskResponseEntity.success(riskLibService.bulkRiskCreation(file, uname));

	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = RISK_SAVE_ACTION)
//	@PostMapping("/createRisk")
	@PostMapping("/risk/new")
	public ResponseEntity<?> creatRisk(Authentication auth, @NonNull @RequestBody RiskLibraryDTO riskLibrary) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		riskLibrary.setCreatedBy(uname);
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(riskLibService.createRisk(riskLibrary), RiskLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = RISK_EDIT_ACTION)
//	@PutMapping("/updateRisk")
	@PutMapping("/risk/modify")
	public ResponseEntity<?> updateRisk(Authentication auth, @NonNull @RequestBody RiskLibraryDTO riskLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		riskLibrary.setModifiedBy(loginUserDetails.getUsername());
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(riskLibService.updateRisk(riskLibrary), RiskLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = RISK_REMOVE_ACTION)
//	@PutMapping("/deleteRisk")
	@PutMapping("/risk/remove")
	public ResponseEntity<?> deleteRisk(Authentication auth, @NonNull @RequestBody RiskLibraryDTO riskLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		riskLibrary.setModifiedBy(loginUserDetails.getUsername());
		return RiskResponseEntity
				.success(MapperUtils.mapToTargetClass(riskLibService.deleteRisk(riskLibrary), RiskLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = RISK_LIST_REMOVE_ACTION)
	@PutMapping("/risk/list/remove")
	public ResponseEntity<?> deleteRiskList(Authentication auth,
			@NonNull @RequestBody List<RiskLibraryDTO> riskLibraryList) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		return RiskResponseEntity
				.success(riskLibService.deleteRiskList(riskLibraryList, loginUserDetails.getUsername()));
	}

}
