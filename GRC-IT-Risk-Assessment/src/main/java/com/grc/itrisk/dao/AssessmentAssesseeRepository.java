package com.grc.itrisk.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.AssessmentAssessee;




@Repository
public interface AssessmentAssesseeRepository extends JpaRepository<AssessmentAssessee, Long>{
	
	@Transactional
	@Modifying
	@Query("update AssessmentAssessee r set r.active = 'N' where r.assessmentId = :assessmentId")
	public Integer updateITRiskAssessmentAssesseeToInactive(long assessmentId);
	
	@Query("From AssessmentAssessee r where r.active = 'Y' AND r.departmentID = :departmentID ")
	public List<AssessmentAssessee> findByDepartmentID(String departmentID);		


}
