package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.CMAssetQuestionnaireAssessment;

@Repository
public interface AssetQuestionnaireAssessmentRepository extends JpaRepository<CMAssetQuestionnaireAssessment, Long> {

	@Query("FROM  CMAssetQuestionnaireAssessment WHERE deleteFlag = 'N' ORDER BY createdDate ASC ")
	List<CMAssetQuestionnaireAssessment> findAllAssessment();

	@Query("FROM  CMAssetQuestionnaireAssessment WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate ASC ")
	List<CMAssetQuestionnaireAssessment> findAllByActiveflag();

	@Query("FROM  CMAssetQuestionnaireAssessment WHERE assetId = :assetId AND deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate ASC ")
	List<CMAssetQuestionnaireAssessment> findByAssetId(@Param("assetId") String assetId);

	@Query("FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate ASC")
	List<CMAssetQuestionnaireAssessment> findByAssessmentId(@Param("assessmentId") String assessmentId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentId(@Param("assessmentId") String assessmentId);

	@Query("FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND controlId = :controlId AND questionId = :questionId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	CMAssetQuestionnaireAssessment findByAssessmentIdAndControlIdAndQuestionId(
			@Param("assessmentId") String assessmentId, @Param("controlId") String controlId,
			@Param("questionId") String questionId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND questionId = :questionId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentIdAndQuestionId(@Param("assessmentId") String assessmentId,
			@Param("questionId") String questionId);

	@Query("FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND questionId = :questionId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	CMAssetQuestionnaireAssessment findByAssessmentIdAndQuestionId(@Param("assessmentId") String assessmentId,
			@Param("questionId") String questionId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND controlId = :controlId AND questionId = :questionId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentIdAndControlIdAndQuestionId(@Param("assessmentId") String assessmentId,
			@Param("controlId") String controlId, @Param("questionId") String questionId);

	@Query("SELECT COUNT(*) FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND controlId = :controlId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByAssessmentIdAndControlId(@Param("assessmentId") String assessmentId,
			@Param("controlId") String controlId);

	@Query("FROM  CMAssetQuestionnaireAssessment WHERE assessmentId = :assessmentId AND controlId = :controlId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	CMAssetQuestionnaireAssessment findByAssessmentIdAndControlId(@Param("assessmentId") String assessmentId,
			@Param("controlId") String controlId);

}
