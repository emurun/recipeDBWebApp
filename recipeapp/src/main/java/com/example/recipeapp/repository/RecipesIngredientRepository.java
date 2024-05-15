package com.example.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.recipeapp.model.RecipesIngredient;

public interface RecipesIngredientRepository extends JpaRepository<RecipesIngredient, Long> {

    List<RecipesIngredient> findByRecipeId(Long recipeId);
}
