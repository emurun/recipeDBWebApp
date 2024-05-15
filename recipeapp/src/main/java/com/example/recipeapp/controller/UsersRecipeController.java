package com.example.recipeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipeapp.model.UsersRecipe;
import com.example.recipeapp.model.LongObject;
import com.example.recipeapp.service.UsersRecipeService;

@RestController
@RequestMapping("/api/usersRecipes")
public class UsersRecipeController {
    private final UsersRecipeService usersRecipeService;

    @Autowired
    public UsersRecipeController(UsersRecipeService usersRecipeService) {
        this.usersRecipeService = usersRecipeService;
    }

    @GetMapping("/getAllUsersRecipes")
    @ResponseBody
    public List<UsersRecipe> getAllUsersRecipes() {
        return usersRecipeService.getAllUsersRecipes();
    }

    @PostMapping(path = "/createUsersRecipe", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<UsersRecipe> createUsersRecipe(@RequestBody UsersRecipe usersRecipe) {
        UsersRecipe savedUsersRecipe = usersRecipeService.saveUsersRecipe(usersRecipe);
        return new ResponseEntity<>(savedUsersRecipe, HttpStatus.CREATED);
    }

    @PostMapping(path = "/getUserByRecipe", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Long> getUserByRecipe(@RequestBody LongObject id) {
        Long userId = usersRecipeService.getUserByRecipe(id.getLong());
        return new ResponseEntity<>(userId, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/getRecipesByUser", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<List<UsersRecipe>> getRecipesByUser(@RequestBody LongObject id) {
        List<UsersRecipe> usersRecipe = usersRecipeService.getRecipesByUser(id.getLong());
        return new ResponseEntity<>(usersRecipe, HttpStatus.ACCEPTED);
    }

}
