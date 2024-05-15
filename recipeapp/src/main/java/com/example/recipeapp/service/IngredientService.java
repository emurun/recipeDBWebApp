package com.example.recipeapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.repository.IngredientRepository;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId).get();
    }

    public String getIngredientNameById(Long ingredientId) {
        return ingredientRepository.findById(ingredientId).get().getIngredientName();
    }

    public Ingredient getIngredientByName(String ingredientName) {
        return ingredientRepository.getByIngredientName(ingredientName);
    }
}
