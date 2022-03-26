package com.ddd.spring.common;

import org.springframework.http.ResponseEntity;

public abstract class AbstractController {

	private final ApplicationService applicationService;

	public AbstractController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	public ResponseEntity<Object> processRequest(Command command) {
		return this.applicationService.process(command);
	}
}
