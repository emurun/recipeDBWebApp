package com.example.recipeapp.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
class RecipesIngredientKey implements Serializable {

    @Column(name = "recipe_id")
    Long recipeId;

    @Column(name = "ingredient_id")
    Long ingredientId;

    public RecipesIngredientKey() {

    }

    public RecipesIngredientKey(Long recipeId, Long ingredientId) {
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int hashCode() {
        return (recipeId.intValue() + ingredientId.intValue());
    }

    @Override
    public boolean equals(Object key) {
        return key.hashCode() == this.hashCode();
    }

}