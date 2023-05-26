package com.asymmetrix.grc.riskkri.dto;

import java.util.List;

import com.asymmetrix.grc.riskkri.entity.KriBusinessLineOneDD;
import com.asymmetrix.grc.riskkri.entity.KriBusinessLineTwoDD;
import com.asymmetrix.grc.riskkri.entity.KriCasueCategoryDD;
import com.asymmetrix.grc.riskkri.entity.KriCountDataCollectFieldDD;
import com.asymmetrix.grc.riskkri.entity.KriDataCollectionDD;
import com.asymmetrix.grc.riskkri.entity.KriLocationDD;
import com.asymmetrix.grc.riskkri.entity.KriRiskCategoryDD;
import com.asymmetrix.grc.riskkri.entity.KriRiskEventTypeOneDD;
import com.asymmetrix.grc.riskkri.entity.KriRiskEventTypeTwoDD;
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
public class KriMapDropdownValues {

	private List<KriBusinessLineOneDD> businessLineOne;

	private List<KriBusinessLineTwoDD> businessLineTwo;

	private List<KriRiskEventTypeOneDD> riskEventTypeOne;

	private List<KriRiskEventTypeTwoDD> riskEventTypeTwo;

	private List<KriRiskCategoryDD> riskCategory;

	private List<KriCasueCategoryDD> causeCategory;

	private List<KriLocationDD> location;

	private List<KriDataCollectionDD> dataCollection;

	private List<KriCountDataCollectFieldDD> fieldCountForDataCollection;

	public List<KriBusinessLineOneDD> getBusinessLineOne() {
		return businessLineOne;
	}

	public void setBusinessLineOne(List<KriBusinessLineOneDD> businessLineOne) {
		this.businessLineOne = businessLineOne;
	}

	public List<KriBusinessLineTwoDD> getBusinessLineTwo() {
		return businessLineTwo;
	}

	public void setBusinessLineTwo(List<KriBusinessLineTwoDD> businessLineTwo) {
		this.businessLineTwo = businessLineTwo;
	}

	public List<KriRiskEventTypeOneDD> getRiskEventTypeOne() {
		return riskEventTypeOne;
	}

	public void setRiskEventTypeOne(List<KriRiskEventTypeOneDD> riskEventTypeOne) {
		this.riskEventTypeOne = riskEventTypeOne;
	}

	public List<KriRiskEventTypeTwoDD> getRiskEventTypeTwo() {
		return riskEventTypeTwo;
	}

	public void setRiskEventTypeTwo(List<KriRiskEventTypeTwoDD> riskEventTypeTwo) {
		this.riskEventTypeTwo = riskEventTypeTwo;
	}

	public List<KriRiskCategoryDD> getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(List<KriRiskCategoryDD> riskCategory) {
		this.riskCategory = riskCategory;
	}

	public List<KriCasueCategoryDD> getCauseCategory() {
		return causeCategory;
	}

	public void setCauseCategory(List<KriCasueCategoryDD> causeCategory) {
		this.causeCategory = causeCategory;
	}

	public List<KriLocationDD> getLocation() {
		return location;
	}

	public void setLocation(List<KriLocationDD> location) {
		this.location = location;
	}

	public List<KriDataCollectionDD> getDataCollection() {
		return dataCollection;
	}

	public void setDataCollection(List<KriDataCollectionDD> dataCollection) {
		this.dataCollection = dataCollection;
	}

	public List<KriCountDataCollectFieldDD> getFieldCountForDataCollection() {
		return fieldCountForDataCollection;
	}

	public void setFieldCountForDataCollection(List<KriCountDataCollectFieldDD> fieldCountForDataCollection) {
		this.fieldCountForDataCollection = fieldCountForDataCollection;
	}

}
