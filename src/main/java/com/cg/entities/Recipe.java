package com.cg.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "Recipe")
public class Recipe {

	@Id
	@Column(name = "recipe_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 3,max=30, message = "Recipe name should be minimum 3  and maximum 10 characters")
	@Column(name = "recipe_name")
	private String name;

	@Column(name = "servings_number")
	private int servings_no;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "is_vegetarian")
	private Boolean isVeg;
	
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "recipe_id", nullable = false)
	@JoinColumn(name = "recipe_id")
	private List<Ingredient> ingredientList;
	
	@Column(name = "cooking_instructions")
	private String cookingInstructions;

	public Recipe() {
		super();
	}
	
	public Recipe(Long id, String name, int servings_no, Date creationDate, @NotNull @NotBlank Boolean isVeg,
			List<Ingredient> ingredientList, String cookingInstructions) {
		super();
		this.id = id;
		this.name = name;
		this.servings_no = servings_no;
		this.creationDate = creationDate;
		this.isVeg = isVeg;
		this.ingredientList = ingredientList;
		this.cookingInstructions = cookingInstructions;
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

	public int getServings_no() {
		return servings_no;
	}

	public void setServings_no(int servings_no) {
		this.servings_no = servings_no;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public String getCookingInstructions() {
		return cookingInstructions;
	}

	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", servings_no=" + servings_no + ", creationDate=" + creationDate
				+ ", isVeg=" + isVeg + ", ingredientList=" + ingredientList + ", cookingInstructions="
				+ cookingInstructions + "]";
	}

	
	
	
}
