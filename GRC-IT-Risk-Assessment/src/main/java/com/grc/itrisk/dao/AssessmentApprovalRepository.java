package com.grc.itrisk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.Assessment;



@Repository
public interface AssessmentApprovalRepository extends JpaRepository<Assessment, Long> {
	
	@Query("FROM Assessment WHERE deleteFlag = 'N' AND approvalFlag = 'Y' AND saveFlag = 'N' ORDER BY modifiedDate DESC ")
	List<Assessment> findAllAssessmentApproval();

	@Query("FROM Assessment WHERE assessmentId = :assessmentId AND saveFlag = 'N' AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	Assessment getAssessmentApprovalByAssessmentId(@Param("assessmentId") long assessmentId);
}
