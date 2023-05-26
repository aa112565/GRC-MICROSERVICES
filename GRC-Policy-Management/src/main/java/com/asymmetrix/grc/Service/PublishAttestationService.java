package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.PolicyAttachmentsDTO;
import com.asymmetrix.grc.Dto.PolicyFileUploadDTO;
import com.asymmetrix.grc.Dto.PublishAttestationDTO;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.PublishAttestation;

public interface PublishAttestationService {

	
	List<PublishAttestation> getAllPublishAttestationByActiveflag();

	PublishAttestation getPublishAttestationById(long publishAttestationID);
	
	PublishAttestation getPublishAttestationByPolicyId(long PolicyId);

	PublishAttestationDTO createPublishAttestation(PublishAttestationDTO PaDto, String userName);

	PublishAttestationDTO updatePublishAttestation(PublishAttestationDTO PaDto, String userName);

	PublishAttestationDTO deletePublishAttestation(PublishAttestationDTO PaDto, String userName);
	
	public List<CreatePolicy> getAllPolicy();

	String createFiles(PolicyAttachmentsDTO policyDto, String userName);

//	String fileDelete(String refId);

	String fileDeleteByDocId(String docId);

	List<PolicyFileUploadDTO> findAllAttachment(String refId);

	PolicyFileUploadDTO downloadFile(String docId);

}
