package hh.sof03.backendPractice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long recipeId;
	private String name;
	private String description;
	private String ingredient;
	private String instruction;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="typeId")
	private Type type;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="userId")
	private User user;

public Recipe() {}

public Recipe(String name, String description, String ingredient, String instruction, Type type, User user) {
	super();
	this.name = name;
	this.description = description;
	this.instruction = instruction;
	this.ingredient = ingredient;
	this.type = type;
	this.user = user;
}

public Type getType() {
	return type;
}

public void setType(Type type) {
	this.type = type;
}

public String getIngredient() {
	return ingredient;
}

public void setIngredient(String ingredient) {
	this.ingredient = ingredient;
}

public Long getRecipeId() {
	return recipeId;
}

public void setRecipeId(Long recipeId) {
	this.recipeId = recipeId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getInstruction() {
	return instruction;
}

public void setInstruction(String instruction) {
	this.instruction = instruction;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Recipe [recipeId=" + recipeId + ", name=" + name + ", description=" + description + ", instruction=" + instruction
			+ ", ingredient=" + ingredient + ", type=" + type + ", + user=" + user + "]";
}

}