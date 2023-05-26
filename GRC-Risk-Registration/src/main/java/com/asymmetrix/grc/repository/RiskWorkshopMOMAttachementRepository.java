package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.entity.RiskWorkshopMOM;
import com.asymmetrix.grc.entity.RiskWorkshopMOMAttachments;

@Repository
public interface RiskWorkshopMOMAttachementRepository extends JpaRepository<RiskWorkshopMOMAttachments, Long>{
	
	@Transactional
	@Modifying
	@Query("update RiskWorkshopMOMAttachments r set r.active = 'N' where r.attachmentID in :ids")
	public Integer updateWorkshopMOMAttachmentToInactive(@Param("ids") List<Long> attachmentsList);
	
	public RiskWorkshopMOMAttachments findByAttachmentIDAndActive(Long attachmentID, String activeFlag);
	
	public RiskWorkshopMOMAttachments findByWorkshopIDAndActive(String workshopID, String activeFlag);
	
	public List<RiskWorkshopMOM> findByActive(String activeFlag);	
	
	public RiskWorkshopMOMAttachments findByAttachmentIDAndFileNameAndActive(Long attachmentID, String fileName, String activeFlag);

}
