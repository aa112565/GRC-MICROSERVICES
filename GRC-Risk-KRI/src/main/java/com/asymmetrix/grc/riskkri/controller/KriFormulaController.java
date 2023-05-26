package com.asymmetrix.grc.riskkri.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.KRIResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dto.KriFormulaDTO;
import com.asymmetrix.grc.riskkri.service.KriFormulaService;


@RestController
@RequestMapping("/kri")
public class KriFormulaController {

	@Autowired
	private KriFormulaService formulaService;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-KRI-FORMULA-DETAILS";
	private static final String READ_ACTION = "READ-KRI-FORMULA-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-KRI-FORMULA-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/formula/find/all")
	public ResponseEntity<?> getKriFormulaList() {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(formulaService.getKriFormula(), KriFormulaDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/formula/find/{id}")
	public ResponseEntity<?> getKriFormulaById(@NonNull @PathVariable(value = "id") long formulaId) {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(formulaService.getKriFormulaId(formulaId), KriFormulaDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/formula/kri/{id}")
	public ResponseEntity<?> getKriFormulaByKriId(@NonNull @PathVariable(value = "id") String kriId) {
		return KRIResponseEntity
				.success(MapperUtils.mapToTargetClass(formulaService.getKriFormulaByKriId(kriId), KriFormulaDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/formula/new")
	public ResponseEntity<?> creatKriFormula(Authentication auth, @NonNull @RequestBody KriFormulaDTO kriFormula) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriFormula.setCreatedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(
				MapperUtils.mapToTargetClass(formulaService.createKriFormula(kriFormula), KriFormulaDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/formula/modify/{id}")
	public ResponseEntity<?> updateKriFormula(Authentication auth, @NonNull @PathVariable(value = "id") String kriId,
			@NonNull @RequestBody KriFormulaDTO kriFormula) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriFormula.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(
				MapperUtils.mapToTargetClass(formulaService.updateKriFormula(kriId, kriFormula), KriFormulaDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/formula/remove")
	public ResponseEntity<?> deleteKriFormula(Authentication auth, @NonNull @RequestBody KriFormulaDTO kriFormula) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		kriFormula.setModifiedBy(loginUserDetails.getUsername());
		return KRIResponseEntity.success(
				MapperUtils.mapToTargetClass(formulaService.deleteKriFormula(kriFormula), KriFormulaDTO.class));
	}

}
