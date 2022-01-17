
package com.cg.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.controller.RecipeController;
import com.cg.dto.IngredientDTO;
import com.cg.dto.RecipeDTO;
import com.cg.repository.RecipeRepository;
import com.cg.service.RecipeService;

@SpringBootTest
 class RecipeControllerTest {

	@InjectMocks
	private RecipeController recipeController;

	@Mock
	private RecipeService recipeService;

	@Mock
	private RecipeRepository recipeRepositoryObj;

	@Mock
	private ModelMapper modelMapperObj;

	/**
	 * This test case for listAllRecipeDetails
	 */

	@Test
	 void testListAllRecipeDetails() {
		when(recipeService.allRecipeDetails()).thenReturn(Arrays.asList(dtoData()));
		List<RecipeDTO> recipeList = recipeController.allRecipeDetails();
		Assertions.assertThat(recipeList.size()).isPositive();
	}

	/**
	 * This test case for findByRecipeId
	 */

	@Test
	 void testFindByRecipeId() {
		when(recipeService.findByRecipeId(Mockito.anyLong())).thenReturn(dtoData());
		RecipeDTO recipeDTOActual = recipeController.findByRecipeId(1l);
		assertNotNull(recipeDTOActual);
		Assertions.assertThat(recipeDTOActual.getRecipeId()).isPositive();
	}

	/**
	 * This test case for create Recipe
	 */

	@Test
	 void testCreateRecipe() {
		when(recipeService.createRecipe(Mockito.any())).thenReturn("Saved Successfully");
		String message = recipeController.createRecipe(dtoData());
		assertEquals("Saved Successfully", message);
	}

	/**
	 * This test case for update recipe
	 */

	@Test
	 void testUpdateRecipe() {
		when(recipeService.updateRecipe(Mockito.any(), Mockito.anyLong())).thenReturn(dtoData());
		RecipeDTO updatedRecipe = recipeController.updateRecipe(dtoData(), 1l);
		assertEquals(updatedRecipe.getName(), dtoData().getName());
	}

	/**
	 * This test case for delete recipe
	 */

	@Test
	 void testDeleteRecipe() {
		ResponseEntity<String> response = recipeController.deleteRecipe(1l);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	/**
	 * mock data for recipe dto
	 */
	private static RecipeDTO dtoData() {
		RecipeDTO recipedto = new RecipeDTO();

		IngredientDTO ingredient = new IngredientDTO();
		ingredient.setId(1l);
		ingredient.setName("tamato");
		IngredientDTO ingredient1 = new IngredientDTO();
		ingredient1.setId(2l);
		ingredient1.setName("oil");
		List<IngredientDTO> listIngredients = List.of(ingredient, ingredient1);

		Date creationDate = Date.valueOf("2021-10-20");

		recipedto.setName("tamato1 curry");
		recipedto.setRecipeId(1l);
		recipedto.setIsVeg(true);
		recipedto.setCreationDate(creationDate);
		recipedto.setCookingInstructions("cooking");
		recipedto.setServings_no(4);
		recipedto.setIngredientList(listIngredients);

		return recipedto;
	}
}
