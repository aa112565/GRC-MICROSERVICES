package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.entity.RiskTreatment;

@Repository
public interface RiskTreatmentRepository extends JpaRepository<RiskTreatment, Long>{	
	
	public List<RiskTreatment> findByRiskRegIDAndRiskIDAndActive(String riskRegID, String riskID, String activeFlag);	
	
	@Transactional
	@Modifying
	@Query("update RiskTreatment r set r.active = 'N' where r.riskRegID = :riskRegID and r.riskID = :riskID")
	public void updateRiskTreatmentsToInactive(@Param("riskRegID") String riskRegID, @Param("riskID") String riskID); 
	
	@Transactional
	@Modifying
	@Query("update RiskTreatment r set r.active = 'Y' where r.riskRegID = :riskRegID and r.riskID = :riskID")
	public void updateRiskTreatmentsToActive(@Param("riskRegID") String riskRegID, @Param("riskID") String riskID); 
	
	public List<RiskTreatment> findTop2ByRiskRegIDAndRiskIDOrderByRiskTreatmentIDDesc(String riskRegID, String riskId);
}
