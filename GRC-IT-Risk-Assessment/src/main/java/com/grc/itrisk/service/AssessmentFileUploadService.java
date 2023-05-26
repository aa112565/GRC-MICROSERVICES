package com.grc.itrisk.service;

import java.util.List;

import com.grc.itrisk.dto.AssessmentFileUploadDTO;
import com.grc.itrisk.entity.AssessmentFileUpload;

public interface AssessmentFileUploadService {

//	List<AssetFileUpload> getAllDoc();

	List<AssessmentFileUpload> getAllDocByRefId(String refId);

	AssessmentFileUpload getDocById(String docId);

	AssessmentFileUpload createDoc(AssessmentFileUploadDTO vendorDocDto);

//	List<AuditFileUpload> saveAllDoc(List<AuditFileUpload> docList);

	AssessmentFileUpload updateDoc(AssessmentFileUploadDTO vendorDocDto);
	
	AssessmentFileUpload deleteDoc(AssessmentFileUploadDTO vendorDocDto);

	AssessmentFileUpload deleteDocUpdate(String docId);	
	
	AssessmentFileUpload deleteUpdate(AssessmentFileUpload vendorDoc);

	List<AssessmentFileUploadDTO> getDocByList(List<String> vendorDocIdList);

	List<AssessmentFileUploadDTO> findAllAttachment(String refId);
	
	int findCountByActiveflag(String refId);
}
