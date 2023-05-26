package com.asymmetrix.asset.service;

import java.util.List;

import com.asymmetrix.asset.dto.AssessmentFileUploadDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.entity.AssessmentFileUpload;

public interface AssessmentFileUploadService {

	public List<AssessmentFileUpload> getAllDoc();

	public List<AssessmentFileUpload> getAllDocByRefId(String refId);

	public AssessmentFileUpload getDocById(String docId);

	public AssessmentFileUpload createDoc(AssessmentFileUploadDTO docdto);

	public List<AssessmentFileUpload> saveAllDoc(List<AssessmentFileUpload> docList);

	public AssessmentFileUpload updateDoc(AssessmentFileUploadDTO docdto);

	public AssessmentFileUpload deleteUpdate(AssessmentFileUpload assetDoc);

	public AssessmentFileUpload deleteUpdate(String docId);

	public AssessmentFileUpload deleteDoc(AssetFileUploadDTO docdto);

	public List<AssessmentFileUploadDTO> getDocByList(List<String> assetIdList);

	public List<AssessmentFileUploadDTO> downloadFile(String refId);

}
