package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskWorkshopParticipants;

@Repository
public interface RiskWorkshopParticipantsRepository extends JpaRepository<RiskWorkshopParticipants, Long>{
	
	@Transactional
	@Modifying
	@Query("update RiskWorkshopParticipants r set r.active = 'N' where r.workshopID = :workshopID")
	public Integer updateRiskWorkshopParticipantsToInactive(@Param("workshopID") String workshopID);
	
	@Query("From RiskWorkshopParticipants r where r.active = 'Y' AND r.departmentID = :departmentID ")
	public List<RiskWorkshopParticipants> findByDepartmentID(@Param("departmentID") String departmentID);		


}
