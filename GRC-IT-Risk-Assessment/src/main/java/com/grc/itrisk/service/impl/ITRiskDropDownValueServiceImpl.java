
package com.grc.itrisk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grc.itrisk.dao.AssessmentFrequencyRepo;
import com.grc.itrisk.dao.AssessmentRatingResponseRepo;
import com.grc.itrisk.dao.AssessmentTypeRepo;
import com.grc.itrisk.dao.ITRiskIdModuleRepo;
import com.grc.itrisk.entity.AssessmentFrequencyDD;
import com.grc.itrisk.entity.AssessmentRatingResponseDD;
import com.grc.itrisk.entity.AssessmentTypeDD;
import com.grc.itrisk.entity.ITRiskIdPreferenceDD;
import com.grc.itrisk.service.ITRiskDropDownValueService;

@Service
public class ITRiskDropDownValueServiceImpl implements ITRiskDropDownValueService{

	@Autowired
	private AssessmentRatingResponseRepo ratingResponseRepo;

	@Autowired
	private AssessmentFrequencyRepo frequencyRepo;

	@Autowired
	private AssessmentTypeRepo assessmentTypeRepo;	
	
	@Autowired
	private ITRiskIdModuleRepo itRiskIdModuleRepo;

	@Override
	public List<AssessmentRatingResponseDD> getRatingResponse() {
		return this.ratingResponseRepo.findAllByOrder();
	}


	@Override
	public List<AssessmentFrequencyDD> getAssessmentFrequency() {
		return this.frequencyRepo.findAllByOrder();
	}


	@Override
	public List<AssessmentTypeDD> getAssessmentType() {
		return this.assessmentTypeRepo.findAllByOrder();
	}
	
	@Override
	public List<ITRiskIdPreferenceDD> getITRiskIdModule() {
		return this.itRiskIdModuleRepo.findAllByOrder();
	}
}
