package com.asymmetrix.grc.ServiceImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.Dto.PolicyAttachmentsDTO;
import com.asymmetrix.grc.Dto.PolicyFileUploadDTO;
import com.asymmetrix.grc.Dto.PublishAttestationDTO;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.PolicyFileUpload;
import com.asymmetrix.grc.Entity.PublishAttestation;
import com.asymmetrix.grc.Repository.PolicyUploadRepository;
import com.asymmetrix.grc.Repository.PublishAttestationRepo;
import com.asymmetrix.grc.Service.PolicyFileUploadService;
import com.asymmetrix.grc.Service.PublishAttestationService;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;

@SuppressWarnings("unused")
@Service
public class PublishAttestationServiceImpl implements PublishAttestationService {
	
	@Autowired
	PublishAttestationRepo publishAttestationRepo;
	
	@Autowired
	PolicyFileUploadService docService;
	
	PolicyFileUploadDTO fileupload;

	@Override
	public List<PublishAttestation> getAllPublishAttestationByActiveflag() {
		return this.publishAttestationRepo.findAllPublishAttestationByActiveflag();
	}
	
	@Override
	public List<CreatePolicy> getAllPolicy() {
		return this.publishAttestationRepo.findAllPolicy();
	}

	@Override
	public PublishAttestation getPublishAttestationById(long publishAttestationID) {
		return publishAttestationRepo.findById(publishAttestationID).orElseThrow(
				() -> new ResourceNotFoundException("publishAttestationID not found with  Id----> " + publishAttestationID));
	}

	@Override
	public PublishAttestationDTO createPublishAttestation(PublishAttestationDTO PaDto, String userName) {
		PublishAttestationDTO apDto = MapperUtils.mapToTargetClass(PaDto, PublishAttestationDTO.class);
		//	apDto.setStatus("Initiated");
			apDto.setDeleteFlag("N");
			apDto.setActiveFlag("Y");
			apDto.setCreatedBy(userName);
			publishAttestationRepo.updatepublishAttestationToactive(PaDto.getPolicyId());
			publishAttestationRepo.AlertMessage(PaDto.getPolicyId());
			PublishAttestation cmAudit = publishAttestationRepo
					.save(MapperUtils.mapToTargetClass(apDto, PublishAttestation.class));
			return MapperUtils.mapToTargetClass(cmAudit, PublishAttestationDTO.class);
		}

	@Override
	public PublishAttestationDTO updatePublishAttestation(PublishAttestationDTO PaDto, String userName) {
		PublishAttestationDTO apDto = MapperUtils.mapToTargetClass(PaDto, PublishAttestationDTO.class);
		//	apDto.setStatus("Initiated");
			apDto.setDeleteFlag("N");
			apDto.setActiveFlag("Y");
			apDto.setCreatedBy(userName);
			PaDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			PublishAttestation cmAudit = publishAttestationRepo
					.save(MapperUtils.mapToTargetClass(apDto, PublishAttestation.class));
			return MapperUtils.mapToTargetClass(cmAudit, PublishAttestationDTO.class);
			
	}

	@Override
	public PublishAttestationDTO deletePublishAttestation(PublishAttestationDTO PaDto, String userName) {
		PublishAttestation cmAudit = getPublishAttestationById(PaDto.getPublishAttestationID());
		cmAudit.setDeleteFlag("D");
		cmAudit.setActiveFlag("N");
		cmAudit.setModifiedBy(userName);
		PublishAttestation auditProgram = publishAttestationRepo.save(MapperUtils.mapToTargetClass(cmAudit, PublishAttestation.class));		
		return MapperUtils.mapToTargetClass(auditProgram, PublishAttestationDTO.class);
	}
	

	@Override
	public String createFiles(PolicyAttachmentsDTO policyDto, String userName) {
		String result= null;
		 int testCount = policyDto.getFiles().length;
		 System.out.println("file count => "+ testCount);
		if(!policyDto.getFiles()[0].isEmpty()) {
			String fileupload = fileUpload(policyDto, userName);
			result= fileupload;
		}else {			
				result= "No Attachment found !";	
				throw new ResourceNotFoundException("No Attachment found !");
			}
			
		return result;
	}

//	@Override
//	public String fileDelete(String refId) {
//		List<PolicyFileUpload> existFileList = docService.getAllDocByRefId(refId);
//		for (PolicyFileUpload file : existFileList) {
//			docService.deleteUpdate(file);
//		}
//		return "success";
//	}

	@Override
	public String fileDeleteByDocId(String docId) {
		PolicyFileUpload existfile = docService.deleteDocUpdate(docId);
		return "success";
	}

	@Override
	public List<PolicyFileUploadDTO> findAllAttachment(String refId) {
		List<PolicyFileUploadDTO> attachments = docService.findAllAttachment(refId);
		GRCUtils.isValid(attachments, "No Attachment found !");		
		return attachments;
		
	}

	@Override
	public PolicyFileUploadDTO downloadFile(String docId) {
		PolicyFileUploadDTO attachments = MapperUtils.mapToTargetClass(docService.getRefById(docId), PolicyFileUploadDTO.class) ;
		GRCUtils.isValid(attachments, "No Attachment found !");		
		return attachments;
	}
	
	private String fileUpload(PolicyAttachmentsDTO Dto, String userName) {
		if (!Dto.getFiles()[0].isEmpty()) {
			for (MultipartFile file : Dto.getFiles()) {
				 System.out.println(file.getContentType() + "-=--=> "+ file.getOriginalFilename());
				try {
					fileupload = new PolicyFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), Dto.getRefId(), userName);
					PolicyFileUpload upload = docService.createDoc(fileupload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";

}

	@Override
	public PublishAttestation getPublishAttestationByPolicyId(long PolicyId) {
		return publishAttestationRepo.findPublishAttestationIdByPolicyId(PolicyId);
			
	}
	
	
}
