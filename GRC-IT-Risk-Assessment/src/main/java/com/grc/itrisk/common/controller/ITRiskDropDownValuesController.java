package com.grc.itrisk.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grc.itrisk.common.aspect.Loggable;
import com.grc.itrisk.common.response.ITRiskResponse;
import com.grc.itrisk.common.response.ITRiskResponseEntity;
import com.grc.itrisk.dto.DropDownValues;
import com.grc.itrisk.entity.AssessmentFrequencyDD;
import com.grc.itrisk.entity.AssessmentRatingResponseDD;
import com.grc.itrisk.entity.AssessmentTypeDD;
import com.grc.itrisk.entity.ITRiskIdPreferenceDD;
import com.grc.itrisk.service.ITRiskDropDownValueService;

@RestController
public class ITRiskDropDownValuesController {

	@Autowired
	private ITRiskDropDownValueService dropDwonValueService;

	private static final String READ_AUDIT_DD_ACTION = "READ-ITRISK-ASSESSMENT-DROPDOWN-VALUES";


	@PreAuthorize("permitAll()")
	@Loggable(action = READ_AUDIT_DD_ACTION)
	@GetMapping("/assessment/dropdownvalues")
	public ResponseEntity<ITRiskResponse<?>> getAssessmentDropDownValues() {

		DropDownValues dropDwonValuesDto = new DropDownValues();

		List<AssessmentRatingResponseDD> ratingResponse = dropDwonValueService.getRatingResponse();
		dropDwonValuesDto.setAssessmentRatingResponse(ratingResponse);

		List<AssessmentFrequencyDD> frequency = dropDwonValueService.getAssessmentFrequency();
		dropDwonValuesDto.setAssessmentFrequency(frequency);;
		
		List<AssessmentTypeDD> assessmentType = dropDwonValueService.getAssessmentType();
		dropDwonValuesDto.setAssessmentType(assessmentType);	
		
		List<ITRiskIdPreferenceDD>  preferenceModule= dropDwonValueService.getITRiskIdModule();
		dropDwonValuesDto.setIdPreferenceModule(preferenceModule);		
	
		return ITRiskResponseEntity.success(dropDwonValuesDto);
	}

	


}
