package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.Entity.Attestations;

@Repository
public interface AttestationsRepo extends JpaRepository<Attestations, Long> {
	
	@Query("FROM  Attestations WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND PolicyId = :PolicyId")
	List<Attestations> findByPolicyId(@Param("PolicyId")String PolicyId);
	
	@Transactional
	@Modifying
	@Query("update CreatePolicy r set r.alertMessage = 'Attestation is Pending for new policy publish' where r.id = :policyId AND attestaionsId = :attestaionsId")
	public void updateAlert(@Param("attestaionsId") String attestaionsId , @Param("policyId") long policyId);

}
