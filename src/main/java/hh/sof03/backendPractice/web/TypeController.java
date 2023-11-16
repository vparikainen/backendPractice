package hh.sof03.backendPractice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.backendPractice.domain.Type;
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
	
	@RequestMapping(value="/addtype")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addType(Model model) {
		model.addAttribute("type", new Type());
		return "addtype";
	}
	
	@PostMapping(value="/savetype")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String save(Type type) {
		typeRepository.save(type);
		return "redirect:/typelist";
	}
	
 	@GetMapping(value = "/remove/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteType(@PathVariable("id") Long typeId, Model model) {
    	typeRepository.deleteById(typeId);
        return "redirect:/typelist";
    }
 	
}
