package com.asymmetrix.grc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateSectionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String templateSectionId;

	@NotBlank
	private String templateId;

	@NotBlank
	private String sectionName;

	public TemplateSectionDTO(String templateSectionId, String templateId, String sectionName) {
		super();
		this.templateSectionId = templateSectionId;
		this.templateId = templateId;
		this.sectionName = sectionName;
	}

	public String getTemplateSectionId() {
		return templateSectionId;
	}

	public void setTemplateSectionId(String templateSectionId) {
		this.templateSectionId = templateSectionId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public TemplateSectionDTO() {
		super();
	}

}
