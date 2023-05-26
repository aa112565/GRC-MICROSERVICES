package com.asymmetrix.grc.common.config.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCUtils;

@Service
public class AuthenticationDetailsImpl implements IAuthenticationDetails {

	private static final String INVALID_AUTH = "Invalid Authentication instance";
	private static final String INVALID_OAUTH2_AUTH_DETAILS = "Invalid OAuth2Authentication Details instance";

	@Override
	public Authentication getAuthentication() {
		return getAuth();
	}

	@Override
	public String getOAuthBearerToken() {
		OAuth2AuthenticationDetails oauth = getOauth2AuthDetails();
		return oauth.getTokenType().concat(" ").concat(oauth.getTokenValue());
	}

	@Override
	public LoginUserDetails getLoginUserDetails() {
		return (LoginUserDetails) getOauth2AuthDetails().getDecodedDetails();
	}

	@Override
	public String getLoginUserName() {
		return getAuth().getName();
	}

	private OAuth2AuthenticationDetails getOauth2AuthDetails() {
		Authentication auth = getAuth();
		if (auth.getDetails() instanceof OAuth2AuthenticationDetails) {
			return (OAuth2AuthenticationDetails) auth.getDetails();
		} else {
			throw new GRCException(INVALID_OAUTH2_AUTH_DETAILS);
		}
	}

	private Authentication getAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		GRCUtils.isValid(auth, INVALID_AUTH);
		return auth;
	}

}