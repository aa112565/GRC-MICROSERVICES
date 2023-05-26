package com.grc.threat.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grc.threat.risk.entity.ThreatCategory;


@Repository
public interface ThreatCategoryRepository extends JpaRepository<ThreatCategory, String> {
	@Query("FROM  ThreatCategory ORDER BY threatCategoryOrder ASC ")
	List<ThreatCategory> findAllByOrder();
}
