package com.example.recipeapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeIntake {

    @JsonProperty
    public String name;

    @JsonProperty
    public String description;

    @JsonProperty
    public String instructions;

    @JsonProperty
    public String userName;

    @JsonProperty
    public List<String> ingredients;

    public RecipeIntake(String name, String userName, String description, String instructions,
            List<String> ingredients) {
        this.userName = userName;
        this.ingredients = ingredients;
        this.name = name;
        this.description = description;
        this.instructions = instructions;
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

    public String getUserName() {
        return userName;
    }

}
