package hh.sof03.backendPractice.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ingredientId;
	private String ingredientName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
	private List<Recipe> recipe;
	
public Ingredient() {}

public Ingredient(String ingredientName) {
	super();
	this.ingredientName = ingredientName;
}

public List<Recipe> getRecipe() {
	return recipe;
}

public void setRecipe(List<Recipe> recipe) {
	this.recipe = recipe;
}

public Long getIngredientId() {
	return ingredientId;
}

public void setIngredientId(Long ingredientId) {
	this.ingredientId = ingredientId;
}

public String getIngredientName() {
	return ingredientName;
}

public void setIngredientName(String ingredientName) {
	this.ingredientName = ingredientName;
}

@Override
public String toString() {
	return "Ingredient [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName + "]";
}

}