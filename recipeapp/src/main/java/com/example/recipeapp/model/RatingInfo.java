package com.example.recipeapp.model;

public class RatingInfo {

  public Long ratingId;

  public int stars;

  public String description;

  public String userName;

  public RatingInfo(Long ratingId, int stars, String description, String username) {
    this.ratingId = ratingId;
    this.userName = username;
    this.description = description;
    this.stars = stars;
  }

  public Long getRatingId() {
    return ratingId;
  }

  public String getUserName() {
    return userName;
  }

  public int getStars() {
    return stars;
  }

  public String getDescription() {
    return description;
  }
}
