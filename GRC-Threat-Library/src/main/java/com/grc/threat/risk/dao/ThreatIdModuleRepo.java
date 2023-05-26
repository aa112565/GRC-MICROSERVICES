package com.grc.threat.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grc.threat.risk.entity.ThreatIdPreferenceDD;


@Repository
public interface ThreatIdModuleRepo extends JpaRepository<ThreatIdPreferenceDD, String> {
	@Query("FROM  ThreatIdPreferenceDD ORDER BY moduleOrder ASC ")
	List<ThreatIdPreferenceDD> findAllByOrder();
}
