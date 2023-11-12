package hh.sof03.backendPractice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.backendPractice.domain.TypeRepository;

@Controller
public class TypeController {
	
	@Autowired
	private TypeRepository typeRepository;
	
	@GetMapping(value="/typelist")
	public String getTypes(Model model) {
		model.addAttribute("types", typeRepository.findAll());
		return "typelist";
	}

}
