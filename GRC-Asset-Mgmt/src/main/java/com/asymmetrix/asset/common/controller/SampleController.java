package com.asymmetrix.asset.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.asset.common.aspect.Loggable;

@RestController
public class SampleController {
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ASSET-LIBRARY-DETAILS";

	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@GetMapping({ "/Test" })
	public String messageDisplay() {
		return "Welcome";

	}

}
