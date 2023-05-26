package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.RiskRegisterDTO;
import com.asymmetrix.grc.entity.RiskRegisterMapping;

@Repository
public interface RiskRegisterMappingRepository extends JpaRepository<RiskRegisterMapping, String> {

	@Query("SELECT riskId FROM  RiskRegisterMapping WHERE riskRegId = :riskRegId AND isActive = 'Y' ")
	List<Long> findActiveRiskIds(@Param("riskRegId") String riskRegId);
	
	@Query("FROM  RiskRegisterMapping WHERE riskRegId = :riskRegId AND isActive = 'Y' ")
	List<RiskRegisterMapping> findAllActiveRiskIds(@Param("riskRegId") String riskRegId);
	
	@Query("FROM  RiskRegisterMapping WHERE isActive = 'Y' ORDER BY createdDate DESC")
	List<RiskRegisterMapping> findAllActiveRiskAndRegiserIds();	
	
	
	@Query("SELECT new com.asymmetrix.grc.dto.RiskRegisterDTO(rm.riskRegId, rr.wsId, rr.deptId, rm.riskId, rm.ownerName) FROM  RiskRegisterMapping rm, RiskRegister rr WHERE rm.isActive = 'Y' AND rm.riskRegId = rr.riskRegId ORDER BY rm.createdDate DESC")
	List<RiskRegisterDTO> findAllActiveRiskAndRegiserIdsDto();
	
	@Query("SELECT COUNT(riskId) FROM  RiskRegisterMapping WHERE riskRegId = :riskRegId AND isActive = 'Y' ")
	int findActiveRiskIdsConut(@Param("riskRegId") String riskRegId);

	@Transactional
	@Modifying
	@Query("Update RiskRegisterMapping riskRegMap SET riskRegMap.isActive = 'F' where riskRegMap.riskRegId = :riskRegId ")
	public void setRiskAsInActiveByRiskRegId(@Param("riskRegId") String riskRegId);
	
	@Query("SELECT COUNT(*) FROM  RiskRegisterMapping  WHERE isActive = 'Y' ")
	long countByActive();

}
