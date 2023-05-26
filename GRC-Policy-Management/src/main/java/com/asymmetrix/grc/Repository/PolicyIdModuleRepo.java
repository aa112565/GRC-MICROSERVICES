package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.PolicyIdPreferenceDD;

@Repository
public interface PolicyIdModuleRepo extends JpaRepository<PolicyIdPreferenceDD, String> {

	@Query("FROM  PolicyIdPreferenceDD ORDER BY moduleOrder ASC ")
	List<PolicyIdPreferenceDD> findAll();
	
}
