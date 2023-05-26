package com.grc.itrisk.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.exception.ITRiskException;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.TemplateRatingLogRepository;
import com.grc.itrisk.dao.TemplateRatingRepository;
import com.grc.itrisk.dto.TemplateMasterDTO;
import com.grc.itrisk.dto.TemplateRatingDTO;
import com.grc.itrisk.entity.TemplateMaster;
import com.grc.itrisk.entity.TemplateRating;
import com.grc.itrisk.entity.TemplateRatingLog;
import com.grc.itrisk.service.TemplateRatingService;


@Service
public class TemplateRatingServiceImpl implements TemplateRatingService {

	@Autowired
	private TemplateRatingRepository templateRatingRepo;
	
	@Autowired
	private TemplateRatingLogRepository templateRatingLogRepo;
	
	@Autowired
	private TemplateMasterServiceImpl templateMasterServiceImpl;

	@Override
	public List<TemplateRating> getAllTemplateRating() {
		List<TemplateRating> orgs = templateRatingRepo.findAllTemplateRating();
		 if (orgs.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }
		
		return orgs;
	}
	
/*	
	@Override
	public List<TemplateRatingDDDTO> getAllTemplateRatingDD() {
		List<TemplateRatingDDDTO> orgs = templateRatingRepo.findAllOrgDD();
		 if (orgs.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }
		
		return orgs;
	}
*/	


	@Override
	public TemplateRating getTemplateRatingByRefId(long templateId) {
		TemplateRating templates = templateRatingRepo.getTemplateRatingByRefId(templateId);		
		 if (ObjectUtils.isEmpty(templates)){
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }	
		return templates;	
	
	}

	
	@Override
	public TemplateRating getTemplateRatingById(long templateRatingId) {
		return templateRatingRepo.findById(templateRatingId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Template not found with  Id----> " + templateRatingId));
				.orElseThrow(() -> new ITRiskException(ITRiskErrorConstants.ENTITY_NOT_FOUND + templateRatingId));
	}

	public List<TemplateRating> saveAll(List<TemplateRating> templateRatingList) {
		return this.templateRatingRepo.saveAll(templateRatingList);
	}

	@Override
	public TemplateRating createTemplateRating(TemplateRatingDTO templateRatingDto) {		
		TemplateRating templateRating = MapperUtils.mapToTargetClass(templateRatingDto, TemplateRating.class);
		templateRating.setActiveFlag("Y");
		templateRating.setDeleteFlag("N");	
	//	return this.templateRatingRepo.save(templateRating);
		TemplateRating newRating = templateRatingRepo.save(templateRating);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(templateRatingDto.getTemplateId(), "Create-Rating", newRating.getTemplateRatingId());	
		return newRating;
	}
	
	public Boolean updateTemplate(long templateMasterId, String remarks, long templateRatingId) {
		TemplateMasterDTO exitTemplate = MapperUtils.mapToTargetClass(templateMasterServiceImpl.getTemplateById(templateMasterId), TemplateMasterDTO.class);
		String tempRemark = remarks+"----"+Long.toString(templateRatingId);
		exitTemplate.setRemarks(tempRemark);
		TemplateMaster modifyTemplate =  templateMasterServiceImpl.updateTemplate(exitTemplate);
		return (ObjectUtils.isEmpty(modifyTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}
	

	public TemplateRatingLog updateTemplateRatingLog(long templateRatingId) {			
		TemplateRatingDTO existingTemplate = MapperUtils.mapToTargetClass(getTemplateRatingById(templateRatingId), TemplateRatingDTO.class);		
		TemplateRatingLog templateRatingLog = MapperUtils.mapToTargetClass(existingTemplate, TemplateRatingLog.class);
		return this.templateRatingLogRepo.save(templateRatingLog);
	}

	
	@Override
	@Transactional
	public TemplateRating updateTemplateRating(TemplateRatingDTO templateRatingDto) {		
		@SuppressWarnings("unused")
		TemplateRatingLog log = updateTemplateRatingLog(templateRatingDto.getTemplateRatingId());
		TemplateRating templateRating = MapperUtils.mapToTargetClass(templateRatingDto, TemplateRating.class);
		templateRating.setActiveFlag("Y");
		templateRating.setDeleteFlag("N");
		TemplateRating updateRating = templateRatingRepo.save(templateRating);
	//	return this.templateRatingRepo.save(templateRating);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(templateRatingDto.getTemplateId(), "Modify-Rating", templateRatingDto.getTemplateRatingId());	
		return updateRating;
	}

	

	@Override
	public boolean deleteTemplateRating(TemplateRatingDTO templateRatingDto) {
		TemplateRating existingTemplate = getTemplateRatingById(templateRatingDto.getTemplateRatingId());
		existingTemplate.setActiveFlag("N");
		existingTemplate.setDeleteFlag("D");
		existingTemplate.setRemarks(templateRatingDto.getRemarks());
	//	return this.templateRatingRepo.save(existingTemplate);
		TemplateRating removeTemplate = templateRatingRepo.save(existingTemplate);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(templateRatingDto.getTemplateId(), "Remove-Rating", templateRatingDto.getTemplateRatingId());
		return (ObjectUtils.isEmpty(removeTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean inActiveTemplateRating(TemplateRatingDTO templateRatingDto) {
		TemplateRating existingTemplate = getTemplateRatingById(templateRatingDto.getTemplateRatingId());
		existingTemplate.setActiveFlag("N");	
		existingTemplate.setRemarks(templateRatingDto.getRemarks());
		TemplateRating inActiveTemplate = templateRatingRepo.save(existingTemplate);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(templateRatingDto.getTemplateId(), "inActive-Rating", templateRatingDto.getTemplateRatingId());
		return (ObjectUtils.isEmpty(inActiveTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean activeTemplateRating(TemplateRatingDTO templateRatingDto) {
		TemplateRating existingTemplate = getTemplateRatingById(templateRatingDto.getTemplateRatingId());
		existingTemplate.setActiveFlag("Y");	
		existingTemplate.setRemarks(templateRatingDto.getRemarks());
		TemplateRating activeTemplate = templateRatingRepo.save(existingTemplate);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(templateRatingDto.getTemplateId(), "Active-Rating", templateRatingDto.getTemplateRatingId());
		return (ObjectUtils.isEmpty(activeTemplate)) ? Boolean.FALSE : Boolean.TRUE;
		
	}

	
}
