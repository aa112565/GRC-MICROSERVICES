package com.asymmetrix.grc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.exception.ResourceNotFoundException;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.TemplateAttachmentsDTO;
import com.asymmetrix.grc.dto.TemplateFileUploadDTO;
import com.asymmetrix.grc.entity.TemplateFileUpload;
import com.asymmetrix.grc.repository.TemplateUploadRepository;
import com.asymmetrix.grc.service.TemplateFileUploadService;



@SuppressWarnings("unused")
@Service
public class TemplateUploadServiceImpl implements TemplateFileUploadService {

	@Autowired
	private TemplateUploadRepository documentRepo;

	TemplateFileUploadDTO fileUpload;

	
	@Override
	public List<TemplateFileUpload> getAllDocByRefId(String refId) {
		return this.documentRepo.getAllByRefId(refId);
	}

	@Override
	public TemplateFileUpload getDocById(String docId) {
		return documentRepo.findById(docId).orElseThrow(
				() -> new ResourceNotFoundException("GRC-Template Management - Document not found with  Id----> " + docId));
	}
	
	@Override
	public int findCountByActiveflag(String refId) {
		int attachments = documentRepo.findCountByActiveflag(refId);
		return attachments;
	}
	
	@Override
	public List<TemplateFileUploadDTO> findAllAttachment(String refId) {
		List<TemplateFileUploadDTO> attachments = MapperUtils.mapToTargetClass(documentRepo.getAllDocByRefId(refId),
				TemplateFileUploadDTO.class);
		return attachments;
	}
	
	
	@Override
	public List<TemplateFileUploadDTO> findAttachmentHistory(String refId, String docName) {
		List<TemplateFileUploadDTO> attachments = MapperUtils.mapToTargetClass(documentRepo.getDocHistory(refId, docName),
				TemplateFileUploadDTO.class);
		return attachments;
	}
	
	
	

	@Override
	public TemplateFileUpload createDoc(TemplateFileUploadDTO docDto) {
		TemplateFileUpload templateDoc = MapperUtils.mapToTargetClass(docDto, TemplateFileUpload.class);
		templateDoc.setDeleteFlag("N");
		templateDoc.setActiveFlag("Y");
		return this.documentRepo.save(templateDoc);
	}
	
	
	
	@Override
	public TemplateFileUpload deleteDocUpdate(String docId) {
		TemplateFileUpload existingAuditDoc = getDocById(docId);
		existingAuditDoc.setDeleteFlag("D");
		existingAuditDoc.setActiveFlag("N");
		return this.documentRepo.save(existingAuditDoc);
	}

	@Override
	public List<TemplateFileUploadDTO> getDocByList(List<String> templateDocIdList) {
		List<TemplateFileUploadDTO> templateDocList = new ArrayList<>();
		for (String mapId : templateDocIdList) {
			TemplateFileUploadDTO docInfo = MapperUtils.mapToTargetClass(getDocById(mapId), TemplateFileUploadDTO.class);
			templateDocList.add(docInfo);
		}
		return templateDocList;
	}

	

	@Override
	@Transactional
	public String createFiles(TemplateAttachmentsDTO templateDto, String userName) {		
		String result= null;		
		 int testCount = templateDto.getFiles().length;
		 System.out.println("file count => "+ testCount);
		if(!templateDto.getFiles()[0].isEmpty()) {
			String fileupload = fileUpload(templateDto, userName);
			result= fileupload;
		}else {			
				result= "No Attachment found !";	
				throw new GRCException("No Attachment found !");
			}
			
		return result;
	}
	

	// file upload
	private String fileUpload(TemplateAttachmentsDTO templateAttachmentDto, String userName) {
		
		if (!templateAttachmentDto.getFiles()[0].isEmpty()) {
			for (MultipartFile file : templateAttachmentDto.getFiles()) {
				 System.out.println(file.getContentType() + "-=--=> "+ file.getOriginalFilename());
				try {
					fileUpload = new TemplateFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), templateAttachmentDto.getRefId(), userName);
					TemplateFileUpload upload = createDoc(fileUpload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";
	}
	
	
	@Override
	public TemplateFileUploadDTO downloadFile(String docId) {
		TemplateFileUploadDTO attachments = MapperUtils.mapToTargetClass(getDocById(docId), TemplateFileUploadDTO.class) ;
		GRCUtils.isValid(attachments, "No Attachment found !");		
		return attachments;
	}

	
	// file delete
	@Override
	public String fileDelete(String refId) {
		List<TemplateFileUpload> existFileList = getAllDocByRefId(refId);
		for (TemplateFileUpload file : existFileList) {
		//	deleteUpdate(file);
			deleteDocUpdate(file.getDocId());
		}
		return "success";
	}

	// file delete
	@Override
	public String fileDeleteByDocId(String docId) {
		TemplateFileUpload existfile = deleteDocUpdate(docId);
		return "success";
	}
	
	
	
	
/*	
	@Override
	public TemplateFileUpload updateDoc(TemplateFileUploadDTO docDto) {
		TemplateFileUpload templateDoc = MapperUtils.mapToTargetClass(docDto, TemplateFileUpload.class);
		templateDoc.setDeleteFlag("N");
		templateDoc.setActiveFlag("Y");
		return this.documentRepo.save(templateDoc);
	}
	

	@Override
	public TemplateFileUpload deleteUpdate(TemplateFileUpload templateDoc) {
		TemplateFileUpload existingBiaDoc = getDocById(templateDoc.getDocId());
		existingBiaDoc.setDeleteFlag("D");
		existingBiaDoc.setActiveFlag("N");
		return this.documentRepo.save(existingBiaDoc);
	}

	@Override
	public TemplateFileUpload deleteDoc(TemplateFileUploadDTO docDto) {
	//	AuditFileUpload templateDoc = MapperUtils.mapToTargetClass(docDto, AuditFileUpload.class);
		TemplateFileUpload deleteAsset = deleteDocUpdate(docDto.getDocId());		
		return deleteAsset;
	}
*/
	

	
/*	
	@Override
	public List<TemplateFileUploadDTO> findAllAttachment(String refId) {
		List<TemplateFileUploadDTO> attachments = docService.findAllAttachment(refId);
		TemplateUtils.isValid(attachments, "No Attachment found !");		
		return attachments;
	}
*/	

	
	
	/*
	@Override
	public int findCountByActiveflag(long refId) {
		int docCount = findCountByActiveflag(Long.toString(refId));
		return docCount;
	}
	

	@Override
	public int getTemplateControlCountByActiveflag() {
		return this.templateControlRepo.getTemplateControlCountByActiveflag();
	}

*/

	
}
