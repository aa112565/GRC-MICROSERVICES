package com.asymmetrix.grc.riskcontrol.controller;

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
import com.asymmetrix.grc.common.constants.ControlLibraryErrorConstants;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.ControlLibraryResponse;
import com.asymmetrix.grc.common.response.ControlLibraryResponseEntity;
import com.asymmetrix.grc.common.utils.ExcelHelper;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskcontrol.dto.ControlLibraryDTO;

import com.asymmetrix.grc.riskcontrol.service.ConrolLibraryServiceThai;

@RestController
@RequestMapping("/controlLibrary")
public class ControlLibraryThaiController {

	@Autowired
	private ConrolLibraryServiceThai    thaiControlLibService;

	private static final String READ_ACTION = "THAI-READ-CONTROL-LIBRARY-DETAILS";
	private static final String READ_ALL_ACTION = "THAI-READ-ALL-CONTROL-LIBRARY-DETAILS";
	private static final String SAVE_OR_EDIT_ACTION = "THAI-SAVE-OR-EDIT-CONTROL-LIBRARY-DETAILS";
	private static final String BULK_CONTROL_CREATION_ACTION = "THAI-BULK-CONTROL-CREATION";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/thai/control/find/all")
	public ResponseEntity<?> getAllControl(Authentication auth) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		@SuppressWarnings("unused")
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		return ControlLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(thaiControlLibService.getAllControl(), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/thai/control/find/{id}")
	public ResponseEntity<?> getControlbyId(@NonNull @PathVariable(value = "id") long controlId) {
		return ControlLibraryResponseEntity.success(MapperUtils
				.mapToTargetClass(thaiControlLibService.getControlById(controlId), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = BULK_CONTROL_CREATION_ACTION)
	@PostMapping(value = "/thai/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ControlLibraryResponse<?>> bulkRiskUpload(@NonNull @RequestPart MultipartFile file) {
		if (!ExcelHelper.hasExcelFormat(file)) {
			return ControlLibraryResponseEntity
					.failure(new ControlLibraryResponse<>(ControlLibraryErrorConstants.FAILED,
							ControlLibraryErrorConstants.INVALID_EXCEL_FILE_FORMAT), HttpStatus.BAD_REQUEST);
		}
		return ControlLibraryResponseEntity.success(thaiControlLibService.bulkControlCreation(file));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/thai/control/new")
	public ResponseEntity<?> creatControl(Authentication auth, @NonNull @RequestBody ControlLibraryDTO controlLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		controlLibrary.setCreatedBy(uname);
		return ControlLibraryResponseEntity.success(MapperUtils
				.mapToTargetClass(thaiControlLibService.createControl(controlLibrary), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/thai/control/modify")
	public ResponseEntity<?> updateControl(Authentication auth,
			@NonNull @RequestBody ControlLibraryDTO controlLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		controlLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ControlLibraryResponseEntity.success(MapperUtils
				.mapToTargetClass(thaiControlLibService.updateControl(controlLibrary), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/thai/control/remove")
	public ResponseEntity<?> deleteControl(Authentication auth,
			@NonNull @RequestBody ControlLibraryDTO controlLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		controlLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ControlLibraryResponseEntity.success(MapperUtils
				.mapToTargetClass(thaiControlLibService.deleteControl(controlLibrary), ControlLibraryDTO.class));
	}

}
