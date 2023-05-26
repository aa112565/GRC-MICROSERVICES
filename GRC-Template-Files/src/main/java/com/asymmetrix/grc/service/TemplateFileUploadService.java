package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.TemplateAttachmentsDTO;
import com.asymmetrix.grc.dto.TemplateFileUploadDTO;
import com.asymmetrix.grc.entity.TemplateFileUpload;


public interface TemplateFileUploadService {

//	List<AssetFileUpload> getAllDoc();

	List<TemplateFileUpload> getAllDocByRefId(String refId);

	TemplateFileUpload getDocById(String docId);

	TemplateFileUpload createDoc(TemplateFileUploadDTO templateDocDto);

//	List<AuditFileUpload> saveAllDoc(List<AuditFileUpload> docList);

//	TemplateFileUpload updateDoc(TemplateFileUploadDTO templateDocDto);
	
//	TemplateFileUpload deleteDoc(TemplateFileUploadDTO templateDocDto);

	TemplateFileUpload deleteDocUpdate(String docId);	
	
//	TemplateFileUpload deleteUpdate(TemplateFileUpload templateDoc);

	List<TemplateFileUploadDTO> getDocByList(List<String> templateDocIdList);

	List<TemplateFileUploadDTO> findAllAttachment(String refId);
	
	int findCountByActiveflag(String refId);
	
	String fileDelete(String refId);

	String fileDeleteByDocId(String docId);

//	String createFiles(TemplateAttachmentsDTO assetdto);

	TemplateFileUploadDTO downloadFile(String docId);

	String createFiles(TemplateAttachmentsDTO vendorDto, String userName);

	List<TemplateFileUploadDTO> findAttachmentHistory(String refId, String docName);
}
