package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriRiskCategoryDD;

@Repository
public interface KriRiskCategoryRepo extends JpaRepository<KriRiskCategoryDD, String> {
	@Query("FROM  KriRiskCategoryDD ORDER BY riskCategoryOrder ASC ")
	List<KriRiskCategoryDD> findAllByOrder();
}
