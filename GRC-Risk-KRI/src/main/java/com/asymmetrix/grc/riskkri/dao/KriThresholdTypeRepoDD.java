package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriThresholdTypeDD;

@Repository
public interface KriThresholdTypeRepoDD extends JpaRepository<KriThresholdTypeDD, String> {
	@Query("FROM  KriThresholdTypeDD ORDER BY thresholdTypeOrder ASC ")
	List<KriThresholdTypeDD> findAllByOrder();
}

