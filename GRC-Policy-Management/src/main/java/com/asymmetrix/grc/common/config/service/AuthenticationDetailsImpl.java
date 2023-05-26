package com.asymmetrix.grc.common.config.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import com.asymmetrix.grc.common.exception.GRCException;

@Component
public class AuthenticationDetailsImpl implements IAuthenticationDetails {
	
	private static final String INVALID_OAUTH2_AUTH_DETAILS = "Invalid OAuth2Authentication Details instance";

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@Override
	public String getOAuthBearerToken() {
		OAuth2AuthenticationDetails oauth = getOauth2AuthDetails();
		return oauth.getTokenType().concat(" ").concat(oauth.getTokenValue());
	}

	private OAuth2AuthenticationDetails getOauth2AuthDetails() {
		Authentication auth = getAuthentication();
		if (auth.getDetails() instanceof OAuth2AuthenticationDetails) {
			return (OAuth2AuthenticationDetails) auth.getDetails();
		} else {
			throw new GRCException(INVALID_OAUTH2_AUTH_DETAILS);
		}
	}

}
