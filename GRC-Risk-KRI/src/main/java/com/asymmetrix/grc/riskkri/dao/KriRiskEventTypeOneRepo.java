package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriRiskEventTypeOneDD;

@Repository
public interface KriRiskEventTypeOneRepo extends JpaRepository<KriRiskEventTypeOneDD, String> {
	@Query("FROM  KriRiskEventTypeOneDD ORDER BY riskEventTypeOneOrder ASC ")
	List<KriRiskEventTypeOneDD> findAllByOrder();
}
