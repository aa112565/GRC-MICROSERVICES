package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asymmetrix.grc.Entity.Collabrator;

public interface CollabratorRepo extends JpaRepository<Collabrator, Long> {
	
	
	    @Query("FROM  Collabrator WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	    List<Collabrator> findAllByActiveflag();
	    
	    @Query("FROM  Collabrator WHERE policyId = :policyId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	    List<Collabrator> findByPolicyId(@Param("policyId") String policyId);
//	    
//	    @Query("FROM  Collabrator WHERE collabratorId = :collabratorId AND policyId = :policyId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
//	    List<Collabrator> findAllByPolicyId();
	    
	   
	    
//	    @Query("FROM  Collabrator WHERE findingId = :findingId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
//	    List<Collabrator> findByFindingId(@Param("findingId") final String findingId);
	    
//	    @Query("SELECT COUNT(*) FROM  VendorFinding WHERE deleteFlag = 'N' AND activeFlag = 'Y' ")
//	    int getVendorFindingCountByActiveflag();

		
	    
//	    @Transactional
//	    @Modifying
//	    @Query("update Collabrator r set r.approvalInitStatus = :approvalInitStatus, r.approvalLevel = :approvalLevel, r.approvalFlag = 'Y' where r.assessmentId = :assessmentId and r.activeFlag = 'Y' ")
//	    Integer updateFindingApprovalInitToActive(@Param("approvalInitStatus") final String approvalInitStatus, @Param("approvalLevel") final String approvalLevel, final long assessmentId);
//	    
//	    @Query("SELECT COUNT(*) FROM  Collabrator  WHERE deleteFlag = 'N' AND approvalFlag = 'Y' AND activeFlag = 'Y' ")
//	    long countByActiveFlagAndApprovalFlag();
//	    
//	    @Query("FROM  Collabrator WHERE deleteFlag = 'N' AND approvalFlag = 'Y' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
//	    List<Collabrator> findAllByApprovalFlagAndActiveflag();
	}


