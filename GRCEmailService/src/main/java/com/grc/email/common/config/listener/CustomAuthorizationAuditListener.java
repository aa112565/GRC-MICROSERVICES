package com.grc.email.common.config.listener;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.security.AbstractAuthorizationAuditListener;
import org.springframework.security.access.event.AbstractAuthorizationEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.stereotype.Component;

import com.grc.email.common.aspect.repository.AuditLogDao;

@Component
public class CustomAuthorizationAuditListener extends AbstractAuthorizationAuditListener {

  @Resource
  AuditLogDao auditDao;

  private static final Logger LOG = LoggerFactory.getLogger(CustomAuthorizationAuditListener.class);

  @Override
  public void onApplicationEvent(AbstractAuthorizationEvent event) {
    if (event instanceof AuthorizationFailureEvent) {
      onAuthorizationFailureEvent((AuthorizationFailureEvent) event);
    }
  }

  private void onAuthorizationFailureEvent(AuthorizationFailureEvent event) {
    LOG.error("PreAuthorization exception {} for user id {} ",
        event.getAccessDeniedException().getMessage(), event.getAuthentication().getName());
  }
}
