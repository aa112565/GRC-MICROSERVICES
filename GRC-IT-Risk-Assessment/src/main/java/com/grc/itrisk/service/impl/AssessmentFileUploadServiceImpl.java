package com.grc.itrisk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.AssessmentUploadRepository;

import com.grc.itrisk.dto.AssessmentFileUploadDTO;
import com.grc.itrisk.entity.AssessmentFileUpload;

import com.grc.itrisk.exception.ResourceNotFoundException;
import com.grc.itrisk.service.AssessmentFileUploadService;

@SuppressWarnings("unused")
@Service
public class AssessmentFileUploadServiceImpl implements AssessmentFileUploadService {

	@Autowired
	private AssessmentUploadRepository documentRepo;

	

	@Override
	public List<AssessmentFileUpload> getAllDocByRefId(String refId) {
		return this.documentRepo.getAllByRefId(refId);
	}

	@Override
	public AssessmentFileUpload getDocById(String docId) {
		return documentRepo.findById(docId).orElseThrow(
				() -> new ResourceNotFoundException("GRC-IT Risk Assessment - Document not found with  Id----> " + docId));
	}

	@Override
	public AssessmentFileUpload createDoc(AssessmentFileUploadDTO docDto) {
		AssessmentFileUpload assetDoc = MapperUtils.mapToTargetClass(docDto, AssessmentFileUpload.class);
		assetDoc.setDeleteFlag("N");
		assetDoc.setActiveFlag("Y");
		return this.documentRepo.save(assetDoc);
	}
	

	
	@Override
	public AssessmentFileUpload updateDoc(AssessmentFileUploadDTO docDto) {
		AssessmentFileUpload auditDoc = MapperUtils.mapToTargetClass(docDto, AssessmentFileUpload.class);
		auditDoc.setDeleteFlag("N");
		auditDoc.setActiveFlag("Y");
		return this.documentRepo.save(auditDoc);
	}
	

	@Override
	public AssessmentFileUpload deleteUpdate(AssessmentFileUpload assetDoc) {
		AssessmentFileUpload existingBiaDoc = getDocById(assetDoc.getDocId());
		existingBiaDoc.setDeleteFlag("D");
		existingBiaDoc.setActiveFlag("N");
		return this.documentRepo.save(existingBiaDoc);
	}

	@Override
	public AssessmentFileUpload deleteDocUpdate(String docId) {
		AssessmentFileUpload existingAuditDoc = getDocById(docId);
		existingAuditDoc.setDeleteFlag("D");
		existingAuditDoc.setActiveFlag("N");
		return this.documentRepo.save(existingAuditDoc);
	}

	@Override
	public AssessmentFileUpload deleteDoc(AssessmentFileUploadDTO docDto) {
	//	AuditFileUpload assetDoc = MapperUtils.mapToTargetClass(docDto, AuditFileUpload.class);
		AssessmentFileUpload deleteAsset = deleteDocUpdate(docDto.getDocId());		
		return deleteAsset;
	}

	@Override
	public List<AssessmentFileUploadDTO> getDocByList(List<String> auditDocIdList) {
		List<AssessmentFileUploadDTO> auditDocList = new ArrayList<>();
		for (String mapId : auditDocIdList) {
			AssessmentFileUploadDTO docInfo = MapperUtils.mapToTargetClass(getDocById(mapId), AssessmentFileUploadDTO.class);
			auditDocList.add(docInfo);
		}
		return auditDocList;
	}

	@Override
	public List<AssessmentFileUploadDTO> findAllAttachment(String refId) {
		List<AssessmentFileUploadDTO> attachments = MapperUtils.mapToTargetClass(documentRepo.getAllDocByRefId(refId),
				AssessmentFileUploadDTO.class);
		return attachments;
	}

	@Override
	public int findCountByActiveflag(String refId) {
		int attachments = documentRepo.findCountByActiveflag(refId);
		return attachments;
	}

	
}
