package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.TemplateDTO;

public interface TemplateService {

	public TemplateDTO saveOrUpdate(TemplateDTO template);

	public TemplateDTO findById(String templateId);

	public List<TemplateDTO> findByTemplateName(String templateName);

	public List<TemplateDTO> getAll();
	
	public void deleteById(String templateId);

	public List<TemplateDTO> findByTemplateStatus(String templateStatus);
	
	public List<TemplateDTO> findTemplateByCreateDateWithLimit(int pageByLimit);
}
