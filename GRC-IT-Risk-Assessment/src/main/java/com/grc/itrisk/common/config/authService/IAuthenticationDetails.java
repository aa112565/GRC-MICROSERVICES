package com.grc.itrisk.common.config.authService;

import org.springframework.security.core.Authentication;

public interface IAuthenticationDetails {
	Authentication getAuthentication();
	 public String getOAuthBearerToken();
}
