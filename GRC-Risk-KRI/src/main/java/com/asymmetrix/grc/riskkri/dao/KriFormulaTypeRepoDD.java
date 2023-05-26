package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriFormulaTypeDD;

@Repository
public interface KriFormulaTypeRepoDD extends JpaRepository<KriFormulaTypeDD, String> {
	@Query("FROM  KriFormulaTypeDD ORDER BY formulaOrder ASC ")
	List<KriFormulaTypeDD> findAllByOrder();
}
