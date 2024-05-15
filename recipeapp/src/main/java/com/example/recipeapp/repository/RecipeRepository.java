package com.example.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recipeapp.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findRecipeById(Long id);

    String findNameByRecipeId(Long recipeId);
}
