package com.asymmetrix.grc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.RiskApprovalLevel;

@Repository
public interface RiskApprovalLevelRepo extends JpaRepository<RiskApprovalLevel, String> {	

	
	RiskApprovalLevel findByRiskRegIdAndRiskId(String riskRegId, String riskId);
	
	@Query("SELECT COUNT(*) FROM  RiskApprovalLevel  WHERE activeFlag = 'Y' AND riskRegId = :riskRegId AND riskId = :riskId ")
	long countByRiskRegIdAndRiskId(@Param("riskRegId") String riskRegId, @Param("riskId") String riskId);
	
	
	@Transactional
	@Modifying
	@Query("update RiskApprovalLevel r set r.status = :status, r.levelOneStatus = :levelOneStatus where r.riskRegId = :riskRegId and r.riskId = :riskId")
	public Integer updateRiskApprovalLevelOneStatus(@Param("levelOneStatus") String levelOneStatus, @Param("status") String status, @Param("riskRegId") String riskRegId, @Param("riskId") String riskId);
	
	@Transactional
	@Modifying
	@Query("update RiskApprovalLevel r set r.status = :status, r.levelTwoStatus = :levelTwoStatus where r.riskRegId = :riskRegId and r.riskId = :riskId")
	public Integer updateRiskApprovalLevelTwoStatus(@Param("levelTwoStatus") String levelTwoStatus, @Param("status") String status, @Param("riskRegId") String riskRegId, @Param("riskId") String riskId);
	
	@Transactional
	@Modifying
	@Query("update RiskApprovalLevel r set r.status = :status, r.levelThreeStatus = :levelThreeStatus where r.riskRegId = :riskRegId and r.riskId = :riskId")
	public Integer updateRiskApprovalLevelThreeStatus(@Param("levelThreeStatus") String levelThreeStatus, @Param("status") String status, @Param("riskRegId") String riskRegId, @Param("riskId") String riskId);
	
}
