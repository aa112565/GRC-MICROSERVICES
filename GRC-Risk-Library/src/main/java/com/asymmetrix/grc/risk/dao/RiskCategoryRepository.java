package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.RiskCategoryDD;


@Repository
public interface RiskCategoryRepository extends JpaRepository<RiskCategoryDD, String> {
	@Query("FROM  RiskCategoryDD ORDER BY riskCategoryOrder ASC ")
	List<RiskCategoryDD> findAllByOrder();
}
