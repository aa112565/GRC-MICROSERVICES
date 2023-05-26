package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryArabic;

@Repository
public interface ControlLibraryArabicRepository extends JpaRepository<ControlLibraryArabic, Long> {

	@Query("SELECT COUNT(*) FROM  ControlLibraryArabic WHERE controlId = :controlId ")
	int findByConut(@Param("controlId") long controlId);

	@Query("FROM  ControlLibraryArabic WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<ControlLibraryArabic> findAllControl();

	ControlLibraryArabic findFirstByOrderByCreatedDateDescControlIdDesc();

}
