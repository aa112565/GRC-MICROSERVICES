package com.grc.itrisk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.ITRiskIdPreferenceDD;

@Repository
public interface ITRiskIdModuleRepo extends JpaRepository<ITRiskIdPreferenceDD, String> {
	@Query("FROM  ITRiskIdPreferenceDD ORDER BY moduleOrder ASC ")
	List<ITRiskIdPreferenceDD> findAllByOrder();
}
