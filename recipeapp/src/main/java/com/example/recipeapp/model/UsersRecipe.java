package com.example.recipeapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users_Recipes")
public class UsersRecipe {

    @Id
    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "user_id")
    private Long userId;

    public UsersRecipe() {
    }

    public UsersRecipe(Long recipeID2, Long userId2) {
        this.recipeId = recipeID2;
        this.userId = userId2;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}