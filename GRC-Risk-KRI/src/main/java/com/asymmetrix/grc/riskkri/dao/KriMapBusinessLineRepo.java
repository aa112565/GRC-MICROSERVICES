package com.asymmetrix.grc.riskkri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriMapBusinessLine;

@Repository
public interface KriMapBusinessLineRepo extends JpaRepository<KriMapBusinessLine, Long> {

	@Query("FROM  KriMapBusinessLine WHERE kriId = :kriId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	KriMapBusinessLine findByKriId(String kriId);

	@Query("SELECT COUNT(*) FROM  KriMapBusinessLine WHERE kriId = :kriId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	Long getKriMapBusinessLineCount(@Param("kriId") String kriId);

}
