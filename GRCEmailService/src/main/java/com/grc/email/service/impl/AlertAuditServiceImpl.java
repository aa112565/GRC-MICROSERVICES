package com.grc.email.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.grc.email.common.utils.GRCUtils;
import com.grc.email.common.utils.MapperUtils;
import com.grc.email.dto.AlertAuditDTO;
import com.grc.email.dto.AuditAttachmentDTO;
import com.grc.email.entity.AuditAttachment;
import com.grc.email.repository.AlertAuditRepository;
import com.grc.email.repository.AuditAttachmentRepository;
import com.grc.email.service.AlertAuditService;

@Service
public class AlertAuditServiceImpl implements AlertAuditService {

	@Resource
	AlertAuditRepository alertAuditRepo;
	@Resource
	AuditAttachmentRepository auditAttachRepo;

	@Override
	public List<AlertAuditDTO> getAlertAudit(Long alertSrNo) {
		return MapperUtils.mapToTargetClass(alertAuditRepo.findByAlertSrNo(alertSrNo), AlertAuditDTO.class);
	}

	@Override
	public AuditAttachmentDTO downloadFile(Long fileId, String fileName) {
		AuditAttachment attachment = auditAttachRepo.findByAuditIdAndFileName(fileId, fileName);
		GRCUtils.isValid(attachment, "No Attachment found !");
		return MapperUtils.mapToTargetClass(attachment,
				AuditAttachmentDTO.class);
	}

}
