package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskCurrency;

@Repository
public interface RiskCurrencyRepository extends JpaRepository<RiskCurrency, Long> {

	@Query("Select riskCurrency.currency from RiskCurrency riskCurrency")
	List<String> getAll();

}
