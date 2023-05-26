/**
 * 
 */
package com.grc.threat.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grc.threat.risk.entity.ThreatType;


@Repository
public interface ThreatTypeRepository extends JpaRepository<ThreatType, String> {
	@Query("FROM  ThreatType ORDER BY threatTypeOrder ASC ")
	List<ThreatType> findAllByOrder();
}
