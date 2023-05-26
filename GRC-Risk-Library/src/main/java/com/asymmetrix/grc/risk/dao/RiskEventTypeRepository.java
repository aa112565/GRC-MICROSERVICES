/**
 * 
 */
package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asymmetrix.grc.risk.entity.RiskEventTypeDD;


public interface RiskEventTypeRepository extends JpaRepository<RiskEventTypeDD, String> {
	@Query("FROM  RiskEventTypeDD ORDER BY riskEventTypeOrder ASC ")
	List<RiskEventTypeDD> findAllByOrder();
}
