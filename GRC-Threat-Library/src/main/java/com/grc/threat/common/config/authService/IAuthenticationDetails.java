package com.grc.threat.common.config.authService;

import org.springframework.security.core.Authentication;

public interface IAuthenticationDetails {
	Authentication getAuthentication();
}
