package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.PolicyFileUploadDTO;
import com.asymmetrix.grc.Entity.PolicyFileUpload;

public interface PolicyFileUploadService {
	
	

	List<PolicyFileUpload> getAllDocByRefId(String refId);

	PolicyFileUpload getRefById(String refId);

	PolicyFileUpload createDoc(PolicyFileUploadDTO docDto);

//	List<AuditFileUpload> saveAllDoc(List<AuditFileUpload> docList);

	PolicyFileUpload updateDoc(PolicyFileUploadDTO docDto);
	
	PolicyFileUpload deleteDoc(PolicyFileUploadDTO docDto);

	PolicyFileUpload deleteDocUpdate(String docId);	
	
//	PolicyFileUpload deleteUpdate(PolicyFileUpload docDto);

//	List<PolicyFileUploadDTO> getDocByList(List<String> policyDocIdList);

	List<PolicyFileUploadDTO> findAllAttachment(String refId);
	
	int findCountByActiveflag(String refId);


}
