package com.asymmetrix.asset.service;

import java.util.List;

import com.asymmetrix.asset.dto.AssessmentAttachmentsDTO;
import com.asymmetrix.asset.dto.AssessmentFileUploadDTO;
import com.asymmetrix.asset.dto.AssetQuestionAssessmentDTO;
import com.asymmetrix.asset.dto.CMAssetQuestionAssessmentDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryAssessmentReportDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryCountDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryReportDTO;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireAssessment;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireCategoryAssessment;

public interface AssetQuestionnaireAssessmentService {

	List<CMAssetQuestionnaireAssessment> getAllAssetQuestionnaireAssessment();

	List<CMAssetQuestionnaireAssessment> getAllAssetQuestionnaireAssessmentByActiveflag();

	CMAssetQuestionnaireAssessment getAssetQuestionnaireAssessmentById(long assessmentId);

	List<CMAssetQuestionnaireAssessment> getAssetQuestionnaireAssessmentByAssetId(String assetId);

	List<CMAssetQuestionnaireAssessment> getAssetQuestionnaireAssessmentByAssessmentId(String assessmentId);

	List<QuestionnaireCategoryCountDTO> getAssetQuestionnaireAssessmentCountByAssessmentIdAndControlId(
			String assessmentId, List<QuestionnaireCategoryCountDTO> assetCountDto);

	List<QuestionnaireCategoryAssessmentReportDTO> getAssetQuestionnaireAssessmentReportByAssessmentId(
			String assessmentId, List<QuestionnaireCategoryReportDTO> assetReportDto);

	CMAssetQuestionnaireAssessment getAssetQuestionnaireAssessmentByQuestionId(String assessmentId, String controlId,
			String questionId);

	CMAssetQuestionnaireAssessment createQuestionnaireAssessment(CMAssetQuestionAssessmentDTO assessmentDto);

	CMAssetQuestionnaireCategoryAssessment assessmentCategoryStatusUpdateForCompleted(String assessmentId,
			String categoryId);

	List<CMAssetQuestionnaireAssessment> saveAllAssetQuestionnaireAssessment(
			List<CMAssetQuestionnaireAssessment> assessmentList);

	CMAssetQuestionnaireAssessment updateQuestionnaireAssessment(CMAssetQuestionAssessmentDTO assessmentDto);

	CMAssetQuestionnaireAssessment deleteQuestionnaireAssessment(CMAssetQuestionAssessmentDTO assessmentDto);

	List<AssetQuestionAssessmentDTO> getAssetQuestionnaireAssessmentByList(List<Long> assessmentIdList);

	String fileDeleteByDocId(String docId);

	String createFiles(AssessmentAttachmentsDTO assessmentDto);

	List<AssessmentFileUploadDTO> downloadFile(String docId);

}
