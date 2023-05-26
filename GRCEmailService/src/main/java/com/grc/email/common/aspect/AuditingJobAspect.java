package com.grc.email.common.aspect;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.grc.email.common.aspect.entity.AuditLog;
import com.grc.email.common.aspect.repository.AuditLogDao;
import com.grc.email.common.exception.GRCException;
import com.grc.email.common.utils.GRCUtils;


@Aspect
@Component
@Transactional
public class AuditingJobAspect {

  private static final String ANNOTATION_LOGGABLE = "@annotation(loggable)";
  private static final String PRE_AUTHORIZE_LISTENER =
      "execution(* com.grc.email.common.config.listener.CustomAuthorizationAuditListener.*(..))";

  private static final String STARTED = "Started";
  private static final String IN_PROGRESS = "In-Progress";
  private static final String COMPLETED = "Completed";
  private static final String SUCCESS = "Success";
  private static final String ERROR = "Error";
  private static final String PRE_AUTHORIZE = "PreAuthorize";
  private static final String ANONYMOUS_USER = "anonymousUser";

  private static final String SPEC_CHAR_HYPHEN = "-";

  private static final String LOGGABLE = "loggable";

  private static final String ERROR_METHOD_FIRST_ARG_AUTH =
      "Method's first argument should be Authentication";

  private static final String ERROR_AUTHORIZATION_HEADER_NOT_FOUND =
      "User is anonymousUser, Authorization Header not found";

  @Resource
  AuditLogDao auditDao;
  
  @Resource
  HttpServletRequest request;

  @Before(value = ANNOTATION_LOGGABLE, argNames = LOGGABLE)
  public void logBeforeAction(JoinPoint jp, Loggable loggable) {
    saveAuditLog(jp, loggable.action(), STARTED, IN_PROGRESS);
  }

  @After(value = ANNOTATION_LOGGABLE, argNames = LOGGABLE)
  public void logAfterAction(JoinPoint jp, Loggable loggable) {
    saveAuditLog(jp, loggable.action(), SUCCESS, COMPLETED);
  }

  @AfterThrowing(pointcut = ANNOTATION_LOGGABLE, throwing = "error")
  public void logAfterThrowingError(JoinPoint jp, Loggable loggable, Throwable error) {
    saveAuditLog(jp, loggable.action(), ERROR, error.getMessage());
  }

  @After(PRE_AUTHORIZE_LISTENER)
  public void handleAccessDeniedExecption(JoinPoint jp) {
    saveAccessDeniedLog(jp);
  }

  private Authentication getAuthObj(JoinPoint jp) {
    if (!ObjectUtils.isEmpty(jp.getArgs()) && jp.getArgs().length >= 1
        && jp.getArgs()[0] instanceof Authentication) {
      return (Authentication) jp.getArgs()[0];
    } else {
    	throw new IllegalArgumentException(ERROR_METHOD_FIRST_ARG_AUTH);
    }
  }

  private String getIpAddress(Authentication auth) {
	  /*
		 * since we are getting the wso2 Ip address as remote ip address so we are
		 * setting clientIp in the header with key :"REMOTE_ADDR" from WSO2 API Manager
		 */
		String remoteAddress = request.getHeader("REMOTE_ADDR");
		return (!ObjectUtils.isEmpty(remoteAddress)) ? remoteAddress
				: request.getRemoteAddr();
  }

  private void saveAuditLog(JoinPoint jp, String action, String message, String actionResult) {
    Authentication auth = getAuthObj(jp);
    auditDao
        .save(getAuditLogObj(auth.getName(), action, actionResult, getIpAddress(auth), message));
  }

  private AuditLog getAuditLogObj(String userId, String action, String actionResult,
      String ipAddress, String message) {
    AuditLog audlogObj = new AuditLog();
    audlogObj.setAction(action);
    audlogObj.setIpAddress(ipAddress);
    audlogObj.setMessage(message);
    audlogObj.setActionResult(actionResult);
    audlogObj.setUserId(userId);
    audlogObj.setCreatedTime(new Date());
    return audlogObj;
  }

  private void saveAccessDeniedLog(JoinPoint jp) {
    AuthorizationFailureEvent event = (AuthorizationFailureEvent) jp.getArgs()[0];
    if (ANONYMOUS_USER.equals(event.getAuthentication().getName())
        && (event.getAuthentication() instanceof AnonymousAuthenticationToken)) {
      throw new GRCException(ERROR_AUTHORIZATION_HEADER_NOT_FOUND);
    }
    auditDao.save(getAuditLogObj(getUserName(event),
        GRCUtils.toUpperWithSpeChar(getMethodName(event), SPEC_CHAR_HYPHEN), PRE_AUTHORIZE,
        getIpAddress(event), getErrorMsg(event)));
  }

  private String getErrorMsg(AuthorizationFailureEvent event) {
    return event.getAccessDeniedException().getMessage();
  }

  private String getUserName(AuthorizationFailureEvent event) {
    return event.getAuthentication().getName();
  }

  private String getIpAddress(AuthorizationFailureEvent event) {
    if (event.getAuthentication().getDetails() instanceof OAuth2AuthenticationDetails) {
      return ((OAuth2AuthenticationDetails) event.getAuthentication().getDetails()).getRemoteAddress();
    } else {
      return ((WebAuthenticationDetails) event.getAuthentication()).getRemoteAddress();
    }
  }

  private String getMethodName(AuthorizationFailureEvent event) {
    return ((ReflectiveMethodInvocation) event.getSource()).getMethod().getName();
  }

}
