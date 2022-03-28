package com.ddd.spring.application.client;

import dddspring.common.AppicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NewClientService extends AppicationService<NewClientForm, ResponseEntity<Object>> {

	@Override
	public ResponseEntity<Object> process(NewClientForm form) {
		return ResponseEntity.ok("teste");
	}
}
