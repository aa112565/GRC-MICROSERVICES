package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.utils.constants.GRCErrorConstants;
import com.asymmetrix.grc.dto.TemplateDTO;
import com.asymmetrix.grc.entity.Template;
import com.asymmetrix.grc.repository.TemplateRepository;
import com.asymmetrix.grc.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Resource
	private TemplateRepository templateRespository;
	
	private static final String MODIFIED_DATE = "modifiedDate";

	@Override
	public TemplateDTO saveOrUpdate(TemplateDTO template) {
		return MapperUtils.mapToTargetClass(
				templateRespository.save(MapperUtils.mapToTargetClass(template, Template.class)), TemplateDTO.class);
	}

	@Override
	public TemplateDTO findById(String templateId) {
		return MapperUtils.mapToTargetClass(templateRespository.findById(templateId).orElseThrow(
				() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + templateId)), TemplateDTO.class);
	}

	@Override
	public List<TemplateDTO> getAll() {
		return MapperUtils.mapToTargetClass(templateRespository.findAll(Sort.by(Sort.Direction.DESC, MODIFIED_DATE)),
				TemplateDTO.class);
	}

	@Override
	public void deleteById(String templateId) {
		templateRespository.deleteById(templateId);
	}

	@Override
	public List<TemplateDTO> findByTemplateStatus(String templateStatus) {
		return MapperUtils.mapToTargetClass(templateRespository.findByTemplateStatus(templateStatus),
				TemplateDTO.class);
	}

	@Override
	public List<TemplateDTO> findByTemplateName(String templateName) {
		return MapperUtils.mapToTargetClass(templateRespository.findByTemplateNameContainingIgnoreCase(templateName),
				TemplateDTO.class);
	}

	@Override
	public List<TemplateDTO> findTemplateByCreateDateWithLimit(int pageByLimit) {
		Pageable pageableObj = PageRequest.of(0, pageByLimit, Sort.by(Sort.Direction.DESC, MODIFIED_DATE));
		Page<Template> template = GRCUtils.isValid(templateRespository.findAll(pageableObj),
				GRCErrorConstants.NOT_VALID);
		return MapperUtils.mapToTargetClass(template.getContent(), TemplateDTO.class);
	}
	
}
