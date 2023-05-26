package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KriRiskRegistryRiskMappingDTO;
import com.asymmetrix.grc.riskkri.entity.KriRiskRegistryRiskMapping;

public interface KriRiskRegistryRiskMappingService {
	
	List<KriRiskRegistryRiskMapping> getKriRiskRegistryRiskMappingList();
	KriRiskRegistryRiskMapping getKriRiskRegistryRiskMappingById(long kriRiskMapId);
	List<KriRiskRegistryRiskMapping> getKriRiskRegistryRiskMappingByKriId(String kriId);
	List<KriRiskRegistryRiskMapping> createKriRiskRegistryRiskMapping(
			List<KriRiskRegistryRiskMappingDTO> kriRiskRegistryMapDto, String createUser);
	List<KriRiskRegistryRiskMapping> updateKriRiskRegistryRiskMapping(String kriId,
			List<KriRiskRegistryRiskMappingDTO> newkriRiskRegistryMapDto, String updateUser);
	List<KriRiskRegistryRiskMapping> deleteKriRiskRegistryRiskMapping(
			List<KriRiskRegistryRiskMappingDTO> removekriRiskRegistryMapDto, String updateUser);

}
