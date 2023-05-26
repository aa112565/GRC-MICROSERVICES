package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.riskkri.entity.KriPreference;


@Repository
public interface KriIdPreferenceRepository extends JpaRepository<KriPreference, Long> {	

	@Query("FROM  KriPreference WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	List<KriPreference> findAllByActiveflag();
	
	@Query("SELECT COUNT(*) FROM  KriPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int getKriIdPreferenceCountByModule(@Param("preferenceModule") String preferenceModule);
	
	@Query("FROM  KriPreference WHERE preferenceModule = :preferenceModule AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	KriPreference getKriIdPreferenceByModule(@Param("preferenceModule") String preferenceModule);	
	
	@Query("SELECT COUNT(*) FROM  KriPreference WHERE preferenceModule = :preferenceModule AND status = 'Y' AND  deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findNewIdPreferenceCountByStatusFlag(@Param("preferenceModule") String preferenceModule);

//	int findNewIdPreference(String preferenceOganization, String preferenceYear, String runningSeries);
	
	@Query("SELECT COUNT(*) FROM  KriPreference WHERE preferenceOganization = :preferenceOganization AND preferenceYear = :preferenceYear AND runningSeries = :runningSeries ")
	int findNewIdPreference(@Param("preferenceOganization") String preferenceOganization, @Param("preferenceYear") String preferenceYear, @Param("runningSeries") String runningSeries);


	
}
