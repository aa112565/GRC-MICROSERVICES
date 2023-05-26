package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriRiskEventTypeTwoDD;

@Repository
public interface KriRiskEventTypeTwoRepo extends JpaRepository<KriRiskEventTypeTwoDD, String> {
	@Query("FROM  KriRiskEventTypeTwoDD ORDER BY riskEventTypeTwoOrder ASC ")
	List<KriRiskEventTypeTwoDD> findAllByOrder();
}
