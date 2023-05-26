package com.asymmetrix.grc.service;

public interface OTPService {

	String mailOTP(final String userId);

	boolean validateOTP(final String userId, final int otp);

}