package com.grc.threat.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.threat.risk.entity.ThreatPreference;


@Repository
public interface ThreatIdPreferenceRepository extends JpaRepository<ThreatPreference, Long> {	

	@Query("FROM  ThreatPreference WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<ThreatPreference> findAllByActiveflag();
	
	@Query("SELECT COUNT(*) FROM  ThreatPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getThreatIdPreferenceCountByModule(@Param("preferenceModule") String preferenceModule);
	
	@Query("FROM  ThreatPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	ThreatPreference getThreatIdPreferenceByModule(@Param("preferenceModule") String preferenceModule);	
	
	@Query("SELECT COUNT(*) FROM  ThreatPreference WHERE preferenceModule = :preferenceModule AND status = 'Y' AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findNewIdPreferenceCountByStatusFlag(@Param("preferenceModule") String preferenceModule);

//	int findNewIdPreference(String preferenceOganization, String preferenceYear, String runningSeries);
	
	@Query("SELECT COUNT(*) FROM  ThreatPreference WHERE preferenceOganization = :preferenceOganization AND preferenceYear = :preferenceYear AND runningSeries = :runningSeries ")
	int findNewIdPreference(@Param("preferenceOganization") String preferenceOganization, @Param("preferenceYear") String preferenceYear, @Param("runningSeries") String runningSeries);


//	RiakPreference getRiskIdPreferenceByModule(String preferenceModule);
	
}
