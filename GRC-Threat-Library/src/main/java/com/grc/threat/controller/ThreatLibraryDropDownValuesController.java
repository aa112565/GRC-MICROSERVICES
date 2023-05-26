package com.grc.threat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grc.threat.common.aspect.Loggable;
import com.grc.threat.common.response.ThreatLibraryResponse;
import com.grc.threat.common.response.ThreatLibraryResponseEntity;
import com.grc.threat.risk.dto.DropDownValues;
import com.grc.threat.risk.entity.ThreatCategory;
import com.grc.threat.risk.entity.ThreatIdPreferenceDD;
import com.grc.threat.risk.entity.ThreatType;
import com.grc.threat.risk.service.DropDownValueService;

@RestController
@RequestMapping("/threat")
public class ThreatLibraryDropDownValuesController {

	@Autowired
	private DropDownValueService dropDwonValueService;

	private static final String READ_ACTION = "READ-THREAT-LIBRARY-DETAILS-DD";

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/getAllDropDownValues")
	public ResponseEntity<ThreatLibraryResponse<DropDownValues>> getAllDropDownValues() {
		DropDownValues dropDwonValuesDto = new DropDownValues();
		
	//	List<ThreatCategory> rc = getAllThreatCategory();
	//	dropDwonValuesDto.setThreatCategory(rc);
		
		List<ThreatType> rt = getAllThreatType();
		dropDwonValuesDto.setThreatType(rt);
		
		List<ThreatIdPreferenceDD>  preferenceModule= getThreatIdModule();
		dropDwonValuesDto.setIdPreferenceModule(preferenceModule);
		
		return ThreatLibraryResponseEntity.success(dropDwonValuesDto);
	}
	

	@GetMapping("/getThreatCategory")
	public List<ThreatCategory> getAllThreatCategory() {
		return this.dropDwonValueService.getAllThreatCategory();
	}

	@PostMapping("/createThreatCategory")
	public ThreatCategory createThreatCategory(@RequestBody ThreatCategory dropDownValue) {
		return this.dropDwonValueService.createThreatCategory(dropDownValue);
	}

	@GetMapping("/getThreatType")
	public List<ThreatType> getAllThreatType() {
		return this.dropDwonValueService.getAllThreatType();
	}

	@PostMapping("/createThreatType")
	public ThreatType createThreatType(@RequestBody ThreatType dropDownValue) {
		return this.dropDwonValueService.createThreatType(dropDownValue);
	}


	public List<ThreatIdPreferenceDD> getThreatIdModule() {
		return this.dropDwonValueService.getThreatIdModule();
	}


}
