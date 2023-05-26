package com.grc.itrisk.service;

import java.util.List;


import com.grc.itrisk.dto.TemplateRatingDTO;
import com.grc.itrisk.entity.TemplateRating;

public interface TemplateRatingService {

	List<TemplateRating> getAllTemplateRating(); 

	TemplateRating getTemplateRatingById(long templateRatingId);	

	TemplateRating createTemplateRating(TemplateRatingDTO templateRatingDto);

	TemplateRating updateTemplateRating(TemplateRatingDTO templateRatingDto);

	boolean deleteTemplateRating(TemplateRatingDTO templateRatingDto);

	boolean inActiveTemplateRating(TemplateRatingDTO templateRating);

	boolean activeTemplateRating(TemplateRatingDTO templateRating);

//	TemplateRating getAllTemplateRatingByRefId(long templateId);

	TemplateRating getTemplateRatingByRefId(long templateId);

	

//	List<TemplateRatingDDDTO> getAllTemplateDD();

	
}
