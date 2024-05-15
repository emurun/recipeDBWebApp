package com.example.recipeapp.service;

import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.repository.RecipeRepository;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe saveRecipe(Recipe recipe) {
        System.out.println("Saving recipe: " + recipe);
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long recipeId) {
        System.out.println("Service: Long: " + recipeId);
        Recipe recipe = recipeRepository.findRecipeById(recipeId);
        System.out.println(recipe);
        return recipe;

    }

    public String getNameByRecipeId(Long recipeId) {
        return recipeRepository.findRecipeById(recipeId).getName();
    }

    public String getDescriptionByRecipeId(Long recipeId) {
        return recipeRepository.findRecipeById(recipeId).getDescription();
    }

    public String getInstructionsByRecipeId(Long recipeId) {
        return recipeRepository.findRecipeById(recipeId).getInstructions();
    }
}
