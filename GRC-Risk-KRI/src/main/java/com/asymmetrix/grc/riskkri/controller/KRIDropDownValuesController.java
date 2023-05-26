package com.asymmetrix.grc.riskkri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.response.KRIResponse;
import com.asymmetrix.grc.common.response.KRIResponseEntity;

import com.asymmetrix.grc.riskkri.dto.DropDownValues;
import com.asymmetrix.grc.riskkri.dto.KriFormulaDropdownValues;
import com.asymmetrix.grc.riskkri.dto.KriMapDropdownValues;
import com.asymmetrix.grc.riskkri.dto.KriMetricsupdateDropdownValues;
import com.asymmetrix.grc.riskkri.dto.KriOtherdetailsDropdownValues;
import com.asymmetrix.grc.riskkri.dto.KriThresholdDropdownValues;
import com.asymmetrix.grc.riskkri.entity.EnterpriseKiDD;
import com.asymmetrix.grc.riskkri.entity.KriBusinessLineOneDD;
import com.asymmetrix.grc.riskkri.entity.KriBusinessLineTwoDD;
import com.asymmetrix.grc.riskkri.entity.KriCasueCategoryDD;
import com.asymmetrix.grc.riskkri.entity.KriCountDataCollectFieldDD;
import com.asymmetrix.grc.riskkri.entity.KriDataCollectionDD;
import com.asymmetrix.grc.riskkri.entity.KriFormulaTypeDD;
import com.asymmetrix.grc.riskkri.entity.KriIdPreferenceDD;
import com.asymmetrix.grc.riskkri.entity.KriLocationDD;
import com.asymmetrix.grc.riskkri.entity.KriMetricsFinancialYearDD;
import com.asymmetrix.grc.riskkri.entity.KriReviewFrequencyDD;
import com.asymmetrix.grc.riskkri.entity.KriRiskCategoryDD;
import com.asymmetrix.grc.riskkri.entity.KriRiskEventTypeOneDD;
import com.asymmetrix.grc.riskkri.entity.KriRiskEventTypeTwoDD;
import com.asymmetrix.grc.riskkri.entity.KriThresholdCurrencyDD;
import com.asymmetrix.grc.riskkri.entity.KriThresholdMeasuringScaleDD;
import com.asymmetrix.grc.riskkri.entity.KriThresholdTypeDD;
import com.asymmetrix.grc.riskkri.entity.NatureOfKriDD;
import com.asymmetrix.grc.riskkri.entity.RiskIndicatorTypeDD;
import com.asymmetrix.grc.riskkri.service.DropDownValueService;

@RestController
public class KRIDropDownValuesController {

	@Autowired
	private DropDownValueService dropDwonValueService;

	private static final String READ_KRI_ACTION = "READ-KRI-LIBRARY-DD-DETAILS";
	private static final String READ_KRI_METRICS_ACTION = "READ-KRI-LIBRARY-METRICS-DD-DETAILS";
	private static final String READ_KRI_MAP_ACTION = "READ-KRI-LIBRARY-MAP-BUSINESSUNIT-DD-DETAILS";
	private static final String READ_KRI_OTHERDETAILS_ACTION = "READ-KRI-LIBRARY-OTHERDETAILS-DD-DETAILS";
	private static final String READ_KRI_FORMULA_ACTION = "READ-KRI-LIBRARY-FORMULA-DD-DETAILS";
	private static final String READ_KRI_THRESHOLD_ACTION = "READ-KRI-LIBRARY-THRESHOLD-DD-DETAILS";

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_KRI_ACTION)
	@GetMapping("/kri/dropdownvalues")
	public ResponseEntity<KRIResponse<DropDownValues>> getAllDropDownValues() {

		DropDownValues dropDwonValuesDto = new DropDownValues();

		List<NatureOfKriDD> kn = getAllKriNature();
		dropDwonValuesDto.setKriNature(kn);
	

		List<RiskIndicatorTypeDD> rit = getAllRiskIndicatorType();
		dropDwonValuesDto.setRiskIndicatorType(rit);

		List<EnterpriseKiDD> ek = getAllEnterpriseKi();
		dropDwonValuesDto.setEnterpriseKi(ek);
		
		List<KriIdPreferenceDD>  preferenceModule= getKriIdModule();
		dropDwonValuesDto.setIdPreferenceModule(preferenceModule);

		return KRIResponseEntity.success(dropDwonValuesDto);
	}

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_KRI_METRICS_ACTION)
	@GetMapping("/krimetricsupdate/dropdownvalues")
	public ResponseEntity<KRIResponse<KriMetricsupdateDropdownValues>> getKriMetricUpdateDropdown() {
		KriMetricsupdateDropdownValues dropDwonValues = new KriMetricsupdateDropdownValues();
		List<KriMetricsFinancialYearDD> metricsupdateDD = getKriMetricsFinancialYear();
		dropDwonValues.setMetricsupdateDropdownValues(metricsupdateDD);
		return KRIResponseEntity.success(dropDwonValues);
	}

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_KRI_OTHERDETAILS_ACTION)
	@GetMapping("/kriotherdetail/dropdownvalues")
	public ResponseEntity<KRIResponse<KriOtherdetailsDropdownValues>> getKriOtherdetailsDropdown() {
		KriOtherdetailsDropdownValues dropDwonValues = new KriOtherdetailsDropdownValues();
		List<KriReviewFrequencyDD> reviewFrequencyDD = getKriReviewFrequency();
		dropDwonValues.setOtherdetailsDropdownValues(reviewFrequencyDD);
		return KRIResponseEntity.success(dropDwonValues);
	}

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_KRI_FORMULA_ACTION)
	@GetMapping("/kriformula/dropdownvalues")
	public ResponseEntity<KRIResponse<KriFormulaDropdownValues>> getKriFormulaDropdown() {
		KriFormulaDropdownValues dropDwonValues = new KriFormulaDropdownValues();
		List<KriFormulaTypeDD> formulaDD = getKriFormulaType();
		dropDwonValues.setFormulaDropdownValuesdto(formulaDD);
		return KRIResponseEntity.success(dropDwonValues);
	}

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_KRI_THRESHOLD_ACTION)
	@GetMapping("/krithreshold/dropdownvalues")
	public ResponseEntity<KRIResponse<KriThresholdDropdownValues>> getKriThresholdDropDownValues() {

		KriThresholdDropdownValues dropDwonValuesDto = new KriThresholdDropdownValues();

		List<KriThresholdCurrencyDD> tc = getKriThresholdCurrency();
		dropDwonValuesDto.setKriThresholdCurrency(tc);

		List<KriThresholdTypeDD> tt = getKriThresholdType();
		dropDwonValuesDto.setKriThresholdType(tt);

		List<KriThresholdMeasuringScaleDD> tms = getKriThresholdMeasuringScale();
		dropDwonValuesDto.setKriThresholdMeasuringScale(tms);

		return KRIResponseEntity.success(dropDwonValuesDto);
	}

	@PreAuthorize("permitAll()")
	@Loggable(action = READ_KRI_MAP_ACTION)
	@GetMapping("/krimap/dropdownvalues")
	public ResponseEntity<KRIResponse<KriMapDropdownValues>> getKriMapAllDropDownValues() {

		KriMapDropdownValues kriMapDropDwonValues = new KriMapDropdownValues();

		List<KriBusinessLineOneDD> bLineOne = getKriBusinesslineOne();
		kriMapDropDwonValues.setBusinessLineOne(bLineOne);

		List<KriBusinessLineTwoDD> bLineTwo = getKriBusinesslineTwo();
		kriMapDropDwonValues.setBusinessLineTwo(bLineTwo);

		List<KriRiskEventTypeOneDD> rEventTypeOne = getKriRiskEventTypeOne();
		kriMapDropDwonValues.setRiskEventTypeOne(rEventTypeOne);

		List<KriRiskEventTypeTwoDD> rEventTypeTwo = getKriRiskEventTyprTwo();
		kriMapDropDwonValues.setRiskEventTypeTwo(rEventTypeTwo);

		List<KriRiskCategoryDD> rCategory = getKriRiskCategory();
		kriMapDropDwonValues.setRiskCategory(rCategory);

		List<KriCasueCategoryDD> causeCategory = getKriCauseCategory();
		kriMapDropDwonValues.setCauseCategory(causeCategory);

		List<KriLocationDD> kLocation = getKriLocation();
		kriMapDropDwonValues.setLocation(kLocation);

		List<KriDataCollectionDD> kDataCollection = getKriDataCollection();
		kriMapDropDwonValues.setDataCollection(kDataCollection);

		List<KriCountDataCollectFieldDD> kCountDataCollectField = getKriCountDataCollectField();
		kriMapDropDwonValues.setFieldCountForDataCollection(kCountDataCollectField);

		return KRIResponseEntity.success(kriMapDropDwonValues);

	}

	public List<KriMetricsFinancialYearDD> getKriMetricsFinancialYear() {
		return this.dropDwonValueService.getKriMetricsFinancialYear();
	}

	public List<KriReviewFrequencyDD> getKriReviewFrequency() {
		return this.dropDwonValueService.getKriReviewFrequency();
	}

	public List<KriFormulaTypeDD> getKriFormulaType() {
		return this.dropDwonValueService.getKriFormulaType();
	}

	public List<KriThresholdCurrencyDD> getKriThresholdCurrency() {
		return this.dropDwonValueService.getKriThresholdCurrency();
	}

	public List<KriThresholdTypeDD> getKriThresholdType() {
		return this.dropDwonValueService.getKriThresholdType();
	}

	public List<KriThresholdMeasuringScaleDD> getKriThresholdMeasuringScale() {
		return this.dropDwonValueService.getKriThresholdMeasuringScale();
	}

	public List<KriBusinessLineOneDD> getKriBusinesslineOne() {
		return this.dropDwonValueService.getKriBusinesslineOne();
	}

	public List<KriBusinessLineTwoDD> getKriBusinesslineTwo() {
		return this.dropDwonValueService.getKriBusinesslineTwo();
	}

	public List<KriRiskEventTypeOneDD> getKriRiskEventTypeOne() {
		return this.dropDwonValueService.getKriRiskEventTypeOne();
	}

	public List<KriRiskEventTypeTwoDD> getKriRiskEventTyprTwo() {
		return this.dropDwonValueService.getKriRiskEventTyprTwo();
	}

	public List<KriRiskCategoryDD> getKriRiskCategory() {
		return this.dropDwonValueService.getKriRiskCategory();
	}

	public List<KriCasueCategoryDD> getKriCauseCategory() {
		return this.dropDwonValueService.getKriCauseCategory();
	}

	public List<KriLocationDD> getKriLocation() {
		return this.dropDwonValueService.getKriLocation();
	}

	public List<KriDataCollectionDD> getKriDataCollection() {
		return this.dropDwonValueService.getKriDataCollection();
	}

	public List<KriCountDataCollectFieldDD> getKriCountDataCollectField() {
		return this.dropDwonValueService.getKriCountDataCollectField();
	}

	@GetMapping("/getKriNature")
	public List<NatureOfKriDD> getAllKriNature() {
		return this.dropDwonValueService.getAllNatureOfKri();
	}

	@PostMapping("/createKriNature")
	public NatureOfKriDD createKriNAture(@RequestBody NatureOfKriDD dropDownValue) {
		return this.dropDwonValueService.createNatureOfKri(dropDownValue);
	}

	@GetMapping("/getRiskIndicatorType")
	public List<RiskIndicatorTypeDD> getAllRiskIndicatorType() {
		return this.dropDwonValueService.getAllRiskIndicatorType();
	}

	@PostMapping("/createRiskIndicatorType")
	public RiskIndicatorTypeDD createRiskEventType(@RequestBody RiskIndicatorTypeDD dropDownValue) {
		return this.dropDwonValueService.createRiskIndicatorType(dropDownValue);
	}

	@GetMapping("/getEnterpriseKi")
	public List<EnterpriseKiDD> getAllEnterpriseKi() {
		return this.dropDwonValueService.getAllEnterpriseKi();
	}

	@PostMapping("/createEnterpriseKi")
	public EnterpriseKiDD createRiskType(@RequestBody EnterpriseKiDD dropDownValue) {
		return this.dropDwonValueService.createEnterpriseKi(dropDownValue);
	}
	
	public List<KriIdPreferenceDD> getKriIdModule() {
		return this.dropDwonValueService.getKriIdModule();
	}


}
