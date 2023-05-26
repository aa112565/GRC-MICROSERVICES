package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.RiskApprovalHistoryDTO;
import com.asymmetrix.grc.entity.RiskApprovalStatus;

@Repository
public interface RiskApprovalStatusRepo extends JpaRepository<RiskApprovalStatus, String> {
	
	List<RiskApprovalStatus> findByApprovalId(String approvalId);

//	List<RiskApprovalStatus> findByRiskRegIdAndRiskIdOrderByCreatedDateDesc(String riskregId, String riskId);	

	@Query("SELECT new com.asymmetrix.grc.dto.RiskApprovalHistoryDTO(ras.approvalLevel, ras.approvalStatus, ras.comments, ras.createdDate, ras.createdBy)"
			+" FROM RiskApprovalStatus ras WHERE ras.riskRegId = :riskRegId AND ras.riskId = :riskId ORDER BY approvalLevel DESC")
	List<RiskApprovalHistoryDTO> findByRiskRegIdAndRiskId(@Param("riskRegId") String riskRegId, @Param("riskId") String riskId);
}
