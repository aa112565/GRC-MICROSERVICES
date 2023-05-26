package com.asymmetrix.grc.oauth.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * 
 * CustomPasswordEnconder used for encode and password matching.  
 */

public final class CustomPasswordEnconder implements PasswordEncoder {

	/*
	 * Since password will be encrypted from UI.So we are returning the same.
	 */
	@Override
	public String encode(CharSequence encryptPwdFromUI) {
		return encryptPwdFromUI.toString();
	}

	/*
	 * Match the password
	 */
	@Override
	public boolean matches(CharSequence charSequence, String encryptPwdFromUI) {
		return charSequence.toString().equals(encryptPwdFromUI);
	}

}
