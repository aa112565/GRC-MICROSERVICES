package com.grc.itrisk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.dto.AssessmentFileUploadDTO;
import com.grc.itrisk.entity.AssessmentFileUpload;

@Repository
public interface AssessmentUploadRepository extends JpaRepository<AssessmentFileUpload, String> {

	@Query("FROM AssessmentFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<AssessmentFileUpload> getAllByRefId(@Param("refId") String refId);
	
	@Query("SELECT new com.grc.itrisk.dto.AssessmentFileUploadDTO(afl.docId, afl.docName, afl.docType) FROM AssessmentFileUpload afl WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<AssessmentFileUploadDTO> getAllDocByRefId(@Param("refId") String refId);

	AssessmentFileUpload findByDocIdAndDocName(String docID, String docName);
	
	@Query("SELECT COUNT(*) FROM AssessmentFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y'")
	int findCountByActiveflag(@Param("refId") String refId);

}
