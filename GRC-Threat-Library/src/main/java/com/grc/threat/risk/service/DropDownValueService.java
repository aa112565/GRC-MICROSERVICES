/**
 * 
 */
package com.grc.threat.risk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grc.threat.risk.dao.ThreatCategoryRepository;
import com.grc.threat.risk.dao.ThreatIdModuleRepo;
import com.grc.threat.risk.dao.ThreatTypeRepository;
import com.grc.threat.risk.entity.ThreatCategory;
import com.grc.threat.risk.entity.ThreatIdPreferenceDD;
import com.grc.threat.risk.entity.ThreatType;



@Service
public class DropDownValueService {

	@Autowired
	private ThreatTypeRepository threatTypeRepo;

	@Autowired
	private ThreatCategoryRepository threatCategoryRepo;

	
	@Autowired
	private ThreatIdModuleRepo threatIdModuleRepo;

	public List<ThreatCategory> getAllThreatCategory() {
		return this.threatCategoryRepo.findAllByOrder();
	}

	public List<ThreatType> getAllThreatType() {
		return this.threatTypeRepo.findAllByOrder();
	}

	public ThreatCategory createThreatCategory(ThreatCategory dropDownValue) {
		return this.threatCategoryRepo.save(dropDownValue);
	}

	public ThreatType createThreatType(ThreatType dropDownValue) {
		return this.threatTypeRepo.save(dropDownValue);
	}

		
	public List<ThreatIdPreferenceDD> getThreatIdModule() {
		return this.threatIdModuleRepo.findAllByOrder();
	}
}
