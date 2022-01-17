package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.RecipeDTO;
import com.cg.service.RecipeService;

/**
 * Recipe Controller to perform CRUD operations for Recipe
 * 
 * @author parebhar
 */
@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;

	/**
	 * Returns List of all the recipes
	 * 
	 * @return - List of Recipes
	 */
	@GetMapping("/recipes")
	public List<RecipeDTO> allRecipeDetails() {
		return recipeService.allRecipeDetails();
	}
	
	/**
	 * Returns specific Recipe details by passing recipeId
	 * 
	 * @param id - recipe id
	 * @return - specific record of the recipe
	 */
	@GetMapping("recipe/{id}")
	public RecipeDTO findByRecipeId(@PathVariable Long id) {
		return recipeService.findByRecipeId(id);
	}
	
	/**
	 * Create new Recipe details.
	 * 
	 * @param recipeDto RecipeDTO
	 * @return String status
	 */
	@PostMapping("/addRecipe")
	public String createRecipe(@Valid @RequestBody RecipeDTO recipeDto) {
		 return recipeService.createRecipe(recipeDto);
	}
	
	/**
	 * Update Recipe details details by passing recipe id.
	 * 
	 * @param recipeDto RecipeDTO
	 * @param id        recipeId
	 * @return recipeDto Object
	 */
	@PutMapping("/updateRecipe/{id}")
	public RecipeDTO updateRecipe(@Valid @RequestBody RecipeDTO recipeDto, @PathVariable Long id) {
		return recipeService.updateRecipe(recipeDto, id);
	}

	/**
	 * Delete Recipe details by passing recipe id from database
	 * 
	 * @param id recipeId
	 * @return status
	 */
	@DeleteMapping("/deleteRecipe/{id}")
	public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
		return ResponseEntity.ok().body(recipeService.deleteRecipe(id));
	}
	
}
