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

import com.asymmetrix.grc.entity.seq.TemplateSequenceIdGenerator;

@Entity
@Table(name = "TEMPLATE")
public class Template extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGen_seq")
	@GenericGenerator(name = "idGen_seq", strategy = "com.asymmetrix.grc.entity.seq.TemplateSequenceIdGenerator", parameters = {
			@Parameter(name = TemplateSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = TemplateSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "T_"),
			@Parameter(name = TemplateSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%1d") })
	@Column(name = "v_template_id")
	private String templateId;

	@Column(name = "v_template_name", nullable = false)
	private String templateName;

	@Column(name = "v_created_by", updatable = false, nullable = false)
	private String createdBy;

	@Column(name = "v_last_updated_by")
	private String lastUpdatedBy;

	@Column(name = "v_template_status", nullable = false)
	private String templateStatus;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getTemplateStatus() {
		return templateStatus;
	}

	public void setTemplateStatus(String templateStatus) {
		this.templateStatus = templateStatus;
	}

	public Template(String templateId, String templateName, String createdBy, String lastUpdatedBy,
			String templateStatus) {
		super();
		this.templateId = templateId;
		this.templateName = templateName;
		this.createdBy = createdBy;
		this.lastUpdatedBy = lastUpdatedBy;
		this.templateStatus = templateStatus;
	}

	public Template() {
		super();
	}

}
