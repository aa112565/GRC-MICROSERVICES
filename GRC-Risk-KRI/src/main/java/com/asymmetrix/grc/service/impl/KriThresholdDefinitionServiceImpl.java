package com.asymmetrix.grc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dao.KriThresholdDefinitionRepo;
import com.asymmetrix.grc.riskkri.dto.KriThresholdDefinitionDTO;
import com.asymmetrix.grc.riskkri.entity.KriThresholdDefinition;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KriThresholdDefinitionService;

@Service
public class KriThresholdDefinitionServiceImpl implements KriThresholdDefinitionService{

	@Autowired
	private KriThresholdDefinitionRepo thresholdDefRepo;

	@Override
	public List<KriThresholdDefinition> getKriThresholdDefiniton() {
		return this.thresholdDefRepo.findAll();
	}

	@Override
	public KriThresholdDefinition getKriThresholdDefById(long thresholdId) {
		return thresholdDefRepo.findById(thresholdId).orElseThrow(
				() -> new ResourceNotFoundException("Kri-Threshold Definition not found with  Id----> " + thresholdId));
	}

	@Override
	public KriThresholdDefinition getKriThresholdDefByKriId(String kriId) {
		return thresholdDefRepo.findByKriId(kriId);
	}

	@Override
	public KriThresholdDefinition createKriThresholdDefiniton(KriThresholdDefinitionDTO kriThresholdDto) {
		KriThresholdDefinition kriThreshold = MapperUtils.mapToTargetClass(kriThresholdDto,
				KriThresholdDefinition.class);
		kriThreshold.setDeleteFlag("N");
		kriThreshold.setActiveFlag("Y");
		return thresholdDefRepo.save(kriThreshold);
	}

	@Override
	public KriThresholdDefinition updateKriThresholdDefiniton(String kriId, KriThresholdDefinitionDTO kriThresholdDto) {
		@SuppressWarnings("unused")
		KriThresholdDefinition kriThreshold = deleteUpdate(getKriThresholdDefByKriId(kriId));
		return createKriThresholdDefiniton(kriThresholdDto);
	}

	
	public KriThresholdDefinition deleteUpdate(KriThresholdDefinition kriThreshold) {
		KriThresholdDefinition existingkriThreshold = getKriThresholdDefById(kriThreshold.getThresholdDefId());
		existingkriThreshold.setActiveFlag("N");
		existingkriThreshold.setDeleteFlag("D");
		return this.thresholdDefRepo.save(existingkriThreshold);
	}

	@Override
	public KriThresholdDefinition deleteKriThresholdDefiniton(KriThresholdDefinitionDTO kriThresholdDto) {
		KriThresholdDefinition kriThreshold = MapperUtils.mapToTargetClass(kriThresholdDto,
				KriThresholdDefinition.class);
		kriThreshold.setDeleteFlag("D");
		kriThreshold.setActiveFlag("N");
		return this.thresholdDefRepo.save(kriThreshold);
	}

}
