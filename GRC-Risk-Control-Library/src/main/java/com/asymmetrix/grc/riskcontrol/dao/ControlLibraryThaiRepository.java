package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryThai;

@Repository
public interface ControlLibraryThaiRepository extends JpaRepository<ControlLibraryThai, Long> {

	@Query("SELECT COUNT(*) FROM  ControlLibraryThai WHERE controlId = :controlId ")
	int findByConut(@Param("controlId") long controlId);

	@Query("FROM  ControlLibraryThai WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<ControlLibraryThai> findAllControl();

	ControlLibraryThai findFirstByOrderByCreatedDateDescControlIdDesc();

}
