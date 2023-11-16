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

import hh.sof03.backendPractice.domain.Type;
import hh.sof03.backendPractice.domain.TypeRepository;

@Controller
public class TypeRestController {
	
	@Autowired
	private TypeRepository typeRepository;
	
	// RESTful service to get all types
	@GetMapping(value="/types")
	public @ResponseBody List<Type> typeListRest() {
		return(List<Type>)typeRepository.findAll();
	}
	
	// RESTful service to get type by id
	@GetMapping(value="/types/{id}")
	public @ResponseBody Optional<Type> findTypeRest(@PathVariable("id") Long typeId) {
		return typeRepository.findById(typeId);
	}
	
	// RESTful service to save new type
	@PostMapping(value="/types")
	public @ResponseBody Type type(@RequestBody Type type) {
		return typeRepository.save(type);
	}

}
