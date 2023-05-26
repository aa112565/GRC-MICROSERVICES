package com.grc.itrisk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grc.itrisk.entity.AssessmentTypeDD;

public interface AssessmentTypeRepo extends JpaRepository<AssessmentTypeDD, String> {
	@Query("FROM  AssessmentTypeDD ORDER BY assessmentTypeOrder ASC ")
	List<AssessmentTypeDD> findAllByOrder();
}
