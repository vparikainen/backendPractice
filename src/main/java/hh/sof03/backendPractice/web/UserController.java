package hh.sof03.backendPractice.web;

import jakarta.validation.Valid;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.backendPractice.domain.SignupForm;
import hh.sof03.backendPractice.domain.User;
import hh.sof03.backendPractice.domain.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/signup")
	public String signup(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	// create a new user
	@PostMapping(value="/saveuser")
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
				String pswd = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPswd = bc.encode(pswd);
				
				User newUser = new User();
				newUser.setPasswordHash(hashPswd);
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");
				if (userRepository.findByUsername(signupForm.getUsername()) == null) {
					userRepository.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Password doesn't match");
				return "signup";
			}
		} else {
			return "signup";
		}
		return "redirect:/login";
	}

}
