package com.example.recipeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.recipeapp.model.RecipesIngredient;
import com.example.recipeapp.repository.RecipesIngredientRepository;

@Service
public class RecipesIngredientService {
    private final RecipesIngredientRepository recipesIngredientRepository;

    @Autowired
    public RecipesIngredientService(RecipesIngredientRepository recipesIngredientRepository) {
        this.recipesIngredientRepository = recipesIngredientRepository;
    }

    public RecipesIngredient saveRecipesIngredient(RecipesIngredient recipesIngredient) {
        return recipesIngredientRepository.save(recipesIngredient);
    }

    public List<RecipesIngredient> getAllRecipesIngredients() {
        return recipesIngredientRepository.findAll();
    }

    public List<Long> getRecipesIngredientsByRecipeId(Long recipeId) {
        List<RecipesIngredient> recipesIngredients = recipesIngredientRepository.findByRecipeId(recipeId);
        List<Long> recipesIngredientIds = new ArrayList<>();
        for (RecipesIngredient r : recipesIngredients) {
            recipesIngredientIds.add(r.getIngredient().getIngredientId());
        }
        return recipesIngredientIds;

    }
}