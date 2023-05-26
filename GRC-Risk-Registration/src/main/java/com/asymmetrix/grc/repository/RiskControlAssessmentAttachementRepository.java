package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.RiskControlAssessmentAttachments;

@Repository
public interface RiskControlAssessmentAttachementRepository extends JpaRepository<RiskControlAssessmentAttachments, Long>{
	
	@Transactional
	@Modifying	
	@Query("update RiskControlAssessmentAttachments r set r.active = 'N' where r.attachmentID = :id")
	public Integer updateRiskControlAssessmentAttachmentToInactive(@Param("id") Long attachmentID);
	
	public RiskControlAssessmentAttachments findByRiskRegIDAndAndActive(Long attachmentID, String activeFlag);
	
	public List<RiskControlAssessmentAttachments> findByRiskRegIDAndRiskIDAndControlIDAndActive(String riskRegID, long riskID, long controlID, String activeFlag);
	
	public List<RiskControlAssessmentAttachments> findByActive(String activeFlag);	
	
	public RiskControlAssessmentAttachments findByAttachmentIDAndFileNameAndActive(Long attachmentID, String fileName, String activeFlag);

}
