package com.asymmetrix.grc.riskkri.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.KRIResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dto.KriRiskRegistryRiskMappingDTO;
import com.asymmetrix.grc.riskkri.entity.KriRiskRegistryRiskMapping;
import com.asymmetrix.grc.riskkri.service.KriRiskRegistryRiskMappingService;


@RestController
@RequestMapping("/kriregistry")
public class KriRiskRegistryRiskMappingController {

	@Autowired
	private KriRiskRegistryRiskMappingService kriRegistryMapService;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-KRI-REGISTRY-MAP-DETAILS";
	private static final String READ_ACTION = "READ-KRI-REGISTRY-MAP-DETAILS";
	private static final String READ_ALL_ACTION = "READ-KRI-REGISTRY-MAP-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ACTION)
	@GetMapping("/riskmap/find/all")
	public ResponseEntity<?> getKriRiskRegistryRiskMappingList() {
		return KRIResponseEntity.success(MapperUtils.mapToTargetClass(
				kriRegistryMapService.getKriRiskRegistryRiskMappingList(), KriRiskRegistryRiskMappingDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/riskmap/find/{id}")
	public ResponseEntity<?> getKriRiskRegistryRiskMappingById(@NonNull @PathVariable(value = "id") long kriRiskMapId) {
		return KRIResponseEntity.success(
				MapperUtils.mapToTargetClass(kriRegistryMapService.getKriRiskRegistryRiskMappingById(kriRiskMapId),
						KriRiskRegistryRiskMappingDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/riskmap/kri/{id}")
	public ResponseEntity<?> getKriRiskRegistryRiskMappingByKriId(@NonNull @PathVariable(value = "id") String kriId) {

		List<KriRiskRegistryRiskMappingDTO> KriRiskRegistryMappingList = new ArrayList<>();
		List<KriRiskRegistryRiskMapping> KriRiskRegistryRiskMappingList = kriRegistryMapService
				.getKriRiskRegistryRiskMappingByKriId(kriId);
		for (KriRiskRegistryRiskMapping KriRiskRegistryRiskMap : KriRiskRegistryRiskMappingList) {
			KriRiskRegistryMappingList
					.add(MapperUtils.mapToTargetClass(KriRiskRegistryRiskMap, KriRiskRegistryRiskMappingDTO.class));
		}
		return KRIResponseEntity.success(KriRiskRegistryMappingList);

	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/riskmap/new")
	public ResponseEntity<?> createKriRiskRegistryRiskMapping(Authentication auth,
			@NonNull @RequestBody List<KriRiskRegistryRiskMappingDTO> kriRiskRegistryMapDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();

		List<KriRiskRegistryRiskMappingDTO> KriRiskRegistryMappingList = new ArrayList<>();
		List<KriRiskRegistryRiskMapping> KriRiskRegistryRiskMappingList = kriRegistryMapService
				.createKriRiskRegistryRiskMapping(kriRiskRegistryMapDto, loginUserDetails.getUsername());

		for (KriRiskRegistryRiskMapping KriRiskRegistryRiskMap : KriRiskRegistryRiskMappingList) {
			KriRiskRegistryMappingList
					.add(MapperUtils.mapToTargetClass(KriRiskRegistryRiskMap, KriRiskRegistryRiskMappingDTO.class));
		}
		return KRIResponseEntity.success(KriRiskRegistryMappingList);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/riskmap/modify/{id}")
	public ResponseEntity<?> updateKriRiskRegistryRiskMapping(Authentication auth,
			@NonNull @PathVariable(value = "id") String kriId,
			@NonNull @RequestBody List<KriRiskRegistryRiskMappingDTO> newkriRiskRegistryMapDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		List<KriRiskRegistryRiskMappingDTO> KriRiskRegistryMappingList = new ArrayList<>();
		List<KriRiskRegistryRiskMapping> KriRiskRegistryRiskMappingList = kriRegistryMapService
				.updateKriRiskRegistryRiskMapping(kriId, newkriRiskRegistryMapDto, loginUserDetails.getUsername());
		for (KriRiskRegistryRiskMapping KriRiskRegistryRiskMap : KriRiskRegistryRiskMappingList) {
			KriRiskRegistryMappingList
					.add(MapperUtils.mapToTargetClass(KriRiskRegistryRiskMap, KriRiskRegistryRiskMappingDTO.class));
		}
		return KRIResponseEntity.success(KriRiskRegistryMappingList);

	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/riskmap/remove")
	public ResponseEntity<?> deleteKriRiskRegistryRiskMapping(Authentication auth,
			@NonNull @RequestBody List<KriRiskRegistryRiskMappingDTO> removekriRiskRegistryMapDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		List<KriRiskRegistryRiskMappingDTO> KriRiskRegistryMappingList = new ArrayList<>();
		List<KriRiskRegistryRiskMapping> KriRiskRegistryRiskMappingList = kriRegistryMapService
				.deleteKriRiskRegistryRiskMapping(removekriRiskRegistryMapDto, loginUserDetails.getUsername());
		for (KriRiskRegistryRiskMapping KriRiskRegistryRiskMap : KriRiskRegistryRiskMappingList) {
			KriRiskRegistryMappingList
					.add(MapperUtils.mapToTargetClass(KriRiskRegistryRiskMap, KriRiskRegistryRiskMappingDTO.class));
		}
		return KRIResponseEntity.success(KriRiskRegistryMappingList);

	}

}
