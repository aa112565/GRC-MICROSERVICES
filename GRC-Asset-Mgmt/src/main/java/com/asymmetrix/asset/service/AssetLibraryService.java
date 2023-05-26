package com.asymmetrix.asset.service;

import java.util.List;

import com.asymmetrix.asset.dto.AssetAssessmentCountByPieChartDTO;
import com.asymmetrix.asset.dto.AssetAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetWithComplianceClassDTO;
import com.asymmetrix.asset.dto.CMAssetDTO;

import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.entity.CMAsset;

public interface AssetLibraryService {

	List<CMAsset> getAllAsset();

	List<CMAsset> getAllAssetByActiveflag();

	int getAssetCountByActiveflag();

	AssetScoring getAssetScoreByAssetId(String assetId);

	CMAsset getAssetById(long assetId);

	CMAsset createAsset(CMAssetDTO assetdto);

	List<CMAsset> saveAllAsset(List<CMAsset> assetList);

//	AssetLog updateAssetLog(CMAssetDTO assetdto);

	CMAsset updateAsset(CMAssetDTO assetdto);

	CMAsset deleteUpdate(CMAsset cmasset);

	CMAsset deleteAsset(CMAssetDTO assetdto);

	List<CMAssetDTO> getAssetByList(List<Long> biaIdList);

	String fileDelete(String refId);

	String fileDeleteByDocId(String docId);

	String createFiles(AssetAttachmentsDTO assetdto);

	List<AssetFileUploadDTO> downloadFile(String docId);

	List<AssetWithComplianceClassDTO> getAssetListWithComplianceClass();

	List<AssetAssessmentCountByPieChartDTO> getAssetCountListByComplianceClass();

	String deleteAssetList(List<CMAssetDTO> assetListDto, String userName);

}
