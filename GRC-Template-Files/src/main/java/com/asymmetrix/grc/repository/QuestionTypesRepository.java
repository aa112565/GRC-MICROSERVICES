package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.QuestionTypes;

@Repository
public interface QuestionTypesRepository  extends JpaRepository<QuestionTypes, Integer> {

}
