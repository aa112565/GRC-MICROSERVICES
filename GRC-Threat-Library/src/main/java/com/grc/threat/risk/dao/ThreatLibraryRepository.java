package com.grc.threat.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.threat.risk.entity.ThreatLibrary;

@Repository
public interface ThreatLibraryRepository extends JpaRepository<ThreatLibrary, Long> {

	@Query("SELECT COUNT(*) FROM  ThreatLibrary WHERE threatId = :threatId ")
	int findByConut(@Param("threatId") long threatId);

	@Query("FROM  ThreatLibrary WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<ThreatLibrary> findAllThreat();

	ThreatLibrary findFirstByOrderByCreatedDateDescThreatIdDesc();

}
