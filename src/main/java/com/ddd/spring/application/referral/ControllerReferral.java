package com.ddd.spring.application.referral;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerReferral {
    
	@GetMapping("/referrals")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("pages/referrals/index.html");

		return model;
	}
}
