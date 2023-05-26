package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.RiskLibrary;


@Repository
public interface RiskLibraryRepository extends JpaRepository<RiskLibrary, Long> {

	@Query("SELECT COUNT(*) FROM  RiskLibrary WHERE riskId = :riskId ")
	int findByConut(@Param("riskId") long riskId);

	@Query("FROM  RiskLibrary WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<RiskLibrary> findAllRisk();
	
	RiskLibrary findFirstByOrderByCreatedDateDescRiskIdDesc();
}
