package com.example.recipeapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeInfo {

    @JsonProperty
    public Long recipeId;

    @JsonProperty
    public String name;

    @JsonProperty
    public String description;

    @JsonProperty
    public String instructions;

    @JsonProperty
    public Long userId;;

    @JsonProperty
    public List<String> ingredients;

    @JsonProperty
    public String userName;

    public RecipeInfo() {
    }

    public RecipeInfo(Long recipeId, String name, Long userId, String description, String instructions,
            List<String> ingredients) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.ingredients = ingredients;
        this.name = name;
        this.description = description;
        this.instructions = instructions;
    }

    public RecipeInfo(String name, Long userId, String description, String instructions,
            List<String> ingredients) {
        this.userId = userId;
        this.ingredients = ingredients;
        this.name = name;
        this.description = description;
        this.instructions = instructions;
    }

    public RecipeInfo(Long recipeId2, String name2, String userName2, String description2, String instructions2,
            List<String> ingredients2) {
        this.description = description2;
        this.ingredients = ingredients2;
        this.instructions = instructions2;
        this.userName = userName2;
        this.recipeId = recipeId2;
        this.name = name2;
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return recipeId;
    }
}
