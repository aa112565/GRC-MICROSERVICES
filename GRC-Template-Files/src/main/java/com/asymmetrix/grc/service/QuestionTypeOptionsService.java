package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.QuestionTypeOptionsDTO;

public interface QuestionTypeOptionsService {

	public List<QuestionTypeOptionsDTO> findByQtypeId(Integer id);

}
