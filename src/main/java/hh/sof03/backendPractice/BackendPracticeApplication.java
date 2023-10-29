package hh.sof03.backendPractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.backendPractice.domain.Recipe;
import hh.sof03.backendPractice.domain.RecipeRepository;

@SpringBootApplication
public class BackendPracticeApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BackendPracticeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendPracticeApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository recipeRepository) {
		return(args) -> {
			Recipe recipe1 = new Recipe("Boiled egg", "Makes a hard boiled egg.", "1. Boil an egg.");
			Recipe recipe2 = new Recipe("Fried egg", "Easy way to fry an egg.", "1. Fry an egg.");
			recipeRepository.save(recipe1);
			recipeRepository.save(recipe2);
		};
	}

}
