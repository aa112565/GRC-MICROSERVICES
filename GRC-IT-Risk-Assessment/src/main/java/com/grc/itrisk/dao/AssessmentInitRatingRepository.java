package com.grc.itrisk.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.AssessmentInitRating;


@Repository
public interface AssessmentInitRatingRepository extends JpaRepository<AssessmentInitRating, Long> {
	
	@Query("FROM AssessmentInitRating WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<AssessmentInitRating> findAllAssessmentInitRating();

	@Query("FROM AssessmentInitRating WHERE assessmentId = :assessmentId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	AssessmentInitRating getAssessmentInitRatingByRefId(long assessmentId);

	@Transactional
	@Modifying
	@Query("update AssessmentInitRating r set r.activeFlag = 'N', r.deleteFlag = 'Y' where r.assessmentId = :assessmentId")
	public Integer updateAssessmentInitRatingToInactive(long assessmentId);
}
