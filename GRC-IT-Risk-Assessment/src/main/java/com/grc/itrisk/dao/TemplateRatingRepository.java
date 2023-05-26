package com.grc.itrisk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grc.itrisk.entity.TemplateRating;

@Repository
public interface TemplateRatingRepository extends JpaRepository<TemplateRating, Long> {
	
	@Query("FROM TemplateRating WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<TemplateRating> findAllTemplateRating();

	@Query("FROM TemplateRating WHERE templateId = :templateId AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	TemplateRating getTemplateRatingByRefId(@Param("templateId") long templateId);
}
