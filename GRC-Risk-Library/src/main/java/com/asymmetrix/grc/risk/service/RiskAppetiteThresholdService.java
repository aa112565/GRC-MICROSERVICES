package com.asymmetrix.grc.risk.service;

import java.util.List;

import com.asymmetrix.grc.risk.dto.RiskAppetiteThresholdDTO;
import com.asymmetrix.grc.risk.entity.RiskAppetiteThreshold;

public interface RiskAppetiteThresholdService {

	List<RiskAppetiteThreshold> getAllRiskAppetiteThreshold();

	RiskAppetiteThreshold getRiskAppetiteThresholdByAppetiteID(long appetiteId);

	RiskAppetiteThreshold getRiskAppetiteThresholdById(String thresholdId);

	RiskAppetiteThreshold createRiskAppetiteThreshold(RiskAppetiteThresholdDTO appetiteThresholdDto);

	RiskAppetiteThreshold updateRiskAppetiteThreshold(RiskAppetiteThresholdDTO appetiteThresholdDto);

	RiskAppetiteThreshold deleteRiskAppetiteThreshold(RiskAppetiteThresholdDTO appetiteThresholdDto);

}
