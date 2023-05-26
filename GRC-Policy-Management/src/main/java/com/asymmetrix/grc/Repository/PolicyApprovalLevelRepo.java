package com.asymmetrix.grc.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.PolicyApprovalLevel;

@Repository
public interface PolicyApprovalLevelRepo extends JpaRepository <PolicyApprovalLevel, String>{
	
	PolicyApprovalLevel findByPolicyUniqueIdAndPolicyId(final String policyUniqueId, final String policyId);
	    
	    @Query("SELECT COUNT(*) FROM  PolicyApprovalLevel  WHERE activeFlag = 'Y' AND policyUniqueId = :policyUniqueId AND policyId = :policyId ")
	    long countByPolicyUniqueIdAndPolicyId(@Param("policyUniqueId") final String policyUniqueId, @Param("policyId") final String policyId);
	    
	    @Transactional
	    @Modifying
	    @Query("update PolicyApprovalLevel r set r.status = :status, r.levelOneStatus = :levelOneStatus where r.policyUniqueId = :policyUniqueId and r.policyId = :policyId")
	    Integer updatePolicyApprovalLevelOneStatus(@Param("levelOneStatus") final String levelOneStatus, @Param("status") final String status, @Param("policyUniqueId") final String vendorUniqueId, @Param("policyId") final String policyId);
	    
	    @Transactional
	    @Modifying
	    @Query("update PolicyApprovalLevel r set r.status = :status, r.levelTwoStatus = :levelTwoStatus where r.policyUniqueId = :policyUniqueId and r.policyId = :policyId")
	    Integer updatePolicyApprovalLevelTwoStatus(@Param("levelTwoStatus") final String levelTwoStatus, @Param("status") final String status, @Param("policyUniqueId") final String vendorUniqueId, @Param("policyId") final String policyId);
	    
	    @Transactional
	    @Modifying
	    @Query("update PolicyApprovalLevel r set r.status = :status, r.levelThreeStatus = :levelThreeStatus where r.policyUniqueId = :policyUniqueId and r.policyId = :policyId")
	    Integer updatePolicyApprovalLevelThreeStatus(@Param("levelThreeStatus") final String levelThreeStatus, @Param("status") final String status, @Param("policyUniqueId") final String vendorUniqueId, @Param("policyId") final String policyId);
	}
