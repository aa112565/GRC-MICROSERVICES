package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.Entity.PolicyCollaborate;


@Repository
public interface PolicyCollaborateRepo extends JpaRepository<PolicyCollaborate, Long> {
	
	
	@Query("FROM  PolicyCollaborate WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND PolicyId = :PolicyId")
	List<PolicyCollaborate> findByPolicyId(@Param("PolicyId")String PolicyId);
	
	@Transactional
	@Modifying
	@Query("update CreatePolicy r set r.collabrateFlag = 'Y' where r.id = :policyId AND collabrateId = :collabrateId ")
	public void updateCollabrateToactive( @Param("collabrateId") String collabrateId , @Param("policyId") long policyId);
	
//	@Transactional
//	@Modifying
//	@Query("update CreatePolicy r set r.approve = 'A' where r.id = :collabrateId ")
//	public void updateCollabrateToactive(@Param("collabrateId") Long collabrateId);
	
//	@Transactional
//	@Modifying
//	@Query("update CreatePolicy r set r.collabrateFlag = 'Y' where r.id = :policyId AND collabrateId = :collabrateId")
//	public void updateCollabrate(@Param("collabrateId") int collabrateId ,@Param("policyId") long policyId);
//	
	

}
