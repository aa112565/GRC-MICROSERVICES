package com.grc.itrisk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.AssessmentFrequencyDD;

@Repository
public interface AssessmentFrequencyRepo extends JpaRepository<AssessmentFrequencyDD, String> {

	@Query("FROM  AssessmentFrequencyDD ORDER BY assessmentFrequencyOrder ASC ")
	List<AssessmentFrequencyDD> findAllByOrder();

}
