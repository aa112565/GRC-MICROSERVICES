package com.asymmetrix.asset.service;

import java.util.List;

import com.asymmetrix.asset.dto.AssessmentAttachmentsDTO;
import com.asymmetrix.asset.dto.AssessmentFileUploadDTO;
import com.asymmetrix.asset.dto.AssetAssessmentCountByPieChartDTO;
import com.asymmetrix.asset.dto.AssetAssessmentCountDTO;
import com.asymmetrix.asset.dto.CMAssetAssessmentDTO;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.CMAssetAssessment;

public interface AssetAssessmentService {

	List<CMAssetAssessment> getAllAssetAssessment();

	List<CMAssetAssessment> getAllAssetAssessmentByActiveflag();

	List<CMAsset> getAllAssetAssessmentByCountBasedReports(String status);

	AssetAssessmentCountDTO getAllAssetAssessmentByCount();

	CMAssetAssessment getAssetAssessmentById(long assessmentId);

	CMAssetAssessment getAssetAssessmentByAssetId(String assetDetails);

	CMAssetAssessment createAssessment(CMAssetAssessmentDTO assessmentDto);

	List<CMAssetAssessment> saveAllAssetAssessment(List<CMAssetAssessment> assessmentList);

	CMAssetAssessment updateAssessment(CMAssetAssessmentDTO assessmentDto);

	CMAssetAssessment deleteAssessment(CMAssetAssessmentDTO assessmentDto);

	List<CMAssetAssessmentDTO> getAssetAssessmentByList(List<Long> assessmentIdList);

	List<AssetAssessmentCountByPieChartDTO> getAllAssetAssessmentCountForPieChart();

	String createFiles(AssessmentAttachmentsDTO assetAttachment);

	String fileDeleteByDocId(String docId);

	List<AssessmentFileUploadDTO> downloadFile(String refId);

}
