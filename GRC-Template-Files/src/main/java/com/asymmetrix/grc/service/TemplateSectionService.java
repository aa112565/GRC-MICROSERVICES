package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.TemplateSectionDTO;

public interface TemplateSectionService {

	public TemplateSectionDTO saveOrUpdate(TemplateSectionDTO templateSection);
	
	public TemplateSectionDTO findById(String templateSectionId);
	
	public List<TemplateSectionDTO> findByTemplateId(String templateId);
	
	public List<String> getSectionNamesByTemplateId(String templateId);
	
	public void deleteById(String templateSectionId);
}
