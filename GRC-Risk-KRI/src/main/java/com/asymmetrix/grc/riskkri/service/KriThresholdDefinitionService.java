package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KriThresholdDefinitionDTO;
import com.asymmetrix.grc.riskkri.entity.KriThresholdDefinition;

public interface KriThresholdDefinitionService {
	
	List<KriThresholdDefinition> getKriThresholdDefiniton();
	KriThresholdDefinition getKriThresholdDefById(long thresholdId);
	KriThresholdDefinition getKriThresholdDefByKriId(String kriId);
	KriThresholdDefinition createKriThresholdDefiniton(KriThresholdDefinitionDTO kriThresholdDto);
	KriThresholdDefinition updateKriThresholdDefiniton(String kriId, KriThresholdDefinitionDTO kriThresholdDto);
	KriThresholdDefinition deleteKriThresholdDefiniton(KriThresholdDefinitionDTO kriThresholdDto);

}
