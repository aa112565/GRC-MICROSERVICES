package com.asymmetrix.grc.common.aspect;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.utils.GRCUtils;



import org.aspectj.lang.JoinPoint;





@Aspect
@Component
public class MaskUserFieldViewActionAspect {
	@Resource
	private HttpServletRequest request;

	@AfterReturning(value = "@annotation(MaskUserField)", returning = "result")
	public <T> void maskUserData(JoinPoint joinPoint, Object result)
			throws IllegalAccessException, ClassNotFoundException {
		if (isReqUrlContainsView()) {
			@SuppressWarnings("unchecked")
			ResponseEntity<GRCResponse<?>> response = (ResponseEntity<GRCResponse<?>>) result;
			if (isTypeAsList(response.getBody().getResult())) {
				@SuppressWarnings("unchecked")
				List<T> t = (List<T>) response.getBody().getResult();
				maskData(t);
			} else {
				maskData(response.getBody().getResult());
			}
		}
	}

	private <T> void maskData(List<T> list) throws IllegalAccessException, ClassNotFoundException {
		for (T t : list) {
			maskAnnotatedFields(t);
		}
	}

	private <T> void maskData(T t) throws IllegalAccessException, ClassNotFoundException {
		maskAnnotatedFields(t);
	}

	private <T> void maskAnnotatedFields(T t) throws IllegalAccessException, ClassNotFoundException {
		Class<?> clazz = Class.forName(t.getClass().getName());
		for (Field field : clazz.getDeclaredFields()) {
			if (!ObjectUtils.isEmpty(field.getAnnotationsByType(MaskUserField.class))) {
				field.setAccessible(true);
				if (field.get(t) != null) {
					field.set(t, GRCUtils.maskInput(field.get(t).toString()));
				}
			}
		}
	}

	private <T> boolean isTypeAsList(T t) {
		return (t instanceof List) ? Boolean.TRUE : Boolean.FALSE;
	}

	private boolean isReqUrlContainsView() {
		String url = request.getRequestURI();
		return url.contains("view");
	}


}
