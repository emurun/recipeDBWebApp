package com.example.recipeapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipeapp.model.*;
import com.example.recipeapp.service.*;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    private final RatingService ratingService;
    private final UserService userService;

    @Autowired
    public RatingController(RatingService ratingService, UserService userService) {
        this.ratingService = ratingService;
        this.userService = userService;
    }

    @GetMapping("/getAllRatings")
    @ResponseBody
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping(path = "/getRatingById", consumes = "application/json")
    @ResponseBody
    public Optional<Rating> getRatingById(@RequestBody LongObject id) {
        return ratingService.findRatingById(id.getLong());
    }

    @PostMapping(path = "/getRatingsByRecipe", consumes = "application/json")
    @ResponseBody
    public List<RatingInfo> getRatingsByRecipe(@RequestBody LongObject id) {
        List<Rating> ratings = ratingService.findRatingByRecipeId(id.getLong());

        List<RatingInfo> response = new ArrayList<RatingInfo>();
        for (int i = 0; i < ratings.size(); i++) {
            Rating rating = ratings.get(i);
            User user = userService.findByUserId(rating.getUserId());
            RatingInfo rInfo = new RatingInfo(rating.getRatingId(), rating.getStars(), rating.getDescription(),
                    user.getUserName());
            response.add(rInfo);
        }
        return response;
    }

    @PostMapping(path = "/createRating", consumes = { "application/json" })
    @ResponseBody
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.saveRating(rating);
        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }
}
