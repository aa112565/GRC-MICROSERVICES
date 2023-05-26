package com.asymmetrix.grc.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.PolicyFileUploadDTO;
import com.asymmetrix.grc.Entity.PolicyFileUpload;
import com.asymmetrix.grc.Repository.PolicyUploadRepository;
import com.asymmetrix.grc.Service.PolicyFileUploadService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;

@SuppressWarnings("unused")
@Service
public class PolicyFileUploadServiceImpl implements PolicyFileUploadService {
	
	@Autowired
	private PolicyUploadRepository documentRepo;

	@Override
	public List<PolicyFileUpload> getAllDocByRefId(String refId) {
		return this.documentRepo.getAllByRefId(refId);
	}

	@Override
	public PolicyFileUpload getRefById(String refId) {
		return documentRepo.findById(refId).orElseThrow(
				() -> new ResourceNotFoundException("GRC-Audit Management - Document not found with  Id----> " + refId));
	}

	@Override
	public PolicyFileUpload createDoc(PolicyFileUploadDTO docDto) {
		PolicyFileUpload assetDoc = MapperUtils.mapToTargetClass(docDto, PolicyFileUpload.class);
		assetDoc.setDeleteFlag("N");
		assetDoc.setActiveFlag("Y");
		return this.documentRepo.save(assetDoc);
	}

	@Override
	public PolicyFileUpload updateDoc(PolicyFileUploadDTO docDto) {
		PolicyFileUpload assetDoc = MapperUtils.mapToTargetClass(docDto, PolicyFileUpload.class);
		assetDoc.setDeleteFlag("N");
		assetDoc.setActiveFlag("Y");
		return this.documentRepo.save(assetDoc);
	}

	@Override
	public PolicyFileUpload deleteDoc(PolicyFileUploadDTO docDto) {
		PolicyFileUpload deletePolicy = deleteDocUpdate(docDto.getDocId());		
		return deletePolicy;
	}

	@Override
	public PolicyFileUpload deleteDocUpdate(String refId) {
		PolicyFileUpload existingAuditDoc = getRefById(refId);
		existingAuditDoc.setDeleteFlag("D");
		existingAuditDoc.setActiveFlag("N");
		return this.documentRepo.save(existingAuditDoc);
	}

//	@Override
//	public PolicyFileUpload deleteUpdate(PolicyFileUpload docDto) {
//		PolicyFileUpload existingBiaDoc = getDocById(docDto.getDocId());
//		existingBiaDoc.setDeleteFlag("D");
//		existingBiaDoc.setActiveFlag("N");
//		return this.documentRepo.save(existingBiaDoc);
//	}
//
//	@Override
//	public List<PolicyFileUploadDTO> getDocByList(List<String> policyDocIdList) {
//		List<PolicyFileUploadDTO> auditDocList = new ArrayList<>();
//		for (String mapId : policyDocIdList) {
//			PolicyFileUploadDTO docInfo = MapperUtils.mapToTargetClass(getDocById(mapId), PolicyFileUploadDTO.class);
//			auditDocList.add(docInfo);
//		}
//		return auditDocList;
//	}

	@Override
	public List<PolicyFileUploadDTO> findAllAttachment(String refId) {
		List<PolicyFileUploadDTO> attachments = MapperUtils.mapToTargetClass(documentRepo.getAllDocByRefId(refId),
				PolicyFileUploadDTO.class);
		return attachments;
	}

	@Override
	public int findCountByActiveflag(String refId) {
		int attachments = documentRepo.findCountByActiveflag(refId);
		return attachments;
	}

}
