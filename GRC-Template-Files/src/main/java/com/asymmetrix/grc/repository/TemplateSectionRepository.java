package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.TemplateSectionDTO;
import com.asymmetrix.grc.entity.TemplateSection;

@Repository
public interface TemplateSectionRepository extends JpaRepository<TemplateSection, String> {

	@Query("Select new com.asymmetrix.grc.dto.TemplateSectionDTO(ts.templateSectionId, ts.templateId, "
			+ "ts.sectionName) FROM TemplateSection ts WHERE ts.templateId = :templateId")
	List<TemplateSectionDTO> findByTemplateId(String templateId);

	@Query("Select ts.sectionName FROM TemplateSection ts WHERE ts.templateId = :templateId")
	List<String> getSectionNamesByTemplateId(String templateId);

}
