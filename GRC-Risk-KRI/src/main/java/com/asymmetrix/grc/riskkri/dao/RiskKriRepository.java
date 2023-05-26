package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.RiskKri;

@Repository
public interface RiskKriRepository extends JpaRepository<RiskKri, Long> {

	@Query("FROM  RiskKri WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<RiskKri> findAllKri();

	RiskKri findFirstByOrderByCreatedDateDescKriIdDesc();

}
