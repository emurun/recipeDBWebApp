package com.example.recipeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recipeapp.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByUserId(Long userId);

    List<Rating> findByRecipeId(Long recipeId);

    Rating findByRecipeIdAndUserId(Long recipeId, Long userId);

}
