package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.QuestionTypeOptionsDTO;
import com.asymmetrix.grc.repository.QuestionTypeOptionsRepository;
import com.asymmetrix.grc.service.QuestionTypeOptionsService;

@Service
public class QuestionTypeOptionsServiceImpl implements QuestionTypeOptionsService {

	@Resource
	private QuestionTypeOptionsRepository questionTypeOptionsRepo;

	public List<QuestionTypeOptionsDTO> findByQtypeId(Integer qtypeId) {
		return MapperUtils.mapToTargetClass(questionTypeOptionsRepo.findByQtypeId(qtypeId),
				QuestionTypeOptionsDTO.class);
	}

}
