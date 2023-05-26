package com.grc.itrisk.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.AssessmentAssessors;



@Repository
public interface AssessmentAssessorsRepository extends JpaRepository<AssessmentAssessors, Long>{
	
	@Transactional
	@Modifying
	@Query("update AssessmentAssessors r set r.active = 'N' where r.assessmentId = :assessmentId")
	public Integer updateITRiskAssessmentAssessorToInactive(long assessmentId);
	
	@Query("From AssessmentAssessors r where r.active = 'Y' AND r.departmentID = :departmentID ")
	public List<AssessmentAssessors> findByDepartmentID(String departmentID);		


}
