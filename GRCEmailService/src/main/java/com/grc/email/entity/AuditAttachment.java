package com.grc.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@IdClass(AuditAttachmentId.class)
@Table(name = "adt_wf_alert_attachments")
public class AuditAttachment {
	@Id
	@Column(name = "N_ADT_ID")
	private Long auditId;
	@Lob
	@Column(name = "B_FILE")
	private byte[] file;
	@Id
	@Column(name = "V_FILENAME")
	private String fileName;
	@Column(name = "V_FILETYPE")
	private String filetype;
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
	public AuditAttachment() {}
	public AuditAttachment(Long auditId, byte[] file, String fileName, String filetype) {
		super();
		this.auditId = auditId;
		this.file = file;
		this.fileName = fileName;
		this.filetype = filetype;
	}
	public AuditAttachment(byte[] file, String fileName, String filetype) {
		super();
		this.file = file;
		this.fileName = fileName;
		this.filetype = filetype;
	}
	
}
