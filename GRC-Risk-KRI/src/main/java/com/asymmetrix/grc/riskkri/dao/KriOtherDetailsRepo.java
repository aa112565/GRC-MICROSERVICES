package com.asymmetrix.grc.riskkri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriOtherDetails;

@Repository
public interface KriOtherDetailsRepo extends JpaRepository<KriOtherDetails, Long> {

	@Query("FROM KriOtherDetails WHERE kriId = :kriId AND  activeFlag = 'Y' AND deleteFlag = 'N' ")
	KriOtherDetails findByKriId(String kriId);

	@Query("SELECT kod.reviewFrequency FROM  KriOtherDetails kod WHERE kod.kriId = :kriId AND  kod.activeFlag = 'Y' AND kod.deleteFlag = 'N' ")
	String getKriFrequencyByKriId(@Param("kriId") String kriId);

}
