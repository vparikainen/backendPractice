package hh.sof03.backendPractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

}
