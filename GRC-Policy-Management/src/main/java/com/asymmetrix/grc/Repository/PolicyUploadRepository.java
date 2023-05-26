package com.asymmetrix.grc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Dto.PolicyFileUploadDTO;
import com.asymmetrix.grc.Entity.PolicyFileUpload;

@Repository
public interface PolicyUploadRepository extends JpaRepository<PolicyFileUpload, String> {
	
	@Query("FROM PolicyFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<PolicyFileUpload> getAllByRefId(@Param("refId") String refId);
	
	@Query("SELECT new com.asymmetrix.grc.Dto.PolicyFileUploadDTO(afl.docId, afl.docName, afl.docType) FROM PolicyFileUpload afl WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<PolicyFileUpload> getAllDocByRefId(@Param("refId") String refId);

	PolicyFileUpload findByDocIdAndDocName(String docID, String docName);
	
	@Query("SELECT COUNT(*) FROM PolicyFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y'")
	int findCountByActiveflag(@Param("refId") String refId);


}
