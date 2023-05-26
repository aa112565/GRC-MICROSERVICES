package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.TemplateFileUploadDTO;
import com.asymmetrix.grc.entity.TemplateFileUpload;

@Repository
public interface TemplateUploadRepository extends JpaRepository<TemplateFileUpload, String> {

	@Query("FROM TemplateFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<TemplateFileUpload> getAllByRefId(@Param("refId") String refId);
	
	@Query("FROM TemplateFileUpload WHERE refId = :refId AND docName = :docName")
	List<TemplateFileUpload> getDocHistory(@Param("refId") String refId, @Param("docName") String docName);	
	
	@Query("SELECT new com.asymmetrix.grc.dto.TemplateFileUploadDTO(afl.docId, afl.docName, afl.docType) FROM TemplateFileUpload afl WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<TemplateFileUploadDTO> getAllDocByRefId(@Param("refId") String refId);

	TemplateFileUpload findByDocIdAndDocName(String docID, String docName);
	
	@Query("SELECT COUNT(*) FROM TemplateFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y'")
	int findCountByActiveflag(@Param("refId") String refId);

}
