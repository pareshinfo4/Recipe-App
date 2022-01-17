package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.Recipe;

/**
 * RecipeRepository to access H2 database Recipe table.
 * @author parebhar
 *
 */

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
