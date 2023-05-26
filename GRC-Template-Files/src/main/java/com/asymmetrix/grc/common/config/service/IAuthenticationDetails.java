package com.asymmetrix.grc.common.config.service;

import org.springframework.security.core.Authentication;

import com.asymmetrix.grc.common.dto.LoginUserDetails;

public interface IAuthenticationDetails {
	Authentication getAuthentication();

	String getOAuthBearerToken();

	LoginUserDetails getLoginUserDetails();

	String getLoginUserName();
}