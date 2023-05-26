package com.asymmetrix.grc.riskcontrol.controller;

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

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.constants.ControlLibraryErrorConstants;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.ControlLibraryResponse;
import com.asymmetrix.grc.common.response.ControlLibraryResponseEntity;
import com.asymmetrix.grc.common.utils.ExcelHelper;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskcontrol.dto.ControlDetailsDTO;
import com.asymmetrix.grc.riskcontrol.dto.ControlLibraryDTO;
import com.asymmetrix.grc.riskcontrol.service.ConrolLibraryService;

@RestController
@RequestMapping("/controlLibrary")
public class ControlLibraryController {

	@Autowired
	private ConrolLibraryService controlLibService;

	private static final String READ_CONTROL_ACTION = "READ-CONTROL-LIBRARY-DETAILS";
	private static final String READ_ALL_CONTROL_ACTION = "READ-ALL-CONTROL-LIBRARY-DETAILS";
	private static final String READ_LIST_CONTROL_ACTION = "READ-LIST-CONTROL-LIBRARY-DETAILS";
	private static final String BULK_CONTROL_CREATION_ACTION = "BULK-CONTROL-CREATION";
	private static final String CONTROL_SAVE_ACTION = "SAVE-CONTROL-LIBRARY-DETAILS";
	private static final String CONTROL_EDIT_ACTION = "EDIT-CONTROL-LIBRARY-DETAILS";
	private static final String CONTROL_REMOVE_ACTION = "REMOVE-CONTROL-LIBRARY-DETAILS";
	private static final String CONTROL_REMOVE_LIST_ACTION = "REMOVE-CONTROL-LIST-LIBRARY-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_CONTROL_ACTION)
//	@GetMapping("/getAllControl")
	@PostMapping("/control/find/all")
	public ResponseEntity<?> getAllControl(Authentication auth) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		@SuppressWarnings("unused")
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		return ControlLibraryResponseEntity
				.success(MapperUtils.mapToTargetClass(controlLibService.getAllControl(), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_CONTROL_ACTION)
//	@GetMapping("/getControl/{id}")
	@GetMapping("/control/find/{id}")
	public ResponseEntity<?> getControlbyId(@NonNull @PathVariable(value = "id") long controlId) {
		return ControlLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(controlLibService.getControlById(controlId), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_LIST_CONTROL_ACTION)
	@PostMapping("/krimap/activelist")
	public ResponseEntity<?> getActiveControlByList(@NonNull @RequestBody ControlDetailsDTO controlDetailsDTO) {
		// System.out.println(
		// "---------active-id-list------------size----->" +
		// (controlDetailsDTO.getControlIdList()).size());
		ControlDetailsDTO controlDTO = new ControlDetailsDTO();
		controlDTO
				.setControlLibraryList(controlLibService.getActiveControlByList(controlDetailsDTO.getControlIdList()));
		return ControlLibraryResponseEntity.success(controlDTO);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = BULK_CONTROL_CREATION_ACTION)
	@PostMapping(value = "/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ControlLibraryResponse<?>> bulkRiskUpload(Authentication auth,
			@NonNull @RequestPart MultipartFile file) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();

		if (!ExcelHelper.hasExcelFormat(file)) {
			return ControlLibraryResponseEntity
					.failure(new ControlLibraryResponse<>(ControlLibraryErrorConstants.FAILED,
							ControlLibraryErrorConstants.INVALID_EXCEL_FILE_FORMAT), HttpStatus.BAD_REQUEST);
		}
		return ControlLibraryResponseEntity.success(controlLibService.bulkControlCreation(file, uname));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = CONTROL_SAVE_ACTION)
//	@PostMapping("/createControl")
	@PostMapping("/control/new")
	public ResponseEntity<?> creatControl(Authentication auth, @NonNull @RequestBody ControlLibraryDTO controlLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		controlLibrary.setCreatedBy(loginUserDetails.getUsername());
		return ControlLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(controlLibService.createControl(controlLibrary), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = CONTROL_EDIT_ACTION)
//	@PutMapping("/updateControl")
	@PutMapping("/control/modify")
	public ResponseEntity<?> updateControl(Authentication auth,
			@NonNull @RequestBody ControlLibraryDTO controlLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		controlLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ControlLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(controlLibService.updateControl(controlLibrary), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = CONTROL_REMOVE_ACTION)
//	@PutMapping("/deleteControl")
	@PutMapping("/control/remove")
	public ResponseEntity<?> deleteControl(Authentication auth,
			@NonNull @RequestBody ControlLibraryDTO controlLibrary) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		controlLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ControlLibraryResponseEntity.success(
				MapperUtils.mapToTargetClass(controlLibService.deleteControl(controlLibrary), ControlLibraryDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = CONTROL_REMOVE_LIST_ACTION)
//	@PutMapping("/deleteControl")
	@PutMapping("/control/remove/list")
	public ResponseEntity<?> deleteControlList(Authentication auth,
			@NonNull @RequestBody List<ControlLibraryDTO> controlLibraryList) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		// controlLibrary.setModifiedBy(loginUserDetails.getUsername());
		return ControlLibraryResponseEntity
				.success(controlLibService.deleteControlList(controlLibraryList, loginUserDetails.getUsername()));
	}
}
