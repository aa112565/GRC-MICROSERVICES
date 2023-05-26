package com.asymmetrix.grc.risk.service;

import java.util.List;

import com.asymmetrix.grc.risk.dto.RiskAppetiteDTO;
import com.asymmetrix.grc.risk.entity.RiskAppetite;

public interface RiskAppetiteService {

	List<RiskAppetite> getAllAppetite();

	RiskAppetite getAppetiteById(long appetiteId);

	RiskAppetite createRiskAppetite(RiskAppetiteDTO riskAppetitedto);

	RiskAppetite updateRiskAppetite(RiskAppetiteDTO riskAppetitedto);

	RiskAppetite deleteRiskAppetite(RiskAppetiteDTO riskAppetitedto);

}
