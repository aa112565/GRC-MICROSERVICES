/**
 * 
 */
package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.RiskTypeDD;


@Repository
public interface RiskTypeRepository extends JpaRepository<RiskTypeDD, String> {
	@Query("FROM  RiskTypeDD ORDER BY riskTypeOrder ASC ")
	List<RiskTypeDD> findAllByOrder();

}
