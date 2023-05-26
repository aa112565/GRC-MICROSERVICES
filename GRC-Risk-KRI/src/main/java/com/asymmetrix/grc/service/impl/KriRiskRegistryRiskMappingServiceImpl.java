package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dao.KriRiskRegistryRiskMappingRepo;
import com.asymmetrix.grc.riskkri.dto.KriRiskRegistryRiskMappingDTO;
import com.asymmetrix.grc.riskkri.entity.KriRiskRegistryRiskMapping;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KriRiskRegistryRiskMappingService;

@Service
public class KriRiskRegistryRiskMappingServiceImpl implements KriRiskRegistryRiskMappingService {

	@Autowired
	private KriRiskRegistryRiskMappingRepo kriRegistryMapRepo;

	@Override
	public List<KriRiskRegistryRiskMapping> getKriRiskRegistryRiskMappingList() {
		return this.kriRegistryMapRepo.findAll();
	}

	@Override
	public KriRiskRegistryRiskMapping getKriRiskRegistryRiskMappingById(long kriRiskMapId) {
		return kriRegistryMapRepo.findById(kriRiskMapId).orElseThrow(
				() -> new ResourceNotFoundException("Kri-Risk-Registry not found with  Id----> " + kriRiskMapId));
	}

	@Override
	public List<KriRiskRegistryRiskMapping> getKriRiskRegistryRiskMappingByKriId(String kriId) {
		return kriRegistryMapRepo.findByKriId(kriId);
	}

	@Override
	public List<KriRiskRegistryRiskMapping> createKriRiskRegistryRiskMapping(
			List<KriRiskRegistryRiskMappingDTO> kriRiskRegistryMapDto, String createUser) {
		List<KriRiskRegistryRiskMapping> riskregistrymapping = new ArrayList<>();
		for (KriRiskRegistryRiskMappingDTO riskregistrymap : kriRiskRegistryMapDto) {
			KriRiskRegistryRiskMapping kriRiskRegistryMap = MapperUtils.mapToTargetClass(riskregistrymap,
					KriRiskRegistryRiskMapping.class);
			kriRiskRegistryMap.setActiveFlag("Y");
			kriRiskRegistryMap.setDeleteFlag("N");
			kriRiskRegistryMap.setCreatedBy(createUser);
			riskregistrymapping.add(kriRegistryMapRepo.save(kriRiskRegistryMap));
		}
		return riskregistrymapping;
	}

	@Transactional
	@Modifying
	@Override
	public List<KriRiskRegistryRiskMapping> updateKriRiskRegistryRiskMapping(String kriId,
			List<KriRiskRegistryRiskMappingDTO> newkriRiskRegistryMapDto, String updateUser) {
	//	System.out.println("======================updateKriRiskRegistryRiskMapping=====================" + kriId);

		// List<KriRiskRegistryRiskMapping> existingriskregistrymapping =
		// getKriRiskRegistryRiskMappingByKriId(kriId);
		/*
		 * List<KriRiskRegistryRiskMappingDTO> KriRiskRegistryMappingList = new
		 * ArrayList<>(); for(KriRiskRegistryRiskMapping KriRiskRegistryRiskMap :
		 * existingriskregistrymapping ) {
		 * KriRiskRegistryMappingList.add(MapperUtils.mapToTargetClass(
		 * KriRiskRegistryRiskMap, KriRiskRegistryRiskMappingDTO.class)); }
		 */
		@SuppressWarnings("unused")
		List<KriRiskRegistryRiskMapping> deleteriskmap = deleteUpdate(getKriRiskRegistryRiskMappingByKriId(kriId),
				updateUser);
		return createKriRiskRegistryRiskMapping(newkriRiskRegistryMapDto, updateUser);
	}

//  Kri-Risk-Registry-Map - Soft Delete
	public List<KriRiskRegistryRiskMapping> deleteUpdate(List<KriRiskRegistryRiskMapping> updatekriRiskRegistryMap,
			String updateUser) {

		List<KriRiskRegistryRiskMapping> riskregistrymapping = new ArrayList<>();
		for (KriRiskRegistryRiskMapping riskregistrymap : updatekriRiskRegistryMap) {

			riskregistrymap.setActiveFlag("N");
			riskregistrymap.setDeleteFlag("D");
			riskregistrymap.setModifiedBy(updateUser);
			riskregistrymapping.add(kriRegistryMapRepo.save(riskregistrymap));
		}
		return riskregistrymapping;
	}

	@Override
	public List<KriRiskRegistryRiskMapping> deleteKriRiskRegistryRiskMapping(
			List<KriRiskRegistryRiskMappingDTO> removekriRiskRegistryMapDto, String updateUser) {
		List<KriRiskRegistryRiskMapping> KriRiskRegistryMappingList = new ArrayList<>();
		for (KriRiskRegistryRiskMappingDTO KriRiskRegistryRiskMap : removekriRiskRegistryMapDto) {
			KriRiskRegistryMappingList
					.add(MapperUtils.mapToTargetClass(KriRiskRegistryRiskMap, KriRiskRegistryRiskMapping.class));
		}
		List<KriRiskRegistryRiskMapping> deleteriskmap = this.deleteUpdate(KriRiskRegistryMappingList, updateUser);
		return deleteriskmap;
	}

}
