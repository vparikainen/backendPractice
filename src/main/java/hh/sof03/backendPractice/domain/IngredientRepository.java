package hh.sof03.backendPractice.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{

	List<Ingredient> findByIngredientName(String ingredientName);
	
}
