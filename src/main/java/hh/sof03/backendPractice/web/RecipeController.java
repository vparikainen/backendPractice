package hh.sof03.backendPractice.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.backendPractice.domain.Recipe;
import hh.sof03.backendPractice.domain.RecipeRepository;
import hh.sof03.backendPractice.domain.TypeRepository;

@Controller
public class RecipeController {
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private TypeRepository typeRepository;

	// show all recipes
	@GetMapping(value = {"/", "/recipelist"})
	public String getRecipes(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "recipelist";
	}
	
	// add new recipe
	@RequestMapping(value="/add")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("types", typeRepository.findAll());
		return "addrecipe";
	}
	
	// save new recipe
	@PostMapping(value="/save")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public String save(Recipe recipe) {
		recipeRepository.save(recipe);
		return "redirect:/recipelist";
	}
	
	// delete recipe by id
	@GetMapping(value="/delete/{id}")
	public String deleteRecipe(@PathVariable("id") Long recipeId, Model model, Authentication authentication) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
		
		if(recipeOptional.isPresent()) {
			Recipe recipe = recipeOptional.get();
			
			boolean isAdmin = authentication.getAuthorities().stream()
					.anyMatch(role -> role.getAuthority().equals("ADMIN"));
			
			if (isAdmin || isUserAllowed(authentication.getName(), recipe)) {
				recipeRepository.delete(recipe);
			} else {
				return "redirect:/recipelist";
			}
			
			}else {
				return "redirect:/recipelist";
		}
		return "redirect:/recipelist";
	}
	
	private boolean isUserAllowed(String username, Recipe recipe) {
		return username.equals(recipe.getUser().getUsername());
	}
	
	// edit recipe
	@RequestMapping(value="/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editRecipe(@PathVariable("id") Long recipeId, Model model) {
		model.addAttribute("recipe", recipeRepository.findById(recipeId));
		model.addAttribute("types", typeRepository.findAll());
		return "editrecipe";
	}
}
