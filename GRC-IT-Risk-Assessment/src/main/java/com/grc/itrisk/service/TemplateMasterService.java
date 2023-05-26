package com.grc.itrisk.service;

import java.util.List;

import com.grc.itrisk.dto.TemplateMasterDTO;
import com.grc.itrisk.entity.TemplateMaster;

public interface TemplateMasterService {

	List<TemplateMaster> getAllTemplate(); 

	TemplateMaster getTemplateById(long templateMasterId);	

	TemplateMaster createTemplate(TemplateMasterDTO templateMasterDto);

	TemplateMaster updateTemplate(TemplateMasterDTO templateMasterDto);

	boolean deleteTemplate(TemplateMasterDTO templateMasterDto);

	boolean inActiveTemplate(TemplateMasterDTO templateMaster);

	boolean activeTemplate(TemplateMasterDTO templateMaster);

//	List<TemplateMaster> getAllTemplateByRefId(String refId);

//	List<TemplateMasterDDDTO> getAllTemplateDD();

	
}
