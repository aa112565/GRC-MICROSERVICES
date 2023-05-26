package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.Entity.PeriodicReview;

@Repository
public interface PeriodicReviewRepo extends JpaRepository <PeriodicReview, Long>{

	@Query("FROM  PeriodicReview WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<PeriodicReview> findAllByOrder();
	
	@Query("FROM  PeriodicReview WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<PeriodicReview> findAllByActiveflag();
	
	@Query("FROM  PeriodicReview WHERE approve = 'A' ORDER BY createdDate DESC ")
	List<PeriodicReview> findAllByApproveflag();
	
	@Query("FROM  PeriodicReview WHERE policyId = :policyId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	PeriodicReview findPeriodicReviewByPolicyId(@Param("policyId") String policyId);	
	
	@Query("SELECT COUNT(*) FROM  CreatePolicy WHERE deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyCountByActiveflag();
	
	
	PeriodicReview findFirstByOrderByCreatedDateDescPolicyIdDesc();
}
