package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Dto.PolicyApprovalHistoryDTO;
import com.asymmetrix.grc.Entity.PolicyApprovalStatus;

@Repository
public interface PolicyApprovalStatusRepo extends JpaRepository<PolicyApprovalStatus, String> {

	 List<PolicyApprovalStatus> findByApprovalId(final String approvalId);
	    
	    @Query("SELECT new com.asymmetrix.grc.Dto.PolicyApprovalHistoryDTO(ras.approvalLevel, ras.approvalStatus, ras.comments, ras.createdDate, ras.createdBy) FROM PolicyApprovalStatus ras WHERE ras.policyUniqueId = :policyUniqueId AND ras.policyId = :policyId ORDER BY approvalLevel DESC")
	    List<PolicyApprovalHistoryDTO> findByPolicyUniqueIdAndPolicyId(@Param("policyUniqueId") final String policyUniqueId, @Param("policyId") final String policyId);

}