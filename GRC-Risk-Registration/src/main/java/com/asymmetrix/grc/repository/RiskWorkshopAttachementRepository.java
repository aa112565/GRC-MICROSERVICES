package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.RiskWorkshop;
import com.asymmetrix.grc.entity.RiskWorkshopAttachments;

@Repository
public interface RiskWorkshopAttachementRepository extends JpaRepository<RiskWorkshopAttachments, Long>{
	
	@Transactional
	@Modifying	
	@Query("update RiskWorkshopAttachments r set r.active = 'N' where r.attachmentID = :id")
	public Integer updateWorkshopAttachmentToInactive(@Param("id") Long attachmentID);
	
	public RiskWorkshopAttachments findByAttachmentIDAndActive(Long attachmentID, String activeFlag);
	
	public List<RiskWorkshopAttachments> findByWorkshopIDAndActive(String workshopID, String activeFlag);
	
	public List<RiskWorkshop> findByActive(String activeFlag);	
	
	public RiskWorkshopAttachments findByAttachmentIDAndFileNameAndActive(Long attachmentID, String fileName, String activeFlag);

}
