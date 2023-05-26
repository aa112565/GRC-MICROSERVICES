package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriThresholdCurrencyDD;

@Repository
public interface KriThresholdCurrencyRepoDD extends JpaRepository<KriThresholdCurrencyDD, String> {
	@Query("FROM  KriThresholdCurrencyDD ORDER BY currencyOrder ASC ")
	List<KriThresholdCurrencyDD> findAllByOrder();
}
