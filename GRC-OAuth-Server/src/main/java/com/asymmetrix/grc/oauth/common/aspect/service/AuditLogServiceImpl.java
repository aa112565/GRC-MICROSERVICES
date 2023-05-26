package com.asymmetrix.grc.oauth.common.aspect.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.oauth.common.aspect.entity.AuditLog;
import com.asymmetrix.grc.oauth.common.aspect.repository.AuditLogRepository;

@Service
public class AuditLogServiceImpl implements AuditLogService {
	@Resource
	AuditLogRepository auditLogRepo;

	@Override
	public void saveAuditLog(String userId, String action, String actionResult, String ipAddress, String message) {
		AuditLog audlogObj = new AuditLog();
		audlogObj.setAction(action);
		audlogObj.setIpAddress(ipAddress);
		audlogObj.setMessage(message);
		audlogObj.setActionResult(actionResult);
		audlogObj.setUserId(userId);
		audlogObj.setCreatedTime(new Date());
		auditLogRepo.save(audlogObj);
	}

}