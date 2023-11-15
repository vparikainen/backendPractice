package hh.sof03.backendPractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.backendPractice.domain.Recipe;
import hh.sof03.backendPractice.domain.RecipeRepository;
import hh.sof03.backendPractice.domain.Type;
import hh.sof03.backendPractice.domain.TypeRepository;
import hh.sof03.backendPractice.domain.User;
import hh.sof03.backendPractice.domain.UserRepository;

@SpringBootApplication
public class BackendPracticeApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendPracticeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendPracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository recipeRepository, TypeRepository typeRepository,
			UserRepository userRepository) {
		return (args) -> {
			User user1 = new User("user", "$2a$10$RzYskoztN1v1G7WnrVl.LeM9VwA7NaxOrwOLbYgyu4ymehHODTEaq", "USER");
			User user2 = new User("admin", "$2a$10$rqmyFj6hq8LQazpLS.AMue8jwcvWF2W4CiPlV6Jn0B5mysHRq9BDa", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

			Type type1 = new Type("salty");
			Type type2 = new Type("sweet");
			Type type3 = new Type("beverage");
			typeRepository.save(type1);
			typeRepository.save(type2);
			typeRepository.save(type3);

			Recipe recipe1 = new Recipe("Boiled egg", "How to make a hard boiled egg.", "egg", "1. Boil the egg.",
					type1, user2);
			Recipe recipe2 = new Recipe("Fried egg", "How to fry an egg.", "egg", "Fry the egg.", type1, user1);
			Recipe recipe3 = new Recipe("Hot cocoa", "Delicious homemade hot cocoa.", "Cocoa powder, Sugar, Chocolate, Milk, Heavy Cream, Vanilla extract", "1. In a saucepan, whisk together sugar & cocoa powder. 2. Add milk and cream (in 1:1 ratio), chocolate chunks & vanilla. 3. Serve with your favourite toppings.", type3, user1);
			recipeRepository.save(recipe1);
			recipeRepository.save(recipe2);
			recipeRepository.save(recipe3);

			log.info("Fetch all the recipes");
			for (Recipe recipe : recipeRepository.findAll()) {
				log.info(recipe.toString());
			}
		};

	}

}