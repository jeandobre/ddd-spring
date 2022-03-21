package dddspring.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReferralController {
    
	@GetMapping("/referrals")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("pages/referrals/index.html");

		return model;
	}
}
