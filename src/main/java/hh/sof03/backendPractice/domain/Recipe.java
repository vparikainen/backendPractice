package hh.sof03.backendPractice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String instruction;


public Recipe() {}

public Recipe(String name, String description, String instruction) {
	super();
	this.name = name;
	this.description = description;
	this.instruction = instruction;
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
			+ "]";
}

}