package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskcontrol.entity.ControlLibrary;

@Repository
public interface ControlLibraryRepository extends JpaRepository<ControlLibrary, Long> {

	@Query("SELECT COUNT(*) FROM  ControlLibrary WHERE controlId = :controlId ")
	int findByConut(@Param("controlId") long controlId);

	@Query("FROM  ControlLibrary WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<ControlLibrary> findAllControl();

	ControlLibrary findFirstByOrderByCreatedDateDescControlIdDesc();

}
