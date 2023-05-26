package com.grc.email.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;

import com.grc.email.common.constants.GRCConstants;
import com.grc.email.common.constants.GRCErrorConstants;
import com.grc.email.common.exception.GRCException;

public class GRCUtils {

  private GRCUtils() {}

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
    return new StringBuilder().append(GRCConstants.HTTP).append(request.getServerName())
        .append(GRCConstants.COLON).append(request.getServerPort()).append(request.getContextPath())
        .toString();
  }

	public static byte[] toPrimitivesBytes(Byte[] oBytes) {
		byte[] bytes = new byte[oBytes.length];
		for (int i = 0; i < oBytes.length; i++) {
			bytes[i] = oBytes[i];
		}
		return bytes;
	}
  
}
