package hh.sof03.backendPractice.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.backendPractice.domain.Recipe;
import hh.sof03.backendPractice.domain.RecipeRepository;

@RestController
public class RecipeRestController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	// RESTful service to get all recipes
	@GetMapping(value="/recipes")
	public @ResponseBody List<Recipe> recipeListRest() {
		return(List<Recipe>)recipeRepository.findAll();
	}
	
	// RESTful service to get recipe by id
	@GetMapping(value="/recipes/{id}")
	public @ResponseBody Optional<Recipe> findRecipeRest(@PathVariable("id") Long recipeId) {
		return recipeRepository.findById(recipeId);
	}
	
	// RESTFUL service to save new recipe
	@PostMapping(value="/recipes")
	public @ResponseBody Recipe saveRecipe(@RequestBody Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
	@DeleteMapping(value="/recipes/{id}")
	public ResponseEntity<Void> deleteRecipe(@PathVariable("id") Long recipeId) {
		Optional<Recipe> recipe = recipeRepository.findById(recipeId);
		if (recipe.isPresent()) {
			recipeRepository.deleteById(recipeId);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
