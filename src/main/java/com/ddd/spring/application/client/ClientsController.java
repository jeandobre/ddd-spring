package com.ddd.spring.application.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/html/clients")
public class ClientsController {

	@GetMapping
	public ModelAndView index() {
		return new ModelAndView("pages/clients/index.html");
	}
		
}
