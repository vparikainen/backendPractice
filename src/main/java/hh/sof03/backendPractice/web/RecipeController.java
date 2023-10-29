package hh.sof03.backendPractice.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.backendPractice.domain.Recipe;
import hh.sof03.backendPractice.domain.RecipeRepository;

@Controller
public class RecipeController {
	@Autowired
	private RecipeRepository recipeRepository;
	
	private final List<Recipe> recipes = new ArrayList<Recipe>();

	@GetMapping(value = "/recipelist")
	public String getRecipes(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "recipelist";

	}
}
