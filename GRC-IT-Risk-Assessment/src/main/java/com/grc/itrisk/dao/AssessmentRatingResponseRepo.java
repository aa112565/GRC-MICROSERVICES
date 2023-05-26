package com.grc.itrisk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grc.itrisk.entity.AssessmentRatingResponseDD;


public interface AssessmentRatingResponseRepo extends JpaRepository<AssessmentRatingResponseDD, String> {
	@Query("FROM  AssessmentRatingResponseDD ORDER BY responseOrder ASC ")
	List<AssessmentRatingResponseDD> findAllByOrder();
}
