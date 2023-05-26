package com.asymmetrix.grc.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.ReviewPolicy;

@Repository
public interface CreatePolicyRepo extends JpaRepository<CreatePolicy, Long> {
	
	@Query("FROM  CreatePolicy  WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<CreatePolicy> findAllByOrder();
	
	@Query("FROM  CreatePolicy WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<CreatePolicy> findAllByActiveflag();
	
	@Query("FROM  CreatePolicy WHERE approve = 'A' ORDER BY createdDate DESC ")
	List<CreatePolicy> findAllByApproveflag();
	
	@Query("FROM  CreatePolicy WHERE collabrateFlag = 'Y' AND reject = null ORDER BY createdDate DESC ")
	List<CreatePolicy> findAllByWithCollabrate();
	
	@Query("FROM  CreatePolicy WHERE collabrateFlag = null AND reject = null OR approve = 'A'  ORDER BY createdDate DESC ")
//	@Query("FROM  CreatePolicy WHERE collabrateFlag = null AND reject = 'R' ORDER BY createdDate DESC ")
	List<CreatePolicy> findAllByNoCollabrate();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE review = 'Z'AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyCountByActiveflag();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE review = 'Z'AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyReview();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE policyApprove = 'AA' AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyApproved();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE policyApprove = 'AA' AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyApprov();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE IssuanceDate > ReviewDate AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyExpired();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE IssuanceDate <= ReviewDate AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyPending();
	
//	@Query("SELECT COUNT(*) FROM  CreatePolicy  WHERE ValidTill - IssuanceDate ")
//	int getPolicyAgeing();
//	
//	@Query(value = "from CreatePolicy t where yourDate BETWEEN :ValidTill AND :IssuanceDate")
//	public List<CreatePolicy> getPolicyAgeing(@Param("ValidTill")Date ValidTill,@Param("IssuanceDate")Date IssuanceDate);
//	
	
	@Query("SELECT COUNT(*) As ViewCount  FROM  CreatePolicy Group By policyId order By ViewCount Desc ")
	List<CreatePolicy> getPolicyMostAccessed();
	
	@Query("FROM CreatePolicy WHERE review = 'Z' AND policyId = :policyId  ORDER BY createdDate DESC ")
	List<CreatePolicy> findAllByReviewPolicy();
	
	CreatePolicy findFirstByOrderByCreatedDateDescPolicyIdDesc();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findInprogresCountByPolicyStatus();

	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE status = :status AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCompletedCountByPolicyStatus(@Param("status") String status);
	
//	@Query("select count(distinct Category) from CreatePolicy ")
//	//@Query("SELECT DISTINCT FROM  CreatePolicy WHERE Category = :Category AND deleteFlag = 'N' AND activeFlag = 'Y' ")
//	int frequentlyAccessedPolicy();
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE Category = :Category AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int frequentlyAccessedPolicy(@Param("Category") String Category);
	
		
	@Transactional
    @Modifying
    @Query("update CreatePolicy r set r.approvalInitStatus = :approvalInitStatus, r.approvalLevel = :approvalLevel, r.approvalFlag = 'Y' where r.policyId = :policyId and r.activeFlag = 'Y' ")
    Integer updatePolicyApprovalInitToActive(@Param("approvalInitStatus") final String approvalInitStatus, @Param("approvalLevel") final String approvalLevel, final Long policyId);
    
    
    @Query("SELECT COUNT(*) FROM  CreatePolicy  WHERE deleteFlag = 'N' AND approvalFlag = 'Y' AND activeFlag = 'Y' ")
    int countByActiveFlagAndApprovalFlag();
    
    @Query("FROM  CreatePolicy WHERE deleteFlag = 'N' AND approvalFlag = 'Y' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
    List<CreatePolicy> findAllByApprovalFlagAndActiveflag();
    
    @Query("SELECT COUNT(*) FROM  CreatePolicy WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND approvalFlag = 'Y' ")
    int getPolicyCountByApprovalflag();
    
    @Query("SELECT COUNT(*) FROM  CreatePolicy  WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND approvalFlag = 'Y' AND approvalInitStatus = :approvalInitStatus AND approvalLevel = :approvalLevel ")
    int getPolicyCountByApprovalLevelAndApprovalStatus(@Param("approvalInitStatus") final String approvalInitStatus, @Param("approvalLevel") final String approvalLevel);
    
    @Query("FROM  CreatePolicy  WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND approvalFlag = 'Y' AND approvalInitStatus = :approvalInitStatus AND approvalLevel = :approvalLevel ")
    List<CreatePolicy> getPolicyListByApprovalLevelAndApprovalStatus(@Param("approvalInitStatus") final String approvalInitStatus, @Param("approvalLevel") final String approvalLevel);
    
    
    @Transactional
	@Modifying
	@Query("update CreatePolicy set policyApprove = null , review = null , approve = null where id = :policyId")
	public void updateReject(@Param("policyId") long policyId);
    
    @Transactional
	@Modifying
	@Query("update CreatePolicy set review = 'R' where id = :policyId")
	public void updateRejectReview(@Param("policyId") long policyId);
}
