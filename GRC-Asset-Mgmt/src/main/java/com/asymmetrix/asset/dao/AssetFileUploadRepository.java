package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetFileUpload;

@Repository
public interface AssetFileUploadRepository extends JpaRepository<AssetFileUpload, String> {

	@Query("FROM AssetFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<AssetFileUpload> getAllDocByRefId(@Param("refId") String refId);

//	@Query("FROM AssetFileUpload WHERE refId = :refId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
//	AssetFileUpload getDocByRefId(@Param("refId") String refId);

	AssetFileUpload findByDocIdAndDocName(String docID, String docName);

}
