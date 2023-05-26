package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriRiskRegistryRiskMapping;

@Repository
public interface KriRiskRegistryRiskMappingRepo extends JpaRepository<KriRiskRegistryRiskMapping, Long> {

	@Query("FROM  KriRiskRegistryRiskMapping WHERE kriId = :kriId AND deleteFlag = 'N'  AND activeFlag = 'Y' ")
	List<KriRiskRegistryRiskMapping> findByKriId(@Param("kriId") String kriId);
}
