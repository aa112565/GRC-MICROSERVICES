package com.grc.itrisk.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.grc.itrisk.entity.AssessmentPostRating;


@Repository
public interface AssessmentPostRatingRepository extends JpaRepository<AssessmentPostRating, Long> {
	
	@Query("FROM AssessmentPostRating WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<AssessmentPostRating> findAllAssessmentPostRating();

	@Query("FROM AssessmentPostRating WHERE assessmentId = :assessmentId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	AssessmentPostRating getAssessmentPostRatingByRefId(long assessmentId);

	@Transactional
	@Modifying
	@Query("update AssessmentPostRating r set r.activeFlag = 'N', r.deleteFlag = 'Y' where r.assessmentId = :assessmentId")
	public Integer updateAssessmentPostRatingToInactive(long assessmentId);
}
