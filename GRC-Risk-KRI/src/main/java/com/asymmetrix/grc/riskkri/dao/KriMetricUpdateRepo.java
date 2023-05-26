package com.asymmetrix.grc.riskkri.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asymmetrix.grc.riskkri.entity.KriMetricsUpdate;

public interface KriMetricUpdateRepo extends JpaRepository<KriMetricsUpdate, Long> {

	@Query("FROM  KriMetricsUpdate WHERE kriId = :kriId AND deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<KriMetricsUpdate> findByKriId(@Param("kriId") String kriId);

	@Query("FROM  KriMetricsUpdate WHERE deleteFlag = 'N' ORDER BY kriId, modifiedDate DESC ")
	List<KriMetricsUpdate> findAllMetrics();

	@Query("FROM  KriMetricsUpdate WHERE deleteFlag = 'N' AND modifiedDate BETWEEN :startdate AND :enddate ORDER BY modifiedDate DESC ")
	List<KriMetricsUpdate> findAllMetricsBetweenDates(@Param("startdate") Date startdate,
			@Param("enddate") Date enddate);

	@Query("FROM  KriMetricsUpdate WHERE kriId = :kriId AND deleteFlag = 'N'  AND activeFlag = 'Y' ORDER BY createdDate DESC ")
	KriMetricsUpdate findLatestByKriId(@Param("kriId") String kriId);

	@Query("SELECT COUNT(*) FROM  KriMetricsUpdate WHERE kriId = :kriId AND deleteFlag = 'N'  AND activeFlag = 'Y' ")
	int getLatestCountByKriId(@Param("kriId") String kriId);

	@Query("SELECT COUNT(*) FROM  KriMetricsUpdate WHERE frequency = :frequency AND financialYear = :financialYear AND kriId = :kriId AND deleteFlag = 'N' ")
	int getMetricsUpdateCount(@Param("frequency") String frequency, @Param("financialYear") String financialYear,
			@Param("kriId") String kriId);

	@Query("SELECT COUNT(*) FROM  KriMetricsUpdate WHERE financialYear = :financialYear AND kriId = :kriId AND deleteFlag = 'N' ")
	int getMetricsUpdateCountFrequencyNull(@Param("financialYear") String financialYear, @Param("kriId") String kriId);

}
