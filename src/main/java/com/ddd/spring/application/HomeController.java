package com.ddd.spring.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("pages/home/index");
		model.addObject("info", "Apenas um teste");
		return model;
	}
	
	
}
