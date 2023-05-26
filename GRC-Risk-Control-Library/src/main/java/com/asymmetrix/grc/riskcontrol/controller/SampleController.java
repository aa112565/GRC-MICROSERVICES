package com.asymmetrix.grc.riskcontrol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping({ "/Test" })
	public String messageDisplay() {
		return "Welcome";

	}

}
