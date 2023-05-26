package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.entity.RiskScoring;


@Repository
public interface RiskScoringRepository extends JpaRepository<RiskScoring, Long> {

	RiskScoring findByRiskRegIdAndRiskIdAndActive(String riskRegId, Long riskId, String active);
	
	@Query("FROM  RiskScoring WHERE active = 'Y' ")
	List<RiskScoring> findAllByBranchName( );
	
	
	@Query("SELECT COUNT(*) FROM  RiskScoring  WHERE active = 'Y' AND riskRegId = :riskRegId AND riskId = :riskId ")
	long countByRiskRegIdAndRiskId(@Param("riskRegId") String riskRegId, @Param("riskId") Long riskId);
	

	@Query("FROM  RiskScoring  WHERE active = 'Y' AND inherentImpactRating = :impact AND inherentLikelihoodRating = :likelihood ")
	List<RiskScoring> getInherentImpactRatingList(@Param("impact") String impact, @Param("likelihood") String likelihood);
	

	@Query("FROM  RiskScoring  WHERE active = 'Y' AND residualImpactRating = :impact AND residualLikelihoodRating = :likelihood ")
	List<RiskScoring> getResidualImpactRatingList(@Param("impact") String impact, @Param("likelihood") String likelihood);
	
	@Query("SELECT COUNT(*) FROM  RiskScoring  WHERE  active = 'Y' AND inherentImpactRating = :impact AND inherentLikelihoodRating = :likelihood ")
	Long getInherentImpactRatingCount(@Param("impact") String impact, @Param("likelihood") String likelihood);
	
	@Query("SELECT COUNT(*) FROM  RiskScoring  WHERE active = 'Y' AND residualImpactRating = :impact AND residualLikelihoodRating = :likelihood ")
	Long getResidualImpactRatingCount(@Param("impact") String impact, @Param("likelihood") String likelihood);

	
/*	
	@Query(value= "SELECT * FROM  RR_RISK_SCORING  WHERE V_INHERENT_IMPACT_RATING = :impact AND V_INHERENT_LIKELIHOOD_RATING = :likelihood ", nativeQuery = true)
	List<RiskScoring> getInherentImpactRatingList(@Param("impact") String impact, @Param("likelihood") String likelihood);
	

	@Query(value= "SELECT * FROM  RR_RISK_SCORING  WHERE V_RESIDUAL_IMPACT_RATING = :impact AND V_RESIDUAL_LIKELIHOOD_RATING = :likelihood ", nativeQuery = true)
	List<RiskScoring> getResidualImpactRatingList(@Param("impact") String impact, @Param("likelihood") String likelihood);
	
	@Query(value= "SELECT COUNT(*) FROM  RR_RISK_SCORING  WHERE V_INHERENT_IMPACT_RATING = :impact AND V_INHERENT_LIKELIHOOD_RATING = :likelihood ", nativeQuery = true)
	Long getInherentImpactRatingCount(@Param("impact") String impact, @Param("likelihood") String likelihood);
	
	@Query(value= "SELECT COUNT(*) FROM  RR_RISK_SCORING  WHERE V_RESIDUAL_IMPACT_RATING = :impact AND V_RESIDUAL_LIKELIHOOD_RATING = :likelihood ", nativeQuery = true)
	Long getResidualImpactRatingCount(@Param("impact") String impact, @Param("likelihood") String likelihood);
	*/
	
	@Transactional
	@Modifying
	@Query("update RiskScoring r set r.active = 'N' where r.riskRegId = :riskRegId and r.riskId = :riskId")
	Integer updateRiskScoringToInactive(String riskRegId, Long riskId);
	
	@Transactional
	@Modifying
	@Query("update RiskScoring r set r.active = 'Y' where r.riskRegId = :riskRegId and r.riskId = :riskId")
	Integer updateRiskScoringToActive(String riskRegId, Long riskId);
	
	@Transactional
	@Modifying
	@Query("update RiskScoring r set r.approvalInitStatus = :approvalInitStatus, r.approvalFlag = 'Y' where r.riskRegId = :riskRegId and r.riskId = :riskId and r.active = 'Y' ")
	Integer updateRiskApprovalInitToActive(@Param("approvalInitStatus") String approvalInitStatus, String riskRegId, Long riskId);
	
//	@Query("select r from RiskScoring r where r.riskId = :riskID and r.riskRegId = :riskRegID "
//			+ "order by r.srno desc fetch first 2 rows only")
//	public List<RiskTreatment> getRiskScoringHistory(String riskRegID, String riskID);
	
	
	public List<RiskScoring> findTop2ByRiskRegIdAndRiskIdOrderBySrnoDesc(String riskRegID, long riskId);

	List<RiskScoring> findByActiveAndApprovalFlagOrderBySrnoDesc(String active, String approvalFlag);
	
	List<RiskScoring> findByActiveOrderBySrnoDesc(String active);
	
	@Query("SELECT COUNT(*) FROM  RiskScoring  WHERE active = 'Y' AND approvalFlag = 'Y' ")
	long countByActiveAndApprovalFlag();
	
	@Query("SELECT COUNT(*) FROM  RiskScoring  WHERE active = 'Y' ")
	long countByActive();
	
}
