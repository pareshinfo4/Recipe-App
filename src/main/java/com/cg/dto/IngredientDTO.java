package com.cg.dto;


/**
 * IngredientsDTO class for ingredient data.
 * 
 * @author parebhar
 *
 */

public class IngredientDTO {

	private Long id;
	private String name;
	
	/**
	 * Default constructor
	 */
	public IngredientDTO() {
		super();
	}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param name
	 */
	public IngredientDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "IngredientDTO [id=" + id + ", name=" + name + "]";
	}
	
	

	
	
}
