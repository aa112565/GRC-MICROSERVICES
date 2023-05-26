package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.riskcontrol.entity.ControlPreference;


@Repository
public interface ControlIdPreferenceRepository extends JpaRepository<ControlPreference, Long> {	

	@Query("FROM  ControlPreference WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<ControlPreference> findAllByActiveflag();
	
	@Query("SELECT COUNT(*) FROM  ControlPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getControlIdPreferenceCountByModule(@Param("preferenceModule") String preferenceModule);
	
	@Query("FROM  ControlPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	ControlPreference getControlIdPreferenceByModule(@Param("preferenceModule") String preferenceModule);	
	
	@Query("SELECT COUNT(*) FROM  ControlPreference WHERE preferenceModule = :preferenceModule AND status = 'Y' AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findNewIdPreferenceCountByStatusFlag(@Param("preferenceModule") String preferenceModule);

//	int findNewIdPreference(String preferenceOganization, String preferenceYear, String runningSeries);
	
	@Query("SELECT COUNT(*) FROM  ControlPreference WHERE preferenceOganization = :preferenceOganization AND preferenceYear = :preferenceYear AND runningSeries = :runningSeries ")
	int findNewIdPreference(@Param("preferenceOganization") String preferenceOganization, @Param("preferenceYear") String preferenceYear, @Param("runningSeries") String runningSeries);


//	RiakPreference getRiskIdPreferenceByModule(String preferenceModule);
	
}
