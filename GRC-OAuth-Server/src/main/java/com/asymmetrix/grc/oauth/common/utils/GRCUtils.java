package com.asymmetrix.grc.oauth.common.utils;

import java.util.List;

import static java.util.stream.Collectors.joining;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.oauth.common.exception.GRCException;

public class GRCUtils {

	private GRCUtils() {
	}

	public static <T> void isValid(T t) {
		if (ObjectUtils.isEmpty(t)) {
			throw new GRCException(GRCErrorConstants.VALUE_IS_NULL);
		}
	}

	public static <T> void isValid(T t, String msg) {
		if (ObjectUtils.isEmpty(t)) {
			throw new GRCException(msg);
		}
	}

	public static String toUpperWithSpeChar(String str, String specialChar) {
		return str.replaceAll("()([A-Z])", "$1" + specialChar + "$2").toUpperCase();
	}

	public static String getAppUrl(HttpServletRequest request) {
		return new StringBuilder().append(GRCConstants.HTTP).append(request.getServerName()).append(GRCConstants.COLON)
				.append(request.getServerPort()).append(request.getContextPath()).toString();
	}

	public static String listToCSVString(List<String> list) {
		return !ObjectUtils.isEmpty(list)
				? list.stream().filter(x -> !ObjectUtils.isEmpty(x)).collect(joining(GRCConstants.COMMA))
				: null;
	}

}
