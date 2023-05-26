package com.grc.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grc.email.entity.AuditAttachment;
import com.grc.email.entity.AuditAttachmentId;

public interface AuditAttachmentRepository extends JpaRepository<AuditAttachment, AuditAttachmentId>{
	AuditAttachment findByAuditIdAndFileName(Long auditId, String fileName);
}
