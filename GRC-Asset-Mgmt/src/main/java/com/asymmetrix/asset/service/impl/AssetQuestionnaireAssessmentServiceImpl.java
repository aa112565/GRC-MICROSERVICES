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
import com.asymmetrix.asset.dao.AssetQuestionnaireAssessmentLogRepository;
import com.asymmetrix.asset.dao.AssetQuestionnaireAssessmentRepository;
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
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.dto.CMAssetQuestionAssessmentDTO;
import com.asymmetrix.asset.dto.CMAssetQuestionCategoryAssessmentDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryAssessmentReportDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryCountDTO;
import com.asymmetrix.asset.dto.QuestionnaireCategoryReportDTO;
import com.asymmetrix.asset.entity.AssetLog;
import com.asymmetrix.asset.entity.AssetQuestionnaireAssessmentLog;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.CMAssetAssessment;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireAssessment;
import com.asymmetrix.asset.entity.CMAssetQuestionnaireCategoryAssessment;
import com.asymmetrix.asset.common.utils.AssetUtils;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.controller.AssetQuestionnaireCategoryAssessmentController;
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
import com.asymmetrix.asset.service.AssessmentFileUploadService;
import com.asymmetrix.asset.service.AssetAssessmentService;
import com.asymmetrix.asset.service.AssetQuestionnaireAssessmentService;

@SuppressWarnings("unused")
@Service
public class AssetQuestionnaireAssessmentServiceImpl implements AssetQuestionnaireAssessmentService {

	@Autowired
	private AssetAssessmentService assetAssessmentLibService;

	@Autowired
	private AssetQuestionnaireAssessmentRepository assesmentRepo;

	@Autowired
	private AssetQuestionnaireCategoryAssessmentRepository assesmentCategoryRepo;

	@Autowired
	private AssetQuestionnaireAssessmentLogRepository assetLogRepo;

	@Autowired
	private AssessmentFileUploadService docService;

	@Autowired
	private AssetQuestionnaireCategoryAssessmentServiceImpl assetQuestionnaireCategoryAssessmentLibService;

	AssessmentFileUploadDTO fileUpload;

	@Override
	public List<CMAssetQuestionnaireAssessment> getAllAssetQuestionnaireAssessment() {
		return this.assesmentRepo.findAllAssessment();
	}

	@Override
	public List<CMAssetQuestionnaireAssessment> getAllAssetQuestionnaireAssessmentByActiveflag() {
		return this.assesmentRepo.findAllByActiveflag();
	}

	@Override
	public CMAssetQuestionnaireAssessment getAssetQuestionnaireAssessmentById(long assessmentId) {
		return assesmentRepo.findById(assessmentId).orElseThrow(() -> new ResourceNotFoundException(
				"CM-Questionnaire Assessment not found with  Id----> " + assessmentId));
	}

	@Override
	public List<CMAssetQuestionnaireAssessment> getAssetQuestionnaireAssessmentByAssetId(String assetId) {
		return assesmentRepo.findByAssetId(assetId);
	}

	@Override
	public List<CMAssetQuestionnaireAssessment> getAssetQuestionnaireAssessmentByAssessmentId(String assessmentId) {
		return assesmentRepo.findByAssessmentId(assessmentId);
	}

	/*
	 * public List<CMAssetQuestionnaireAssessment>
	 * getAssetQuestionnaireAssessmentByControlId(String controlId) { return
	 * assesmentRepo.findByControlId(controlId); }
	 */

	@Override
	public List<QuestionnaireCategoryCountDTO> getAssetQuestionnaireAssessmentCountByAssessmentIdAndControlId(
			String assessmentId, List<QuestionnaireCategoryCountDTO> assetCountDto) {
		List<QuestionnaireCategoryCountDTO> countDto = new ArrayList<>();
		int count = assesmentRepo.findCountByAssessmentId(assessmentId);
		// System.out.println("Assessment-Id"+assessmentId
		// +"=========================="+"Count"+count);
		if (count > 0) {
			int tempToalCount = 0;
			int tempCompletedCount = 0;
			for (QuestionnaireCategoryCountDTO tempList : assetCountDto) {
				QuestionnaireCategoryCountDTO tempDto = new QuestionnaireCategoryCountDTO();
				int totalCount = Integer.parseInt(tempList.getTotalCount());
				tempToalCount = tempToalCount + totalCount;
				// int completedCount =
				// assesmentRepo.findCountByControlId(templist.getCategoryId());
				int completedCount = assesmentRepo.findCountByAssessmentIdAndControlId(assessmentId,
						tempList.getCategoryId());
				tempCompletedCount = tempCompletedCount + completedCount;

				// status update for category based assessment
				if (totalCount == completedCount) {
					int categoryUpdateCount = assesmentCategoryRepo.findCountByAssessmentIdAndControlId(assessmentId,
							tempList.getCategoryId());
					if (categoryUpdateCount == 0) {
						CMAssetQuestionnaireCategoryAssessment tempStatus = assessmentCategoryStatusUpdateForCompleted(
								assessmentId, tempList.getCategoryId());
						// System.out.println("Control-Id"+tempstatus.getControlId() +"==========status
						// update for category based
						// assessment================"+"category-update-status"+tempstatus.getStatus());

					}
				}
				if (tempToalCount == tempCompletedCount) {
					assessmentStatusUpdateForCompleted(assessmentId);
				}
				if (tempToalCount != tempCompletedCount) {
					assessmentStatusUpdateForInprogress(assessmentId, tempList.getCategoryId());
				}
				// System.out.println("Count"+totalcount
				// +"=========================="+"completedCount"+completedCount);
				// System.out.println("Total-count"+temptoalcount
				// +"=========================="+"Total-completedCount"+tempcompletedcount);

				tempDto.setCategoryId(tempList.getCategoryId());
				tempDto.setCategory(tempList.getCategory());
				tempDto.setTotalCount(tempList.getTotalCount());
				tempDto.setCompletedCount(String.valueOf(completedCount));

				countDto.add(tempDto);
			}
			return countDto;
		} else {
			return assetCountDto;
		}
	}

	@Override
	public List<QuestionnaireCategoryAssessmentReportDTO> getAssetQuestionnaireAssessmentReportByAssessmentId(
			String assessmentId, List<QuestionnaireCategoryReportDTO> assetReportDto) {
		List<QuestionnaireCategoryAssessmentReportDTO> reportsDto = new ArrayList<>();
		// System.out.println("Assessment-Id"+assessmentId);
		for (QuestionnaireCategoryReportDTO tempList : assetReportDto) {
			// QuestionnaireCategoryAssessmentReportDTO tempDto = new
			// QuestionnaireCategoryAssessmentReportDTO();
			QuestionnaireCategoryAssessmentReportDTO tempDto = MapperUtils.mapToTargetClass(tempList,
					QuestionnaireCategoryAssessmentReportDTO.class);
			int tempCount = assesmentRepo.findCountByAssessmentIdAndQuestionId(assessmentId,
					tempDto.getQuestionnaireId());
			// System.out.println("Question-Id"
			// +templist.getQuestionnaireId()+"=========================="+"Count"+tempCount);
			if (tempCount > 0) {
				CMAssetQuestionnaireAssessment tempQuestAssessment = assesmentRepo
						.findByAssessmentIdAndQuestionId(assessmentId, tempDto.getQuestionnaireId());
				tempDto.setAssessmentEvidenceType(tempQuestAssessment.getEvidenceType());
				tempDto.setResponsibility(tempQuestAssessment.getResponsibility());
				tempDto.setRemarks(tempQuestAssessment.getRemarks());
				tempDto.setStatus(tempQuestAssessment.getStatus());
			}
			reportsDto.add(tempDto);
		}
		return reportsDto;
	}

	@Override
	public CMAssetQuestionnaireAssessment getAssetQuestionnaireAssessmentByQuestionId(String assessmentId,
			String controlId, String questionId) {
		// System.out.println("assessmentId"+assessmentId+"ControlId"+conrolId+"questionId"+questionId);
		return assesmentRepo.findByAssessmentIdAndControlIdAndQuestionId(assessmentId, controlId, questionId);
	}

	@Override
	public CMAssetQuestionnaireAssessment createQuestionnaireAssessment(CMAssetQuestionAssessmentDTO assessmentDto) {
		assessmentDto.setDeleteFlag("N");
		assessmentDto.setActiveFlag("Y");
		AssetQuestionAssessmentDTO assessmentDTO = MapperUtils.mapToTargetClass(assessmentDto,
				AssetQuestionAssessmentDTO.class);
		CMAssetQuestionnaireAssessment cmassessment = assesmentRepo
				.save(MapperUtils.mapToTargetClass(assessmentDTO, CMAssetQuestionnaireAssessment.class));
		assessmentStatusUpdateForInprogress(cmassessment.getAssessmentId(), cmassessment.getControlId());
		return cmassessment;
	}

	@Override
	public CMAssetQuestionnaireCategoryAssessment assessmentCategoryStatusUpdateForCompleted(String assessmentId,
			String categoryId) {
		// System.out.println("+++++++++inside+++assessmentCategoryStatusUpdateForCompleted++++++++++++++++");
		// CMAssetQuestionnaireAssessment temprecord =
		// assesmentRepo.findByAssessmentIdAndControlId(assessmentId, categoryId);

		CMAssetAssessmentDTO tempAssessment = MapperUtils.mapToTargetClass(
				assetAssessmentLibService.getAssetAssessmentById(Long.parseLong(assessmentId)),
				CMAssetAssessmentDTO.class);
		CMAssetQuestionCategoryAssessmentDTO categoryDto = new CMAssetQuestionCategoryAssessmentDTO();
		categoryDto.setAssessmentId(assessmentId);
		categoryDto.setAssetId(tempAssessment.getAssetDetails());
		categoryDto.setControlId(categoryId);
		categoryDto.setStatus("Completed");
		categoryDto.setActiveFlag("Y");
		categoryDto.setDeleteFlag("N");
		categoryDto.setCreatedBy("Admin");
		CMAssetQuestionnaireCategoryAssessment catDto = assetQuestionnaireCategoryAssessmentLibService
				.createQuestionnaireCategoryAssessment(categoryDto);
		return catDto;
	}

	
	public void assessmentStatusUpdateForCompleted(String assessmentId) {
		CMAssetAssessmentDTO tempAssessment = MapperUtils.mapToTargetClass(
				assetAssessmentLibService.getAssetAssessmentById(Long.parseLong(assessmentId)),
				CMAssetAssessmentDTO.class);
		tempAssessment.setStatus("Completed");
		tempAssessment.setModifiedBy("Admin");
		CMAssetAssessment cmAssessment = MapperUtils
				.mapToTargetClass(assetAssessmentLibService.updateAssessment(tempAssessment), CMAssetAssessment.class);
		// System.out.println("Assessment-Id" + assessmentId + "==========status update
		// for assessment================"
		// + "Assessment-update-status" + cmAssessment.getStatus());
	}

	
	public void assessmentStatusUpdateForInprogress(String assessmentId, String controlId) {
		int tempCount = assesmentRepo.findCountByAssessmentIdAndControlId(assessmentId, controlId);
		if (tempCount > 0 && tempCount < 2) {
			CMAssetAssessmentDTO tempAssessment = MapperUtils.mapToTargetClass(
					assetAssessmentLibService.getAssetAssessmentById(Long.parseLong(assessmentId)),
					CMAssetAssessmentDTO.class);
			tempAssessment.setStatus("Inprogress");
			tempAssessment.setModifiedBy("Admin");
			CMAssetAssessment cmcategoryassessment = MapperUtils.mapToTargetClass(
					assetAssessmentLibService.updateAssessment(tempAssessment), CMAssetAssessment.class);
			// System.out.println("Assessment-Id"+cmcategoryassessment.getAssessmentId()
			// +"==========status update for
			// assessment================"+"Assessment-update-status"+cmcategoryassessment.getStatus());
		}
	}

	@Override
	public List<CMAssetQuestionnaireAssessment> saveAllAssetQuestionnaireAssessment(
			List<CMAssetQuestionnaireAssessment> assessmentList) {
		List<CMAssetQuestionnaireAssessment> templist = assesmentRepo.saveAll(assessmentList);
		return templist;
	}

	public AssetQuestionnaireAssessmentLog updateLogQuestionnaireAssessment(
			CMAssetQuestionAssessmentDTO assessmentDto) {
		CMAssetQuestionnaireAssessment cmAssessment = getAssetQuestionnaireAssessmentById(
				assessmentDto.getAssetQuestionAssessmentId());
		cmAssessment.setDeleteFlag("D");
		cmAssessment.setActiveFlag("N");
		AssetQuestionnaireAssessmentLog assessmentlog = assetLogRepo
				.save(MapperUtils.mapToTargetClass(cmAssessment, AssetQuestionnaireAssessmentLog.class));
		return assessmentlog;
	}

	@Override
	public CMAssetQuestionnaireAssessment updateQuestionnaireAssessment(CMAssetQuestionAssessmentDTO assessmentDto) {
		AssetQuestionnaireAssessmentLog assessmentLog = updateLogQuestionnaireAssessment(assessmentDto);
		assessmentDto.setDeleteFlag("N");
		assessmentDto.setActiveFlag("Y");
		AssetQuestionAssessmentDTO QuestionAssessmentDto = MapperUtils.mapToTargetClass(assessmentDto,
				AssetQuestionAssessmentDTO.class);
		CMAssetQuestionnaireAssessment cmAssessment = assesmentRepo
				.save(MapperUtils.mapToTargetClass(QuestionAssessmentDto, CMAssetQuestionnaireAssessment.class));
		return cmAssessment;
	}

	@Override
	public CMAssetQuestionnaireAssessment deleteQuestionnaireAssessment(CMAssetQuestionAssessmentDTO assessmentDto) {

		// AssetQuestionAssessmentDTO assessmentDTO =
		// MapperUtils.mapToTargetClass(assessmentdto,
		// AssetQuestionAssessmentDTO.class);
		// CMAssetQuestionnaireAssessment cmassessment =
		// MapperUtils.mapToTargetClass(assessmentDTO,
		// CMAssetQuestionnaireAssessment.class);

		CMAssetQuestionnaireAssessment cmAssessment = getAssetQuestionnaireAssessmentById(
				assessmentDto.getAssetQuestionAssessmentId());
		cmAssessment.setDeleteFlag("D");
		cmAssessment.setActiveFlag("N");
		return assesmentRepo.save(cmAssessment);
	}

	@Override
	public List<AssetQuestionAssessmentDTO> getAssetQuestionnaireAssessmentByList(List<Long> assessmentIdList) {
		List<AssetQuestionAssessmentDTO> assessmentList = new ArrayList<>();
		for (long mapId : assessmentIdList) {
			AssetQuestionAssessmentDTO detailAssessment = MapperUtils
					.mapToTargetClass(getAssetQuestionnaireAssessmentById(mapId), AssetQuestionAssessmentDTO.class);
			assessmentList.add(detailAssessment);
		}
		return assessmentList;
	}

	// file upload
	private String fileUpload(AssessmentAttachmentsDTO assetdto) {
		if (!assetdto.getFiles()[0].isEmpty()) {
			for (MultipartFile file : assetdto.getFiles()) {
				// System.out.println(assetdto.getFiles().getContentType() + "-=--=> "+
				// assetdto.getFile().getOriginalFilename());
				try {
					fileUpload = new AssessmentFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), assetdto.getRefId());
					AssessmentFileUpload upload = docService.createDoc(fileUpload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";
	}

	// file upload
	private String fileUpload(CMAssetAssessmentDTO assetdto) {
		if (!assetdto.getFiles()[0].isEmpty()) {
			for (MultipartFile file : assetdto.getFiles()) {
				// System.out.println(file.getContentType() + "-=--=> "+
				// file.getOriginalFilename());
				try {
					fileUpload = new AssessmentFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), String.valueOf(assetdto.getAssessmentId()));
					AssessmentFileUpload upload = docService.createDoc(fileUpload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";
	}

	// file delete
	public String fileDelete(String refId) {
		List<AssessmentFileUpload> existfilelist = docService.getAllDocByRefId(refId);
		for (AssessmentFileUpload file : existfilelist) {
			docService.deleteUpdate(file);
		}
		return "success";
	}

	// file delete
	@Override
	public String fileDeleteByDocId(String docId) {
		AssessmentFileUpload existfile = docService.deleteUpdate(docId);
		return "success";
	}

	@Override
	@Transactional
	public String createFiles(AssessmentAttachmentsDTO attachmentDto) {
		// int testcount = assetdto.getFile().length;
		// System.out.println("file count => "+ testcount);
		if (!attachmentDto.getFiles()[0].isEmpty()) {
			String fileupload = fileUpload(attachmentDto);
		}
		return "succuess";
	}

	@Override
	public List<AssessmentFileUploadDTO> downloadFile(String docId) {
		List<AssessmentFileUploadDTO> attachments = docService.downloadFile(docId);
		AssetUtils.isValid(attachments, "No Attachment found !");
		return attachments;
	}

}
