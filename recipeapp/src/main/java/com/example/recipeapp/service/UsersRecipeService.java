package com.example.recipeapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.recipeapp.model.UsersRecipe;
import com.example.recipeapp.repository.UsersRecipeRepository;

@Service
public class UsersRecipeService {
    private final UsersRecipeRepository usersRecipeRepository;

    @Autowired
    public UsersRecipeService(UsersRecipeRepository usersRecipeRepository) {
        this.usersRecipeRepository = usersRecipeRepository;
    }

    public UsersRecipe saveUsersRecipe(UsersRecipe usersRecipe) {
        return usersRecipeRepository.save(usersRecipe);
    }

    public List<UsersRecipe> getAllUsersRecipes() {
        return usersRecipeRepository.findAll();
    }

    public Long getUserByRecipe(Long recipeId) {
        System.out.println("Looking for recipe id: " + recipeId);
        UsersRecipe usersRecipe = usersRecipeRepository.findById(recipeId).get();
        return usersRecipe.getUserId();
    }

    public List<UsersRecipe> getRecipesByUser(Long id) {
        return usersRecipeRepository.findByUserId(id);
    }

}
