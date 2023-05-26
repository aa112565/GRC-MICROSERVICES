package com.asymmetrix.grc.risk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;

@RestController
public class SampleController {
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-RIS-LIBRARY-TEST";

	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@GetMapping({ "/Test" })
	public String messageDisplay() {
		return "Welcome";

	}

}
