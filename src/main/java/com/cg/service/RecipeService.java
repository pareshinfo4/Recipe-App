package com.cg.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.IngredientDTO;
import com.cg.dto.RecipeDTO;
import com.cg.entities.Ingredient;
import com.cg.entities.Recipe;
import com.cg.exception.RecipeNotFoundException;
import com.cg.repository.RecipeRepository;

/**
 * Recipe service  for  crud operations.
 * 
 * @author parebhar
 *
 */
@Service
public class RecipeService {

	@Autowired
	RecipeRepository recipeRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	/**
	 * Get List of all Recipes.
	 *
	 */
	public List<RecipeDTO> allRecipeDetails(){
		
		var recipeList = recipeRepo.findAll();
		
		return Optional.of(recipeList).filter(recipe -> !recipe.isEmpty())
				                .orElseThrow(RecipeNotFoundException::new).stream()
				                .map(recipe -> modelMapper.map(recipe, RecipeDTO.class))
				                .collect(Collectors.toList());
		
	}
	
	/**
	 * Get Recipe by recipe id
	 * 
	 * @param id
	 * @return RecipeDTO
	 */
	public RecipeDTO findByRecipeId(Long id) {
		Recipe recipe = recipeRepo.findById(id).orElseThrow(RecipeNotFoundException::new);
		return modelMapper.map(recipe, RecipeDTO.class);
	}
	
	/**
	 * Save new Recipe details
	 * 
	 * @param recipeDto recipe details
	 */
	public String createRecipe(RecipeDTO recipeDto) {
		
		Recipe recipe = modelMapper.map(recipeDto, Recipe.class);

		recipeRepo.save(recipe);
		
		return "Saved Successfully";

	}
	
	/**
	 * Update existing Recipe details.
	 * 
	 * @param recipeDto recipe details
	 * @param id        recipeId
	 * @return - RecipeDTO Object updated.
	 */
	public RecipeDTO updateRecipe(RecipeDTO recipeDto, Long id) {

		List<IngredientDTO> updatedIngredientList = recipeDto.getIngredientList();
		List<Ingredient> ingredientList = updatedIngredientList.stream()
				.map(ingredientDto -> modelMapper.map(ingredientDto, Ingredient.class))
				.collect(Collectors.toList());

		return recipeRepo.findById(id).map(recipe -> {
			recipe.setCookingInstructions(recipeDto.getCookingInstructions());
			recipe.setCreationDate(recipeDto.getCreationDate());
			recipe.setIngredientList(ingredientList);
			recipe.setIsVeg(recipeDto.getIsVeg());
			recipe.setServings_no(recipeDto.getServings_no());
			recipe.setName(recipeDto.getName());
			
			Recipe saveRecipe = recipeRepo.save(recipe);
			
			return modelMapper.map(saveRecipe, RecipeDTO.class);
			
		    }).orElseThrow(RecipeNotFoundException::new);

	}
	
	/**
	 * Delete Recipe details by passing recipe id.
	 * 
	 * @param id
	 */
	public String deleteRecipe(Long id) {
		Recipe recipe = recipeRepo.findById(id).orElseThrow(RecipeNotFoundException::new);
		recipeRepo.delete(recipe);
		return "Deleted Successfully";
	}


}
