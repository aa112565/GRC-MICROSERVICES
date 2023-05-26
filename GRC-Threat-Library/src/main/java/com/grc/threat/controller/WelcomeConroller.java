package com.grc.threat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeConroller {

	@GetMapping({ "/" })
	public String welcome() {
		return "Welcome to Risk - Threat Management Application !";
	}

}
