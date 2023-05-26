package com.asymmetrix.grc.riskkri.dto;

import java.util.List;

import com.asymmetrix.grc.riskkri.entity.KriMetricsFinancialYearDD;
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
public class KriMetricsupdateDropdownValues {

	private List<KriMetricsFinancialYearDD> metricsupdateDropdownValues;

	public List<KriMetricsFinancialYearDD> getMetricsupdateDropdownValues() {
		return metricsupdateDropdownValues;
	}

	public void setMetricsupdateDropdownValues(List<KriMetricsFinancialYearDD> metricsupdateDropdownValues) {
		this.metricsupdateDropdownValues = metricsupdateDropdownValues;
	}

}
