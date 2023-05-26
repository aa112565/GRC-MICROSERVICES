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
import com.asymmetrix.asset.dao.AssetRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.dto.AssessmentAttachmentsDTO;
import com.asymmetrix.asset.dto.AssessmentFileUploadDTO;
import com.asymmetrix.asset.dto.AssetAssessmentCountByPieChartDTO;
import com.asymmetrix.asset.dto.AssetAssessmentCountDTO;
import com.asymmetrix.asset.dto.AssetAssessmentDTO;
import com.asymmetrix.asset.dto.AssetAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetScoreCountByComplianceClassDTO;
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.entity.AssetLog;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.CMAssetAssessment;
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
import com.asymmetrix.asset.service.AssessmentFileUploadService;
import com.asymmetrix.asset.service.AssetAssessmentService;
import com.asymmetrix.asset.service.AssetLibraryService;

@SuppressWarnings("unused")
@Service
public class AssetAssessmentServiceImpl implements AssetAssessmentService {

	@Autowired
	private AssetAssessmentRepository assesmentRepo;

	@Autowired
	private AssetLibraryService assetLibService;

	@Autowired
	private AssetAssessmentLogRepository assetLogRepo;

	@Autowired
	private AssessmentFileUploadService docService;

	AssessmentFileUploadDTO fileupload;

	@Override
	public List<CMAssetAssessment> getAllAssetAssessment() {
		return this.assesmentRepo.findAllAssessment();
	}

	@Override
	public List<CMAssetAssessment> getAllAssetAssessmentByActiveflag() {
		return this.assesmentRepo.findAllByActiveflag();
	}

	@Override
	public List<CMAsset> getAllAssetAssessmentByCountBasedReports(String status) {
		List<CMAssetAssessment> temprecords = assesmentRepo.findAllByAssessmentStatus(status);
		List<CMAsset> tempassetlist = new ArrayList<>();
		for (CMAssetAssessment asset : temprecords) {
			CMAsset tempasset = new CMAsset();
			tempasset = assetLibService.getAssetById(Long.parseLong(asset.getAssetDetails()));
			tempassetlist.add(tempasset);
		}
		return tempassetlist;
	}

	@Override
	public AssetAssessmentCountDTO getAllAssetAssessmentByCount() {
		AssetAssessmentCountDTO assessmentcountdto = new AssetAssessmentCountDTO();
		assessmentcountdto.setAssetTotalCount(String.valueOf(assetLibService.getAssetCountByActiveflag()));
		assessmentcountdto.setAssessmentTotalCount(String.valueOf(assesmentRepo.findTotalCount()));
		assessmentcountdto.setAssessmentInitiatedCount(String.valueOf(assesmentRepo.findCountByInitated()));
		assessmentcountdto.setAssessmentInprogressCount(String.valueOf(assesmentRepo.findCountByInprogress()));
		assessmentcountdto.setAssessmentCompletedCount(String.valueOf(assesmentRepo.findCountByCompleted()));
		return assessmentcountdto;
	}

	@Override
	public List<AssetAssessmentCountByPieChartDTO> getAllAssetAssessmentCountForPieChart() {
		AssetAssessmentCountByPieChartDTO assessmentCountDto;
		List<AssetAssessmentCountByPieChartDTO> pieChartData = new ArrayList<>();		
		
		int totalCount = assetLibService.getAssetCountByActiveflag();
		assessmentCountDto = new AssetAssessmentCountByPieChartDTO();
		int initiatedCount = assesmentRepo.findCountByInitated();
		double tempInitiatedCount = (initiatedCount * 100 / totalCount);
		assessmentCountDto.setName("Initiated");
		assessmentCountDto.setValue(String.valueOf(tempInitiatedCount));
		pieChartData.add(assessmentCountDto);

		assessmentCountDto = new AssetAssessmentCountByPieChartDTO();
		int inprogressCount = assesmentRepo.findCountByInprogress();
		double tempInprogressCount = (inprogressCount * 100 / totalCount);
		assessmentCountDto.setName("Inprogress");
		assessmentCountDto.setValue(String.valueOf(tempInprogressCount));
		pieChartData.add(assessmentCountDto);

		assessmentCountDto = new AssetAssessmentCountByPieChartDTO();
		int completedCount = assesmentRepo.findCountByCompleted();
		double tempCompletedCount = (completedCount * 100 / totalCount);
		assessmentCountDto.setName("Completed");
		assessmentCountDto.setValue(String.valueOf(tempCompletedCount));
		pieChartData.add(assessmentCountDto);

		return pieChartData;
	}

	@Override
	public CMAssetAssessment getAssetAssessmentById(long assessmentId) {
		return assesmentRepo.findById(assessmentId).orElseThrow(
				() -> new ResourceNotFoundException("CM-Assessment not found with  Id----> " + assessmentId));
	}

	@Override
	public CMAssetAssessment getAssetAssessmentByAssetId(String assetDetails) {
		return assesmentRepo.findByAssetId(assetDetails);
	}

	@Override
	public CMAssetAssessment createAssessment(CMAssetAssessmentDTO assessmentDto) {
		assessmentDto.setStatus("Initiated");
		assessmentDto.setDeleteFlag("N");
		assessmentDto.setActiveFlag("Y");
		AssetAssessmentDTO assetAssessmentDto = MapperUtils.mapToTargetClass(assessmentDto, AssetAssessmentDTO.class);
		CMAssetAssessment cmAssessment = assesmentRepo
				.save(MapperUtils.mapToTargetClass(assetAssessmentDto, CMAssetAssessment.class));
		return cmAssessment;
	}

	@Override
	public List<CMAssetAssessment> saveAllAssetAssessment(List<CMAssetAssessment> assessmentList) {
		return this.assesmentRepo.saveAll(assessmentList);
	}

//	@Override
	public AssetAssessmentLog updateLogAssessment(CMAssetAssessmentDTO assessmentdto) {
		CMAssetAssessment cmAssessment = getAssetAssessmentById(assessmentdto.getAssessmentId());
		cmAssessment.setDeleteFlag("D");
		cmAssessment.setActiveFlag("N");
		AssetAssessmentLog assessmentlog = assetLogRepo
				.save(MapperUtils.mapToTargetClass(cmAssessment, AssetAssessmentLog.class));
		return assessmentlog;
	}

	@Override
	public CMAssetAssessment updateAssessment(CMAssetAssessmentDTO assessmentDto) {		
		AssetAssessmentLog assessmentlog = updateLogAssessment(assessmentDto);
		assessmentDto.setDeleteFlag("N");
		assessmentDto.setActiveFlag("Y");
		AssetAssessmentDTO assetAssessmentDto = MapperUtils.mapToTargetClass(assessmentDto, AssetAssessmentDTO.class);
		CMAssetAssessment cmAssessment = assesmentRepo
				.save(MapperUtils.mapToTargetClass(assetAssessmentDto, CMAssetAssessment.class));
		return cmAssessment;
	}

	@Override
	public CMAssetAssessment deleteAssessment(CMAssetAssessmentDTO assessmentDto) {
	
		CMAssetAssessment cmAssessment = getAssetAssessmentById(assessmentDto.getAssessmentId());
		cmAssessment.setDeleteFlag("D");
		cmAssessment.setActiveFlag("N");
		return assesmentRepo.save(cmAssessment);
	}

	@Override
	public List<CMAssetAssessmentDTO> getAssetAssessmentByList(List<Long> assessmentIdList) {
		List<CMAssetAssessmentDTO> assessmentList = new ArrayList<>();
		for (long mapId : assessmentIdList) {
			CMAssetAssessmentDTO detailAssessment = MapperUtils.mapToTargetClass(getAssetAssessmentById(mapId),
					CMAssetAssessmentDTO.class);
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
					fileupload = new AssessmentFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), assetdto.getRefId());
					AssessmentFileUpload upload = docService.createDoc(fileupload);
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
				System.out.println(file.getContentType() + "-=--=> " + file.getOriginalFilename());
				try {
					fileupload = new AssessmentFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), String.valueOf(assetdto.getAssessmentId()));
					AssessmentFileUpload upload = docService.createDoc(fileupload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";
	}

	// file delete
	public String fileDelete(String refId) throws IOException {
		List<AssessmentFileUpload> existFileList = docService.getAllDocByRefId(refId);
		for (AssessmentFileUpload file : existFileList) {
			docService.deleteUpdate(file);
		}
		return "success";
	}

	// file delete
	public String fileDeleteByDocId(String docId) {
		AssessmentFileUpload existfile = docService.deleteUpdate(docId);
		return "success";
	}

	@Transactional
	public String createFiles(AssessmentAttachmentsDTO assetDto) {
		// int testcount = assetdto.getFile().length;
		// System.out.println("file count => "+ testcount);
		if (!assetDto.getFiles()[0].isEmpty()) {
			String fileupload = fileUpload(assetDto);
		}
		return "succuess";
	}

	public List<AssessmentFileUploadDTO> downloadFile(String docId) {
		List<AssessmentFileUploadDTO> attachments = docService.downloadFile(docId);
		AssetUtils.isValid(attachments, "No Attachment found !");
		// return MapperUtils.mapToTargetClass(attachments, AssetAttachmentsDTO.class);
		return attachments;
	}

	
}
