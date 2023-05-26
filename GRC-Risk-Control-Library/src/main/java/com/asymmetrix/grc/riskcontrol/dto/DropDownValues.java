package com.asymmetrix.grc.riskcontrol.dto;

import java.util.List;


import com.asymmetrix.grc.riskcontrol.entity.ControlCategory;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategoryArabic;
import com.asymmetrix.grc.riskcontrol.entity.ControlCategoryThai;
import com.asymmetrix.grc.riskcontrol.entity.ControlIdPreferenceDD;
import com.asymmetrix.grc.riskcontrol.entity.ControlType;
import com.asymmetrix.grc.riskcontrol.entity.ControlTypeArabic;
import com.asymmetrix.grc.riskcontrol.entity.ControlTypeThai;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropDownValues {

	private List<ControlCategory> controlCategory;

	private List<ControlType> controlType;

	private List<ControlCategoryArabic> arabicControlCategory;

	private List<ControlTypeArabic> arabicControlType;
	
	private List<ControlCategoryThai> thaiControlCategory;

	private List<ControlTypeThai> thaiControlType;
	
	private List<ControlIdPreferenceDD>  idPreferenceModule;

	public List<ControlCategory> getControlCategory() {
		return controlCategory;
	}

	public void setControlCategory(List<ControlCategory> controlCategory) {
		this.controlCategory = controlCategory;
	}

	public List<ControlType> getControlType() {
		return controlType;
	}

	public void setControltype(List<ControlType> controlType) {
		this.controlType = controlType;
	}

	public List<ControlCategoryArabic> getArabicControlCategory() {
		return arabicControlCategory;
	}

	public void setArabicControlCategory(List<ControlCategoryArabic> arabicControlCategory) {
		this.arabicControlCategory = arabicControlCategory;
	}

	public List<ControlTypeArabic> getArabicControlType() {
		return arabicControlType;
	}

	public void setArabicControlType(List<ControlTypeArabic> arabicControlType) {
		this.arabicControlType = arabicControlType;
	}

	public List<ControlCategoryThai> getThaiControlCategory() {
		return thaiControlCategory;
	}

	public void setThaiControlCategory(List<ControlCategoryThai> thaiControlCategory) {
		this.thaiControlCategory = thaiControlCategory;
	}

	public List<ControlTypeThai> getThaiControlType() {
		return thaiControlType;
	}

	public void setThaiControlType(List<ControlTypeThai> thaiControlType) {
		this.thaiControlType = thaiControlType;
	}

	public List<ControlIdPreferenceDD> getIdPreferenceModule() {
		return idPreferenceModule;
	}

	public void setIdPreferenceModule(List<ControlIdPreferenceDD> idPreferenceModule) {
		this.idPreferenceModule = idPreferenceModule;
	}

	public void setControlType(List<ControlType> controlType) {
		this.controlType = controlType;
	}
	
	

}
