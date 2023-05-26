package com.grc.itrisk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.Assessment;


@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
	
	@Query("FROM Assessment WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<Assessment> findAllAssessment();

	@Query("FROM Assessment WHERE templateId = :templateId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<Assessment> getAllAssessmentByTemplateId(@Param("templateId") long templateId);

	Assessment findFirstByOrderByCreatedDateDescAssessmentIdDesc();
}
