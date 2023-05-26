package com.grc.itrisk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.exception.ITRiskException;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.TemplateControlLogRepository;
import com.grc.itrisk.dao.TemplateControlRepository;

import com.grc.itrisk.dto.TemplateControlDTO;
import com.grc.itrisk.dto.TemplateMasterDTO;
import com.grc.itrisk.entity.TemplateControl;
import com.grc.itrisk.entity.TemplateControlLog;
import com.grc.itrisk.entity.TemplateMaster;
import com.grc.itrisk.service.TemplateControlService;


@Service
public class TemplateControlServiceImpl implements TemplateControlService {

	@Autowired
	private TemplateControlRepository templateControlRepo;
	
	@Autowired
	private TemplateControlLogRepository templateControlLogRepo;
	
	@Autowired
	private TemplateMasterServiceImpl templateMasterServiceImpl;

	@Override
	public List<TemplateControl> getAllTemplateControl() {
		List<TemplateControl> orgs = templateControlRepo.findAllTemplateControl();
		 if (orgs.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }
		
		return orgs;
	}
	

	@Override
	public List<TemplateControl> getAllTemplateControlByRefId(long templateId) {
		List<TemplateControl> templates = templateControlRepo.getAllTemplateControlByRefId(templateId);
		 if (templates.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.ENTITY_NOT_FOUND);
		    }
		
		return templates;	
	
	}

	
	@Override
	public TemplateControl getTemplateControlById(long templateControlId) {
		return templateControlRepo.findById(templateControlId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Template not found with  Id----> " + templateControlId));
				.orElseThrow(() -> new ITRiskException(ITRiskErrorConstants.ENTITY_NOT_FOUND + templateControlId));
	}

	

	public List<TemplateControl> saveAll(List<TemplateControl> templateControlList) {
		return this.templateControlRepo.saveAll(templateControlList);
	}

	@Override
	public List<TemplateControl> createTemplateControl(List<TemplateControlDTO> templateControlDto, String userName) {
		List<TemplateControl> resultControlList = new ArrayList<TemplateControl>();
		for(TemplateControlDTO control:templateControlDto) {
			control.setCreatedBy(userName);
			TemplateControl templateControl = MapperUtils.mapToTargetClass(control, TemplateControl.class);
			templateControl.setActiveFlag("Y");
			templateControl.setDeleteFlag("N");	
			TemplateControl newControl = templateControlRepo.save(templateControl);
			resultControlList.add(newControl);
			@SuppressWarnings("unused")
			Boolean updateStatus = updateTemplate(control.getTemplateId(), "Create-Control", newControl.getTemplateControlId());
		}		
		return resultControlList;
	}
	
	
	public Boolean updateTemplate(long templateMasterId, String remarks, long templateControlId) {
		TemplateMasterDTO exitTemplate = MapperUtils.mapToTargetClass(templateMasterServiceImpl.getTemplateById(templateMasterId), TemplateMasterDTO.class);
		String tempRemark = remarks+"----"+Long.toString(templateControlId);
		exitTemplate.setRemarks(tempRemark);
		TemplateMaster modifyTemplate =  templateMasterServiceImpl.updateTemplate(exitTemplate);
		return (ObjectUtils.isEmpty(modifyTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}
	
	
	public TemplateControlLog updateTemplateControlLog(long templateControlId) {			
		TemplateControlDTO existingTemplate = MapperUtils.mapToTargetClass(getTemplateControlById(templateControlId), TemplateControlDTO.class);		
		TemplateControlLog templateControlLog = MapperUtils.mapToTargetClass(existingTemplate, TemplateControlLog.class);
		return this.templateControlLogRepo.save(templateControlLog);
	}

	
	@Override
	@Transactional
	public TemplateControl updateTemplateControl(TemplateControlDTO templateControlDto) {		
		@SuppressWarnings("unused")
		TemplateControlLog log = updateTemplateControlLog(templateControlDto.getTemplateControlId());
		TemplateControl templateControl = MapperUtils.mapToTargetClass(templateControlDto, TemplateControl.class);
		templateControl.setActiveFlag("Y");
		templateControl.setDeleteFlag("N");
		TemplateControl updateControl = templateControlRepo.save(templateControl);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(templateControlDto.getTemplateId(), "Update-Control", templateControlDto.getTemplateControlId());
		return updateControl;
	}

	
	@Transactional
	@Override
	public boolean deleteTemplateControl(TemplateControlDTO templateControlDto) {
		@SuppressWarnings("unused")
		TemplateControlLog log = updateTemplateControlLog(templateControlDto.getTemplateControlId());
		TemplateControl existingTemplate = getTemplateControlById(templateControlDto.getTemplateControlId());
		existingTemplate.setActiveFlag("N");
		existingTemplate.setDeleteFlag("D");
		existingTemplate.setRemarks(templateControlDto.getRemarks());	
		TemplateControl updateTemplate = templateControlRepo.save(existingTemplate);		
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(updateTemplate.getTemplateId(), "Delete-Control", templateControlDto.getTemplateControlId());
		return (ObjectUtils.isEmpty(updateTemplate)) ? Boolean.FALSE : Boolean.TRUE;

	}

	@Transactional
	@Override
	public boolean inActiveTemplateControl(TemplateControlDTO templateControlDto) {
		@SuppressWarnings("unused")
		TemplateControlLog log = updateTemplateControlLog(templateControlDto.getTemplateControlId());
		TemplateControl existingTemplate = getTemplateControlById(templateControlDto.getTemplateControlId());
		existingTemplate.setActiveFlag("N");	
		existingTemplate.setRemarks(templateControlDto.getRemarks());
		TemplateControl updateTemplate = templateControlRepo.save(existingTemplate);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(updateTemplate.getTemplateId(), "inActive-Control", templateControlDto.getTemplateControlId());
		return (ObjectUtils.isEmpty(updateTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Transactional
	@Override
	public boolean activeTemplateControl(TemplateControlDTO templateControlDto) {
		@SuppressWarnings("unused")
		TemplateControlLog log = updateTemplateControlLog(templateControlDto.getTemplateControlId());
		TemplateControl existingTemplate = getTemplateControlById(templateControlDto.getTemplateControlId());
		existingTemplate.setActiveFlag("Y");	
		existingTemplate.setRemarks(templateControlDto.getRemarks());
		TemplateControl updateTemplate = templateControlRepo.save(existingTemplate);
		@SuppressWarnings("unused")
		Boolean updateStatus = updateTemplate(updateTemplate.getTemplateId(), "Active-Control", templateControlDto.getTemplateControlId());
		return (ObjectUtils.isEmpty(updateTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}

	
}
