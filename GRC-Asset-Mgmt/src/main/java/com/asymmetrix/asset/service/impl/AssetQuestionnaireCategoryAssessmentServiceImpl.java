package com.asymmetrix.asset.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.asset.dao.AssetAssessmentLogRepository;
import com.asymmetrix.asset.dao.AssetAssessmentRepository;
import com.asymmetrix.asset.dao.AssetLogRepository;
import com.asymmetrix.asset.dao.AssetQuestionnaireAssessmentRepository;
import com.asymmetrix.asset.dao.AssetQuestionnaireCategoryAssessmentLogRepository;
import com.asymmetrix.asset.dao.AssetQuestionnaireCategoryAssessmentRepository;
import com.asymmetrix.asset.dao.AssetRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.dto.AssessmentAttachmentsDTO;
import com.asymmetrix.asset.dto.AssessmentFileUploadDTO;
import com.asymmetrix.asset.dto.AssetAssessmentDTO;
import com.asymmetrix.asset.dto.AssetAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetQuestionAssessmentDTO;
import com.asymmetrix.asset.dto.AssetQuestionCategoryAssessmentDTO;
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.dto.CMAssetQuestionAssessmentDTO;
import com.asymmetrix.asset.dto.CMAssetQuestionCategoryAssessmentDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryAssessmentReportDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryCountDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryReportDTO;
import com.asymmetrix.asset.entity.AssetLog;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.CMAssetAssessment;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireAssessment;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireCategoryAssessment;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireCategoryAssessmentLog;
import com.asymmetrix.asset.common.utils.AssetUtils;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.dao.AssetLogRepository;
import com.asymmetrix.asset.dao.AssetRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetScoreImliedLevelDTO;
import com.asymmetrix.asset.dto.AssetScoringDTO;
import com.asymmetrix.asset.dto.AssetWithComplianceClassDTO;
import com.asymmetrix.asset.dto.CMAssetAssessmentDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.AssessmentFileUpload;
import com.asymmetrix.asset.entity.AssetAssessmentLog;
import com.asymmetrix.asset.entity.AssetFileUpload;
import com.asymmetrix.asset.entity.AssetLog;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.exception.ResourceNotFoundException;
import com.asymmetrix.asset.service.AssetQuestionnaireCategoryAssessmentService;

@SuppressWarnings("unused")
@Service
public class AssetQuestionnaireCategoryAssessmentServiceImpl implements AssetQuestionnaireCategoryAssessmentService {

	@Autowired
	private AssetQuestionnaireCategoryAssessmentRepository assesmentRepo;

	@Autowired
	private AssetQuestionnaireCategoryAssessmentLogRepository assetLogRepo;



	@Override
	public List<CMAssetQuestionnaireCategoryAssessment> getAllAssetQuestionnaireCategoryAssessment() {
		return this.assesmentRepo.findAllAssessment();
	}

	@Override
	public List<CMAssetQuestionnaireCategoryAssessment> getAllAssetQuestionnaireCategoryAssessmentByActiveflag() {
		return this.assesmentRepo.findAllByActiveflag();
	}

	@Override
	public CMAssetQuestionnaireCategoryAssessment getAssetQuestionnaireCategoryAssessmentById(long assessmentId) {
		return assesmentRepo.findById(assessmentId).orElseThrow(() -> new ResourceNotFoundException(
				"CM-Questionnaire Category Assessment not found with  Id----> " + assessmentId));
	}

	@Override
	public List<CMAssetQuestionnaireCategoryAssessment> getAssetQuestionnaireCategoryAssessmentByAssetId(
			String assetId) {
		return assesmentRepo.findByAssetId(assetId);
	}

	@Override
	public List<CMAssetQuestionnaireCategoryAssessment> getAssetQuestionnaireCategoryAssessmentByAssessmentId(
			String assessmentId) {
		return assesmentRepo.findByAssessmentId(assessmentId);
	}

	@Override
	public CMAssetQuestionnaireCategoryAssessment getAssetQuestionnaireCategoryAssessmentByControlId(
			String assessmentId, String controlId) {
		// System.out.println("assessmentId"+assessmentId+"ControlId"+controlId);
		return assesmentRepo.findByAssessmentIdAndQuestionId(assessmentId, controlId);
	}

	@Override
	public CMAssetQuestionnaireCategoryAssessment createQuestionnaireCategoryAssessment(
			CMAssetQuestionCategoryAssessmentDTO categoryAssessmentDto) {
		categoryAssessmentDto.setDeleteFlag("N");
		categoryAssessmentDto.setActiveFlag("Y");
		AssetQuestionCategoryAssessmentDTO assessmentDTO = MapperUtils.mapToTargetClass(categoryAssessmentDto,
				AssetQuestionCategoryAssessmentDTO.class);
		CMAssetQuestionnaireCategoryAssessment qcAssessment = assesmentRepo
				.save(MapperUtils.mapToTargetClass(assessmentDTO, CMAssetQuestionnaireCategoryAssessment.class));
		return qcAssessment;
	}

	@Override
	public List<CMAssetQuestionnaireCategoryAssessment> saveAllAssetQuestionnaireCategoryAssessment(
			List<CMAssetQuestionnaireCategoryAssessment> assessmentList) {
		return this.assesmentRepo.saveAll(assessmentList);
	}

	public CMAssetQuestionnaireCategoryAssessmentLog updateLogQuestionnaireCategoryAssessment(
			CMAssetQuestionCategoryAssessmentDTO categoryAssessmentDto) {
		CMAssetQuestionnaireCategoryAssessment qcAssessment = getAssetQuestionnaireCategoryAssessmentById(
				categoryAssessmentDto.getAssetQuestionCategoryAssessmentId());
		qcAssessment.setDeleteFlag("D");
		qcAssessment.setActiveFlag("N");
		CMAssetQuestionnaireCategoryAssessmentLog assessmentLog = assetLogRepo
				.save(MapperUtils.mapToTargetClass(qcAssessment, CMAssetQuestionnaireCategoryAssessmentLog.class));
		return assessmentLog;
	}

	@Override
	public CMAssetQuestionnaireCategoryAssessment updateQuestionnaireCategoryAssessment(
			CMAssetQuestionCategoryAssessmentDTO categoryAssessmentDto) {		
		CMAssetQuestionnaireCategoryAssessmentLog assessmentLog = updateLogQuestionnaireCategoryAssessment(
				categoryAssessmentDto);
		categoryAssessmentDto.setDeleteFlag("N");
		categoryAssessmentDto.setActiveFlag("Y");
		AssetQuestionCategoryAssessmentDTO assessmentDto = MapperUtils.mapToTargetClass(categoryAssessmentDto,
				AssetQuestionCategoryAssessmentDTO.class);
		CMAssetQuestionnaireCategoryAssessment qcAssessment = assesmentRepo
				.save(MapperUtils.mapToTargetClass(assessmentDto, CMAssetQuestionnaireCategoryAssessment.class));
		return qcAssessment;
	}

	@Override
	public CMAssetQuestionnaireCategoryAssessment deleteQuestionnaireCategoryAssessment(
			CMAssetQuestionCategoryAssessmentDTO categoryAssessmentDto) {
/*
		AssetQuestionCategoryAssessmentDTO assessmentDTO = MapperUtils.mapToTargetClass(assessmentdto,
				AssetQuestionCategoryAssessmentDTO.class);
		CMAssetQuestionnaireCategoryAssessment cmassessment = MapperUtils.mapToTargetClass(assessmentDTO,
				CMAssetQuestionnaireCategoryAssessment.class);
*/	
		CMAssetQuestionnaireCategoryAssessment qcAssessment = getAssetQuestionnaireCategoryAssessmentById(
				categoryAssessmentDto.getAssetQuestionCategoryAssessmentId());
		qcAssessment.setDeleteFlag("D");
		qcAssessment.setActiveFlag("N");
		return assesmentRepo.save(qcAssessment);
	}

	@Override
	public List<AssetQuestionCategoryAssessmentDTO> getAssetQuestionnaireCategoryAssessmentByList(
			List<Long> assessmentIdList) {
		List<AssetQuestionCategoryAssessmentDTO> assessmentList = new ArrayList<>();
		for (long mapId : assessmentIdList) {
			AssetQuestionCategoryAssessmentDTO detailAssessment = MapperUtils.mapToTargetClass(
					getAssetQuestionnaireCategoryAssessmentById(mapId), AssetQuestionCategoryAssessmentDTO.class);
			assessmentList.add(detailAssessment);
		}
		return assessmentList;
	}

	
}
