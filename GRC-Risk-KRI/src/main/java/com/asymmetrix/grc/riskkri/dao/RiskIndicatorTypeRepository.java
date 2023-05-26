/**
 * 
 */
package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asymmetrix.grc.riskkri.entity.RiskIndicatorTypeDD;

public interface RiskIndicatorTypeRepository extends JpaRepository<RiskIndicatorTypeDD, String> {
	@Query("FROM  RiskIndicatorTypeDD ORDER BY riskIndicatorOrder ASC ")
	List<RiskIndicatorTypeDD> findAllByOrder();
}
