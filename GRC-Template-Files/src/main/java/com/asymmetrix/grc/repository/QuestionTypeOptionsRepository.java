package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.QuestionTypeOptions;

@Repository
public interface QuestionTypeOptionsRepository extends JpaRepository<QuestionTypeOptions, Integer> {

	public List<QuestionTypeOptions> findByQtypeId(Integer qtypeId);

}
