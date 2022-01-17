
package com.cg.serviceTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entities.Ingredient;
import com.cg.entities.Recipe;
import com.cg.repository.RecipeRepository;

/**
 * This class is used for RecipeService Test
 * 
 * @author parebar
 *
 */

@SpringBootTest
 class RecipeServiceTest {

	@Autowired
	private RecipeRepository repo;

	/**
	 * Test case to check createRecipe
	 */

	@Test
	void testCreateRecipe() {

		Recipe recipe = new Recipe();

		Ingredient ingredient = new Ingredient();

		ingredient.setName("dal");

		Ingredient ingredient1 = new Ingredient();

		ingredient1.setName("sugar");

		List<Ingredient> listIngredients = List.of(ingredient, ingredient1);

		Date creationDate = Date.valueOf("2021-10-20");
		recipe.setName("dal curry");
		recipe.setIsVeg(true);
		recipe.setCreationDate(creationDate);
		recipe.setCookingInstructions("cooking");
		recipe.setServings_no(4);
		recipe.setIngredientList(listIngredients);

		repo.save(recipe);

		List<Recipe> findAll = (List<Recipe>) repo.findAll();

		Assertions.assertThat(findAll.size()).isPositive();

	}

	/**
	 * Test case to check ListRecipeDetails
	 */

	@Test
	void testListRecipe() {
		before();
		List<Recipe> findAll = (List<Recipe>) repo.findAll();
		Assertions.assertThat(findAll.size()).isPositive();
	}

	/**
	 * Test case to check updateRecipe
	 */

	@Test
	void testUpdateRecipe() {
		before();
		Recipe recipe = repo.findById(1l).get();
		recipe.setName("patato curry");

		repo.save(recipe);

		Recipe updatedEmployee = repo.findById(1l).get();

		Assertions.assertThat(updatedEmployee.getName()).isEqualTo("patato curry");
	}

	/**
	 * Test case to check deleteRecipe
	 */

	@SuppressWarnings("unchecked")

	@Test
	void testDeleteRecipe() {
		before();

		Recipe emp = repo.findById(1l).get();

		repo.deleteById(emp.getId());
		List<Recipe> e2 = new ArrayList<Recipe>();
		Optional<Recipe> findById = repo.findById(1l);
		if (findById.isPresent()) {
			e2 = (List<Recipe>) findById.get();
		}

		Assertions.assertThat(e2).isEmpty();

	}

	/**
	 * Method to call before each test for data available
	 */
	public void before() {
		Recipe recipe = new Recipe();

		Ingredient ingredient = new Ingredient();
		ingredient.setName("dal");
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setName("sugar");
		List<Ingredient> listIngredients = List.of(ingredient, ingredient1);

		Date creationDate = Date.valueOf("2021-10-20");
		recipe.setId(1l);
		recipe.setName("tamato curry");
		recipe.setIsVeg(true);
		recipe.setCreationDate(creationDate);
		recipe.setCookingInstructions("cooking");
		recipe.setServings_no(4);
		recipe.setIngredientList(listIngredients);

		repo.save(recipe);
	}
}
