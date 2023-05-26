package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.RiskIdPreferenceDD;


@Repository
public interface RiskIdModuleRepo extends JpaRepository<RiskIdPreferenceDD, String> {
	@Query("FROM  RiskIdPreferenceDD ORDER BY moduleOrder ASC ")
	List<RiskIdPreferenceDD> findAllByOrder();
}
