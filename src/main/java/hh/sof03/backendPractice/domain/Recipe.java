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
	private Long id;
	private String name;
	private String description;
	private String instruction;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="ingredientId")
	private Ingredient ingredient;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="typeId")
	private Type type;

public Recipe() {}

public Recipe(String name, String description, Ingredient ingredient, String instruction, Type type) {
	super();
	this.name = name;
	this.description = description;
	this.instruction = instruction;
	this.ingredient = ingredient;
	this.type = type;
}

public Type getType() {
	return type;
}

public void setType(Type type) {
	this.type = type;
}

public Ingredient getIngredient() {
	return ingredient;
}

public void setIngredient(Ingredient ingredient) {
	this.ingredient = ingredient;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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

@Override
public String toString() {
	return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", instruction=" + instruction
			+ ", ingredient=" + ingredient + ", type=" + type + "]";
}

}