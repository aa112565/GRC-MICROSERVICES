package com.asymmetrix.asset.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.asymmetrix.asset.common.aspect.Loggable;
import com.asymmetrix.asset.common.dto.LoginUserDetails;
import com.asymmetrix.asset.common.response.AssetResponseEntity;
import com.asymmetrix.asset.common.utils.MapperUtils;

import com.asymmetrix.asset.dto.AssetReqResDTO;
import com.asymmetrix.asset.dto.CMAssetAssessmentDTO;
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.dto.AssessmentAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetAssessmentCountByChart;
import com.asymmetrix.asset.dto.AssetAssessmentCountByPieChartDTO;
import com.asymmetrix.asset.dto.AssetAssessmentCountDTO;
import com.asymmetrix.asset.dto.AssetAssessmentDTO;
import com.asymmetrix.asset.service.AssessmentFileUploadService;
import com.asymmetrix.asset.service.AssetAssessmentService;
import com.asymmetrix.asset.service.AssetLibraryService;

@RestController
public class AssetAssessmentController {

	@Autowired
	private AssetAssessmentService assetAssessmentLibService;
	@Autowired
	private AssetLibraryService assetLibService;
	@Autowired
	private AssessmentFileUploadService docService;

	private static final String SAVE_ASSET_ASSESSMENT_ACTION = "SAVE-ASSET-ASSESSMENT-DETAILS";
	private static final String EDIT_ASSET_ASSESSMENT_ACTION = "EDIT-ASSET-ASSESSMENT-DETAILS";
	private static final String REMOVE_ASSET_ASSESSMENT_ACTION = "DELETE-ASSET-ASSESSMENT-DETAILS";
	private static final String SAVE_OR_EDIT_FILE_UPLOAD_ACTION = "SAVE-OR-EDIT-FILE-UPLOAD-ASSET-ASSESSMENT-DETAILS";
	private static final String READ_ASSET_ASSESSMENT_ACTION = "READ-ASSET-ASSESSMENT-DETAILS";
	private static final String READ_ALL_ASSET_ASSESSMENT_ACTION = "READ-ALL-ASSET-ASSESSMENT-DETAILS";


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ASSET_ASSESSMENT_ACTION)
//	@GetMapping("/asset/assessment/find/all")
	@PostMapping("/asset/assessment/find/all")
	public ResponseEntity<?> getAllAssetAssessment() {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetAssessmentLibService.getAllAssetAssessmentByActiveflag(), CMAssetAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_ASSESSMENT_ACTION)
//	@GetMapping("/asset/assessment/find/count")
	@PostMapping("/asset/assessment/find/count")
	public ResponseEntity<?> getAllAssetAssessmentCount() {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetAssessmentLibService.getAllAssetAssessmentByCount(), AssetAssessmentCountDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ASSET_ASSESSMENT_ACTION)
	@PostMapping("/asset/assessment/dashboard/charts")
	public AssetAssessmentCountByChart getAllAssetAssessmentCountByChart() {
		AssetAssessmentCountByChart charts = new AssetAssessmentCountByChart();
		List<AssetAssessmentCountByPieChartDTO> pieChart = assetAssessmentLibService
				.getAllAssetAssessmentCountForPieChart();
		charts.setPieChart(pieChart);
		List<AssetAssessmentCountByPieChartDTO> scoreCountDto = assetLibService.getAssetCountListByComplianceClass();
		charts.setCountScoreChart(scoreCountDto);		
		return charts;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ASSET_ASSESSMENT_ACTION)
//	@GetMapping("/asset/assessment/report/Status/{status}")
	@PostMapping("/asset/assessment/report/Status/{status}")
	public ResponseEntity<?> getAllAssetAssessmentCountBasedReports(
			@NonNull @PathVariable(value = "status") String assessmentStatus) {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(
				assetAssessmentLibService.getAllAssetAssessmentByCountBasedReports(assessmentStatus),
				CMAssetDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_ASSESSMENT_ACTION)
	@GetMapping("/asset/assessment/find/{id}")
	public AssetReqResDTO getAssetAssessmentById(@NonNull @PathVariable(value = "id") long assessmentId) {

		AssetReqResDTO resDTO = new AssetReqResDTO();
		AssetAssessmentDTO assetDto = MapperUtils.mapToTargetClass(
				assetAssessmentLibService.getAssetAssessmentById(assessmentId), AssetAssessmentDTO.class);		
		resDTO.setAssetassessmentdto(assetDto);		
		return resDTO;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_ASSESSMENT_ACTION)
	@GetMapping("/asset/assessment/find/asset/{id}")
	public AssetReqResDTO getAssetAssessmentByAssetId(@NonNull @PathVariable(value = "id") String assetDetails) {
		AssetReqResDTO resDTO = new AssetReqResDTO();
		AssetAssessmentDTO assetDto = MapperUtils.mapToTargetClass(
				assetAssessmentLibService.getAssetAssessmentByAssetId(assetDetails), AssetAssessmentDTO.class);
		resDTO.setAssetassessmentdto(assetDto);
		return resDTO;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_FILE_UPLOAD_ACTION)
	@PostMapping("/asset/assessment/attachment/new")
	public AssetReqResDTO createAssetAssessmentAttachment(
			@NonNull @ModelAttribute AssessmentAttachmentsDTO assetattAchment) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		String result = assetAssessmentLibService.createFiles(assetattAchment);
		System.out.println("file Upload result  => " + result);
		List<AssessmentAttachmentsDTO> fileList = MapperUtils.mapToTargetClass(
				docService.getAllDocByRefId(assetattAchment.getRefId()), AssessmentAttachmentsDTO.class);
		resDto.setAssessmentfiles(fileList);
		return resDto;
	}

	@GetMapping("/asset/assessment/attachment/download/{refId}")
	public ResponseEntity<?> downloadFile(@NonNull @PathVariable String refId) {
		return AssetResponseEntity.success(MapperUtils.mapToTargetClass(assetAssessmentLibService.downloadFile(refId),
				AssessmentAttachmentsDTO.class));
	}

	@PutMapping("/asset/assessment/attachment/remove/{docId}")
	public ResponseEntity<?> deleteFile(@NonNull @PathVariable String docId) {
		String attachment = null;
		try {
			attachment = assetAssessmentLibService.fileDeleteByDocId(docId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AssetResponseEntity.success(attachment);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_ASSET_ASSESSMENT_ACTION)
	@PostMapping("/asset/assessment/new")
	public ResponseEntity<?> createAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetAssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setCreatedBy(loginUserDetails.getUsername());		
		return AssetResponseEntity.success(MapperUtils
				.mapToTargetClass(assetAssessmentLibService.createAssessment(assessmentDto), CMAssetAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = EDIT_ASSET_ASSESSMENT_ACTION)
	@PutMapping("/asset/assessment/modify")
	public ResponseEntity<?> updateAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetAssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());
		// assetdto.setStatus("Initiated");
		
		return AssetResponseEntity.success(MapperUtils
				.mapToTargetClass(assetAssessmentLibService.updateAssessment(assessmentDto), CMAssetAssessmentDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_ASSET_ASSESSMENT_ACTION)
	@PutMapping("/asset/assessment/remove")
	public ResponseEntity<?> deleteAssessment(Authentication auth,
			@NonNull @RequestBody CMAssetAssessmentDTO assessmentDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assessmentDto.setModifiedBy(loginUserDetails.getUsername());		
		return AssetResponseEntity.success(MapperUtils
				.mapToTargetClass(assetAssessmentLibService.deleteAssessment(assessmentDto), CMAssetAssessmentDTO.class));
	}

	
}
