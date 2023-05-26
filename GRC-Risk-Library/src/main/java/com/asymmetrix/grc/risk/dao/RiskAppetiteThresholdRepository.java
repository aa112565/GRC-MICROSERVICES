package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.RiskAppetiteThreshold;

@Repository
public interface RiskAppetiteThresholdRepository extends JpaRepository<RiskAppetiteThreshold, String> {

	@Query("SELECT COUNT(*) FROM  RiskAppetiteThreshold WHERE appetiteId = :appetiteId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findByConut(@Param("appetiteId") long appetiteId);

	@Query("FROM  RiskAppetiteThreshold WHERE appetiteId = :appetiteId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	RiskAppetiteThreshold findByAppetiteId(@Param("appetiteId") long appetiteId);

	@Query("FROM RiskAppetiteThreshold WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY modifiedDate DESC ")
	List<RiskAppetiteThreshold> findAllThreshold();
}
