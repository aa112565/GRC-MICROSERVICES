package com.grc.itrisk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.ITRiskPreference;



@Repository
public interface ITRiskIdPreferenceRepository extends JpaRepository<ITRiskPreference, Long> {	

	@Query("FROM  ITRiskPreference WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<ITRiskPreference> findAllByActiveflag();
	
	@Query("SELECT COUNT(*) FROM  ITRiskPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getITRiskIdPreferenceCountByModule(@Param("preferenceModule") String preferenceModule);
	
	@Query("FROM  ITRiskPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	ITRiskPreference getITRiskIdPreferenceByModule(@Param("preferenceModule") String preferenceModule);	
	
	@Query("SELECT COUNT(*) FROM  ITRiskPreference WHERE preferenceModule = :preferenceModule AND status = 'Y' AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findNewIdPreferenceCountByStatusFlag(@Param("preferenceModule") String preferenceModule);

//	int findNewIdPreference(String preferenceOganization, String preferenceYear, String runningSeries);
	
	@Query("SELECT COUNT(*) FROM  ITRiskPreference WHERE preferenceOganization = :preferenceOganization AND preferenceYear = :preferenceYear AND runningSeries = :runningSeries ")
	int findNewIdPreference(@Param("preferenceOganization") String preferenceOganization, @Param("preferenceYear") String preferenceYear, @Param("runningSeries") String runningSeries);

}
