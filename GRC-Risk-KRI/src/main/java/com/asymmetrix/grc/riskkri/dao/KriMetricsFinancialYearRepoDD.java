package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriMetricsFinancialYearDD;

@Repository
public interface KriMetricsFinancialYearRepoDD extends JpaRepository<KriMetricsFinancialYearDD, String> {

	@Query("FROM  KriMetricsFinancialYearDD ORDER BY financialYearOrder DESC ")
	List<KriMetricsFinancialYearDD> findAllFinancialYear();

}
