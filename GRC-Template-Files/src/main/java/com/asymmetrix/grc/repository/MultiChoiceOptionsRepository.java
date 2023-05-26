package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.MultiChoiceOptions;

@Repository
public interface MultiChoiceOptionsRepository  extends JpaRepository<MultiChoiceOptions, Integer> {
	
	public List<MultiChoiceOptions> findByQuestionId(String questionId);
	
	@Transactional
	@Modifying
	public void deleteByQuestionId(String questionId);

}
