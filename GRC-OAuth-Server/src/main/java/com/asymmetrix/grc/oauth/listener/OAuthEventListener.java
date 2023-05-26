package com.asymmetrix.grc.oauth.listener;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;

import org.springframework.stereotype.Component;

import com.asymmetrix.grc.oauth.common.aspect.service.AuditLogService;
import com.asymmetrix.grc.oauth.repository.UserRepository;

@Component
public class OAuthEventListener {

	private static final Logger LOG = LoggerFactory.getLogger(OAuthEventListener.class);

	private static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
	private static final String LOGIN = "LOGIN";
	private static final String LOGIN_FAILED = "LOGIN_FAILED";
	private static final String BAD_CREDENTIALS = "BAD_CREDENTIALS";
	private static final String FAILED_ATTEMPT = "FAILED_ATTEMPT";

	@Resource
	UserRepository userRepo;

	@Resource
	AuditLogService auditLogService;
	
	@Resource
	HttpServletRequest request;
	
	@Resource
	TokenStore tokenStore;

	@EventListener
	public void authSuccessEventListener(AbstractAuthenticationEvent event){
		if ((event.getAuthentication().getDetails() instanceof LinkedHashMap)
				&& (event.getAuthentication().isAuthenticated())) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			auditLogService.saveAuditLog(event.getAuthentication().getName(), LOGIN, LOGIN_SUCCESS,
					getIpAddress(authentication), LOGIN_SUCCESS);
			userRepo.updateLastLogin(new Date(), event.getAuthentication().getName());
			LOG.info(LOGIN_SUCCESS);
		}
	}

	@EventListener
	public void authFailureEventListerner(AuthenticationFailureBadCredentialsEvent event) {
		LOG.error(event.getException().getMessage());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		userRepo.incrementFailedAttempt(event.getAuthentication().getName());
		auditLogService.saveAuditLog(event.getAuthentication().getName(), FAILED_ATTEMPT, BAD_CREDENTIALS,
				getIpAddress(authentication), LOGIN_FAILED);
	}

	private String getIpAddress(Authentication auth) {
	//	return ((WebAuthenticationDetails) auth.getDetails()).getRemoteAddress();
		return request.getHeader("REMOTE_ADDR");
	}

}