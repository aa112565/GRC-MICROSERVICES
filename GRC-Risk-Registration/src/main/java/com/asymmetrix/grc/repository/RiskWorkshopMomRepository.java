package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskWorkshopMOM;

@Repository
public interface RiskWorkshopMomRepository extends JpaRepository<RiskWorkshopMOM, Long>{
	
	@Transactional
	@Modifying
	@Query("update RiskWorkshopMOM r set r.active = 'N' where r.workshopID = :workshopID")
	public Integer updateRiskWorkshopMomToInactive(@Param("workshopID") String workshopID);
	
	public RiskWorkshopMOM findByWorkshopIDAndActive(String workshopID, String activeFlag);
		
	public List<RiskWorkshopMOM> findByActive(String activeFlag);			
	

}
