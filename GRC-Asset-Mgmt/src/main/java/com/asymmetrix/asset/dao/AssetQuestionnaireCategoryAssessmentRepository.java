package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.CMAssetQuestionnaireAssessment;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireCategoryAssessment;

@Repository
public interface AssetQuestionnaireCategoryAssessmentRepository
		extends JpaRepository<CMAssetQuestionnaireCategoryAssessment, Long> {

	@Query("FROM  CMAssetQuestionnaireCategoryAssessment WHERE deleteFlag = 'N' ORDER BY createdDate ASC ")
	List<CMAssetQuestionnaireCategoryAssessment> findAllAssessment();

	@Query("FROM  CMAssetQuestionnaireCategoryAssessment WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate ASC ")
	List<CMAssetQuestionnaireCategoryAssessment> findAllByActiveflag();

	@Query("FROM  CMAssetQuestionnaireCategoryAssessment WHERE assetId = :assetId AND deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate ASC ")
	List<CMAssetQuestionnaireCategoryAssessment> findByAssetId(@Param("assetId") String assetId);

	@Query("FROM  CMAssetQuestionnaireCategoryAssessment WHERE assessmentId = :assessmentId AND deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate ASC")
	List<CMAssetQuestionnaireCategoryAssessment> findByAssessmentId(@Param("assessmentId") String assessmentId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireCategoryAssessment WHERE assessmentId = :assessmentId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentId(@Param("assessmentId") String assessmentId);

	@Query("FROM  CMAssetQuestionnaireCategoryAssessment WHERE assessmentId = :assessmentId AND controlId = :controlId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	CMAssetQuestionnaireAssessment findByAssessmentIdAndControlId(@Param("assessmentId") String assessmentId,
			@Param("controlId") String controlId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireCategoryAssessment WHERE assessmentId = :assessmentId AND questionId = :questionId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentIdAndQuestionId(@Param("assessmentId") String assessmentId,
			@Param("questionId") String questionId);

	@Query("FROM  CMAssetQuestionnaireCategoryAssessment WHERE assessmentId = :assessmentId AND questionId = :questionId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	CMAssetQuestionnaireCategoryAssessment findByAssessmentIdAndQuestionId(@Param("assessmentId") String assessmentId,
			@Param("questionId") String questionId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireCategoryAssessment WHERE assessmentId = :assessmentId AND controlId = :controlId AND questionId = :questionId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentIdAndControlIdAndQuestionId(@Param("assessmentId") String assessmentId,
			@Param("controlId") String controlId, @Param("questionId") String questionId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireCategoryAssessment WHERE assessmentId = :assessmentId AND controlId = :controlId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentIdAndControlId(@Param("assessmentId") String assessmentId,
			@Param("controlId") String controlId);

}
