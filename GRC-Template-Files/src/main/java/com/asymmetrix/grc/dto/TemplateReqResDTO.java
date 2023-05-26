package com.asymmetrix.grc.dto;

import java.util.List;


public class TemplateReqResDTO {

	
	private List<TemplateAttachmentsDTO> vendorDocs;		
	private List<TemplateAttachmentsDTO> files;
	private List<TemplateAttachmentsDTO> vendorfiles;
	

	public List<TemplateAttachmentsDTO> getTemplateDocs() {
		return vendorDocs;
	}
	public void setTemplateDocs(List<TemplateAttachmentsDTO> vendorDocs) {
		this.vendorDocs = vendorDocs;
	}
	
	public List<TemplateAttachmentsDTO> getFiles() {
		return files;
	}
	public void setFiles(List<TemplateAttachmentsDTO> files) {
		this.files = files;
	}
	public List<TemplateAttachmentsDTO> getTemplatefiles() {
		return vendorfiles;
	}
	public void setTemplatefiles(List<TemplateAttachmentsDTO> vendorfiles) {
		this.vendorfiles = vendorfiles;
	}
			
	
}
