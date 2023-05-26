package com.asymmetrix.grc.common.aspect;

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
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.aspect.entity.AuditLog;
import com.asymmetrix.grc.common.aspect.repository.AuditLogRepository;
import com.asymmetrix.grc.common.config.authService.IAuthenticationDetails;
import com.asymmetrix.grc.common.constants.ControlLibraryConstants;
import com.asymmetrix.grc.common.exception.ControlLibraryException;
import com.asymmetrix.grc.common.utils.ControlLibraryUtils;

@Aspect
@Component
@Transactional
public class AuditingJobAspect {

	private static final String ANNOTATION_LOGGABLE = "@annotation(loggable)";
	private static final String PRE_AUTHORIZE_LISTENER = "execution(* com.asymmetrix.grc.common.config.listener.CustomAuthorizationAuditListener.*(..))";

	private static final String STARTED = "Started";
	private static final String IN_PROGRESS = "In-Progress";
	private static final String COMPLETED = "Completed";
	private static final String SUCCESS = "Success";
	private static final String ERROR = "Error";
	private static final String PRE_AUTHORIZE = "PreAuthorize";
	private static final String ANONYMOUS_USER = "anonymousUser";

	private static final String SPEC_CHAR_HYPHEN = "-";

	private static final String LOGGABLE = "loggable";

	private static final String ERROR_AUTHORIZATION_HEADER_NOT_FOUND = "User is anonymousUser, Authorization Header not found (User is not authenticated)";

	@Resource
	AuditLogRepository auditRepo;

	@Resource
	HttpServletRequest request;

	@Resource
	private IAuthenticationDetails authentication;

	@Before(value = ANNOTATION_LOGGABLE, argNames = LOGGABLE)
	public void logBeforeAction(JoinPoint jp, Loggable loggable) {
		saveAuditLog(loggable.action(), STARTED, IN_PROGRESS);
	}

	@After(value = ANNOTATION_LOGGABLE, argNames = LOGGABLE)
	public void logAfterAction(JoinPoint jp, Loggable loggable) {
		saveAuditLog(loggable.action(), SUCCESS, COMPLETED);
	}

	@AfterThrowing(pointcut = ANNOTATION_LOGGABLE, throwing = "error")
	public void logAfterThrowingError(JoinPoint jp, Loggable loggable, Throwable error) {
		saveAuditLog(loggable.action(), ERROR, error.getMessage());
	}

	@After(PRE_AUTHORIZE_LISTENER)
	public void handleAccessDeniedExecption(JoinPoint jp) {
		saveAccessDeniedLog(jp);
	}

	private String getIpAddress() {
		return request.getRemoteAddr();
	}

	private void saveAuditLog(String action, String message, String actionResult) {
		String userName = ControlLibraryConstants.ANONYMOUS_USER;
		if (!ObjectUtils.isEmpty(authentication) && !ObjectUtils.isEmpty(authentication.getAuthentication())) {
			userName = authentication.getAuthentication().getName();
		}
		auditRepo.save(getAuditLogObj(userName, action, actionResult, getIpAddress(), message));
	}

	private AuditLog getAuditLogObj(String userId, String action, String actionResult, String ipAddress,
			String message) {
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
			throw new ControlLibraryException(ERROR_AUTHORIZATION_HEADER_NOT_FOUND);
		}
		auditRepo.save(getAuditLogObj(getUserName(event),
				ControlLibraryUtils.toUpperWithSpeChar(getMethodName(event), SPEC_CHAR_HYPHEN), PRE_AUTHORIZE,
				getIpAddress(), getErrorMsg(event)));
	}

	private String getErrorMsg(AuthorizationFailureEvent event) {
		return event.getAccessDeniedException().getMessage();
	}

	private String getUserName(AuthorizationFailureEvent event) {
		return event.getAuthentication().getName();
	}

	private String getMethodName(AuthorizationFailureEvent event) {
		return ((ReflectiveMethodInvocation) event.getSource()).getMethod().getName();
	}

}
