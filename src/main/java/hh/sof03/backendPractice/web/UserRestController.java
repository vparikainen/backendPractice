package hh.sof03.backendPractice.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.backendPractice.domain.User;
import hh.sof03.backendPractice.domain.UserRepository;

@Controller
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value="/users")
	public @ResponseBody List<User> userListRest() {
		return(List<User>)userRepository.findAll();
	}
	
	@GetMapping(value="/users/{id}")
	public @ResponseBody Optional<User> findUserRest(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping(value="/users")
	public @ResponseBody User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
