package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.PolicyIdPreference;


@Repository
public interface PolicyIdPreferenceRepository extends JpaRepository<PolicyIdPreference, Long>{
	
	
	@Query("FROM  PolicyIdPreference WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<PolicyIdPreference> findAllByActiveflag();
	
	@Query("SELECT COUNT(*) FROM  PolicyIdPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getPolicyIdPreferenceCountByModule(@Param("preferenceModule") String preferenceModule);
	
	@Query("FROM  PolicyIdPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	PolicyIdPreference getPolicyIdPreferenceByModule(@Param("preferenceModule") String preferenceModule);	
	
	@Query("SELECT COUNT(*) FROM  PolicyIdPreference WHERE preferenceModule = :preferenceModule AND status = 'Y' AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findNewIdPreferenceCountByStatusFlag(@Param("preferenceModule") String preferenceModule);
	
	@Query("SELECT COUNT(*) FROM  PolicyIdPreference WHERE preferenceOganization = :preferenceOganization AND preferenceYear = :preferenceYear AND runningSeries = :runningSeries ")
	int findNewIdPreference(@Param("preferenceOganization") String preferenceOganization, @Param("preferenceYear") String preferenceYear, @Param("runningSeries") String runningSeries);

//	PolicyIdPreference getRiskIdPreferenceByModule(String preferenceModule);

}
