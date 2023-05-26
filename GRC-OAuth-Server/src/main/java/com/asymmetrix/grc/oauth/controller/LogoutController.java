package com.asymmetrix.grc.oauth.controller;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

@FrameworkEndpoint
public class LogoutController {

	@Resource
	private TokenStore tokenStore;
	
	@Resource
	com.asymmetrix.grc.oauth.common.aspect.service.AuditLogService auditLogService;

	private static final String AUTH_TOKEN = "auth_token";
	private static final String BEARER = "Bearer";
	private static final String TOKEN_NOT_FOUND = "Token not found";
	private static final String ERROR_MSG = "auth_token not found in the header";
	private static final String LOGOUT = "LOGOUT";
	private static final String LOGOUT_SUCCESS = "LOGOUT_SUCCESS";
	private static final String USER_NAME = "username";

	@DeleteMapping("/oauth/token")
	@ResponseStatus(HttpStatus.OK)
	public void revokeToken(@RequestHeader(name = AUTH_TOKEN, required = true) String authorization,
			HttpServletResponse response) throws IOException {
		if (authorization != null && authorization.contains(BEARER)) {
			String tokenId = authorization.substring(BEARER.length() + 1);
			OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenId);
			if (Optional.ofNullable(accessToken).isPresent()) {
				Optional.ofNullable(accessToken.getRefreshToken()).ifPresent(tokenStore::removeRefreshToken);
				tokenStore.removeAccessToken(accessToken);
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String ipAddress = ((WebAuthenticationDetails) authentication.getDetails()).getRemoteAddress();
				auditLogService.saveAuditLog(accessToken.getAdditionalInformation().get(USER_NAME).toString(), LOGOUT, LOGOUT_SUCCESS,ipAddress, LOGOUT_SUCCESS);
			} else {
				throw new InvalidTokenException(TOKEN_NOT_FOUND);
			}
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, ERROR_MSG);
		}
	}
}
