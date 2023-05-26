package com.asymmetrix.grc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateDTO extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	private String templateId;

	@NotBlank
	private String templateName;

	private String createdBy;

	private String lastUpdatedBy;

	private String templateStatus = "DRAFT";

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

	public TemplateDTO(String templateId, String templateName, String createdBy, String lastUpdatedBy,
			String templateStatus, Date createdDate, Date modifiedDate) {
		super(createdDate, modifiedDate);
		this.templateId = templateId;
		this.templateName = templateName;
		this.createdBy = createdBy;
		this.lastUpdatedBy = lastUpdatedBy;
		this.templateStatus = templateStatus;
	}

	public TemplateDTO() {
		super();
	}

}
