package com.asymmetrix.grc.riskkri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.KRIResponse;
import com.asymmetrix.grc.common.response.KRIResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dto.KriDetailsDTO;
import com.asymmetrix.grc.riskkri.dto.RiskKriDTO;
import com.asymmetrix.grc.riskkri.entity.RiskKri;
import com.asymmetrix.grc.riskkri.service.KRILibraryService;

@RestController
public class KRILibraryController {

	@Autowired
	private KRILibraryService kriLibService;

	private static final String READ_KRI_ACTION = "READ-KRI-LIBRARY-DETAILS";
	private static final String READ_ALL_KRI_ACTION = "READ-ALL-KRI-LIBRARY-DETAILS";
	private static final String READ_KRI_LIST_ACTION = "READ-LIST-KRI-LIBRARY-DETAILS";
	private static final String READ_ALL_KRI_BUSI_LINE_ACTION = "READ-ALL-WITH-BUSINESSLINE-KRI-LIBRARY-DETAILS";
	private static final String SAVE_KRI_ACTION = "SAVE-KRI-LIBRARY-DETAILS";
	private static final String EDIT_KRI_ACTION = "EDIT-KRI-LIBRARY-DETAILS";
	private static final String REMOVE_KRI_ACTION = "DELETE-KRI-LIBRARY-DETAILS";
	private static final String REMOVE_KRI_LIST_ACTION = "DELETE-KRI-LIBRARY-LIST-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_KRI_ACTION)
//	@GetMapping("/kri/find/all")
	@PostMapping("/kri/find/all")
	public ResponseEntity<?> getAllKri() {
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(kriLibService.getAllKri(), RiskKriDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_KRI_ACTION)
	@GetMapping("/kri/find/{id}")
	public ResponseEntity<?> getKriById(@NonNull @PathVariable(value = "id") long kriId) {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(kriLibService.getKriById(kriId), RiskKriDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_KRI_LIST_ACTION)
//	@GetMapping("/kri/find/list")
	@PostMapping("/kri/find/list")
	public ResponseEntity<?> getKriList(@NonNull @RequestBody KriDetailsDTO kriDetailsDTO) {
		KriDetailsDTO kriDTO = new KriDetailsDTO();
		kriDTO.setKriRiskListDto(kriLibService.getKriByList(kriDetailsDTO.getKriIdList()));
		return KRIResponseEntity.success(kriDTO);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_KRI_BUSI_LINE_ACTION)
//	@GetMapping("/kri/find/all/withbusinessline")
	@PostMapping("/kri/find/all/withbusinessline")
	public ResponseEntity<?> getAllKriwithBusinessline() {
		KriDetailsDTO kriDTO = new KriDetailsDTO();
		kriDTO.setKriwithbusinesslinelist(kriLibService.getAllKriwithBusinessline());
		return KRIResponseEntity.success(kriDTO);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_KRI_ACTION)
	@PostMapping("/kri/new")
	public ResponseEntity<?> createKri(Authentication auth, @NonNull @RequestBody RiskKriDTO kriMap) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriMap.setCreatedBy(loginUserDetails.getUsername());
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(kriLibService.createKri(kriMap), RiskKriDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_KRI_ACTION)
	@PostMapping("/kri/save/all")
	public ResponseEntity<KRIResponse<List<RiskKri>>> saveAllKri(@NonNull @RequestBody List<RiskKri> riskKriAll) {

		return KRIResponseEntity.success(kriLibService.saveAllKri(riskKriAll));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = EDIT_KRI_ACTION)
	@PutMapping("/kri/modify")
	public ResponseEntity<?> updateKri(Authentication auth, @NonNull @RequestBody RiskKriDTO kriMap) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriMap.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(kriLibService.updateKri(kriMap), RiskKriDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_KRI_ACTION)
	@PutMapping("/kri/remove")
	public ResponseEntity<?> deleteKri(Authentication auth, @NonNull @RequestBody RiskKriDTO kriMap) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriMap.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(kriLibService.deleteKri(kriMap), RiskKriDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_KRI_LIST_ACTION)
	@PutMapping("/kri/remove/list")
	public ResponseEntity<?> deleteKriList(Authentication auth, @NonNull @RequestBody List<RiskKriDTO> kriMapList) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		// kriMap.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(kriLibService.deleteKriList(kriMapList, loginUserDetails.getUsername()));
	}
}
