package com.asymmetrix.grc.oauth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.oauth.entity.CnfgPropertyDetails;

@Repository
public interface CnfgPropertyDetailsRepository extends JpaRepository<CnfgPropertyDetails, Integer> {

	public CnfgPropertyDetails findByCnfgKeyIgnoreCase(String cnfgKey);
	
	public List<CnfgPropertyDetails> findByCnfgNameIgnoreCase(String cnfgName);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CnfgPropertyDetails c WHERE UPPER(c.cnfgValue) = UPPER(:cnfgValue) AND UPPER(c.cnfgKey) = UPPER(:cnfgKey)")
    boolean isExistsByCnfgKeyAndCnfgValue(@Param("cnfgKey") String cnfgKey, @Param("cnfgValue") String cnfgValue);

	public CnfgPropertyDetails findByCnfgNameIgnoreCaseAndCnfgKeyIgnoreCase(String ldap, String key);
	
}
