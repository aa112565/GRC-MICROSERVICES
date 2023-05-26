package com.asymmetrix.grc.riskkri.dto;

import java.util.List;

import com.asymmetrix.grc.riskkri.entity.KriThresholdCurrencyDD;
import com.asymmetrix.grc.riskkri.entity.KriThresholdMeasuringScaleDD;
import com.asymmetrix.grc.riskkri.entity.KriThresholdTypeDD;
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
public class KriThresholdDropdownValues {

	private List<KriThresholdCurrencyDD> kriThresholdCurrency;

	private List<KriThresholdTypeDD> kriThresholdType;

	private List<KriThresholdMeasuringScaleDD> kriThresholdMeasuringScale;

	public List<KriThresholdCurrencyDD> getKriThresholdCurrency() {
		return kriThresholdCurrency;
	}

	public void setKriThresholdCurrency(List<KriThresholdCurrencyDD> kriThresholdCurrency) {
		this.kriThresholdCurrency = kriThresholdCurrency;
	}

	public List<KriThresholdTypeDD> getKriThresholdType() {
		return kriThresholdType;
	}

	public void setKriThresholdType(List<KriThresholdTypeDD> kriThresholdType) {
		this.kriThresholdType = kriThresholdType;
	}

	public List<KriThresholdMeasuringScaleDD> getKriThresholdMeasuringScale() {
		return kriThresholdMeasuringScale;
	}

	public void setKriThresholdMeasuringScale(List<KriThresholdMeasuringScaleDD> kriThresholdMeasuringScale) {
		this.kriThresholdMeasuringScale = kriThresholdMeasuringScale;
	}

}
