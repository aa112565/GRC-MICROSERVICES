/**
 * 
 */
package com.asymmetrix.grc.risk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.risk.dao.PrimarySourceRepository;
import com.asymmetrix.grc.risk.dao.RiskCategoryRepository;
import com.asymmetrix.grc.risk.dao.RiskEventTypeRepository;
import com.asymmetrix.grc.risk.dao.RiskIdModuleRepo;
import com.asymmetrix.grc.risk.dao.RiskTypeRepository;
import com.asymmetrix.grc.risk.dao.SecondarySourceRepository;
import com.asymmetrix.grc.risk.entity.PrimaryReasonSourceDD;
import com.asymmetrix.grc.risk.entity.RiskCategoryDD;
import com.asymmetrix.grc.risk.entity.RiskEventTypeDD;
import com.asymmetrix.grc.risk.entity.RiskIdPreferenceDD;
import com.asymmetrix.grc.risk.entity.RiskTypeDD;
import com.asymmetrix.grc.risk.entity.SecondaryReasonSource;


@Service
public class DropDownValueService {

	@Autowired
	private PrimarySourceRepository primaryReasonRepo;

	@Autowired
	private SecondarySourceRepository secondaryReasonRepo;

	@Autowired
	private RiskTypeRepository riskTypeRepo;

	@Autowired
	private RiskEventTypeRepository riskEventTypeRepo;

	@Autowired
	private RiskCategoryRepository riskCategoryRepo;
	
	@Autowired
	private RiskIdModuleRepo riskIdModuleRepo;

	public List<PrimaryReasonSourceDD> getAllPrimaryReasonSource() {
		return this.primaryReasonRepo.findAllByOrder();
	}

	public List<RiskCategoryDD> getAllRiskCategory() {
		return this.riskCategoryRepo.findAllByOrder();
	}

	public List<RiskEventTypeDD> getAllRiskEventType() {
		return this.riskEventTypeRepo.findAllByOrder();
	}

	public List<RiskTypeDD> getAllRiskType() {
		return this.riskTypeRepo.findAllByOrder();
	}

	public List<SecondaryReasonSource> getAllSecondaryReasonSource() {
		return this.secondaryReasonRepo.findAllByOrder();

	}

	public SecondaryReasonSource createSecondaryReason(SecondaryReasonSource dropDownValue) {

		return this.secondaryReasonRepo.save(dropDownValue);
	}

	public PrimaryReasonSourceDD createPrimaryReason(PrimaryReasonSourceDD dropDownValue) {

		return this.primaryReasonRepo.save(dropDownValue);
	}

	public RiskCategoryDD createRiskCategory(RiskCategoryDD dropDownValue) {

		return this.riskCategoryRepo.save(dropDownValue);
	}

	public RiskEventTypeDD createRiskEventType(RiskEventTypeDD dropDownValue) {

		return this.riskEventTypeRepo.save(dropDownValue);
	}

	public RiskTypeDD createRiskType(RiskTypeDD dropDownValue) {

		return this.riskTypeRepo.save(dropDownValue);
	}
	
	public List<RiskIdPreferenceDD> getRiskIdModule() {
		return this.riskIdModuleRepo.findAllByOrder();
	}
}
