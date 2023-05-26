package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.QuestionTypesDTO;
import com.asymmetrix.grc.repository.QuestionTypesRepository;
import com.asymmetrix.grc.service.QuestionTypesService;

@Service
public class QuestionTypesServiceImpl implements QuestionTypesService {

	@Resource
	private QuestionTypesRepository questionTypesRepo;

	public List<QuestionTypesDTO> getAllTypes() {
		return MapperUtils.mapToTargetClass(questionTypesRepo.findAll(), QuestionTypesDTO.class);
	}

}
