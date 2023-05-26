/**
 * 
 */
package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.asymmetrix.grc.riskkri.dao.EnterpriceKiRepository;
import com.asymmetrix.grc.riskkri.dao.KriBusinessLineOneRepo;
import com.asymmetrix.grc.riskkri.dao.KriBusinessLineTwoRepo;
import com.asymmetrix.grc.riskkri.dao.KriCasueCategoryRepo;
import com.asymmetrix.grc.riskkri.dao.KriCountDataCollectFieldRepo;
import com.asymmetrix.grc.riskkri.dao.KriDataCollectionRepo;
import com.asymmetrix.grc.riskkri.dao.KriFormulaTypeRepoDD;
import com.asymmetrix.grc.riskkri.dao.KriIdModuleRepo;
import com.asymmetrix.grc.riskkri.dao.KriLocationRepo;
import com.asymmetrix.grc.riskkri.dao.KriMetricsFinancialYearRepoDD;
import com.asymmetrix.grc.riskkri.dao.KriReviewFrequencyRepoDD;
import com.asymmetrix.grc.riskkri.dao.KriRiskCategoryRepo;
import com.asymmetrix.grc.riskkri.dao.KriRiskEventTypeOneRepo;
import com.asymmetrix.grc.riskkri.dao.KriRiskEventTypeTwoRepo;
import com.asymmetrix.grc.riskkri.dao.KriThresholdCurrencyRepoDD;
import com.asymmetrix.grc.riskkri.dao.KriThresholdMeasuringScaleRepoDD;
import com.asymmetrix.grc.riskkri.dao.KriThresholdTypeRepoDD;
import com.asymmetrix.grc.riskkri.dao.NatureOfKriRepository;
import com.asymmetrix.grc.riskkri.dao.RiskIndicatorTypeRepository;
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

@Service
public class DropDownValueService {

	@Autowired
	private EnterpriceKiRepository enterpriseKiRepo;

	@Autowired
	private RiskIndicatorTypeRepository riskIndicatorTypeRepo;

	@Autowired
	private NatureOfKriRepository kriNatureRepo;

	@Autowired
	private KriBusinessLineOneRepo businessLineOneRepo;

	@Autowired
	private KriBusinessLineTwoRepo businessLineTwoRepo;

	@Autowired
	private KriRiskEventTypeOneRepo riskEventTypeOneRepo;

	@Autowired
	private KriRiskEventTypeTwoRepo riskEventTypeTwoRepo;

	@Autowired
	private KriRiskCategoryRepo riskCategoryRepo;

	@Autowired
	private KriCasueCategoryRepo causeCategoryRepo;

	@Autowired
	private KriLocationRepo locationRepo;

	@Autowired
	private KriDataCollectionRepo dataCollectionRepo;

	@Autowired
	private KriCountDataCollectFieldRepo countDataCollectionFieldRepo;

	@Autowired
	private KriThresholdCurrencyRepoDD currencyRepo;

	@Autowired
	private KriThresholdTypeRepoDD thresholdRepo;

	@Autowired
	private KriThresholdMeasuringScaleRepoDD measuringScaleRepo;

	@Autowired
	private KriFormulaTypeRepoDD formulaTypeRepo;

	@Autowired
	private KriReviewFrequencyRepoDD reviewFrequencyRepo;

	@Autowired
	private KriMetricsFinancialYearRepoDD financialYearRepo;
	
	@Autowired
	private KriIdModuleRepo kriIdModuleRepo;

	public List<KriMetricsFinancialYearDD> getKriMetricsFinancialYear() {
		// return this.financialYearRepo.findAll();
		return this.financialYearRepo.findAllFinancialYear();
	}

	public List<KriReviewFrequencyDD> getKriReviewFrequency() {
		return this.reviewFrequencyRepo.findAllByOrder();
	}

	public List<KriFormulaTypeDD> getKriFormulaType() {
		return this.formulaTypeRepo.findAllByOrder();
	}

	public List<KriThresholdCurrencyDD> getKriThresholdCurrency() {
		return this.currencyRepo.findAllByOrder();
	}

	public List<KriThresholdTypeDD> getKriThresholdType() {
		return this.thresholdRepo.findAllByOrder();
	}

	public List<KriThresholdMeasuringScaleDD> getKriThresholdMeasuringScale() {
		return this.measuringScaleRepo.findAllByOrder();
	}

	public List<KriBusinessLineOneDD> getKriBusinesslineOne() {
		return this.businessLineOneRepo.findAllByOrder();
	}

	public List<KriBusinessLineTwoDD> getKriBusinesslineTwo() {
		return this.businessLineTwoRepo.findAllByOrder();
	}

	public List<KriRiskEventTypeOneDD> getKriRiskEventTypeOne() {
		return this.riskEventTypeOneRepo.findAllByOrder();
	}

	public List<KriRiskEventTypeTwoDD> getKriRiskEventTyprTwo() {
		return this.riskEventTypeTwoRepo.findAllByOrder();
	}

	public List<KriRiskCategoryDD> getKriRiskCategory() {
		return this.riskCategoryRepo.findAllByOrder();
	}

	public List<KriCasueCategoryDD> getKriCauseCategory() {
		return this.causeCategoryRepo.findAllByOrder();
	}

	public List<KriLocationDD> getKriLocation() {
		return this.locationRepo.findAllByOrder();
	}

	public List<KriDataCollectionDD> getKriDataCollection() {
		return this.dataCollectionRepo.findAllByOrder();
	}

	public List<KriCountDataCollectFieldDD> getKriCountDataCollectField() {
		return this.countDataCollectionFieldRepo.findAllByOrder();
	}

	public List<NatureOfKriDD> getAllNatureOfKri() {
		return this.kriNatureRepo.findAllByOrder();
	}

	public List<RiskIndicatorTypeDD> getAllRiskIndicatorType() {
		return this.riskIndicatorTypeRepo.findAllByOrder();
	}

	public List<EnterpriseKiDD> getAllEnterpriseKi() {
		return this.enterpriseKiRepo.findAllByOrder();
	}
	
	
	
	

	public NatureOfKriDD createNatureOfKri(NatureOfKriDD dropDownValue) {

		return this.kriNatureRepo.save(dropDownValue);
	}

	public RiskIndicatorTypeDD createRiskIndicatorType(RiskIndicatorTypeDD dropDownValue) {

		return this.riskIndicatorTypeRepo.save(dropDownValue);
	}

	public EnterpriseKiDD createEnterpriseKi(EnterpriseKiDD dropDownValue) {

		return this.enterpriseKiRepo.save(dropDownValue);
	}
	
	public List<KriIdPreferenceDD> getKriIdModule() {
		return this.kriIdModuleRepo.findAll();
	}
}
