package com.asymmetrix.asset.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeConroller {

	@GetMapping({ "/" })
	public String welcome() {
		return "Welcome to Compliance - Asset Management Application !";
	}

}
