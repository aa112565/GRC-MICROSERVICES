package com.asymmetrix.grc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.asymmetrix.grc.entity.seq.TemplateSectionSequenceIdGenerator;

@Entity
@Table(name = "TEMPLATE_SECTION")
public class TemplateSection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen_seq")
	@GenericGenerator(name = "idGen_seq", strategy = "com.asymmetrix.grc.entity.seq.TemplateSectionSequenceIdGenerator", parameters = {
			@Parameter(name = TemplateSectionSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = TemplateSectionSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TS_"),
			@Parameter(name = TemplateSectionSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%1d") })
	@Column(name = "v_template_section_id", updatable = false)
	private String templateSectionId;

	@Column(name = "v_template_id", nullable = false)
	private String templateId;

	@Column(name = "v_section_name", nullable = false)
	private String sectionName;

	public TemplateSection(String templateSectionId, String templateId, String sectionName) {
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

	public TemplateSection() {
		super();
	}

}
