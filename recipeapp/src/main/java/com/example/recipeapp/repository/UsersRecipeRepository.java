package com.example.recipeapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recipeapp.model.UsersRecipe;

public interface UsersRecipeRepository extends JpaRepository<UsersRecipe, Long> {
    List<UsersRecipe> findByUserId(Long userId);

    Optional<UsersRecipe> findById(Long recipeId);
}
