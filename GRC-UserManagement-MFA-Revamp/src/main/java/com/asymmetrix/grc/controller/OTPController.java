package com.asymmetrix.grc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.service.OTPService;
import javax.annotation.Resource;
import com.asymmetrix.grc.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")
public class OTPController {

	@Resource
	UserService userServiceImpl;
	@Resource
	OTPService otpServiceImpl;

	@PostMapping({ "/mail/otp" })
	public ResponseEntity<GRCResponse<?>>  sendOTPToMail(final Authentication auth) {
		return GRCResponseEntity.success(otpServiceImpl.mailOTP(auth.getName()));
	}

	@PostMapping({ "/validate/otp/{otpVal}" })
	public ResponseEntity<GRCResponse<?>> validateOTP(final Authentication auth,
			@PathVariable(name = "otpVal", required = true) final int otpVal) {
		return GRCResponseEntity.success(otpServiceImpl.validateOTP(auth.getName(), otpVal));
	}
}