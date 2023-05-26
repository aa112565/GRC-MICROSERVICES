package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssessmentFileUpload;

@Repository
public interface AssessmentFileUploadRepository extends JpaRepository<AssessmentFileUpload, String> {

	@Query("FROM AssessmentFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<AssessmentFileUpload> getAllDocByRefId(@Param("refId") String refId);

	AssessmentFileUpload findByDocIdAndDocName(String docID, String docName);

}
