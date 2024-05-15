package com.example.recipeapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String instructions;

    public Recipe() {
    }

    public Recipe(String description, String instructions, String name) {

        this.name = name;
        this.description = description;
        this.instructions = instructions;
    }

    public Long getId() {
        return recipeId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}