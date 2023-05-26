package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriThresholdMeasuringScaleDD;

@Repository
public interface KriThresholdMeasuringScaleRepoDD extends JpaRepository<KriThresholdMeasuringScaleDD, String> {
	@Query("FROM  KriThresholdMeasuringScaleDD ORDER BY measuringScaleOrder ASC ")
	List<KriThresholdMeasuringScaleDD> findAllByOrder();
}

