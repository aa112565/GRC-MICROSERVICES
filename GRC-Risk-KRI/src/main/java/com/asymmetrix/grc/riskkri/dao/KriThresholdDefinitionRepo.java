package com.asymmetrix.grc.riskkri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriThresholdDefinition;

@Repository
public interface KriThresholdDefinitionRepo extends JpaRepository<KriThresholdDefinition, Long> {

	@Query("FROM  KriThresholdDefinition WHERE kriId = :kriId AND deleteFlag = 'N'  AND activeFlag = 'Y' ")
	KriThresholdDefinition findByKriId(String kriId);

}
