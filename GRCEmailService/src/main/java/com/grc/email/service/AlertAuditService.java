package com.grc.email.service;

import java.util.List;

import com.grc.email.dto.AlertAuditDTO;
import com.grc.email.dto.AuditAttachmentDTO;

public interface AlertAuditService {
	List<AlertAuditDTO> getAlertAudit(Long alertSrNo);
	AuditAttachmentDTO downloadFile(Long id, String fileName);
}
