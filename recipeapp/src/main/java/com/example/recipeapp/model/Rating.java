package com.example.recipeapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    // @EmbeddedId
    // RatingKey ratingId;

    // @ManyToOne
    // @MapsId("userId")
    // @JoinColumn(name = "user_id")
    // User user;

    // @ManyToOne
    // @MapsId("recipeId")
    // @JoinColumn(name = "recipe_id")
    // Recipe recipe;

    @Column(nullable = false)
    private int stars;

    @Column
    private String description;

    public Rating() {
    }

    public Long getRatingId() {
        return ratingId;
    }

    public int getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    // public User getUserId() {
    // return user;
    // }

    // public Recipe getRecipeId() {
    // return recipe;
    // }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    // public void setUserId(User user) {
    // this.user = user;
    // }

    // public void setRecipeId(Recipe recipe) {
    // this.recipe = recipe;
    // }

}