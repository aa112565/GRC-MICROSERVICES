package com.asymmetrix.grc.common.config.authService;

import org.springframework.security.core.Authentication;

public interface IAuthenticationDetails {
	Authentication getAuthentication();
}
