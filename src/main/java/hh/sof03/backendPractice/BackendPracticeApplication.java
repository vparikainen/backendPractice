package hh.sof03.backendPractice;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.backendPractice.domain.Ingredient;
import hh.sof03.backendPractice.domain.IngredientRepository;
import hh.sof03.backendPractice.domain.Recipe;
import hh.sof03.backendPractice.domain.RecipeRepository;
import hh.sof03.backendPractice.domain.Type;
import hh.sof03.backendPractice.domain.TypeRepository;

@SpringBootApplication
public class BackendPracticeApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BackendPracticeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendPracticeApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, TypeRepository typeRepository) {
		return(args) -> {
			Ingredient ingredient1 = new Ingredient("Egg");
			ingredientRepository.save(ingredient1);
			
			Type type1 = new Type("salty");
			typeRepository.save(type1);
			
			
			Recipe recipe1 = new Recipe("Boiled egg", "How to make a hard boiled egg.", ingredient1, "1. Boil an egg.", type1);
			recipeRepository.save(recipe1);
			
			log.info("Fetch all the recipes");
			for (Recipe recipe : recipeRepository.findAll()) {
				log.info(recipe.toString());
			}
		};
	}

}
