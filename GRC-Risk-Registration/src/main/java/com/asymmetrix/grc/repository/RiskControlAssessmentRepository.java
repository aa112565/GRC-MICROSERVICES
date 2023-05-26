package com.asymmetrix.grc.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskControlAssessment;


@Repository
public interface RiskControlAssessmentRepository extends JpaRepository<RiskControlAssessment, String> {
	public List<RiskControlAssessment> findByRiskRegIdAndRiskId(String riskRegId, long riskId);	
	public List<RiskControlAssessment> findByRiskRegIdAndRiskIdAndActive(String riskRegId, long riskId, String active);	
	public List<RiskControlAssessment> findByRiskIdAndActive(long riskId, String active);
	public List<RiskControlAssessment> findByActive(String active);
	
	@Transactional
	@Modifying
	@Query("Update RiskControlAssessment r set r.active = 'N' where r.riskRegId = :riskRegId  and r.riskId IN :riskId")
	public void setRiskControlAssessmentInActive(@Param("riskRegId") String riskRegId, @Param("riskId") List<Long> riskId);
	
	@Transactional
	@Modifying
	@Query("Update RiskControlAssessment r set r.active = 'N' where r.riskRegId = :riskRegId  and r.riskId IN :riskId and r.controlId = :controlId")
	public void setRiskControlAssessmentInActive(@Param("riskRegId") String riskRegId, @Param("riskId") long riskId, @Param("controlId") long controlId);
	
}
