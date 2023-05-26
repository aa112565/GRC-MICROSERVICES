package com.asymmetrix.asset.service;

import java.util.List;

import com.asymmetrix.asset.dto.AssetQuestionCategoryAssessmentDTO;
import com.asymmetrix.asset.dto.CMAssetQuestionCategoryAssessmentDTO;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireCategoryAssessment;

public interface AssetQuestionnaireCategoryAssessmentService {

	List<CMAssetQuestionnaireCategoryAssessment> getAllAssetQuestionnaireCategoryAssessment();

	List<CMAssetQuestionnaireCategoryAssessment> getAllAssetQuestionnaireCategoryAssessmentByActiveflag();

	CMAssetQuestionnaireCategoryAssessment getAssetQuestionnaireCategoryAssessmentById(long assessmentId);

	List<CMAssetQuestionnaireCategoryAssessment> getAssetQuestionnaireCategoryAssessmentByAssetId(String assetId);

	List<CMAssetQuestionnaireCategoryAssessment> getAssetQuestionnaireCategoryAssessmentByAssessmentId(
			String assessmentId);

	CMAssetQuestionnaireCategoryAssessment getAssetQuestionnaireCategoryAssessmentByControlId(String assessmentId,
			String controlId);

	CMAssetQuestionnaireCategoryAssessment createQuestionnaireCategoryAssessment(
			CMAssetQuestionCategoryAssessmentDTO assessmentDto);

	List<CMAssetQuestionnaireCategoryAssessment> saveAllAssetQuestionnaireCategoryAssessment(
			List<CMAssetQuestionnaireCategoryAssessment> assessmentList);

	CMAssetQuestionnaireCategoryAssessment updateQuestionnaireCategoryAssessment(
			CMAssetQuestionCategoryAssessmentDTO assessmentDto);

	CMAssetQuestionnaireCategoryAssessment deleteQuestionnaireCategoryAssessment(
			CMAssetQuestionCategoryAssessmentDTO assessmentDto);

	List<AssetQuestionCategoryAssessmentDTO> getAssetQuestionnaireCategoryAssessmentByList(List<Long> assessmentIdList);

}
