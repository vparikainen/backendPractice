package hh.sof03.backendPractice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ingredientId;
	private String ingredientName;

public Ingredient() {}

public Ingredient(String ingredientName) {
	super();
	this.ingredientName = ingredientName;
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