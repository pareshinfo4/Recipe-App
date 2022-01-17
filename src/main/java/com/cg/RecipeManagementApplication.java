package com.cg;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.cg.entities.Ingredient;
import com.cg.entities.Recipe;
import com.cg.repository.RecipeRepository;

@SpringBootApplication
@EnableWebSecurity
public class RecipeManagementApplication {

	/**
	 * ModelMapper for parse DTOs into entities and entities to DTO
	 * 
	 * @author parebhar
	 *
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(RecipeManagementApplication.class,
				args);

		RecipeRepository recipeRepository = applicationContext.getBean(RecipeRepository.class);

		Ingredient ingredient = new Ingredient();
		ingredient.setName("tamato");

		Ingredient ingredient1 = new Ingredient();

		ingredient1.setName("oil");

		List<Ingredient> listIngredients = List.of(ingredient, ingredient1);

		Recipe recipe = new Recipe();
		Date creationDate = Date.valueOf("2021-10-20");
		recipe.setName("Tamato curry");
		recipe.setCookingInstructions("cooking");
		recipe.setIsVeg(true);
		recipe.setCreationDate(creationDate);
		recipe.setServings_no(4);
		recipe.setIngredientList(listIngredients);

		recipeRepository.save(recipe);

	}

}
