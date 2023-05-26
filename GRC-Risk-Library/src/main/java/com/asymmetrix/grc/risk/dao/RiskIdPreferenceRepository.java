package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.RiskPreference;



@Repository
public interface RiskIdPreferenceRepository extends JpaRepository<RiskPreference, Long> {	

	@Query("FROM  RiskPreference WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<RiskPreference> findAllByActiveflag();
	
	@Query("SELECT COUNT(*) FROM  RiskPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getRiskIdPreferenceCountByModule(@Param("preferenceModule") String preferenceModule);
	
	@Query("FROM  RiskPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	RiskPreference getRiskIdPreferenceByModule(@Param("preferenceModule") String preferenceModule);	
	
	@Query("SELECT COUNT(*) FROM  RiskPreference WHERE preferenceModule = :preferenceModule AND status = 'Y' AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findNewIdPreferenceCountByStatusFlag(@Param("preferenceModule") String preferenceModule);
	
	@Query("SELECT COUNT(*) FROM  RiskPreference WHERE preferenceOganization = :preferenceOganization AND preferenceYear = :preferenceYear AND runningSeries = :runningSeries ")
	int findNewIdPreference(@Param("preferenceOganization") String preferenceOganization, @Param("preferenceYear") String preferenceYear, @Param("runningSeries") String runningSeries);

//	RiakPreference getRiskIdPreferenceByModule(String preferenceModule);
	
}
