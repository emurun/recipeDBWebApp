package com.example.recipeapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recipes_ingredients")
public class RecipesIngredient {

    @EmbeddedId
    RecipesIngredientKey ingredientKeyId;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

    public RecipesIngredient() {
    }

    public RecipesIngredient(Long recipeID, Long ingredientId) {
        RecipesIngredientKey key = new RecipesIngredientKey(recipeID, ingredientId);
        this.ingredientKeyId = key;
    }

    public RecipesIngredient(Recipe recipe2, Ingredient ingredient2) {
        this.ingredient = ingredient2;
        this.recipe = recipe2;

        this.ingredientKeyId = new RecipesIngredientKey(recipe2.getId(), ingredient2.getIngredientId());
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
