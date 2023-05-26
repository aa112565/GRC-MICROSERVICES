package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.ReviewPolicyDto;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.ReviewPolicy;

@Repository

public interface ReviewPolicyRepo extends JpaRepository<ReviewPolicy, Long> {
	
	@Query("FROM  ReviewPolicy WHERE PolicyId = :PolicyId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	ReviewPolicy findByPolicyId(@Param("PolicyId")long PolicyId);
	
	@Query("FROM CreatePolicy WHERE review = 'Z' AND PolicyId = :PolicyId ORDER BY createdDate DESC ")
	List<CreatePolicy> findAllByApproveflag();
	
	@Query("SELECT COUNT(*) FROM  ReviewPolicy WHERE reviewDate < reviewNextDate AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyAgeing();

	@Modifying
	@Transactional
	@Query("update CreatePolicy  set review = Z WHERE policyId = :policyId ")
	//@Query("FROM  CreatePolicy WHERE review = 'Z' ORDER BY modifiedDate DESC ")
	List<CreatePolicy> findAllPolicy();
	

	@Transactional
	@Modifying
	@Query("update CreatePolicy r set r.review = 'Z' where r.id = :policyId")
	public void updatereviewToInactive(@Param("policyId") long policyId);
//	
	
	@Transactional
	@Modifying
	@Query("update CreatePolicy r set r.policyApprove = 'AA' where r.id = :policyId")
	public void updateApprove(@Param("policyId") long policyId);
	
	@Transactional
	@Modifying
	@Query("update CreatePolicy r set r.review = null where r.id = :policyId")
	public void updateReview(@Param("policyId") long policyId);
	
	@Transactional
	@Modifying
	@Query("update CreatePolicy set policyApprove = 'R' where id = :policyId")
	public void updateReject(@Param("policyId") long policyId);
	
	@Transactional
	@Modifying
	@Query("update CreatePolicy r set review = 'R' where id = :policyId")
	public void updateRejectinReview(@Param("policyId") long policyId);
	
	@Transactional
	@Modifying
	@Query("update CreatePolicy r set approve = 'R' where id = :policyId")
	public void updateRejectinCollabrate(@Param("policyId") long policyId);
	
//	@Transactional
//	@Modifying
//	@Query("update CreatePolicy r set r.publishAttestation = 'P' where r.id = :policyId")
//	public void updatepublishAttestationToactive(@Param("policyId") long policyId);

}
