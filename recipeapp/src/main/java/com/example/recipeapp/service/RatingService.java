package com.example.recipeapp.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.recipeapp.model.*;
import com.example.recipeapp.repository.RatingRepository;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findRatingById(Long ratingId) {
        return ratingRepository.findById(ratingId);
    }

    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public List<Rating> findRatingByUserId(Long user) {
        return ratingRepository.findByUserId(user);
    }

    public List<Rating> findRatingByRecipeId(Long recipe) {
        return ratingRepository.findByRecipeId(recipe);
    }

    public Rating getRecipeByUserandRecipe(Long recipe, Long user) {
        return ratingRepository.findByRecipeIdAndUserId(recipe, user);
    }

}
