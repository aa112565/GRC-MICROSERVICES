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
import com.asymmetrix.grc.common.response.ControlLibraryResponse;
import com.asymmetrix.grc.common.response.ControlLibraryResponseEntity;

import com.asymmetrix.grc.riskcontrol.dto.DropDownValues;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategory;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategoryArabic;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategoryThai;
import com.asymmetrix.grc.riskcontrol.entity.ControlIdPreferenceDD;
import com.asymmetrix.grc.riskcontrol.entity.ControlType;
import com.asymmetrix.grc.riskcontrol.entity.ControlTypeArabic;
import com.asymmetrix.grc.riskcontrol.entity.ControlTypeThai;
import com.asymmetrix.grc.riskcontrol.service.DropDownValueService;

@RestController
@RequestMapping("/control")
public class ControlLibraryDropDownValuesController {

	@Autowired
	private DropDownValueService dropDwonValueService;

	private static final String READ_ACTION = "READ-CONTROL-LIBRARY-DETAILS-DD";

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/getAllDropDownValues")
	public ResponseEntity<ControlLibraryResponse<DropDownValues>> getAllDropDownValues() {
		DropDownValues dropDwonValuesDto = new DropDownValues();
		
		List<ControlCategory> rc = getAllControlCategory();
		dropDwonValuesDto.setControlCategory(rc);
		
		List<ControlType> rt = getAllControlType();
		dropDwonValuesDto.setControltype(rt);
		
		List<ControlIdPreferenceDD>  preferenceModule= getControlIdModule();
		dropDwonValuesDto.setIdPreferenceModule(preferenceModule);
		
		return ControlLibraryResponseEntity.success(dropDwonValuesDto);
	}

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/arabic/getAllDropDownValues")
	public ResponseEntity<ControlLibraryResponse<DropDownValues>> getAllArabicDropDownValues() {
		DropDownValues dropDwonValuesDto = new DropDownValues();
		List<ControlCategoryArabic> rc = getAllArabicControlCategory();
		dropDwonValuesDto.setArabicControlCategory(rc);
		List<ControlTypeArabic> rt = getAllArabicControlType();
		dropDwonValuesDto.setArabicControlType(rt);
		return ControlLibraryResponseEntity.success(dropDwonValuesDto);
	}
	
	
	@PreAuthorize("permitAll()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/thai/getAllDropDownValues")
	public ResponseEntity<ControlLibraryResponse<DropDownValues>> getAllThaiDropDownValues() {
		DropDownValues dropDwonValuesDto = new DropDownValues();
		List<ControlCategoryThai> rc = getAllThaiControlCategory();
		dropDwonValuesDto.setThaiControlCategory(rc);
		List<ControlTypeThai> rt = getAllThaiControlType();
		dropDwonValuesDto.setThaiControlType(rt);
		return ControlLibraryResponseEntity.success(dropDwonValuesDto);
	}

	@GetMapping("/getControlCategory")
	public List<ControlCategory> getAllControlCategory() {
		return this.dropDwonValueService.getAllControlCategory();
	}

	@PostMapping("/createControlCategory")
	public ControlCategory createControlCategory(@RequestBody ControlCategory dropDownValue) {
		return this.dropDwonValueService.createControlCategory(dropDownValue);
	}

	@GetMapping("/getControlType")
	public List<ControlType> getAllControlType() {
		return this.dropDwonValueService.getAllControlType();
	}

	@PostMapping("/createControlType")
	public ControlType createControlType(@RequestBody ControlType dropDownValue) {
		return this.dropDwonValueService.createControlType(dropDownValue);
	}

	@GetMapping("/getControlCategoryArabic")
	public List<ControlCategoryArabic> getAllArabicControlCategory() {
		return this.dropDwonValueService.getAllArabicControlCategory();
	}

	@GetMapping("/getControlTypeArabic")
	public List<ControlTypeArabic> getAllArabicControlType() {
		return this.dropDwonValueService.getAllArabicControlType();
	}
	
	@GetMapping("/getControlCategoryThai")
	public List<ControlCategoryThai> getAllThaiControlCategory() {
		return this.dropDwonValueService.getAllThaiControlCategory();
	}

	@GetMapping("/getControlTypeThai")
	public List<ControlTypeThai> getAllThaiControlType() {
		return this.dropDwonValueService.getAllThaiControlType();		
	}
	
	public List<ControlIdPreferenceDD> getControlIdModule() {
		return this.dropDwonValueService.getControlIdModule();
	}


}
