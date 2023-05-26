package com.grc.itrisk.service;

import java.util.List;

import com.grc.itrisk.dto.TemplateControlDTO;
import com.grc.itrisk.entity.TemplateControl;

public interface TemplateControlService {

	List<TemplateControl> getAllTemplateControl(); 

	TemplateControl getTemplateControlById(long templateControlId);	

	List<TemplateControl> createTemplateControl(List<TemplateControlDTO> templateControlDto, String userName);

	TemplateControl updateTemplateControl(TemplateControlDTO templateControlDto);

	boolean deleteTemplateControl(TemplateControlDTO templateControlDto);

	boolean inActiveTemplateControl(TemplateControlDTO templateControl);

	boolean activeTemplateControl(TemplateControlDTO templateControl);

	List<TemplateControl> getAllTemplateControlByRefId(long templateId);

//	List<TemplateControlDDDTO> getAllTemplateDD();

	
}
