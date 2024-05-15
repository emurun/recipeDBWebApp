package com.example.recipeapp.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    @Column(name = "ingredient_name", unique = true)
    private String ingredientName;

    @OneToMany(mappedBy = "ingredient")
    Set<RecipesIngredient> recipesIngredients;

    public Ingredient() {

    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
