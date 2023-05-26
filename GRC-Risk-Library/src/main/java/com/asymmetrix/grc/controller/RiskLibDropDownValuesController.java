package com.asymmetrix.grc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.response.RiskResponse;
import com.asymmetrix.grc.common.response.RiskResponseEntity;
import com.asymmetrix.grc.risk.dto.DropDownValues;
import com.asymmetrix.grc.risk.entity.PrimaryReasonSourceDD;
import com.asymmetrix.grc.risk.entity.RiskCategoryDD;
import com.asymmetrix.grc.risk.entity.RiskEventTypeDD;
import com.asymmetrix.grc.risk.entity.RiskIdPreferenceDD;
import com.asymmetrix.grc.risk.entity.RiskTypeDD;
import com.asymmetrix.grc.risk.entity.SecondaryReasonSource;
import com.asymmetrix.grc.risk.service.DropDownValueService;


@RestController
@RequestMapping("/risk")
public class RiskLibDropDownValuesController {

	@Autowired
	private DropDownValueService dropDwonValueService;

	private static final String READ_ACTION = "READ-RISK-LIBRARY-DETAILS_DD";

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/getAllDropDownValues")
//	@GetMapping("risk/dropdownvalues")	
	public ResponseEntity<RiskResponse<DropDownValues>> getAllDropDownValues() {

		DropDownValues dropDwonValuesDto = new DropDownValues();
		
		List<SecondaryReasonSource> srs = getAllSecondaryReasonSource();
		dropDwonValuesDto.setSecondaryReasonSource(srs);
		
		List<PrimaryReasonSourceDD> prs = getAllPrimaryReasonSource();
		dropDwonValuesDto.setPrimaryReasonSource(prs);
		
		List<RiskCategoryDD> rc = getAllRiskCategory();
		dropDwonValuesDto.setRiskCategory(rc);
		
		List<RiskEventTypeDD> ret = getAllRiskEventType();
		dropDwonValuesDto.setRiskEventType(ret);
		
		List<RiskTypeDD> rt = getAllRiskType();
		dropDwonValuesDto.setRisktype(rt);
		
		List<RiskIdPreferenceDD>  preferenceModule= getRiskIdModule();
		dropDwonValuesDto.setIdPreferenceModule(preferenceModule);
		
		return RiskResponseEntity.success(dropDwonValuesDto);
	}

	@GetMapping("/getSecondaryReason")
	public List<SecondaryReasonSource> getAllSecondaryReasonSource() {
		return this.dropDwonValueService.getAllSecondaryReasonSource();
	}

	@PostMapping("/createSecondaryReason")
	public SecondaryReasonSource createSecondaryReason(@RequestBody SecondaryReasonSource dropDownValue) {
		return this.dropDwonValueService.createSecondaryReason(dropDownValue);
	}

	@GetMapping("/getPrimaryReason")
	public List<PrimaryReasonSourceDD> getAllPrimaryReasonSource() {
		return this.dropDwonValueService.getAllPrimaryReasonSource();
	}

	@PostMapping("/createPrimaryReason")
	public PrimaryReasonSourceDD createPrimaryReason(@RequestBody PrimaryReasonSourceDD dropDownValue) {
		return this.dropDwonValueService.createPrimaryReason(dropDownValue);
	}

	@GetMapping("/getRiskCategory")
	public List<RiskCategoryDD> getAllRiskCategory() {
		return this.dropDwonValueService.getAllRiskCategory();
	}

	@PostMapping("/createRiskCategory")
	public RiskCategoryDD createRiskCategory(@RequestBody RiskCategoryDD dropDownValue) {
		return this.dropDwonValueService.createRiskCategory(dropDownValue);
	}

	@GetMapping("/getRiskEventType")
	public List<RiskEventTypeDD> getAllRiskEventType() {
		return this.dropDwonValueService.getAllRiskEventType();
	}

	@PostMapping("/createRiskEventType")
	public RiskEventTypeDD createRiskEventType(@RequestBody RiskEventTypeDD dropDownValue) {
		return this.dropDwonValueService.createRiskEventType(dropDownValue);
	}

	@GetMapping("/getRiskType")
	public List<RiskTypeDD> getAllRiskType() {
		return this.dropDwonValueService.getAllRiskType();
	}

	@PostMapping("/createRiskType")
	public RiskTypeDD createRiskType(@RequestBody RiskTypeDD dropDownValue) {
		return this.dropDwonValueService.createRiskType(dropDownValue);
	}
	
	public List<RiskIdPreferenceDD> getRiskIdModule() {
		return this.dropDwonValueService.getRiskIdModule();
	}

}
