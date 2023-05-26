package com.asymmetrix.grc.common.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.util.ObjectUtils;

public class BCryptUtils {

	private BCryptUtils() {
	}

	public static String hashInput(String input) {
		if (ObjectUtils.isEmpty(input)) {
			return input;
		}
		return BCrypt.hashpw(input, BCrypt.gensalt());
	}

}
