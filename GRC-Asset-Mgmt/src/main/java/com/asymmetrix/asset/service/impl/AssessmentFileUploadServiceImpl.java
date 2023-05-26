package com.asymmetrix.asset.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.dao.AssessmentFileUploadRepository;
import com.asymmetrix.asset.dao.AssetFileUploadRepository;
import com.asymmetrix.asset.dao.AssetRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.dto.AssessmentFileUploadDTO;
import com.asymmetrix.asset.dto.AssetAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetScoreImliedLevelDTO;
import com.asymmetrix.asset.dto.AssetScoringDTO;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.AssessmentFileUpload;
import com.asymmetrix.asset.entity.AssetFileUpload;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.exception.ResourceNotFoundException;
import com.asymmetrix.asset.service.AssessmentFileUploadService;

@SuppressWarnings("unused")
@Service
public class AssessmentFileUploadServiceImpl implements AssessmentFileUploadService {

	@Autowired
	private AssessmentFileUploadRepository documentRepo;

	@Override
	public List<AssessmentFileUpload> getAllDoc() {
		return this.documentRepo.findAll();
	}

	@Override
	public List<AssessmentFileUpload> getAllDocByRefId(String refId) {
		return this.documentRepo.getAllDocByRefId(refId);
	}

	@Override
	public AssessmentFileUpload getDocById(String docId) {
		return documentRepo.findById(docId).orElseThrow(
				() -> new ResourceNotFoundException("CM-Assessment - Document not found with  Id----> " + docId));
	}

	@Override
	public AssessmentFileUpload createDoc(AssessmentFileUploadDTO docdto) {
		AssessmentFileUpload assetDoc = MapperUtils.mapToTargetClass(docdto, AssessmentFileUpload.class);
		assetDoc.setDeleteFlag("N");
		assetDoc.setActiveFlag("Y");
		return this.documentRepo.save(assetDoc);
	}

	@Override
	public List<AssessmentFileUpload> saveAllDoc(List<AssessmentFileUpload> docList) {
		return this.documentRepo.saveAll(docList);
	}

	@Override
	public AssessmentFileUpload updateDoc(AssessmentFileUploadDTO docdto) {
		AssessmentFileUpload assetDoc = MapperUtils.mapToTargetClass(docdto, AssessmentFileUpload.class);
		assetDoc.setDeleteFlag("N");
		assetDoc.setActiveFlag("Y");
		return this.documentRepo.save(assetDoc);
	}

	// Bia - Soft Delete
	@Override
	public AssessmentFileUpload deleteUpdate(AssessmentFileUpload assetDoc) {
		AssessmentFileUpload existingBiaDoc = getDocById(assetDoc.getDocId());
		existingBiaDoc.setDeleteFlag("D");
		existingBiaDoc.setActiveFlag("N");
		return this.documentRepo.save(existingBiaDoc);
	}

	@Override
	public AssessmentFileUpload deleteUpdate(String docId) {
		AssessmentFileUpload existingBiaDoc = getDocById(docId);
		existingBiaDoc.setDeleteFlag("D");
		existingBiaDoc.setActiveFlag("N");
		return this.documentRepo.save(existingBiaDoc);
	}

	@Override
	public AssessmentFileUpload deleteDoc(AssetFileUploadDTO docdto) {
		AssessmentFileUpload assetDoc = MapperUtils.mapToTargetClass(docdto, AssessmentFileUpload.class);
		AssessmentFileUpload deleteAsset = this.deleteUpdate(assetDoc);
		return deleteAsset;
	}

	@Override
	public List<AssessmentFileUploadDTO> getDocByList(List<String> assetIdList) {
		List<AssessmentFileUploadDTO> assetList = new ArrayList<>();
		for (String mapId : assetIdList) {
			AssessmentFileUploadDTO detailAsset = MapperUtils.mapToTargetClass(getDocById(mapId),
					AssessmentFileUploadDTO.class);
			assetList.add(detailAsset);
		}
		return assetList;
	}

	@Override
	public List<AssessmentFileUploadDTO> downloadFile(String refId) {
		List<AssessmentFileUploadDTO> attachments = MapperUtils.mapToTargetClass(documentRepo.getAllDocByRefId(refId),
				AssessmentFileUploadDTO.class);
		return attachments;
	}
}
