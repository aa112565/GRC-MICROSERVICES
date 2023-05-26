package com.grc.email.entity;

import java.io.Serializable;

public class AuditAttachmentId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long auditId;
	private String fileName;
	
	public AuditAttachmentId(){}
	
	public AuditAttachmentId(Long auditId, String fileName) {
		super();
		this.auditId = auditId;
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditId == null) ? 0 : auditId.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditAttachmentId other = (AuditAttachmentId) obj;
		if (auditId == null) {
			if (other.auditId != null)
				return false;
		} else if (!auditId.equals(other.auditId))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}
	
	
	
	
}
