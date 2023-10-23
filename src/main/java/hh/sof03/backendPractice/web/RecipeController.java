package hh.sof03.backendPractice.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.backendPractice.domain.Recipe;

@Controller
public class RecipeController {
	
	private final List<Recipe> recipes = new ArrayList<Recipe>();

	@GetMapping(value = "/index")
	public String getRecipes(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("recipes", recipes);
		return "index";

	}
}
