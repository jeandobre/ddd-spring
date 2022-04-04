package com.ddd.spring.application.referral;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ControllerReferral {

	public ControllerReferral() {
		System.out.println("ControllerReferral created...");
	}

	@GetMapping("/referrals")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("pages/referrals/index.html");

		return model;
	}
}
