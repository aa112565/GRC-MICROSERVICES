package com.asymmetrix.grc.common.config.service;

import org.springframework.security.core.Authentication;

public interface IAuthenticationDetails {
  public Authentication getAuthentication();
  public String getOAuthBearerToken();
}
