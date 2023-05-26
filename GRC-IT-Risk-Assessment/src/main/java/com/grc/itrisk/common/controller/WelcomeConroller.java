package com.grc.itrisk.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeConroller {

	@GetMapping({ "/" })
	public String welcome() {
		return "Welcome to GRC - IT Risk Assessment Application !";
	}

}
