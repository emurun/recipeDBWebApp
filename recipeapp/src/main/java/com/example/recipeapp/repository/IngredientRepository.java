package com.example.recipeapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recipeapp.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findById(Long ingredientId);

    Ingredient getByIngredientName(String ingredientName);
}
