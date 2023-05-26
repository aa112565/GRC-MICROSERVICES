package com.asymmetrix.asset.service;

import java.util.List;

import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.entity.AssetFileUpload;

public interface AssetFileUploadService {

//	List<AssetFileUpload> getAllDoc();

	List<AssetFileUpload> getAllDocByRefId(String refId);

	AssetFileUpload getDocById(String docId);

	AssetFileUpload createDoc(AssetFileUploadDTO docDto);

	List<AssetFileUpload> saveAllDoc(List<AssetFileUpload> docList);

	AssetFileUpload updateDoc(AssetFileUploadDTO docDto);

	AssetFileUpload deleteUpdate(String docId);

	AssetFileUpload deleteDoc(AssetFileUploadDTO docDto);

	List<AssetFileUploadDTO> getDocByList(List<String> assetIdList);

	List<AssetFileUploadDTO> downloadFile(String refId);
}
