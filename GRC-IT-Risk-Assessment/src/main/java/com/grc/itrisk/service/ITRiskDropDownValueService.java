
package com.grc.itrisk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grc.itrisk.entity.AssessmentFrequencyDD;
import com.grc.itrisk.entity.AssessmentRatingResponseDD;
import com.grc.itrisk.entity.AssessmentTypeDD;
import com.grc.itrisk.entity.ITRiskIdPreferenceDD;

@Service
public interface ITRiskDropDownValueService {

	List<AssessmentRatingResponseDD> getRatingResponse();

	List<AssessmentFrequencyDD> getAssessmentFrequency();

	List<AssessmentTypeDD> getAssessmentType();

	List<ITRiskIdPreferenceDD> getITRiskIdModule();

	
	
}
