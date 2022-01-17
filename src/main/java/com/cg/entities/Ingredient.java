package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class is used to create Ingredient Entity
 * 
 * @author parebhar
 *
 */
@Entity
@Table(name = "Ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 3,max=30, message = "Ingredient name should be minimum 3  and maximum 10 characters")
	private String name;

	/**
	 * Default constructor
	 */
	public Ingredient() {
		super();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param name
	 */
	public Ingredient(Long id,
			@NotNull @NotBlank @Size(min = 3, max = 10, message = "Ingredient should be minimum 3  and maximum 10 characters") String name) {
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
		return "Ingredient [id=" + id + ", name=" + name + "]";
	}

	
}
