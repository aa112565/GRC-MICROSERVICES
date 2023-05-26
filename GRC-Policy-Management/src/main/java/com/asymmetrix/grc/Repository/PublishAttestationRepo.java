package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.PublishAttestation;

@Repository
public interface PublishAttestationRepo extends JpaRepository<PublishAttestation, Long> {
	
	@Query("FROM  PublishAttestation WHERE activeFlag = 'Y'  AND deleteFlag = 'N' ORDER BY createdDate DESC ")
    List<PublishAttestation> findAllPublishAttestationByActiveflag();
    
    @Query("FROM  PublishAttestation WHERE PolicyId = :PolicyId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
    PublishAttestation findPublishAttestationIdByPolicyId(@Param("PolicyId") long PolicyId);
    
    @Query("SELECT COUNT(*) FROM  PublishAttestation WHERE deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPublishAttestationProgramCountByActiveflag();
    
    @Query("FROM  CreatePolicy WHERE publishAttestation = 'P' ORDER BY modifiedDate DESC ")
	List<CreatePolicy> findAllPolicy();
    
    @Transactional
	@Modifying
	@Query("update CreatePolicy r set r.publishAttestation = 'P' where r.id = :policyId")
	public void updatepublishAttestationToactive(@Param("policyId") long policyId);
    
    @Transactional
	@Modifying
	@Query("update CreatePolicy r set r.alertMessage = 'New Policy Has Published' where r.id = :policyId")
	public void AlertMessage(@Param("policyId") long policyId);
    
}
