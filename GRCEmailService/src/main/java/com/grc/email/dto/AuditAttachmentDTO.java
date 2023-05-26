package com.grc.email.dto;

public class AuditAttachmentDTO {
	private Long auditId;
	private byte[] file;
	private String fileName;
	private String filetype;
	
	public AuditAttachmentDTO(){}

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public AuditAttachmentDTO(Long auditId, byte[] file, String fileName, String filetype) {
		super();
		this.auditId = auditId;
		this.file = file;
		this.fileName = fileName;
		this.filetype = filetype;
	}
	
}
