package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskControlMapping;

@Repository
public interface RiskControlMappingRepository extends JpaRepository<RiskControlMapping, String> {

	@Query("SELECT controlId FROM  RiskControlMapping WHERE riskRegId = :riskRegId AND riskId = :riskId AND isActive = 'Y' ")
	List<Long> findActiveControlIds(@Param("riskRegId") String riskRegId, @Param("riskId") long riskId);

	@Transactional
	@Modifying
	@Query("Update RiskControlMapping riskControlMap SET riskControlMap.isActive = 'F' where riskControlMap.riskRegId = :riskRegId  and riskControlMap.riskId IN :riskId")
	public void setRiskControlAsInActiveById(@Param("riskRegId") String riskRegId, @Param("riskId") List<Long> riskId);
	
}
