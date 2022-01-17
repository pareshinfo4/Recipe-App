package com.cg.dto;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * RecipeDTO class for recipe data 
 * 
 * @author parebhar
 *
 */
public class RecipeDTO {
	
	private Long recipeId;
	private Date creationDate;
	private Boolean isVeg;
	
	@NotNull(message = "Recipe Name Should Not Be Empty")
	@NotBlank
	@Size(min = 5, max = 30, message = "Recipe name should not be less than 5 and more than 30 character.")
	private String name;

	@Min(value = 1, message = "Number of people should be minimum 1 person")
	private int servings_no;

	private List<IngredientDTO> ingredientList;

	@NotNull
	@NotBlank(message = "cookingInstructions Should Not Be Empty")
	private String cookingInstructions;

	/**
	 * Default Constructor
	 */
	public RecipeDTO() {
		super();
	}
	
	/**
	 * @param recipeId
	 * @param creationDateTime
	 * @param isVeg
	 * @param name
	 * @param numberOfPeople
	 * @param ingredientList
	 * @param cookingInstructions
	 */
	
	public RecipeDTO(Long recipeId, Date creationDate, Boolean isVeg,
			@NotNull(message = "Recipe Name Should Not Be Empty") @NotBlank @Size(min = 5, max = 30, message = "Recipe name should not be less than 5 and more than 30 character.") String name,
			@Min(value = 1, message = "Number of people should be minimum 1 person") int servings_no,
			List<IngredientDTO> ingredientList,
			@NotNull @NotBlank(message = "cookingInstructions Should Not Be Empty") String cookingInstructions) {
		super();
		this.recipeId = recipeId;
		this.creationDate = creationDate;
		this.isVeg = isVeg;
		this.name = name;
		this.servings_no = servings_no;
		this.ingredientList = ingredientList;
		this.cookingInstructions = cookingInstructions;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
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

	public List<IngredientDTO> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<IngredientDTO> ingredientList) {
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
		return "RecipeDTO [recipeId=" + recipeId + ", creationDate=" + creationDate + ", isVeg=" + isVeg + ", name="
				+ name + ", numberOfPeople=" + servings_no + ", ingredientList=" + ingredientList
				+ ", cookingInstructions=" + cookingInstructions + "]";
	}

		
	
	
	
	
	
	

}
