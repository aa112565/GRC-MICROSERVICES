/**
 * 
 */
package com.asymmetrix.grc.riskcontrol.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.asymmetrix.grc.riskcontrol.dao.ControlCategoryArabicRepository;
import com.asymmetrix.grc.riskcontrol.dao.ControlCategoryRepository;
import com.asymmetrix.grc.riskcontrol.dao.ControlCategoryThaiRepository;
import com.asymmetrix.grc.riskcontrol.dao.ControlIdModuleRepo;
import com.asymmetrix.grc.riskcontrol.dao.ControlTypeArabicRepository;
import com.asymmetrix.grc.riskcontrol.dao.ControlTypeRepository;
import com.asymmetrix.grc.riskcontrol.dao.ControlTypeThaiRepository;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategory;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategoryArabic;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategoryThai;
import com.asymmetrix.grc.riskcontrol.entity.ControlIdPreferenceDD;
import com.asymmetrix.grc.riskcontrol.entity.ControlType;
import com.asymmetrix.grc.riskcontrol.entity.ControlTypeArabic;
import com.asymmetrix.grc.riskcontrol.entity.ControlTypeThai;

/**
 * 
 *
 */

@Service
public class DropDownValueService {

	@Autowired
	private ControlTypeRepository controlTypeRepo;

	@Autowired
	private ControlCategoryRepository controlCategoryRepo;

	@Autowired
	private ControlTypeArabicRepository arabicControlTypeRepo;

	@Autowired
	private ControlCategoryArabicRepository arabicControlCategoryRepo;
	
	@Autowired
	private ControlTypeThaiRepository thaiControlTypeRepo;

	@Autowired
	private ControlCategoryThaiRepository thaiControlCategoryRepo;
	
	@Autowired
	private ControlIdModuleRepo controlIdModuleRepo;

	public List<ControlCategory> getAllControlCategory() {
		return this.controlCategoryRepo.findAllByOrder();
	}

	public List<ControlType> getAllControlType() {
		return this.controlTypeRepo.findAllByOrder();
	}

	public ControlCategory createControlCategory(ControlCategory dropDownValue) {
		return this.controlCategoryRepo.save(dropDownValue);
	}

	public ControlType createControlType(ControlType dropDownValue) {
		return this.controlTypeRepo.save(dropDownValue);
	}

	public List<ControlCategoryArabic> getAllArabicControlCategory() {
		return this.arabicControlCategoryRepo.findAllByOrder();
	}

	public List<ControlTypeArabic> getAllArabicControlType() {
		return this.arabicControlTypeRepo.findAllByOrder();
	}
	
	public List<ControlCategoryThai> getAllThaiControlCategory() {
		return this.thaiControlCategoryRepo.findAllByOrder();
	}

	public List<ControlTypeThai> getAllThaiControlType() {
		return this.thaiControlTypeRepo.findAllByOrder();
	}
	
	public List<ControlIdPreferenceDD> getControlIdModule() {
		return this.controlIdModuleRepo.findAll();
	}
}
