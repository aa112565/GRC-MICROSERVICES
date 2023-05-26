package com.asymmetrix.grc.oauth.common.aspect.service;

public interface AuditLogService {

	void saveAuditLog(String userId, String action, String actionResult,
		      String ipAddress, String message );
}