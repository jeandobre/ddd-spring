package dddspring.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientsController {

	@RequestMapping("/clients")
	public String index() {
		return "pages/clients/index.html";
	}
		
}
