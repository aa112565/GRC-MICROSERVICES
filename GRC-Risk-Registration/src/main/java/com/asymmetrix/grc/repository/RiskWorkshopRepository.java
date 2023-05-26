package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.RiskWorkshop;

@Repository
public interface RiskWorkshopRepository extends JpaRepository<RiskWorkshop, Long>{
	
	@Transactional
	@Modifying
	@Query("update RiskWorkshop r set r.active = 'N' where r.workshopID = :workshopID")
	public Integer updateRiskWorkshopToInactive(@Param("workshopID") String workshopID);
	
	public RiskWorkshop findByWorkshopIDAndActive(String workshopID, String activeFlag);
		
	//public List<RiskWorkshop> findByActiveOrderByCreatedDateDesc(String activeFlag);		
	
	public RiskWorkshop findFirstByOrderByCreatedDateDescIdDesc();
	
	@Query("from RiskWorkshop r where  r.active = :active  ORDER BY createdDate DESC ")
	List<RiskWorkshop> findActiveByBranchName(@Param("active") String active);
	
	
	@Transactional
	@Modifying
	@Query("update RiskWorkshop r set r.status = :status where r.workshopID = :workshopID and r.active = 'Y'")
	public Integer updateRiskWorkshopStatus(@Param("workshopID") String workshopID, @Param("status") String status);

	@SuppressWarnings("rawtypes")
	public List findByActiveOrderByCreatedDateDesc(String riskWorkshopActive);

}
