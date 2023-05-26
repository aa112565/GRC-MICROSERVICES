package com.asymmetrix.asset.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.dao.AssetFileUploadRepository;
import com.asymmetrix.asset.dao.AssetRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.dto.AssetAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetScoreImliedLevelDTO;
import com.asymmetrix.asset.dto.AssetScoringDTO;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.AssetFileUpload;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.exception.ResourceNotFoundException;
import com.asymmetrix.asset.service.AssetFileUploadService;

@SuppressWarnings("unused")
@Service
public class AssetFileUploadServiceImpl implements AssetFileUploadService {

	@Autowired
	private AssetFileUploadRepository documentRepo;

	/*
	 * @Override public List<AssetFileUpload> getAllDoc() { return
	 * this.documentRepo.findAll(); }
	 */

	@Override
	public List<AssetFileUpload> getAllDocByRefId(String refId) {
		return this.documentRepo.getAllDocByRefId(refId);
	}

	@Override
	public AssetFileUpload getDocById(String docId) {
		return documentRepo.findById(docId).orElseThrow(
				() -> new ResourceNotFoundException("CM-Asset Management - Document not found with  Id----> " + docId));
	}

	@Override
	public AssetFileUpload createDoc(AssetFileUploadDTO docDto) {
		AssetFileUpload assetDoc = MapperUtils.mapToTargetClass(docDto, AssetFileUpload.class);
		assetDoc.setDeleteFlag("N");
		assetDoc.setActiveFlag("Y");
		return this.documentRepo.save(assetDoc);
	}

	@Override
	public List<AssetFileUpload> saveAllDoc(List<AssetFileUpload> docList) {
		return this.documentRepo.saveAll(docList);
	}

	@Override
	public AssetFileUpload updateDoc(AssetFileUploadDTO docDto) {
		AssetFileUpload assetDoc = MapperUtils.mapToTargetClass(docDto, AssetFileUpload.class);
		assetDoc.setDeleteFlag("N");
		assetDoc.setActiveFlag("Y");
		return this.documentRepo.save(assetDoc);
	}

	// Bia - Soft Delete
	public AssetFileUpload deleteUpdate(AssetFileUpload assetDoc) {
		AssetFileUpload existingBiaDoc = getDocById(assetDoc.getDocId());
		existingBiaDoc.setDeleteFlag("D");
		existingBiaDoc.setActiveFlag("N");
		return this.documentRepo.save(existingBiaDoc);
	}

	@Override
	public AssetFileUpload deleteUpdate(String docId) {
		AssetFileUpload existingBiaDoc = getDocById(docId);
		existingBiaDoc.setDeleteFlag("D");
		existingBiaDoc.setActiveFlag("N");
		return this.documentRepo.save(existingBiaDoc);
	}

	@Override
	public AssetFileUpload deleteDoc(AssetFileUploadDTO docDto) {
		AssetFileUpload assetDoc = MapperUtils.mapToTargetClass(docDto, AssetFileUpload.class);
		AssetFileUpload deleteAsset = this.deleteUpdate(assetDoc);
		return deleteAsset;
	}

	@Override
	public List<AssetFileUploadDTO> getDocByList(List<String> assetIdList) {
		List<AssetFileUploadDTO> assetList = new ArrayList<>();
		for (String mapId : assetIdList) {
			AssetFileUploadDTO detailAsset = MapperUtils.mapToTargetClass(getDocById(mapId), AssetFileUploadDTO.class);
			assetList.add(detailAsset);
		}
		return assetList;
	}

	@Override
	public List<AssetFileUploadDTO> downloadFile(String refId) {
		List<AssetFileUploadDTO> attachments = MapperUtils.mapToTargetClass(documentRepo.getAllDocByRefId(refId),
				AssetFileUploadDTO.class);
		return attachments;
	}
}
