package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.utils.constants.GRCErrorConstants;
import com.asymmetrix.grc.dto.TemplateSectionDTO;
import com.asymmetrix.grc.entity.TemplateSection;
import com.asymmetrix.grc.repository.TemplateSectionRepository;
import com.asymmetrix.grc.service.TemplateSectionService;

@Service
public class TemplateSectionServiceImpl implements TemplateSectionService {

	@Resource
	private TemplateSectionRepository templateSectionRespository;

	@Override
	public TemplateSectionDTO saveOrUpdate(TemplateSectionDTO templateSectionDTO) {
		return MapperUtils.mapToTargetClass(
				templateSectionRespository
						.save(MapperUtils.mapToTargetClass(templateSectionDTO, TemplateSection.class)),
				TemplateSectionDTO.class);
	}

	@Override
	public TemplateSectionDTO findById(String sectionId) {
		return MapperUtils.mapToTargetClass(
				templateSectionRespository.findById(sectionId)
						.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + sectionId)),
				TemplateSectionDTO.class);
	}

	@Override
	public List<TemplateSectionDTO> findByTemplateId(String templateId) {
		return GRCUtils.isValid(templateSectionRespository.findByTemplateId(templateId),
				GRCErrorConstants.ENTITY_NOT_FOUND + templateId);
	}

	@Override
	public List<String> getSectionNamesByTemplateId(String templateId) {
		return templateSectionRespository.getSectionNamesByTemplateId(templateId);
	}

	@Override
	public void deleteById(String templateSectionId) {
		templateSectionRespository.deleteById(templateSectionId);
	}

}
